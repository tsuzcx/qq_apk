package com.tencent.mobileqq.triton.render.monitor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;

class ScreenShootMonitor$1
  implements Runnable
{
  ScreenShootMonitor$1(ScreenShootMonitor paramScreenShootMonitor, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void run()
  {
    Object localObject = new int[this.val$w * this.val$h];
    int i = 0;
    while (i < this.val$h)
    {
      int k = this.val$w;
      int m = this.val$h;
      int n = this.val$w;
      int j = 0;
      while (j < this.val$w)
      {
        int i1 = this.val$bitmapBuffer[(i * k + j)];
        localObject[(n * (m - i - 1) + j)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap((int[])localObject, this.val$w, this.val$h, Bitmap.Config.ARGB_8888);
    if (ScreenShootMonitor.access$000(this.this$0) != null) {
      ScreenShootMonitor.access$000(this.this$0).onScreenShotCallback((Bitmap)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.ScreenShootMonitor.1
 * JD-Core Version:    0.7.0.1
 */