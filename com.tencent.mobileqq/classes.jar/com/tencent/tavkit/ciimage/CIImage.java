package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
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
  private final String TAG = "CIImage@" + Integer.toHexString(hashCode());
  @FloatRange(from=0.0D, to=1.0D)
  private float alpha = 1.0F;
  @Nullable
  private Bitmap bitmap;
  @Nullable
  private CGRect frame;
  private boolean isHardMode = false;
  @NonNull
  private final List<CIImage> overlayImages = new ArrayList();
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
    Logger.v(this.TAG, "CIImage() called with: bitmap = [" + paramBitmap + "]");
    this.bitmap = TAVImageFactory.fixSupportImageConfig(paramBitmap);
    this.size = new CGSize(paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public CIImage(@NonNull CGSize paramCGSize)
  {
    Logger.v(this.TAG, "CIImage() called with: renderSize = [" + paramCGSize + "]");
    this.size = paramCGSize;
  }
  
  public CIImage(TextureInfo paramTextureInfo)
  {
    Logger.v(this.TAG, "CIImage() called with: textureInfo = [" + paramTextureInfo + "]");
    this.textureInfo = paramTextureInfo;
    this.size = new CGSize(paramTextureInfo.width, paramTextureInfo.height);
  }
  
  public CIImage(String paramString)
  {
    this(paramString, null);
  }
  
  public CIImage(String paramString, CGSize paramCGSize)
  {
    long l = System.currentTimeMillis();
    this.preferRotation = TAVBitmapUtils.readImagePreferRotation(paramString);
    this.bitmap = decodeBitmap(paramString, paramCGSize);
    this.bitmap = TAVImageFactory.fixSupportImageConfig(this.bitmap);
    if (this.bitmap != null)
    {
      this.size = new CGSize(this.bitmap.getWidth(), this.bitmap.getHeight());
      Logger.v(this.TAG, "CIImage() called with: imagePath = [" + paramString + "], sampleSize = " + paramCGSize + ", BitmapFactory.decodeFile cons ms = " + (System.currentTimeMillis() - l) + ", outBitmapSize = " + this.size);
      return;
    }
    Logger.e(this.TAG, "CIImage: 图片解码失败！imagePath = " + paramString);
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
    int i = 1;
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
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
    switch (CIImage.1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()])
    {
    default: 
      return;
    case 1: 
      localMatrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      return;
    case 2: 
      localMatrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      return;
    }
    paramTAVVideoConfigurationContentMode = new Matrix();
    paramTAVVideoConfigurationContentMode.postScale(paramCGRect.size.width / getExtent().size.width, paramCGRect.size.height / getExtent().size.height);
    localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
    paramTAVVideoConfigurationContentMode = new Matrix();
    paramTAVVideoConfigurationContentMode.postTranslate(paramCGRect.origin.x, paramCGRect.origin.y);
    localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
    imageByApplyingTransform(localMatrix);
  }
  
  public void applyFixInSize(CGSize paramCGSize, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    if (!Utils.isSizeValid(paramCGSize)) {
      return;
    }
    switch (CIImage.1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()])
    {
    default: 
      paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
    }
    for (;;)
    {
      paramTAVVideoConfigurationContentMode = new Matrix();
      paramTAVVideoConfigurationContentMode.postScale(paramCGSize.width / this.size.width, paramCGSize.height / this.size.height);
      imageByApplyingTransform(paramTAVVideoConfigurationContentMode);
      this.size.height = paramCGSize.height;
      this.size.width = paramCGSize.width;
      return;
      paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
      continue;
      paramCGSize = MathUtils.sizeFill(this.size, paramCGSize);
      continue;
      paramCGSize = MathUtils.sizeScale(this.size, paramCGSize);
    }
  }
  
  public void applyFlip(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f4 = 0.0F;
    float f3 = -1.0F;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    float f1;
    float f2;
    if (paramBoolean1)
    {
      f1 = -1.0F;
      if (!paramBoolean1) {
        break label94;
      }
      f2 = this.size.width;
      label36:
      if (!paramBoolean2) {
        break label100;
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        f4 = this.size.height;
      }
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f3);
      localMatrix.postTranslate(f2, f4);
      imageByApplyingTransform(localMatrix);
      return;
      f1 = 1.0F;
      break;
      label94:
      f2 = 0.0F;
      break label36;
      label100:
      f3 = 1.0F;
    }
  }
  
  public void applyPreferRotation()
  {
    applyPreferRotation(0);
  }
  
  public void applyPreferRotation(int paramInt)
  {
    TextureInfo localTextureInfo = getDrawTextureInfo();
    if (localTextureInfo == null) {}
    do
    {
      do
      {
        return;
        this.rotation = (localTextureInfo.preferRotation + paramInt);
      } while (this.rotation == 0);
      Logger.v(this.TAG, "applyPreferRotation: textureInfo.preferRotation = " + this.rotation);
      Matrix localMatrix = new Matrix();
      DecoderUtils.getRotationMatrix(localMatrix, this.rotation, localTextureInfo.width, localTextureInfo.height);
      imageByApplyingTransform(localMatrix);
    } while (this.rotation % 2 != 1);
    this.size.width = localTextureInfo.height;
    this.size.height = localTextureInfo.width;
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
    if (this.frame != null) {}
    for (CGRect localCGRect = new CGRect(this.frame.origin, this.frame.size);; localCGRect = null)
    {
      localCIImage.frame = localCGRect;
      localCIImage.overlayImages.clear();
      localCIImage.overlayImages.addAll(this.overlayImages);
      localCIImage.alpha = this.alpha;
      return localCIImage;
    }
  }
  
  @Deprecated
  public Bitmap convertToBitmap()
  {
    return TAVGLUtils.saveBitmap(this);
  }
  
  public void draw(TextureFilter paramTextureFilter)
  {
    Object localObject = getDrawTextureInfo();
    if (localObject != null)
    {
      Logger.v(this.TAG, "draw: with drawTexture = " + localObject + ", filter = " + paramTextureFilter);
      paramTextureFilter.applyFilter((TextureInfo)localObject, this.transform, ((TextureInfo)localObject).getTextureMatrix(), this.alpha, this.frame);
    }
    if (this.overlayImages.isEmpty()) {}
    for (;;)
    {
      return;
      Logger.v(this.TAG, "draw: with: draw overlayImages = " + this.overlayImages + ", filter = " + paramTextureFilter);
      localObject = this.overlayImages.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((CIImage)((Iterator)localObject).next()).draw(paramTextureFilter);
      }
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
    Object localObject;
    if (this.textureInfo != null) {
      localObject = this.textureInfo;
    }
    TextureInfo localTextureInfo;
    do
    {
      EGLContext localEGLContext;
      do
      {
        return localObject;
        localEGLContext = EGL14.eglGetCurrentContext();
        if (this.textureCacheKey == null) {
          this.textureCacheKey = String.valueOf(hashCode());
        }
        localTextureInfo = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
        if ((localEGLContext == null) || (localTextureInfo == null)) {
          break;
        }
        localObject = localTextureInfo;
      } while (!localTextureInfo.isReleased());
      if (this.bitmap == null) {
        break;
      }
      int i = RenderContext.createTexture(3553);
      localObject = getImageTextureMatrix();
      localTextureInfo = new TextureInfo(i, 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), (Matrix)localObject, this.preferRotation);
      GLES20.glBindTexture(3553, localTextureInfo.textureID);
      GLUtils.texImage2D(3553, 0, this.bitmap, 0);
      GLES20.glBindTexture(3553, 0);
      ThreadLocalTextureCache.getInstance().putTextureInfo(this.textureCacheKey, localTextureInfo);
      Logger.v(this.TAG, "getDrawTextureInfo: bind bitmap texture, texture = " + localTextureInfo + ", eglContext = " + localEGLContext);
      localObject = localTextureInfo;
    } while (!this.isHardMode);
    this.bitmap.recycle();
    this.bitmap = null;
    Logger.v(this.TAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
    return localTextureInfo;
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
    if (paramTAVVideoConfigurationContentMode == TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill) {}
    applyFillInFrame(paramCGRect, paramTAVVideoConfigurationContentMode);
    return this;
  }
  
  public CIImage imageByApplyingTransform(Matrix paramMatrix)
  {
    if (this.transform == null) {
      this.transform = new Matrix();
    }
    this.transform.postConcat(paramMatrix);
    Logger.v(this.TAG, "imageByApplyingTransform() called with: in transform = [" + paramMatrix + "], result transform = " + this.transform);
    return this;
  }
  
  public CIImage imageByCompositingOverImage(CIImage paramCIImage)
  {
    Logger.v(this.TAG, "imageByCompositingOverImage() called with: destImage = [" + paramCIImage + "]");
    paramCIImage.addOverlayImage(this);
    return paramCIImage;
  }
  
  public CIImage imageByCroppingToRect(CGRect paramCGRect)
  {
    if (!Utils.isRectValid(paramCGRect)) {
      return this;
    }
    Logger.v(this.TAG, "imageByCroppingToRect: frame = [" + paramCGRect + "]");
    this.size.width = paramCGRect.size.width;
    this.size.height = paramCGRect.size.height;
    if (this.rotation % 2 != 0) {}
    for (this.frame = new CGRect(paramCGRect.origin.y, paramCGRect.origin.x, paramCGRect.size.height, paramCGRect.size.width);; this.frame = paramCGRect.clone())
    {
      paramCGRect = paramCGRect.origin;
      if ((paramCGRect.x == 0.0F) && (paramCGRect.y == 0.0F)) {
        break;
      }
      Matrix localMatrix = new Matrix();
      localMatrix.postTranslate(-paramCGRect.x, -paramCGRect.y);
      imageByApplyingTransform(localMatrix);
      return this;
    }
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
    }
    finally {}
    Logger.d(this.TAG, "release() end");
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
    Logger.v(this.TAG, "reset() called, before transform = " + this.transform);
    if (this.transform != null) {
      this.transform = null;
    }
  }
  
  public CIImage safeApplyTransform(Matrix paramMatrix)
  {
    if ((paramMatrix == null) || (paramMatrix.isIdentity())) {
      return this;
    }
    Logger.v(this.TAG, "safeApplyTransform: transform = [" + paramMatrix + "]");
    float f1 = getExtent().origin.x + getExtent().size.width / 2.0F;
    float f2 = getExtent().origin.y + getExtent().size.height / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(-f1, -f2);
    localMatrix.postConcat(paramMatrix);
    paramMatrix = new Matrix();
    paramMatrix.postTranslate(f1, f2);
    localMatrix.postConcat(paramMatrix);
    return imageByApplyingTransform(localMatrix);
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
    return "CIImage{hash=" + Integer.toHexString(hashCode()) + ", size=" + this.size + ", textureInfo=" + this.textureInfo + ", bitmap=" + this.bitmap + ", transform=" + this.transform + ", frame=" + this.frame + ", overlayImages=" + this.overlayImages + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImage
 * JD-Core Version:    0.7.0.1
 */