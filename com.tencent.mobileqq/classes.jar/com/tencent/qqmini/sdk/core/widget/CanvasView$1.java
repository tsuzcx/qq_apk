package com.tencent.qqmini.sdk.core.widget;

import android.graphics.Bitmap;
import android.os.Handler;
import bdew;

class CanvasView$1
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = CanvasView.a(this.this$0, this.this$0, true);
    bdew.a().post(new CanvasView.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CanvasView.1
 * JD-Core Version:    0.7.0.1
 */