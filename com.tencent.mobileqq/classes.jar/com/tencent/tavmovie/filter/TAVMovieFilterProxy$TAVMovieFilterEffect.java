package com.tencent.tavmovie.filter;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

class TAVMovieFilterProxy$TAVMovieFilterEffect
  implements TAVVideoEffect.Filter
{
  private TextureInfo cacheTextureInfo;
  private BaseEffect mEffect;
  
  public TAVMovieFilterProxy$TAVMovieFilterEffect(TAVMovieFilterProxy paramTAVMovieFilterProxy)
  {
    this.mEffect = TAVMovieFilterProxy.access$000(paramTAVMovieFilterProxy);
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    int i = (int)paramCIImage.getSize().width;
    int j = (int)paramCIImage.getSize().height;
    if (this.mEffect == null)
    {
      this.mEffect = TAVMovieFilterProxy.access$000(this.this$0);
      if (this.mEffect == null) {
        return paramCIImage;
      }
    }
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
    paramTAVVideoEffect = TAVMovieFilterProxy.access$100(this.this$0, this.cacheTextureInfo);
    paramTAVVideoEffect = this.mEffect.applyFilter(paramTAVVideoEffect);
    paramTAVVideoEffect = TAVMovieFilterProxy.access$200(this.this$0, paramTAVVideoEffect);
    paramTAVVideoEffect.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
    return new CIImage(paramTAVVideoEffect);
  }
  
  public void release()
  {
    Object localObject = this.mEffect;
    if (localObject != null)
    {
      ((BaseEffect)localObject).release();
      this.mEffect = null;
    }
    localObject = this.cacheTextureInfo;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.cacheTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterProxy.TAVMovieFilterEffect
 * JD-Core Version:    0.7.0.1
 */