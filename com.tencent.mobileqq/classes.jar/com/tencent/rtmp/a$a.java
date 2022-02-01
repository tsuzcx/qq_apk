package com.tencent.rtmp;

import android.os.Handler;
import com.tencent.liteav.n;

class a$a
  implements Runnable
{
  private int b = 300;
  
  private a$a(a parama) {}
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    if ((a.a(this.a) != null) && (a.a(this.a).c()))
    {
      int i = a.a(this.a).h();
      if (a.b(this.a) != null) {
        a.b(this.a).onAudioVolumeEvaluationNotify(i);
      }
    }
    if ((a.c(this.a) != null) && (this.b > 0)) {
      a.c(this.a).postDelayed(a.d(this.a), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.a.a
 * JD-Core Version:    0.7.0.1
 */