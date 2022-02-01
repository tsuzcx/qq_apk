package com.tencent.mobileqq.lyric.widget;

import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;

class LyricViewController$3
  implements Runnable
{
  LyricViewController$3(LyricViewController paramLyricViewController, Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3) {}
  
  public void run()
  {
    if (this.a == null) {
      Log.d("ModuleController", "setLyric -> pronounce is null");
    }
    if (this.b == null)
    {
      Log.d("ModuleController", "setLyric -> qrc is null");
      this.this$0.b.a(this.c, this.a);
      this.this$0.c = this.c;
      return;
    }
    this.this$0.b.a(this.b, this.a);
    LyricViewController localLyricViewController = this.this$0;
    localLyricViewController.c = this.b;
    localLyricViewController.h = localLyricViewController.c.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.3
 * JD-Core Version:    0.7.0.1
 */