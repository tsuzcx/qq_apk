package com.tencent.mobileqq.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;

class LyricViewController$5
  implements Runnable
{
  LyricViewController$5(LyricViewController paramLyricViewController, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b != null) {
      this.this$0.b.b();
    }
    if ((this.this$0.c != null) && (!this.this$0.c.f()))
    {
      this.this$0.d = (SystemClock.elapsedRealtime() - this.a);
      if ((this.this$0.f) && (this.this$0.g > 0))
      {
        LyricViewController localLyricViewController = this.this$0;
        localLyricViewController.d -= this.this$0.g;
      }
      LyricViewController.a(this.this$0);
      return;
    }
    Log.w("ModuleController", "seek before set lyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.5
 * JD-Core Version:    0.7.0.1
 */