package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;
import java.util.concurrent.CountDownLatch;

class StickerController$5
  implements Runnable
{
  StickerController$5(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    StickerController.access$700(this.this$0, this.val$stickerContext);
    this.this$0.stickerContext = this.val$stickerContext;
    this.val$countDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.5
 * JD-Core Version:    0.7.0.1
 */