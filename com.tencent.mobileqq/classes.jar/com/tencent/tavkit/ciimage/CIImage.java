package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TAVImageFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.utils.MathUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CIImage
  implements Cloneable
{
  private static Bitmap.Config[] SUPPORT_CONFIGS = { Bitmap.Config.ALPHA_8, Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444, Bitmap.Config.ARGB_8888 };
  private final String TAG;
  @FloatRange(from=0.0D, to=1.0D)
  private float alpha;
  @Nullable
  private Bitmap bitmap;
  @Nullable
  private CGRect frame;
  private boolean isHardMode;
  @NonNull
  private final List<CIImage> overlayImages;
  private int preferRotation;
  private int rotation;
  @NonNull
  private final CGSize size;
  private String textureCacheKey;
  @Nullable
  private TextureInfo textureInfo;
  @Nullable
  private Matrix transform;
  
  public CIImage(Bitmap paramBitmap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CIImage@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImage() called with: bitmap = [");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    this.bitmap = TAVImageFactory.fixSupportImageConfig(paramBitmap);
    this.size = new CGSize(paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public CIImage(@NonNull CGSize paramCGSize)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CIImage@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImage() called with: renderSize = [");
    localStringBuilder.append(paramCGSize);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    this.size = paramCGSize;
  }
  
  public CIImage(TextureInfo paramTextureInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CIImage@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImage() called with: textureInfo = [");
    localStringBuilder.append(paramTextureInfo);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    this.textureInfo = paramTextureInfo;
    this.size = new CGSize(paramTextureInfo.width, paramTextureInfo.height);
  }
  
  public CIImage(String paramString)
  {
    this(paramString, null);
  }
  
  public CIImage(String paramString, CGSize paramCGSize)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CIImage@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    this.TAG = ((StringBuilder)localObject).toString();
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    long l = System.currentTimeMillis();
    this.preferRotation = TAVBitmapUtils.readImagePreferRotation(paramString);
    this.bitmap = decodeBitmap(paramString, paramCGSize);
    this.bitmap = TAVImageFactory.fixSupportImageConfig(this.bitmap);
    localObject = this.bitmap;
    if (localObject != null)
    {
      this.size = new CGSize(((Bitmap)localObject).getWidth(), this.bitmap.getHeight());
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CIImage() called with: imagePath = [");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], sampleSize = ");
      localStringBuilder.append(paramCGSize);
      localStringBuilder.append(", BitmapFactory.decodeFile cons ms = ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      localStringBuilder.append(", outBitmapSize = ");
      localStringBuilder.append(this.size);
      Logger.v((String)localObject, localStringBuilder.toString());
      return;
    }
    paramCGSize = this.TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CIImage: 图片解码失败！imagePath = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.e(paramCGSize, ((StringBuilder)localObject).toString());
    this.size = new CGSize();
  }
  
  private void addOverlayImage(CIImage paramCIImage)
  {
    try
    {
      this.overlayImages.add(paramCIImage);
      return;
    }
    finally {}
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    int i = 1;
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    localOptions2.inPreferredConfig = Bitmap.Config.ARGB_8888;
    return BitmapFactory.decodeFile(paramString, localOptions2);
  }
  
  @NonNull
  private Matrix getImageTextureMatrix()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    return localMatrix;
  }
  
  public void applyFillInFrame(CGRect paramCGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    Matrix localMatrix = new Matrix();
    int i = CIImage.1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramTAVVideoConfigurationContentMode = new Matrix();
        paramTAVVideoConfigurationContentMode.postScale(paramCGRect.size.width / getExtent().size.width, paramCGRect.size.height / getExtent().size.height);
        localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
        paramTAVVideoConfigurationContentMode = new Matrix();
        paramTAVVideoConfigurationContentMode.postTranslate(paramCGRect.origin.x, paramCGRect.origin.y);
        localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
        imageByApplyingTransform(localMatrix);
        return;
      }
      localMatrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      return;
    }
    localMatrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), paramCGRect));
    imageByApplyingTransform(localMatrix);
  }
  
  public void applyFixInSize(CGSize paramCGSize, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    if (!Utils.isSizeValid(paramCGSize)) {
      return;
    }
    int i = CIImage.1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
        } else {
          paramCGSize = MathUtils.sizeScale(this.size, paramCGSize);
        }
      }
      else {
        paramCGSize = MathUtils.sizeFill(this.size, paramCGSize);
      }
    }
    else {
      paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
    }
    paramTAVVideoConfigurationContentMode = new Matrix();
    paramTAVVideoConfigurationContentMode.postScale(paramCGSize.width / this.size.width, paramCGSize.height / this.size.height);
    imageByApplyingTransform(paramTAVVideoConfigurationContentMode);
    this.size.height = paramCGSize.height;
    this.size.width = paramCGSize.width;
  }
  
  public void applyFlip(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    float f3 = -1.0F;
    float f1;
    if (paramBoolean1) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    }
    float f4 = 0.0F;
    float f2;
    if (paramBoolean1) {
      f2 = this.size.width;
    } else {
      f2 = 0.0F;
    }
    if (!paramBoolean2) {
      f3 = 1.0F;
    }
    if (paramBoolean2) {
      f4 = this.size.height;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f3);
    localMatrix.postTranslate(f2, f4);
    imageByApplyingTransform(localMatrix);
  }
  
  public void applyPreferRotation()
  {
    applyPreferRotation(0);
  }
  
  public void applyPreferRotation(int paramInt)
  {
    TextureInfo localTextureInfo = getDrawTextureInfo();
    if (localTextureInfo == null) {
      return;
    }
    this.rotation = (paramInt + localTextureInfo.preferRotation);
    if (this.rotation == 0) {
      return;
    }
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("applyPreferRotation: textureInfo.preferRotation = ");
    localStringBuilder.append(this.rotation);
    Logger.v((String)localObject, localStringBuilder.toString());
    localObject = new Matrix();
    DecoderUtils.getRotationMatrix((Matrix)localObject, this.rotation, localTextureInfo.width, localTextureInfo.height);
    imageByApplyingTransform((Matrix)localObject);
    if (this.rotation % 2 == 1)
    {
      this.size.width = localTextureInfo.height;
      this.size.height = localTextureInfo.width;
    }
  }
  
  public void clearSelfTexture()
  {
    this.textureInfo = null;
  }
  
  public CIImage clone()
  {
    CIImage localCIImage = new CIImage(this.size.clone());
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.textureCacheKey = this.textureCacheKey;
    localCIImage.bitmap = this.bitmap;
    localCIImage.preferRotation = this.preferRotation;
    localCIImage.transform = new Matrix(this.transform);
    CGRect localCGRect = this.frame;
    if (localCGRect != null) {
      localCGRect = new CGRect(localCGRect.origin, this.frame.size);
    } else {
      localCGRect = null;
    }
    localCIImage.frame = localCGRect;
    localCIImage.overlayImages.clear();
    localCIImage.overlayImages.addAll(this.overlayImages);
    localCIImage.alpha = this.alpha;
    return localCIImage;
  }
  
  @Deprecated
  public Bitmap convertToBitmap()
  {
    return TAVGLUtils.saveBitmap(this);
  }
  
  public void draw(TextureFilter paramTextureFilter)
  {
    Object localObject1 = getDrawTextureInfo();
    if (localObject1 != null)
    {
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("draw: with drawTexture = ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", filter = ");
      localStringBuilder.append(paramTextureFilter);
      Logger.v((String)localObject2, localStringBuilder.toString());
      paramTextureFilter.applyFilter((TextureInfo)localObject1, this.transform, ((TextureInfo)localObject1).getTextureMatrix(), this.alpha, this.frame);
    }
    if (this.overlayImages.isEmpty()) {
      return;
    }
    localObject1 = this.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("draw: with: draw overlayImages = ");
    ((StringBuilder)localObject2).append(this.overlayImages);
    ((StringBuilder)localObject2).append(", filter = ");
    ((StringBuilder)localObject2).append(paramTextureFilter);
    Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.overlayImages.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((CIImage)((Iterator)localObject1).next()).draw(paramTextureFilter);
    }
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getAlpha()
  {
    return this.alpha;
  }
  
  @Nullable
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  @Nullable
  public TextureInfo getDrawTextureInfo()
  {
    Object localObject1 = this.textureInfo;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = EGL14.eglGetCurrentContext();
    if (this.textureCacheKey == null) {
      this.textureCacheKey = String.valueOf(hashCode());
    }
    Object localObject2 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
    if ((localObject1 != null) && (localObject2 != null) && (!((TextureInfo)localObject2).isReleased())) {
      return localObject2;
    }
    if (this.bitmap != null)
    {
      int i = RenderContext.createTexture(3553);
      localObject2 = getImageTextureMatrix();
      localObject2 = new TextureInfo(i, 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), (Matrix)localObject2, this.preferRotation);
      GLES20.glBindTexture(3553, ((TextureInfo)localObject2).textureID);
      GLUtils.texImage2D(3553, 0, this.bitmap, 0);
      GLES20.glBindTexture(3553, 0);
      ThreadLocalTextureCache.getInstance().putTextureInfo(this.textureCacheKey, (TextureInfo)localObject2);
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDrawTextureInfo: bind bitmap texture, texture = ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(", eglContext = ");
      localStringBuilder.append(localObject1);
      Logger.v(str, localStringBuilder.toString());
      if (this.isHardMode)
      {
        this.bitmap.recycle();
        this.bitmap = null;
        Logger.v(this.TAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
      }
      return localObject2;
    }
    return null;
  }
  
  public CGRect getExtent()
  {
    return new CGRect(new PointF(0.0F, 0.0F), this.size);
  }
  
  @NonNull
  public List<CIImage> getOverlayImages()
  {
    return this.overlayImages;
  }
  
  @NonNull
  public CGSize getSize()
  {
    return this.size;
  }
  
  @Nullable
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  public CIImage imageApplyFillInFrame(CGRect paramCGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    if (paramTAVVideoConfigurationContentMode == TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill) {
      imageByCroppingToRect(MathUtils.rectFit(new CGRect(new PointF(), paramCGRect.size), getExtent()));
    }
    applyFillInFrame(paramCGRect, paramTAVVideoConfigurationContentMode);
    return this;
  }
  
  public CIImage imageByApplyingTransform(Matrix paramMatrix)
  {
    if (this.transform == null) {
      this.transform = new Matrix();
    }
    this.transform.postConcat(paramMatrix);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imageByApplyingTransform() called with: in transform = [");
    localStringBuilder.append(paramMatrix);
    localStringBuilder.append("], result transform = ");
    localStringBuilder.append(this.transform);
    Logger.v(str, localStringBuilder.toString());
    return this;
  }
  
  public CIImage imageByCompositingOverImage(CIImage paramCIImage)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imageByCompositingOverImage() called with: destImage = [");
    localStringBuilder.append(paramCIImage);
    localStringBuilder.append("]");
    Logger.v(str, localStringBuilder.toString());
    paramCIImage.addOverlayImage(this);
    return paramCIImage;
  }
  
  public CIImage imageByCroppingToRect(CGRect paramCGRect)
  {
    if (!Utils.isRectValid(paramCGRect)) {
      return this;
    }
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imageByCroppingToRect: frame = [");
    localStringBuilder.append(paramCGRect);
    localStringBuilder.append("]");
    Logger.v((String)localObject, localStringBuilder.toString());
    this.size.width = paramCGRect.size.width;
    this.size.height = paramCGRect.size.height;
    if (this.rotation % 2 != 0) {
      this.frame = new CGRect(paramCGRect.origin.y, paramCGRect.origin.x, paramCGRect.size.height, paramCGRect.size.width);
    } else {
      this.frame = paramCGRect.clone();
    }
    paramCGRect = paramCGRect.origin;
    if ((paramCGRect.x != 0.0F) || (paramCGRect.y != 0.0F))
    {
      localObject = new Matrix();
      ((Matrix)localObject).postTranslate(-paramCGRect.x, -paramCGRect.y);
      imageByApplyingTransform((Matrix)localObject);
    }
    return this;
  }
  
  public boolean isCanvasImage()
  {
    return (this.bitmap == null) && (this.textureInfo == null);
  }
  
  public boolean isOriginal()
  {
    return (this.preferRotation == 0) && (this.transform == null) && (this.frame == null) && (this.overlayImages.isEmpty()) && (this.rotation == 0) && (this.alpha == 1.0F);
  }
  
  public void release()
  {
    try
    {
      Logger.d(this.TAG, "release() start");
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        this.bitmap.recycle();
        this.bitmap = null;
      }
      releaseCacheTexture();
      Iterator localIterator = this.overlayImages.iterator();
      while (localIterator.hasNext())
      {
        CIImage localCIImage = (CIImage)localIterator.next();
        if (localCIImage != null) {
          localCIImage.release();
        }
      }
      this.overlayImages.clear();
      Logger.d(this.TAG, "release() end");
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void releaseCacheTexture()
  {
    TextureInfo localTextureInfo = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
    if (localTextureInfo != null)
    {
      localTextureInfo.release();
      ThreadLocalTextureCache.getInstance().remove(this.textureCacheKey);
    }
  }
  
  public void reset()
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset() called, before transform = ");
    localStringBuilder.append(this.transform);
    Logger.v(str, localStringBuilder.toString());
    if (this.transform != null) {
      this.transform = null;
    }
  }
  
  public CIImage safeApplyTransform(Matrix paramMatrix)
  {
    if (paramMatrix != null)
    {
      if (paramMatrix.isIdentity()) {
        return this;
      }
      Object localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safeApplyTransform: transform = [");
      localStringBuilder.append(paramMatrix);
      localStringBuilder.append("]");
      Logger.v((String)localObject, localStringBuilder.toString());
      float f1 = getExtent().origin.x + getExtent().size.width / 2.0F;
      float f2 = getExtent().origin.y + getExtent().size.height / 2.0F;
      localObject = new Matrix();
      ((Matrix)localObject).postTranslate(-f1, -f2);
      ((Matrix)localObject).postConcat(paramMatrix);
      paramMatrix = new Matrix();
      paramMatrix.postTranslate(f1, f2);
      ((Matrix)localObject).postConcat(paramMatrix);
      return imageByApplyingTransform((Matrix)localObject);
    }
    return this;
  }
  
  public void setAlpha(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setFrame(CGRect paramCGRect)
  {
    this.frame = paramCGRect;
  }
  
  public void setHardMode(boolean paramBoolean)
  {
    this.isHardMode = paramBoolean;
  }
  
  public CIImage simpleClone()
  {
    CIImage localCIImage = new CIImage(this.size.clone());
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.preferRotation = this.preferRotation;
    localCIImage.bitmap = this.bitmap;
    localCIImage.alpha = this.alpha;
    return localCIImage;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CIImage{hash=");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", textureInfo=");
    localStringBuilder.append(this.textureInfo);
    localStringBuilder.append(", bitmap=");
    localStringBuilder.append(this.bitmap);
    localStringBuilder.append(", transform=");
    localStringBuilder.append(this.transform);
    localStringBuilder.append(", frame=");
    localStringBuilder.append(this.frame);
    localStringBuilder.append(", overlayImages=");
    localStringBuilder.append(this.overlayImages);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImage
 * JD-Core Version:    0.7.0.1
 */