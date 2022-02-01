package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.qcircle.tavcut.aekit.AEKitModel;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
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
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.model.VideoMaterial;
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
  EnhancedAEAdjust aeAdjust;
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
    if (AEKitNode.access$100(this.this$0).getMediaType() == 1) {
      this.aeFilterManager = new AEFilterManager("defaultBeautyV6.json", false, false, null);
    } else {
      this.aeFilterManager = new AEFilterManager();
    }
    this.aeFilterManager.supportMultiThreads(true);
    this.aeFilterManager.initInGL(paramInt1, paramInt2);
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 300, 100 });
    this.aeFilterManager.setFilterInSmooth(true);
    this.aeFilterManager.setExternalRenderCallback(this);
    this.aeAdjust = new EnhancedAEAdjust();
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
      this.aeFilterManager = AEKitNode.access$200(this.this$0);
      Object localObject = this.aeFilterManager;
      if (localObject != null)
      {
        ((AEFilterManager)localObject).initInGL(paramInt1, paramInt2);
        this.aeFilterManager.setExternalRenderCallback(this);
        this.cacheFrame = new Frame();
        this.aeAdjust = new EnhancedAEAdjust();
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
    paramTAVVideoEffect = paramCIImage;
    if (AEKitNode.access$100(this.this$0) == null) {
      return paramTAVVideoEffect;
    }
    if ((AEKitNode.access$100(this.this$0) != null) && (AEKitNode.access$100(this.this$0).isDisable())) {
      return paramTAVVideoEffect;
    }
    if (AEKitNode.access$100(this.this$0) != null)
    {
      localObject = AEKitNode.access$100(this.this$0).getOverlayImgPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramTAVVideoEffect = new StringBuilder();
        paramTAVVideoEffect.append("apply---has overlayPath: ");
        paramTAVVideoEffect.append((String)localObject);
        Logger.i("AEKitNode", paramTAVVideoEffect.toString());
        return new CIImage((String)localObject);
      }
    }
    DurationUtil.start("apply aeFilterManager");
    int m = (int)paramCIImage.getSize().width;
    int n = (int)paramCIImage.getSize().height;
    initFilterManagerWrap(m, n);
    if (!this.aeFilterManager.isInited()) {
      return paramTAVVideoEffect;
    }
    Object localObject = paramRenderInfo.getCiContext();
    paramCIImage = paramTAVVideoEffect;
    if (localObject != null)
    {
      if (((CIContext)localObject).getRenderContext() == null) {
        return paramTAVVideoEffect;
      }
      long l = paramRenderInfo.getTime().getTimeUs() / 1000L;
      if ((AEKitNode.access$100(this.this$0) != null) && ((l < AEKitNode.access$100(this.this$0).getStartTime()) || (l > AEKitNode.access$100(this.this$0).getStartTime() + AEKitNode.access$100(this.this$0).getDuration()))) {
        return paramTAVVideoEffect;
      }
      if (this.cacheTextureInfo == null)
      {
        ((CIContext)localObject).getRenderContext().makeCurrent();
        this.cacheTextureInfo = CIContext.newTextureInfo(m, n);
      }
      if ((this.cacheTextureInfo.width != m) || (this.cacheTextureInfo.height != n))
      {
        ((CIContext)localObject).getRenderContext().makeCurrent();
        this.cacheTextureInfo.release();
        this.cacheTextureInfo = CIContext.newTextureInfo(m, n);
      }
      paramCIImage = this.cacheOutTexture;
      if (paramCIImage == null)
      {
        ((CIContext)localObject).getRenderContext().makeCurrent();
        this.cacheOutTexture = CIContext.newTextureInfo(m, n);
      }
      else if ((paramCIImage.width != m) || (this.cacheOutTexture.height != n))
      {
        ((CIContext)localObject).getRenderContext().makeCurrent();
        this.cacheOutTexture.release();
        this.cacheOutTexture = CIContext.newTextureInfo(m, n);
      }
      ((CIContext)localObject).convertImageToTexture(paramTAVVideoEffect, this.cacheTextureInfo);
      localObject = this.cacheTextureInfo;
      if (localObject == null) {
        return paramTAVVideoEffect;
      }
      if ((AEKitNode.access$100(this.this$0).getMediaType() == 2) && (AEKitNode.access$100(this.this$0).isDisable() != AEKitNode.access$100(this.this$0).getLastState()) && (!AEKitNode.access$100(this.this$0).isDisable())) {
        if (!this.currentSyncMode)
        {
          this.aeFilterManager.setSyncMode(true);
          this.currentSyncMode = true;
        }
        else
        {
          this.aeFilterManager.setSyncMode(false);
          this.currentSyncMode = false;
          AEKitNode.access$100(this.this$0).setLastState(false);
        }
      }
      if ((AEKitNode.access$100(this.this$0).getMediaType() == 1) && (this.currentSyncMode == AEKitNode.access$300(this.this$0)))
      {
        this.aeFilterManager.setSyncMode(AEKitNode.access$300(this.this$0) ^ true);
        this.currentSyncMode = (AEKitNode.access$300(this.this$0) ^ true);
      }
      this.aeFilterManager.updateWidthHeight(((TextureInfo)localObject).width, ((TextureInfo)localObject).height);
      int i;
      if (AEKitNode.access$100(this.this$0) != null)
      {
        this.aeFilterManager.setGlowAlpha(AEKitNode.access$100(this.this$0).getGlowAlpha());
        paramTAVVideoEffect = this.aeFilterManager.getLutPath();
        if ((TextUtils.isEmpty(paramTAVVideoEffect)) && (TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath()))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i == 0) && (!TextUtils.equals(paramTAVVideoEffect, AEKitNode.access$100(this.this$0).getLutPath())))
        {
          if (AEKitNode.access$100(this.this$0).getLutPath() == null) {
            this.currentAppliedLutPath = "";
          } else {
            this.currentAppliedLutPath = AEKitNode.access$100(this.this$0).getLutPath();
          }
          this.aeFilterManager.updateLutGL(this.currentAppliedLutPath);
          j = 1;
        }
        else
        {
          j = 0;
        }
        this.aeFilterManager.setmIntensity(AEKitNode.access$100(this.this$0).getLutAlpha() * 100.0F);
        this.aeFilterManager.setSmoothLevel(AEKitNode.access$100(this.this$0).getSmoothLevel());
        String str = AEKitNode.access$100(this.this$0).getMaterial();
        boolean bool;
        if (AEKitNode.access$100(this.this$0).getSmoothLevel() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.aeFilterManager.switchAbilityInLightNode("smooth.enable", bool);
        if (!TextUtils.isEmpty(str))
        {
          this.mFlipFilter.RenderProcess(((TextureInfo)localObject).textureID, ((TextureInfo)localObject).width, ((TextureInfo)localObject).height, this.mFlipTextureID[0], 0.0D, this.mFlipFrame);
          paramTAVVideoEffect = this.mFlipFrame;
        }
        else
        {
          paramTAVVideoEffect = null;
        }
        if ((this.aeFilterManager.getVideoMaterial() != null) && (!this.aeFilterManager.getVideoMaterial().getDataPath().equals(LightNode.getEmptyMaterialPath()))) {
          paramRenderInfo = this.aeFilterManager.getVideoMaterial().getDataPath();
        } else {
          paramRenderInfo = null;
        }
        int k;
        if ((TextUtils.isEmpty(paramRenderInfo)) && (TextUtils.isEmpty(str))) {
          k = 1;
        } else {
          k = 0;
        }
        i = j;
        paramCIImage = paramTAVVideoEffect;
        if (k == 0)
        {
          i = j;
          paramCIImage = paramTAVVideoEffect;
          if (!TextUtils.equals(paramRenderInfo, str))
          {
            this.currentAppliedMaterialPath = str;
            if (TextUtils.isEmpty(str))
            {
              this.aeFilterManager.updateMaterialGL(null);
            }
            else
            {
              paramCIImage = VideoSDKMaterialParser.parseVideoMaterial(str, "params");
              this.aeFilterManager.updateMaterialGL(paramCIImage);
            }
            i = 1;
            paramCIImage = paramTAVVideoEffect;
          }
        }
      }
      else
      {
        paramCIImage = null;
        i = 0;
      }
      this.aeFilterManager.setExternalRenderCallback(this);
      int j = ((TextureInfo)localObject).textureID;
      DurationUtil.start("aeFilterManager.drawFrame");
      j = this.aeFilterManager.drawFrame(j, false, 0L);
      DurationUtil.end("aeFilterManager.drawFrame");
      this.mFlipFilter.OnDrawFrameGLSL();
      paramTAVVideoEffect = this.mFlipFilter.RenderProcess(j, m, n);
      if (paramTAVVideoEffect != null) {
        j = paramTAVVideoEffect.getTextureId();
      }
      this.alphaAdjustFilter.setFilterTexture(j);
      paramRenderInfo = this.alphaAdjustFilter;
      float f;
      if (AEKitNode.access$100(this.this$0) != null) {
        f = AEKitNode.access$100(this.this$0).getEffectStrength();
      } else {
        f = 1.0F;
      }
      paramRenderInfo.setAdjustParam(f);
      this.alphaAdjustFilter.RenderProcess(((TextureInfo)localObject).textureID, ((TextureInfo)localObject).width, ((TextureInfo)localObject).height, this.cacheOutTexture.textureID, 0.0D, this.cacheFrame);
      if ((paramCIImage != null) && (!paramCIImage.unlock())) {
        paramCIImage.clear();
      }
      if ((paramTAVVideoEffect != null) && (!paramTAVVideoEffect.unlock())) {
        paramTAVVideoEffect.clear();
      }
      FrameBufferCache.getInstance().forceRecycle();
      if ((AEKitNode.access$100(this.this$0).getMediaType() == 1) && (i != 0)) {
        this.aeFilterManager.freeCache();
      }
      DurationUtil.end("apply aeFilterManager");
      paramCIImage = new CIImage(this.cacheOutTexture);
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    return AEKitNode.access$400(this.this$0);
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
    LogUtils.d("AEKitNode", localStringBuilder.toString());
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
        return;
      }
    }
    paramTexture2.id = paramTexture1.id;
    paramTexture2.width = paramTexture1.width;
    paramTexture2.height = paramTexture1.height;
  }
  
  public void release()
  {
    Log.i("AEKitNode", "releaseAEKitFilter---");
    Object localObject = this.mFlipTextureID;
    GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
    localObject = this.aeFilterManager;
    if (localObject != null)
    {
      ((AEFilterManager)localObject).setExternalRenderCallback(null);
      if (AEKitNode.access$200(this.this$0) == null) {
        this.aeFilterManager.destroy();
      }
      this.aeFilterManager = null;
    }
    if (AEKitNode.access$200(this.this$0) != null) {
      AEKitNode.access$202(this.this$0, null);
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
    localObject = this.cacheTextureInfo;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.cacheTextureInfo.release();
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
      ((EnhancedAEAdjust)localObject).clear();
      this.aeAdjust = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.AEKitNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */