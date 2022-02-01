package com.tencent.weseevideo.editor.sticker;

import android.util.Log;
import java.util.concurrent.locks.ReentrantLock;

class BlurStickerEditView$1
  implements Runnable
{
  BlurStickerEditView$1(BlurStickerEditView paramBlurStickerEditView) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run: thread = ");
    localStringBuilder.append(Thread.currentThread());
    Log.d("BlurStickerEditView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Thread Name2: ");
    localStringBuilder.append(Thread.currentThread().getName());
    Log.d("BlurStickerEditView", localStringBuilder.toString());
    if (this.this$0.lock.isHeldByCurrentThread()) {
      this.this$0.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView.1
 * JD-Core Version:    0.7.0.1
 */