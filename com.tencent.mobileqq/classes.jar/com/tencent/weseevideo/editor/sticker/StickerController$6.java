package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavcut.session.callback.StickerStateCallback;

class StickerController$6
  implements Runnable
{
  StickerController$6(StickerController paramStickerController) {}
  
  public void run()
  {
    if (StickerController.access$800(this.this$0) == 0) {
      return;
    }
    if (StickerController.access$500(this.this$0) != null) {
      StickerController.access$500(this.this$0).onStatusChanged(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.6
 * JD-Core Version:    0.7.0.1
 */