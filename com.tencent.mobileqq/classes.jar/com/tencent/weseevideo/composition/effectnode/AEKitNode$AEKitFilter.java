package com.tencent.weseevideo.composition.effectnode;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.HashMap;
import java.util.Map;

class AEKitNode$AEKitFilter
  implements TAVVideoEffect.Filter, IReportable
{
  public static final String BaseFragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n";
  public static final String BaseVertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  AEFilterManager aeFilterManager;
  AlphaAdjustFilter alphaAdjustFilter;
  private Frame cacheFrame;
  private TextureInfo cacheOutTexture;
  private TextureInfo cacheTextureInfo;
  private String currentAppliedLutPath;
  private String currentAppliedMaterialPath;
  private PTFaceDetector faceDetector;
  private VideoFilterBase mFlipFilter;
  private Frame mFlipFrame = new Frame();
  private int[] mFlipTextureID = new int[1];
  
  private AEKitNode$AEKitFilter(AEKitNode paramAEKitNode) {}
  
  private void initAEFilterManager(int paramInt1, int paramInt2)
  {
    Logger.i("AEKitFilter", "constructing");
    DurationUtil.start("init aeFilterManager");
    this.aeFilterManager = new AEFilterManager();
    this.aeFilterManager.supportMultiThreads(true);
    this.aeFilterManager.enableAIDetect(false);
    this.aeFilterManager.initInGL(paramInt1, paramInt2);
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 118, 101, 116, 102, 103 });
    this.aeFilterManager.setFilterInSmooth(true);
    this.aeFilterManager.switchFilterOn(101, false);
    this.aeFilterManager.switchFilterOn(116, false);
    this.aeFilterManager.switchFilterOn(102, false);
    this.aeFilterManager.switchFilterOn(103, false);
    this.cacheFrame = new Frame();
    this.alphaAdjustFilter = new AlphaAdjustFilter();
    this.alphaAdjustFilter.apply();
    GLES20.glGenTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
    this.mFlipFilter = new VideoFilterBase("precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n");
    this.mFlipFilter.ApplyGLSLFilter();
    DurationUtil.end("init aeFilterManager");
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (AEKitNode.access$100(this.this$0) == null) {}
    int j;
    int k;
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return paramCIImage;
            } while ((AEKitNode.access$100(this.this$0) != null) && (AEKitNode.access$100(this.this$0).isDisable()));
            if (AEKitNode.access$100(this.this$0) != null)
            {
              paramTAVVideoEffect = AEKitNode.access$100(this.this$0).getOverlayImgPath();
              if (!TextUtils.isEmpty(paramTAVVideoEffect))
              {
                Logger.i("AEKitNode", "apply---has overlayPath: " + paramTAVVideoEffect);
                return new CIImage(paramTAVVideoEffect);
              }
            }
            DurationUtil.start("apply aeFilterManager");
            j = (int)paramCIImage.getSize().width;
            k = (int)paramCIImage.getSize().height;
            if (this.aeFilterManager == null) {
              initAEFilterManager(j, k);
            }
          } while (!this.aeFilterManager.isInited());
          paramTAVVideoEffect = paramRenderInfo.getCiContext();
        } while ((paramTAVVideoEffect == null) || (paramTAVVideoEffect.getRenderContext() == null));
        l = paramRenderInfo.getTime().getTimeUs() / 1000L;
      } while ((AEKitNode.access$100(this.this$0) != null) && ((l < AEKitNode.access$100(this.this$0).getStartTime()) || (l > AEKitNode.access$100(this.this$0).getStartTime() + AEKitNode.access$100(this.this$0).getDuration())));
      if (this.cacheTextureInfo == null)
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.cacheTextureInfo = CIContext.newTextureInfo(j, k);
      }
      if ((this.cacheTextureInfo.width != j) || (this.cacheTextureInfo.height != k))
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.cacheTextureInfo.release();
        this.cacheTextureInfo = CIContext.newTextureInfo(j, k);
      }
      if (this.cacheOutTexture != null) {
        break;
      }
      paramTAVVideoEffect.getRenderContext().makeCurrent();
      this.cacheOutTexture = CIContext.newTextureInfo(j, k);
      paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.cacheTextureInfo);
      paramRenderInfo = this.cacheTextureInfo;
    } while (paramRenderInfo == null);
    paramTAVVideoEffect = null;
    this.aeFilterManager.updateWidthHeight(paramRenderInfo.width, paramRenderInfo.height);
    label526:
    boolean bool;
    label576:
    Object localObject;
    if (AEKitNode.access$100(this.this$0) != null)
    {
      this.aeFilterManager.setGlowAlpha(AEKitNode.access$100(this.this$0).getGlowAlpha());
      if (!TextUtils.equals(this.currentAppliedLutPath, AEKitNode.access$100(this.this$0).getLutPath()))
      {
        this.currentAppliedLutPath = AEKitNode.access$100(this.this$0).getLutPath();
        this.aeFilterManager.updateLutGL(this.currentAppliedLutPath);
        this.aeFilterManager.setFilterInSmooth(true);
      }
      this.aeFilterManager.setLookupLevel(AEKitNode.access$100(this.this$0).getLutAlpha());
      this.aeFilterManager.setSmoothLevel(AEKitNode.access$100(this.this$0).getSmoothLevel());
      paramCIImage = AEKitNode.access$100(this.this$0).getAdjustParams();
      if ((paramCIImage != null) && (!paramCIImage.isEmpty()))
      {
        this.aeFilterManager.setAdjustParams(new HashMap(paramCIImage));
        this.aeFilterManager.switchFilterOn(116, true);
        paramCIImage = AEKitNode.access$100(this.this$0).getMaterial();
        if ((TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath())) && (AEKitNode.access$100(this.this$0).getSmoothLevel() <= 0) && (TextUtils.isEmpty(paramCIImage))) {
          break label981;
        }
        bool = true;
        this.aeFilterManager.switchFilterOn(101, bool);
        if (!TextUtils.isEmpty(paramCIImage))
        {
          this.mFlipFilter.RenderProcess(paramRenderInfo.textureID, paramRenderInfo.width, paramRenderInfo.height, this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
          paramTAVVideoEffect = this.mFlipFrame;
        }
        if (TextUtils.equals(this.currentAppliedMaterialPath, paramCIImage)) {
          break label1089;
        }
        this.currentAppliedMaterialPath = paramCIImage;
        localObject = this.aeFilterManager;
        if (TextUtils.isEmpty(paramCIImage)) {
          break label987;
        }
        bool = true;
        label661:
        ((AEFilterManager)localObject).switchFilterOn(102, bool);
        localObject = this.aeFilterManager;
        if (TextUtils.isEmpty(paramCIImage)) {
          break label993;
        }
        bool = true;
        label686:
        ((AEFilterManager)localObject).switchFilterOn(103, bool);
        if (!TextUtils.isEmpty(paramCIImage)) {
          break label999;
        }
        this.aeFilterManager.updateMaterialGL(null);
      }
    }
    for (;;)
    {
      label710:
      int i;
      if (paramTAVVideoEffect != null)
      {
        i = paramTAVVideoEffect.getTextureId();
        label720:
        DurationUtil.start("aeFilterManager.drawFrame");
        i = this.aeFilterManager.drawFrame(i, false, 0L);
        DurationUtil.end("aeFilterManager.drawFrame");
        if (paramTAVVideoEffect == null) {
          break label1107;
        }
        this.mFlipFilter.OnDrawFrameGLSL();
      }
      label1089:
      label1107:
      for (paramCIImage = this.mFlipFilter.RenderProcess(i, j, k);; paramCIImage = null)
      {
        if (paramCIImage != null) {
          i = paramCIImage.getTextureId();
        }
        this.alphaAdjustFilter.setFilterTexture(i);
        localObject = this.alphaAdjustFilter;
        if (AEKitNode.access$100(this.this$0) != null) {}
        for (float f = AEKitNode.access$100(this.this$0).getEffectStrength();; f = 1.0F)
        {
          ((AlphaAdjustFilter)localObject).setAdjustParam(f);
          this.alphaAdjustFilter.RenderProcess(paramRenderInfo.textureID, paramRenderInfo.width, paramRenderInfo.height, this.cacheOutTexture.textureID, 0.0D, this.cacheFrame);
          if ((paramTAVVideoEffect != null) && (!paramTAVVideoEffect.unlock())) {
            paramTAVVideoEffect.clear();
          }
          if ((paramCIImage != null) && (!paramCIImage.unlock())) {
            paramCIImage.clear();
          }
          FrameBufferCache.getInstance().forceRecycle();
          DurationUtil.end("apply aeFilterManager");
          return new CIImage(this.cacheOutTexture);
          if ((this.cacheOutTexture.width == j) && (this.cacheOutTexture.height == k)) {
            break;
          }
          paramTAVVideoEffect.getRenderContext().makeCurrent();
          this.cacheOutTexture.release();
          this.cacheOutTexture = CIContext.newTextureInfo(j, k);
          break;
          this.aeFilterManager.setAdjustParams(null);
          this.aeFilterManager.switchFilterOn(116, false);
          break label526;
          label981:
          bool = false;
          break label576;
          label987:
          bool = false;
          break label661;
          label993:
          bool = false;
          break label686;
          label999:
          paramCIImage = VideoSDKMaterialParser.parseVideoMaterial(paramCIImage, "params");
          this.aeFilterManager.updateMaterialGL(paramCIImage);
          if ((VideoMaterialUtil.isCyberpunkMaterial(paramCIImage)) && (AEKitNode.access$100(this.this$0).getMediaType() == 1) && (this.faceDetector == null))
          {
            this.faceDetector = new PTFaceDetector();
            this.faceDetector.init(true);
            paramCIImage = this.faceDetector.detectFrame(paramTAVVideoEffect, System.currentTimeMillis(), 0, false, 1.0D, 0.0F, true, false, null);
            this.aeFilterManager.setPTFaceAttrData(paramCIImage);
          }
          break label710;
          i = paramRenderInfo.textureID;
          break label720;
        }
      }
      paramTAVVideoEffect = null;
    }
  }
  
  public String getReportKey()
  {
    return AEKitNode.access$200(this.this$0);
  }
  
  public void release()
  {
    Log.i("AEKitNode", "releaseAEKitFilter---");
    GLES20.glDeleteTextures(this.mFlipTextureID.length, this.mFlipTextureID, 0);
    if (this.mFlipFrame != null)
    {
      this.mFlipFrame.clear();
      this.mFlipFrame = null;
    }
    if (this.aeFilterManager != null) {
      this.aeFilterManager.destroy();
    }
    if (this.alphaAdjustFilter != null) {
      this.alphaAdjustFilter.clear();
    }
    if ((this.cacheTextureInfo != null) && (!this.cacheTextureInfo.isReleased())) {
      this.cacheTextureInfo.release();
    }
    if ((this.cacheOutTexture != null) && (!this.cacheOutTexture.isReleased())) {
      this.cacheOutTexture.release();
    }
    if (this.cacheFrame != null)
    {
      this.cacheFrame.clear();
      this.cacheFrame = null;
    }
    if (this.mFlipFilter != null)
    {
      this.mFlipFilter.clearGLSLSelf();
      this.mFlipFilter = null;
    }
    if (this.faceDetector != null)
    {
      this.faceDetector.destroy();
      this.faceDetector = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */