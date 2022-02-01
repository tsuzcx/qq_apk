package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.c) != null)
    {
      LoadTempFileJobListener localLoadTempFileJobListener = (LoadTempFileJobListener)LineLayer.LoadTempFileJob.a(this.c).get();
      if (localLoadTempFileJobListener != null) {
        localLoadTempFileJobListener.a(LineLayer.LoadTempFileJob.b(this.c), this.a, LineLayer.LoadTempFileJob.c(this.c), this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */