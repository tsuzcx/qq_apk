package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;

public abstract interface IBlurStickerRenderContext
{
  public abstract List<TAVSticker> getBlurStickers();
  
  public abstract boolean shouldRenderBlurSticker();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.IBlurStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */