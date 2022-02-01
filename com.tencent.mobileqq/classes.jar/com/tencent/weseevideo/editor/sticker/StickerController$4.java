package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;

class StickerController$4
  implements Runnable
{
  StickerController$4(StickerController paramStickerController, TAVSticker paramTAVSticker) {}
  
  public void run()
  {
    if (StickerController.access$700(this.this$0) == null) {
      return;
    }
    if ("sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(this.val$sticker)))
    {
      StickerController.access$700(this.this$0).loadSticker(this.val$sticker, false);
      return;
    }
    StickerController.access$700(this.this$0).loadSticker(this.val$sticker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.4
 * JD-Core Version:    0.7.0.1
 */