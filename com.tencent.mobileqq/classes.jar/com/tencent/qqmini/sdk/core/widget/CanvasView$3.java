package com.tencent.qqmini.sdk.core.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;

class CanvasView$3
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = CanvasView.a(this.this$0, this.this$0, this.a);
    ThreadManager.a().post(new CanvasView.3.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */