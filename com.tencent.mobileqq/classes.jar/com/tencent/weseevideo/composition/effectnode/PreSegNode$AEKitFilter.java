package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.util.Logger;
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
  AEAdjust jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust;
  AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
  private VideoFilterBase jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase;
  private TextureInfo jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
  private CIImage jdField_a_of_type_ComTencentTavkitCiimageCIImage;
  AlphaAdjustFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private Frame jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private TextureInfo jdField_b_of_type_ComTencentTavCoremediaTextureInfo;
  
  private PreSegNode$AEKitFilter(PreSegNode paramPreSegNode) {}
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    Object localObject = new int[1];
    GLES20.glGenFramebuffers(1, (int[])localObject, 0);
    GLES20.glBindFramebuffer(36160, localObject[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo.textureType, paramInt3, 0);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    return localObject;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Logger.i("AEKitFilter", "constructing");
    DurationUtil.start("init aeFilterManager");
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.supportMultiThreads(true);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 300, 100 });
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setFilterInSmooth(true);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setExternalRenderCallback(this);
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust = new AEAdjust();
    this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust.apply();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter = new AlphaAdjustFilter();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter.apply();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase.ApplyGLSLFilter();
    DurationUtil.end("init aeFilterManager");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode);
      Object localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
      if (localObject != null)
      {
        ((AEFilterManager)localObject).initInGL(paramInt1, paramInt2);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setExternalRenderCallback(this);
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust = new AEAdjust();
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust.apply();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter = new AlphaAdjustFilter();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter.apply();
        localObject = this.jdField_a_of_type_ArrayOfInt;
        GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
        this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase.ApplyGLSLFilter();
      }
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) {
      a(paramInt1, paramInt2);
    }
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramCIImage;
    if (PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) == null) {
      return paramTAVVideoEffect;
    }
    String str = WSSegmentManager.a(PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode), PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode));
    int i = PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode).getIndex();
    if (i < 0) {
      return paramTAVVideoEffect;
    }
    if (PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) != null)
    {
      localObject = PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.pathSeparator);
      localStringBuilder.append(str);
      localStringBuilder.append(".jpg");
      localObject = localStringBuilder.toString();
      if (new File((String)localObject).exists())
      {
        paramTAVVideoEffect = this.jdField_a_of_type_ComTencentTavkitCiimageCIImage;
        if (paramTAVVideoEffect != null) {
          paramTAVVideoEffect.release();
        }
        this.jdField_a_of_type_ComTencentTavkitCiimageCIImage = new CIImage((String)localObject);
        return this.jdField_a_of_type_ComTencentTavkitCiimageCIImage;
      }
    }
    Object localObject = WSSegmentManager.a;
    localObject = WSSegmentManager.a(i, str);
    if ((localObject != null) && (((Bitmap)localObject).getHeight() > 0) && (((Bitmap)localObject).getWidth() > 0))
    {
      paramTAVVideoEffect = this.jdField_a_of_type_ComTencentTavkitCiimageCIImage;
      if (paramTAVVideoEffect != null) {
        paramTAVVideoEffect.release();
      }
      this.jdField_a_of_type_ComTencentTavkitCiimageCIImage = new CIImage(((Bitmap)localObject).copy(((Bitmap)localObject).getConfig(), true));
      return this.jdField_a_of_type_ComTencentTavkitCiimageCIImage;
    }
    DurationUtil.start("apply aeFilterManager");
    int j = (int)paramCIImage.getSize().width;
    int k = (int)paramCIImage.getSize().height;
    b(j, k);
    if (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited()) {
      return paramTAVVideoEffect;
    }
    paramRenderInfo = paramRenderInfo.getCiContext();
    paramCIImage = paramTAVVideoEffect;
    if (paramRenderInfo != null)
    {
      if (paramRenderInfo.getRenderContext() == null) {
        return paramTAVVideoEffect;
      }
      if (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo == null)
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
      }
      if ((this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.width != j) || (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.height != k))
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.release();
        this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
      }
      paramCIImage = this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo;
      if (paramCIImage == null)
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
      }
      else if ((paramCIImage.width != j) || (this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo.height != k))
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo.release();
        this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
      }
      paramRenderInfo.convertImageToTexture(paramTAVVideoEffect, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo);
      paramCIImage = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
      if (paramCIImage == null) {
        return paramTAVVideoEffect;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(paramCIImage.width, paramCIImage.height);
      if (PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) != null)
      {
        paramRenderInfo = PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode).getSegMaterial();
        if (TextUtils.isEmpty(paramRenderInfo)) {
          return paramTAVVideoEffect;
        }
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("smooth.enable", false);
        if (!TextUtils.isEmpty(paramRenderInfo))
        {
          this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase.RenderProcess(paramCIImage.textureID, paramCIImage.width, paramCIImage.height, this.jdField_a_of_type_ArrayOfInt[0], 0.0D, this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame);
          paramTAVVideoEffect = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
        }
        else
        {
          paramTAVVideoEffect = null;
        }
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchAbilityInLightNode("sticker.enable", true);
        paramRenderInfo = VideoSDKMaterialParser.parseVideoMaterial(paramRenderInfo, "params");
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(paramRenderInfo);
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setSyncMode(true);
      }
      else
      {
        paramTAVVideoEffect = null;
      }
      int m = paramCIImage.textureID;
      DurationUtil.start("aeFilterManager.drawFrame");
      m = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(m, false, 0L);
      DurationUtil.end("aeFilterManager.drawFrame");
      paramCIImage = a(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.width, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.height, m);
      paramRenderInfo = WSSegmentManager.a;
      WSSegmentManager.a(i, str, paramCIImage);
      if ((PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) != null) && (paramCIImage != null) && (paramCIImage.getWidth() > 0) && (paramCIImage.getHeight() > 0))
      {
        paramRenderInfo = PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode).a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramRenderInfo);
        ((StringBuilder)localObject).append(File.pathSeparator);
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".jpg");
        paramRenderInfo = ((StringBuilder)localObject).toString();
        PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode).a(paramRenderInfo, paramCIImage);
      }
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase.OnDrawFrameGLSL();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase.RenderProcess(m, j, k, this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo.textureID, 0.0D, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      if ((paramTAVVideoEffect != null) && (!paramTAVVideoEffect.unlock())) {
        paramTAVVideoEffect.clear();
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
      FrameBufferCache.getInstance().forceRecycle();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.freeCache();
      paramCIImage = new CIImage(this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo);
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    return PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode);
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
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).setExternalRenderCallback(null);
      if (PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) == null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    if (PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode) != null) {
      PreSegNode.a(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodePreSegNode, null);
    }
    localObject = this.jdField_a_of_type_ComTencentTavkitCiimageCIImage;
    if (localObject != null)
    {
      ((CIImage)localObject).release();
      this.jdField_a_of_type_ComTencentTavkitCiimageCIImage = null;
    }
    localObject = this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.jdField_b_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterAlphaAdjustFilter;
    if (localObject != null) {
      ((AlphaAdjustFilter)localObject).clear();
    }
    localObject = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.release();
    }
    localObject = this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.jdField_b_of_type_ComTencentTavCoremediaTextureInfo.release();
    }
    localObject = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    if (localObject != null)
    {
      ((Frame)localObject).clear();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase;
    if (localObject != null)
    {
      ((VideoFilterBase)localObject).clearGLSLSelf();
      this.jdField_a_of_type_ComTencentAekitOpenrenderInternalVideoFilterBase = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust;
    if (localObject != null)
    {
      ((AEAdjust)localObject).clear();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEAdjust = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.PreSegNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */