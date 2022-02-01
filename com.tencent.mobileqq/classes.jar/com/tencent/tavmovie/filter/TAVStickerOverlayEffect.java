package com.tencent.tavmovie.filter;

import android.support.annotation.NonNull;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class TAVStickerOverlayEffect
  implements TAVVideoEffect
{
  private static final String TAG = "TAVStickerOverlayEffect";
  private int count = 0;
  private boolean realTimeReleaseEachSticker;
  private boolean realTimeReleaseStickerContext;
  protected String reportKey = "TAVStickerOverlayEffect";
  private TAVStickerRenderContext stickerContext;
  @Nullable
  private List<TAVSticker> stickers;
  
  public TAVStickerOverlayEffect(TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    if (this.count == 0)
    {
      this.count += 1;
      return new TAVStickerOverlayEffect.MyVideoCompositionEffect(this, this.stickerContext, null);
    }
    return new TAVStickerOverlayEffect.MyVideoCompositionEffect(this, this.stickerContext.copy(), null);
  }
  
  @NonNull
  public String effectId()
  {
    return "TAVStickerOverlayEffect";
  }
  
  public TAVStickerRenderContext getStickerContext()
  {
    return this.stickerContext;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
  
  public void setStickers(List<TAVSticker> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stickers = paramList;
    this.realTimeReleaseStickerContext = paramBoolean1;
    this.realTimeReleaseEachSticker = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVStickerOverlayEffect
 * JD-Core Version:    0.7.0.1
 */