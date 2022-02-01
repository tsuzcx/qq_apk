package com.tencent.weseevideo.editor.sticker;

import android.util.Log;
import java.util.concurrent.locks.ReentrantLock;

class BlurStickerEditView$1
  implements Runnable
{
  BlurStickerEditView$1(BlurStickerEditView paramBlurStickerEditView) {}
  
  public void run()
  {
    Log.d("BlurStickerEditView", "run: thread = " + Thread.currentThread());
    Log.d("BlurStickerEditView", "Thread Name2: " + Thread.currentThread().getName());
    if (this.this$0.lock.isHeldByCurrentThread()) {
      this.this$0.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView.1
 * JD-Core Version:    0.7.0.1
 */