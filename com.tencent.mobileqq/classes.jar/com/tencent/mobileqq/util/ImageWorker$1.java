package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.Handler;

class ImageWorker$1
  implements Runnable
{
  public void run()
  {
    Drawable localDrawable = this.a.a(new Object[] { this.b, this.c, Boolean.valueOf(true) });
    ImageWorker.a(this.this$0).post(new ImageWorker.1.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.1
 * JD-Core Version:    0.7.0.1
 */