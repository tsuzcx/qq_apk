package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.model.TAVSticker;

class StickerController$4
  implements Runnable
{
  StickerController$4(StickerController paramStickerController, TAVSticker paramTAVSticker, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.stickerContext == null) {
      return;
    }
    if ((!"sticker_lyric".equals(TAVStickerExKt.getExtraStickerType(this.val$sticker))) && (this.val$needSelect))
    {
      this.this$0.stickerContext.loadSticker(this.val$sticker);
      return;
    }
    this.this$0.stickerContext.loadSticker(this.val$sticker, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.4
 * JD-Core Version:    0.7.0.1
 */