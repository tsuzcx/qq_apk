package com.tencent.mobileqq.lyric.widget;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

class LyricViewScroll$1
  extends TimerTask
{
  int a;
  
  LyricViewScroll$1(LyricViewScroll paramLyricViewScroll) {}
  
  public void run()
  {
    Log.v("LyricViewScroll", "fling detect running");
    if (this.a == this.this$0.getScrollY())
    {
      LyricViewScroll localLyricViewScroll = this.this$0;
      localLyricViewScroll.c = this.a;
      LyricViewScroll.a(localLyricViewScroll).b(this.a);
      Log.d("LyricViewScroll", "fling stop");
      this.this$0.a.cancel();
      localLyricViewScroll = this.this$0;
      localLyricViewScroll.b = false;
      LyricViewScroll.a(localLyricViewScroll, false);
      return;
    }
    this.a = this.this$0.getScrollY();
    LyricViewScroll.a(this.this$0).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewScroll.1
 * JD-Core Version:    0.7.0.1
 */