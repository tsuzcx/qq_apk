package com.tencent.trtc;

import android.graphics.Bitmap;

class TRTCSubCloud$5$1$1
  implements Runnable
{
  TRTCSubCloud$5$1$1(TRTCSubCloud.5.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.b.a.c != null) {
      this.b.a.c.onSnapshotComplete(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.5.1.1
 * JD-Core Version:    0.7.0.1
 */