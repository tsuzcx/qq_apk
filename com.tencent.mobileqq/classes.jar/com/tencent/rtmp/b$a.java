package com.tencent.rtmp;

import android.os.Handler;
import com.tencent.liteav.audio.TXCAudioEngine;

class b$a
  implements Runnable
{
  private int b = 300;
  
  private b$a(b paramb) {}
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    if (this.a.m())
    {
      int i = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
      if (b.b(this.a) != null) {
        b.b(this.a).onAudioVolumeEvaluationNotify(i);
      }
    }
    if ((b.c(this.a) != null) && (this.b > 0)) {
      b.c(this.a).postDelayed(b.d(this.a), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.b.a
 * JD-Core Version:    0.7.0.1
 */