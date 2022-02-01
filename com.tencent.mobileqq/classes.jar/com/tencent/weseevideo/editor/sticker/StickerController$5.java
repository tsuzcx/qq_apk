package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;
import java.util.concurrent.CountDownLatch;

class StickerController$5
  implements Runnable
{
  StickerController$5(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    StickerController.access$800(this.this$0, this.val$stickerContext);
    StickerController.access$702(this.this$0, this.val$stickerContext);
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.5
 * JD-Core Version:    0.7.0.1
 */