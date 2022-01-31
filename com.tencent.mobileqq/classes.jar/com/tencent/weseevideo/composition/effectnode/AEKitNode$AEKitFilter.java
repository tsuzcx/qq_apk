package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
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

class AEKitNode$AEKitFilter
  implements TAVVideoEffect.Filter, IReportable
{
  AEFilterManager aeFilterManager;
  private TextureInfo cacheOutTexture;
  private TextureInfo cacheTextureInfo;
  
  private AEKitNode$AEKitFilter(AEKitNode paramAEKitNode) {}
  
  private void initAEFilterManager(int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    Logger.i("AEKitFilter", "constructing");
    DurationUtil.start("init aeFilterManager");
    this.aeFilterManager = new AEFilterManager();
    this.aeFilterManager.enableAIDetect(false);
    this.aeFilterManager.initInGL(paramInt1, paramInt2);
    this.aeFilterManager.defineFiltersAndOrder(new int[] { 118, 101, 116 });
    this.aeFilterManager.setFilterInSmooth(true);
    this.aeFilterManager.switchFilterOn(101, false);
    this.aeFilterManager.switchFilterOn(116, false);
    if (AEKitNode.access$100(this.this$0) != null)
    {
      this.aeFilterManager.setGlowAlpha(AEKitNode.access$100(this.this$0).getGlowAlpha());
      this.aeFilterManager.updateLutGL(AEKitNode.access$100(this.this$0).getLutPath());
      this.aeFilterManager.setLookupLevel(AEKitNode.access$100(this.this$0).getLutAlpha());
      this.aeFilterManager.setSmoothLevel(AEKitNode.access$100(this.this$0).getSmoothLevel());
      if ((AEKitNode.access$100(this.this$0).isEnableAIFilter()) && (AEKitNode.access$100(this.this$0).getAdjustParams() != null)) {
        this.aeFilterManager.setAdjustParams(AEKitNode.access$100(this.this$0).getAdjustParams());
      }
      if ((!TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath())) || (AEKitNode.access$100(this.this$0).getSmoothLevel() > 0)) {
        bool1 = true;
      }
      boolean bool2 = AEKitNode.access$100(this.this$0).isEnableAIFilter();
      this.aeFilterManager.switchFilterOn(101, bool1);
      this.aeFilterManager.switchFilterOn(116, bool2);
    }
    DurationUtil.end("init aeFilterManager");
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    DurationUtil.start("apply aeFilterManager");
    Logger.i("AEKitFilter", "applying");
    paramTAVVideoEffect = AEKitNode.access$100(this.this$0).getOverlayImgPath();
    if (!TextUtils.isEmpty(paramTAVVideoEffect))
    {
      Logger.i("AEKitFilter", "apply---has overlayPath: " + paramTAVVideoEffect);
      paramTAVVideoEffect = new CIImage(paramTAVVideoEffect);
    }
    int i;
    do
    {
      int j;
      CIContext localCIContext;
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramTAVVideoEffect;
                i = (int)paramCIImage.getSize().width;
                j = (int)paramCIImage.getSize().height;
                if (this.aeFilterManager == null) {
                  initAEFilterManager(i, j);
                }
                paramTAVVideoEffect = paramCIImage;
              } while (!this.aeFilterManager.isInited());
              localCIContext = paramRenderInfo.getCiContext();
              paramTAVVideoEffect = paramCIImage;
            } while (localCIContext == null);
            paramTAVVideoEffect = paramCIImage;
          } while (localCIContext.getRenderContext() == null);
          l = paramRenderInfo.getTime().getTimeUs() / 1000L;
          if (AEKitNode.access$100(this.this$0) == null) {
            break;
          }
          paramTAVVideoEffect = paramCIImage;
        } while (l < AEKitNode.access$100(this.this$0).getStartTime());
        paramTAVVideoEffect = paramCIImage;
      } while (l > AEKitNode.access$100(this.this$0).getStartTime() + AEKitNode.access$100(this.this$0).getDuration());
      if (this.cacheTextureInfo == null)
      {
        localCIContext.getRenderContext().makeCurrent();
        this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
      }
      if ((this.cacheTextureInfo.width != i) || (this.cacheTextureInfo.height != j))
      {
        localCIContext.getRenderContext().makeCurrent();
        this.cacheTextureInfo.release();
        this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
      }
      localCIContext.convertImageToTexture(paramCIImage, this.cacheTextureInfo);
      paramRenderInfo = this.cacheTextureInfo;
      paramTAVVideoEffect = paramCIImage;
    } while (paramRenderInfo == null);
    this.aeFilterManager.updateWidthHeight(paramRenderInfo.width, paramRenderInfo.height);
    if (AEKitNode.access$100(this.this$0) != null)
    {
      this.aeFilterManager.setGlowAlpha(AEKitNode.access$100(this.this$0).getGlowAlpha());
      this.aeFilterManager.updateLutGL(AEKitNode.access$100(this.this$0).getLutPath());
      this.aeFilterManager.setLookupLevel(AEKitNode.access$100(this.this$0).getLutAlpha());
      this.aeFilterManager.setSmoothLevel(AEKitNode.access$100(this.this$0).getSmoothLevel());
      if ((AEKitNode.access$100(this.this$0).isEnableAIFilter()) && (AEKitNode.access$100(this.this$0).getAdjustParams() != null)) {
        this.aeFilterManager.setAdjustParams(AEKitNode.access$100(this.this$0).getAdjustParams());
      }
      if ((TextUtils.isEmpty(AEKitNode.access$100(this.this$0).getLutPath())) && (AEKitNode.access$100(this.this$0).getSmoothLevel() <= 0)) {
        break label583;
      }
    }
    label583:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = AEKitNode.access$100(this.this$0).isEnableAIFilter();
      this.aeFilterManager.switchFilterOn(101, bool1);
      this.aeFilterManager.switchFilterOn(116, bool2);
      DurationUtil.start("aeFilterManager.drawFrame");
      i = this.aeFilterManager.drawFrame(paramRenderInfo.textureID, false, 0L);
      DurationUtil.end("aeFilterManager.drawFrame");
      if (this.cacheOutTexture == null) {
        this.cacheOutTexture = new TextureInfo(i, paramRenderInfo.textureType, paramRenderInfo.width, paramRenderInfo.height, paramRenderInfo.preferRotation);
      }
      DurationUtil.end("apply aeFilterManager");
      return new CIImage(this.cacheOutTexture);
    }
  }
  
  public String getReportKey()
  {
    return this.this$0.reportKey;
  }
  
  public void release()
  {
    if (this.aeFilterManager != null) {
      this.aeFilterManager.destroy();
    }
    if ((this.cacheTextureInfo != null) && (!this.cacheTextureInfo.isReleased())) {
      this.cacheTextureInfo.release();
    }
    if ((this.cacheOutTexture != null) && (!this.cacheOutTexture.isReleased())) {
      this.cacheOutTexture.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AEKitNode.AEKitFilter
 * JD-Core Version:    0.7.0.1
 */