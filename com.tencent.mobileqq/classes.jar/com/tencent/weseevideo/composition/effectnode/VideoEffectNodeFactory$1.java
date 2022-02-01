package com.tencent.weseevideo.composition.effectnode;

import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;

final class VideoEffectNodeFactory$1
  implements Runnable
{
  VideoEffectNodeFactory$1(TAVStickerRenderContext paramTAVStickerRenderContext, TAVSticker paramTAVSticker) {}
  
  public void run()
  {
    this.val$stickerRenderContext.loadSticker(this.val$sticker, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.VideoEffectNodeFactory.1
 * JD-Core Version:    0.7.0.1
 */