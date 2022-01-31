package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;
import java.util.concurrent.CountDownLatch;

class StickerController$4
  implements Runnable
{
  StickerController$4(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    StickerController.access$600(this.this$0, this.val$stickerContext);
    StickerController.access$502(this.this$0, this.val$stickerContext);
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.4
 * JD-Core Version:    0.7.0.1
 */