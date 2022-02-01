package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;

class PreSegNode$AEKitFilter
  implements TAVVideoEffect.Filter, IReportable, ExternalRenderCallback
{
  public static final String BaseFragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n";
  public static final String BaseVertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  AEAdjust aeAdjust;
  AEFilterManager aeFilterManager;
  AlphaAdjustFilter alphaAdjustFilter;
  private Frame cacheFrame;
  private TextureInfo cacheInputTextureInfo;
  private TextureInfo cacheOutTexture;
  private CIImage curCIImage;
  private VideoFilterBase mFlipFilter;
  private Frame mFlipFrame = new Frame();
  private int[] mFlipTextureID = new int[1];
  
  private PreSegNode$AEKitFilter(PreSegNode paramPreSegNode) {}
  
  private Bitmap checkSegCentre(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i4 = paramBitmap.getHeight();
    int i2 = paramBitmap.getWidth();
    int i3 = 0;
    int j = 0;
    int n = 0;
    int i;
    for (int k = 0;; k = i)
    {
      i = k;
      if (j >= paramBitmap.getWidth()) {
        break;
      }
      m = paramBitmap.getHeight() - 1;
      i = k;
      while (m >= 0)
      {
        if (Color.alpha(paramBitmap.getPixel(j, m)) != 0)
        {
          i = j;
          n = 1;
        }
        m -= 1;
      }
      if (n != 0) {
        break;
      }
      j += 1;
    }
    k = 0;
    int i1 = 0;
    for (int m = 0;; m = j)
    {
      j = m;
      if (k >= paramBitmap.getHeight()) {
        break;
      }
      n = paramBitmap.getWidth() - 1;
      j = m;
      while (n >= 0)
      {
        if (Color.alpha(paramBitmap.getPixel(n, k)) != 0)
        {
          j = k;
          i1 = 1;
        }
        n -= 1;
      }
      if (i1 != 0) {
        break;
      }
      k += 1;
    }
    m = paramBitmap.getWidth() - 1;
    n = i2;
    i2 = 0;
    for (;;)
    {
      k = n;
      if (m < 0) {
        break;
      }
      i1 = paramBitmap.getHeight() - 1;
      k = n;
      while (i1 >= 0)
      {
        if (Color.alpha(paramBitmap.getPixel(m, i1)) != 0)
        {
          k = m;
          i2 = 1;
        }
        i1 -= 1;
      }
      if (i2 != 0) {
        break;
      }
      m -= 1;
      n = k;
    }
    m = paramBitmap.getHeight() - 1;
    i2 = 0;
    n = i4;
    for (;;)
    {
      i1 = n;
      if (m < 0) {
        break;
      }
      i1 = paramBitmap.getWidth() - 1;
      while (i1 >= 0)
      {
        if (Color.alpha(paramBitmap.getPixel(i1, m)) != 0)
        {
          n = m;
          i2 = 1;
        }
        i1 -= 1;
      }
      if (i2 != 0)
      {
        i1 = n;
        break;
      }
      m -= 1;
    }
    n = i1;
    m = j;
    if (j == i1)
    {
      n = paramBitmap.getHeight();
      m = 0;
    }
    if (i == k)
    {
      k = paramBitmap.getHeight();
      i = i3;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i, m, k - i, n - m);
    paramBitmap.recycle();
    return localBitmap;
  }
  
  private Bitmap getTextureInfoBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    Object localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    GLES20.glBindFramebuffer(36160, localObject[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, this.cacheOutTexture.textureType, paramInt3, 0);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    return localObject;
  }
  
  private void initAEFilterManager(int paramInt1, int paramInt2)
  {
    Logger.i("AEKitFilter", "constructing");
    DurationUtil.start("init aeFilterManager");
    this.aeFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
    this.aeFilterManager.supportMultiThreads(true);
    this.aeFilterManager.initInGL(paramInt1, paramInt2);
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 300, 100 });
    this.aeFilterManager.setFilterInSmooth(true);
    this.aeFilterManager.setExternalRenderCallback(this);
    this.aeAdjust = new AEAdjust();
    this.aeAdjust.apply();
    this.cacheFrame = new Frame();
    this.alphaAdjustFilter = new AlphaAdjustFilter();
    this.alphaAdjustFilter.apply();
    int[] arrayOfInt = this.mFlipTextureID;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.mFlipFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
    this.mFlipFilter.ApplyGLSLFilter();
    DurationUtil.end("init aeFilterManager");
  }
  
  private void initFilterManagerWrap(int paramInt1, int paramInt2)
  {
    if (this.aeFilterManager == null)
    {
      this.aeFilterManager = PreSegNode.access$100(this.this$0);
      Object localObject = this.aeFilterManager;
      if (localObject != null)
      {
        ((AEFilterManager)localObject).initInGL(paramInt1, paramInt2);
        this.aeFilterManager.setExternalRenderCallback(this);
        this.cacheFrame = new Frame();
        this.aeAdjust = new AEAdjust();
        this.aeAdjust.apply();
        this.alphaAdjustFilter = new AlphaAdjustFilter();
        this.alphaAdjustFilter.apply();
        localObject = this.mFlipTextureID;
        GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
        this.mFlipFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
        this.mFlipFilter.ApplyGLSLFilter();
      }
    }
    if (this.aeFilterManager == null) {
      initAEFilterManager(paramInt1, paramInt2);
    }
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    Object localObject = paramCIImage;
    long l = System.currentTimeMillis();
    Logger.i("PreSegNode begin", String.valueOf(l));
    if (PreSegNode.access$200(this.this$0) == null) {
      return localObject;
    }
    String str = WSSegmentManager.getCacheName(PreSegNode.access$200(this.this$0), PreSegNode.access$300(this.this$0));
    int i = PreSegNode.access$200(this.this$0).getIndex();
    if (i < 0) {
      return localObject;
    }
    if (PreSegNode.access$400(this.this$0) != null)
    {
      paramTAVVideoEffect = PreSegNode.access$400(this.this$0).getCachePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTAVVideoEffect);
      localStringBuilder.append(File.pathSeparator);
      localStringBuilder.append(str);
      localStringBuilder.append(".jpg");
      paramTAVVideoEffect = localStringBuilder.toString();
      if (new File(paramTAVVideoEffect).exists())
      {
        paramCIImage = this.curCIImage;
        if (paramCIImage != null) {
          paramCIImage.release();
        }
        this.curCIImage = new CIImage(paramTAVVideoEffect);
        return this.curCIImage;
      }
    }
    paramTAVVideoEffect = WSSegmentManager.INSTANCE;
    paramTAVVideoEffect = WSSegmentManager.get(i, str);
    if ((paramTAVVideoEffect != null) && (paramTAVVideoEffect.getHeight() > 0) && (paramTAVVideoEffect.getWidth() > 0))
    {
      paramCIImage = this.curCIImage;
      if (paramCIImage != null) {
        paramCIImage.release();
      }
      this.curCIImage = new CIImage(paramTAVVideoEffect.copy(paramTAVVideoEffect.getConfig(), true));
      return this.curCIImage;
    }
    DurationUtil.start("apply aeFilterManager");
    int j = (int)paramCIImage.getSize().width;
    int k = (int)paramCIImage.getSize().height;
    initFilterManagerWrap(j, k);
    if (!this.aeFilterManager.isInited()) {
      return localObject;
    }
    paramCIImage = paramRenderInfo.getCiContext();
    paramTAVVideoEffect = (TAVVideoEffect)localObject;
    if (paramCIImage != null)
    {
      if (paramCIImage.getRenderContext() == null) {
        return localObject;
      }
      if (this.cacheInputTextureInfo == null)
      {
        paramCIImage.getRenderContext().makeCurrent();
        this.cacheInputTextureInfo = CIContext.newTextureInfo(j, k);
      }
      if ((this.cacheInputTextureInfo.width != j) || (this.cacheInputTextureInfo.height != k))
      {
        paramCIImage.getRenderContext().makeCurrent();
        this.cacheInputTextureInfo.release();
        this.cacheInputTextureInfo = CIContext.newTextureInfo(j, k);
      }
      paramTAVVideoEffect = this.cacheOutTexture;
      if (paramTAVVideoEffect == null)
      {
        paramCIImage.getRenderContext().makeCurrent();
        this.cacheOutTexture = CIContext.newTextureInfo(j, k);
      }
      else if ((paramTAVVideoEffect.width != j) || (this.cacheOutTexture.height != k))
      {
        paramCIImage.getRenderContext().makeCurrent();
        this.cacheOutTexture.release();
        this.cacheOutTexture = CIContext.newTextureInfo(j, k);
      }
      paramCIImage.convertImageToTexture((CIImage)localObject, this.cacheInputTextureInfo);
      paramCIImage = this.cacheInputTextureInfo;
      if (paramCIImage == null) {
        return localObject;
      }
      this.aeFilterManager.updateWidthHeight(paramCIImage.width, paramCIImage.height);
      if (PreSegNode.access$200(this.this$0) != null)
      {
        paramRenderInfo = PreSegNode.access$200(this.this$0).getSegMaterial();
        if (TextUtils.isEmpty(paramRenderInfo)) {
          return localObject;
        }
        this.aeFilterManager.switchAbilityInLightNode("smooth.enable", false);
        if (!TextUtils.isEmpty(paramRenderInfo))
        {
          this.mFlipFilter.RenderProcess(paramCIImage.textureID, paramCIImage.width, paramCIImage.height, this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
          paramTAVVideoEffect = this.mFlipFrame;
        }
        else
        {
          paramTAVVideoEffect = null;
        }
        this.aeFilterManager.switchAbilityInLightNode("sticker.enable", true);
        paramRenderInfo = VideoSDKMaterialParser.parseVideoMaterial(paramRenderInfo, "params");
        this.aeFilterManager.updateMaterialGL(paramRenderInfo);
        this.aeFilterManager.setSyncMode(true);
      }
      else
      {
        paramTAVVideoEffect = null;
      }
      int m = paramCIImage.textureID;
      Logger.i("PreSegNode set up", String.valueOf(System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      DurationUtil.start("aeFilterManager.drawFrame");
      m = this.aeFilterManager.drawFrame(m, false, 0L);
      DurationUtil.end("aeFilterManager.drawFrame");
      Logger.i("PreSegNode draw frame", String.valueOf(System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      paramCIImage = checkSegCentre(getTextureInfoBitmap(this.cacheInputTextureInfo.width, this.cacheInputTextureInfo.height, m));
      if (paramCIImage == null) {
        return localObject;
      }
      paramRenderInfo = WSSegmentManager.INSTANCE;
      WSSegmentManager.put(i, str, paramCIImage);
      if ((PreSegNode.access$400(this.this$0) != null) && (paramCIImage != null) && (paramCIImage.getWidth() > 0) && (paramCIImage.getHeight() > 0))
      {
        paramRenderInfo = PreSegNode.access$400(this.this$0).getCachePath();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramRenderInfo);
        ((StringBuilder)localObject).append(File.pathSeparator);
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".jpg");
        paramRenderInfo = ((StringBuilder)localObject).toString();
        PreSegNode.access$400(this.this$0).savePic(paramRenderInfo, paramCIImage);
      }
      this.mFlipFilter.OnDrawFrameGLSL();
      this.mFlipFilter.RenderProcess(m, j, k, this.cacheOutTexture.textureID, 0.0D, this.cacheFrame);
      if ((paramTAVVideoEffect != null) && (!paramTAVVideoEffect.unlock())) {
        paramTAVVideoEffect.clear();
      }
      this.aeFilterManager.updateMaterialGL(null);
      FrameBufferCache.getInstance().forceRecycle();
      this.aeFilterManager.freeCache();
      paramTAVVideoEffect = new CIImage(paramCIImage);
      Logger.i("PreSegNode after", String.valueOf(System.currentTimeMillis() - l));
    }
    return paramTAVVideoEffect;
  }
  
  public String getReportKey()
  {
    return PreSegNode.access$500(this.this$0);
  }
  
  public void onRender(Texture paramTexture1, String paramString1, String paramString2, Texture paramTexture2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRender: 触发外挂滤镜，参数：");
    localStringBuilder.append(paramTexture1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramTexture2);
    LogUtils.d("PreSegNode", localStringBuilder.toString());
    paramTexture2.id = paramTexture1.id;
    paramTexture2.width = paramTexture1.width;
    paramTexture2.height = paramTexture1.height;
  }
  
  public void release()
  {
    Log.i("PreSegNode", "releaseAEKitFilter---");
    Object localObject = this.mFlipTextureID;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.aeFilterManager;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).setExternalRenderCallback(null);
      if (PreSegNode.access$100(this.this$0) == null) {
        this.aeFilterManager.destroy();
      }
      this.aeFilterManager = null;
    }
    if (PreSegNode.access$100(this.this$0) != null) {
      PreSegNode.access$102(this.this$0, null);
    }
    localObject = this.curCIImage;
    if (localObject != null)
    {
      ((CIImage)localObject).release();
      this.curCIImage = null;
    }
    localObject = this.mFlipFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.mFlipFrame = null;
    }
    localObject = this.alphaAdjustFilter;
    if (localObject != null) {
      ((AlphaAdjustFilter)localObject).clear();
    }
    localObject = this.cacheInputTextureInfo;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.cacheInputTextureInfo.release();
    }
    localObject = this.cacheOutTexture;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.cacheOutTexture.release();
    }
    localObject = this.cacheFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.cacheFrame = null;
    }
    localObject = this.mFlipFilter;
    if (localObject != null)
    {
      ((VideoFilterBase)localObject).clearGLSLSelf();
      this.mFlipFilter = null;
    }
    localObject = this.aeAdjust;
    if (localObject != null)
    {
      ((AEAdjust)localObject).clear();
      this.aeAdjust = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.PreSegNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */