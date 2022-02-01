package com.tencent.weseevideo.composition.effectnode;

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
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.AlphaAdjustFilter;
import com.tencent.ttpic.openapi.util.VideoSDKMaterialParser;
import java.util.HashMap;
import java.util.Map;
import org.light.bean.Texture;
import org.light.callback.ExternalRenderCallback;

class AEKitNode$AEKitFilter
  implements TAVVideoEffect.Filter, IReportable, ExternalRenderCallback
{
  public static final String BaseFragShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\nvec2 flipTex = vec2(textureCoordinate.x, 1.0 - textureCoordinate.y);\ngl_FragColor = texture2D (inputImageTexture, flipTex);\n}\n";
  public static final String BaseVertexShader = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  AEAdjust aeAdjust;
  AEFilterManager aeFilterManager;
  AlphaAdjustFilter alphaAdjustFilter;
  private Frame cacheFrame;
  private TextureInfo cacheOutTexture;
  private TextureInfo cacheTextureInfo;
  private String currentAppliedLutPath;
  private String currentAppliedMaterialPath;
  private boolean currentSyncMode;
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
    this.aeFilterManager.initInGL(paramInt1, paramInt2);
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 300, 100 });
    this.aeFilterManager.setFilterInSmooth(true);
    this.aeFilterManager.setExternalRenderCallback(this);
    this.aeAdjust = new AEAdjust();
    this.aeAdjust.apply();
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
    label380:
    int i;
    label451:
    label496:
    Object localObject;
    boolean bool;
    if (AEKitNode.access$100(this.this$0).getMediaType() == 1)
    {
      if (!this.currentSyncMode)
      {
        this.aeFilterManager.setSyncMode(true);
        this.currentSyncMode = true;
      }
      this.aeFilterManager.updateWidthHeight(paramRenderInfo.width, paramRenderInfo.height);
      if (AEKitNode.access$100(this.this$0) == null) {
        break label1128;
      }
      this.aeFilterManager.setGlowAlpha(AEKitNode.access$100(this.this$0).getGlowAlpha());
      if ((!TextUtils.isEmpty(this.currentAppliedLutPath)) || (!TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath()))) {
        break label1060;
      }
      i = 1;
      if ((i == 0) && (!TextUtils.equals(this.currentAppliedLutPath, AEKitNode.access$100(this.this$0).getLutPath())))
      {
        if (AEKitNode.access$100(this.this$0).getLutPath() != null) {
          break label1066;
        }
        this.currentAppliedLutPath = "";
        this.aeFilterManager.updateLutGL(this.currentAppliedLutPath);
      }
      this.aeFilterManager.setLookupLevel(AEKitNode.access$100(this.this$0).getLutAlpha());
      this.aeFilterManager.setSmoothLevel(AEKitNode.access$100(this.this$0).getSmoothLevel());
      localObject = AEKitNode.access$100(this.this$0).getMaterial();
      if ((TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath())) && (AEKitNode.access$100(this.this$0).getSmoothLevel() <= 0) && (TextUtils.isEmpty((CharSequence)localObject))) {
        break label1083;
      }
      bool = true;
      label593:
      this.aeFilterManager.switchAbilityInLightNode("smooth.enable", bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label1123;
      }
      this.mFlipFilter.RenderProcess(paramRenderInfo.textureID, paramRenderInfo.width, paramRenderInfo.height, this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
      paramTAVVideoEffect = this.mFlipFrame;
      label648:
      paramCIImage = paramTAVVideoEffect;
      if (!TextUtils.equals(this.currentAppliedMaterialPath, (CharSequence)localObject))
      {
        this.currentAppliedMaterialPath = ((String)localObject);
        paramCIImage = this.aeFilterManager;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label1089;
        }
        bool = true;
        label684:
        paramCIImage.switchAbilityInLightNode("sticker.enable", bool);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label1095;
        }
        this.aeFilterManager.updateMaterialGL(null);
        paramCIImage = paramTAVVideoEffect;
      }
    }
    for (;;)
    {
      label711:
      i = paramRenderInfo.textureID;
      DurationUtil.start("aeFilterManager.drawFrame");
      i = this.aeFilterManager.drawFrame(i, false, 0L);
      DurationUtil.end("aeFilterManager.drawFrame");
      this.mFlipFilter.OnDrawFrameGLSL();
      paramTAVVideoEffect = this.mFlipFilter.RenderProcess(i, j, k);
      if (paramTAVVideoEffect != null) {
        i = paramTAVVideoEffect.getTextureId();
      }
      this.alphaAdjustFilter.setFilterTexture(i);
      localObject = this.alphaAdjustFilter;
      if (AEKitNode.access$100(this.this$0) != null) {}
      for (float f = AEKitNode.access$100(this.this$0).getEffectStrength();; f = 1.0F)
      {
        ((AlphaAdjustFilter)localObject).setAdjustParam(f);
        this.alphaAdjustFilter.RenderProcess(paramRenderInfo.textureID, paramRenderInfo.width, paramRenderInfo.height, this.cacheOutTexture.textureID, 0.0D, this.cacheFrame);
        if ((paramCIImage != null) && (!paramCIImage.unlock())) {
          paramCIImage.clear();
        }
        if ((paramTAVVideoEffect != null) && (!paramTAVVideoEffect.unlock())) {
          paramTAVVideoEffect.clear();
        }
        FrameBufferCache.getInstance().forceRecycle();
        if (AEKitNode.access$100(this.this$0).getMediaType() == 1) {
          this.aeFilterManager.freeCache();
        }
        DurationUtil.end("apply aeFilterManager");
        return new CIImage(this.cacheOutTexture);
        if ((this.cacheOutTexture.width == j) && (this.cacheOutTexture.height == k)) {
          break;
        }
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.cacheOutTexture.release();
        this.cacheOutTexture = CIContext.newTextureInfo(j, k);
        break;
        if ((AEKitNode.access$100(this.this$0).isDisable() == AEKitNode.access$100(this.this$0).getLastState()) || (AEKitNode.access$100(this.this$0).isDisable())) {
          break label380;
        }
        if (!this.currentSyncMode)
        {
          this.aeFilterManager.setSyncMode(true);
          this.currentSyncMode = true;
          break label380;
        }
        this.aeFilterManager.setSyncMode(false);
        this.currentSyncMode = false;
        AEKitNode.access$100(this.this$0).setLastState(false);
        break label380;
        label1060:
        i = 0;
        break label451;
        label1066:
        this.currentAppliedLutPath = AEKitNode.access$100(this.this$0).getLutPath();
        break label496;
        label1083:
        bool = false;
        break label593;
        label1089:
        bool = false;
        break label684;
        label1095:
        paramCIImage = VideoSDKMaterialParser.parseVideoMaterial((String)localObject, "params");
        this.aeFilterManager.updateMaterialGL(paramCIImage);
        paramCIImage = paramTAVVideoEffect;
        break label711;
      }
      label1123:
      paramTAVVideoEffect = null;
      break label648;
      label1128:
      paramCIImage = null;
    }
  }
  
  public String getReportKey()
  {
    return AEKitNode.access$200(this.this$0);
  }
  
  public void onRender(Texture paramTexture1, String paramString1, String paramString2, Texture paramTexture2)
  {
    LogUtils.d("AEKitNode", "onRender: 触发外挂滤镜，参数：" + paramTexture1 + "|" + paramString1 + "|" + paramString2 + "|" + paramTexture2);
    if ((this.aeAdjust != null) && (AEKitNode.access$100(this.this$0) != null))
    {
      paramString1 = AEKitNode.access$100(this.this$0).getAdjustParams();
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        this.aeAdjust.setAdjustParams(new HashMap(paramString1));
        paramString1 = new Frame();
        paramString1.setSizedTexture(paramTexture1.id, paramTexture1.width, paramTexture1.height);
        paramTexture1 = this.aeAdjust.render(paramString1);
        paramTexture2.id = paramTexture1.getTextureId();
        paramTexture2.width = paramTexture1.width;
        paramTexture2.height = paramTexture1.height;
      }
    }
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
    if (this.aeAdjust != null)
    {
      this.aeAdjust.clear();
      this.aeAdjust = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */