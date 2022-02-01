package com.tencent.tavmovie.filter;

import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import com.tencent.tavsticker.core.TAVStickerRenderContext;

public class TAVBigStickerOverlayEffect
  implements TAVVideoMixEffect
{
  private static final String TAG = "TAVBigStickerOverlayEffect";
  private int count = 0;
  protected String reportKey = "TAVBigStickerOverlayEffect";
  private TAVStickerRenderContext stickerContext;
  
  public TAVBigStickerOverlayEffect(TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  public TAVVideoMixEffect.Filter createFilter()
  {
    if (this.count == 0)
    {
      this.count += 1;
      return new TAVBigStickerOverlayEffect.StickerVideoCompositionMixerEffect(this, this.stickerContext, null);
    }
    return new TAVBigStickerOverlayEffect.StickerVideoCompositionMixerEffect(this, this.stickerContext.copy(), null);
  }
  
  public String effectId()
  {
    return "TAVBigStickerOverlayEffect";
  }
  
  public TAVStickerRenderContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect
 * JD-Core Version:    0.7.0.1
 */