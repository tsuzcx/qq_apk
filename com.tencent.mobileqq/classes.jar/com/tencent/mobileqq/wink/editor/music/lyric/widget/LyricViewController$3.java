package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.util.Log;
import com.tencent.mobileqq.wink.editor.music.lyric.data.Lyric;

class LyricViewController$3
  implements Runnable
{
  LyricViewController$3(LyricViewController paramLyricViewController, Lyric paramLyric1, Lyric paramLyric2, Lyric paramLyric3) {}
  
  public void run()
  {
    if (this.a == null) {
      Log.d("ModuleController", "setLyric -> pronounce is null");
    }
    LyricViewController.a(this.this$0, false);
    if (this.b == null)
    {
      Log.d("ModuleController", "setLyric -> qrc is null");
      this.this$0.c.setLyric(this.c, this.a);
      this.this$0.d = this.c;
      return;
    }
    this.this$0.c.setLyric(this.b, this.a);
    this.this$0.d = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.3
 * JD-Core Version:    0.7.0.1
 */