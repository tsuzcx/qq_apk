package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.weseevideo.model.effect.LutModel;

class WSLutEffectNode$WSLutEffectFilter
  implements TAVVideoEffect.Filter, IReportable
{
  private TextureInfo cacheTextureInfo;
  private WSLutEffectNode.LUTFilter mEffect;
  
  public WSLutEffectNode$WSLutEffectFilter(WSLutEffectNode paramWSLutEffectNode)
  {
    this.mEffect = new WSLutEffectNode.LUTFilter(paramWSLutEffectNode);
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (this.mEffect == null) {}
    long l;
    do
    {
      do
      {
        return paramCIImage;
        paramTAVVideoEffect = paramRenderInfo.getCiContext();
      } while ((paramTAVVideoEffect == null) || (paramTAVVideoEffect.getRenderContext() == null));
      TextureInfo localTextureInfo = CIContext.newTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height);
      paramTAVVideoEffect.convertImageToTexture(paramCIImage, localTextureInfo);
      TAVGLUtils.saveBitmap(localTextureInfo);
      l = paramRenderInfo.getTime().getTimeUs() / 1000L;
    } while (((WSLutEffectNode.access$000(this.this$0) != null) && ((l < WSLutEffectNode.access$000(this.this$0).getLutStartTime()) || (l > WSLutEffectNode.access$000(this.this$0).getLutStartTime() + WSLutEffectNode.access$000(this.this$0).getLutDuration()))) || (!BitmapUtil.isValidBitmap(WSLutEffectNode.access$100(this.this$0))));
    this.mEffect.setLUTBitmap(WSLutEffectNode.access$100(this.this$0));
    if (WSLutEffectNode.access$000(this.this$0) != null) {
      this.mEffect.setIntensity(WSLutEffectNode.access$000(this.this$0).getLutAlpha());
    }
    int i = (int)paramCIImage.getSize().width;
    int j = (int)paramCIImage.getSize().height;
    this.mEffect.setRendererWidth(i);
    this.mEffect.setRendererHeight(j);
    if (this.cacheTextureInfo == null)
    {
      paramTAVVideoEffect.getRenderContext().makeCurrent();
      this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
    }
    if ((this.cacheTextureInfo.width != i) || (this.cacheTextureInfo.height != j))
    {
      paramTAVVideoEffect.getRenderContext().makeCurrent();
      this.cacheTextureInfo.release();
      this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
    }
    paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.cacheTextureInfo);
    paramTAVVideoEffect = getTavTextureInfo(this.cacheTextureInfo);
    paramTAVVideoEffect = getOutputTextureInfo(this.mEffect.applyFilter(paramTAVVideoEffect));
    paramTAVVideoEffect.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
    return new CIImage(paramTAVVideoEffect);
  }
  
  public String getReportKey()
  {
    return this.this$0.reportKey;
  }
  
  public void release()
  {
    if (this.mEffect != null)
    {
      this.mEffect.release();
      this.mEffect = null;
    }
    if ((this.cacheTextureInfo != null) && (!this.cacheTextureInfo.isReleased())) {
      this.cacheTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSLutEffectNode.WSLutEffectFilter
 * JD-Core Version:    0.7.0.1
 */