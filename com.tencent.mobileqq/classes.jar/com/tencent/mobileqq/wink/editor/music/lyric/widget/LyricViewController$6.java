package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import com.tencent.aelight.camera.log.AEQLog;

class LyricViewController$6
  implements Runnable
{
  LyricViewController$6(LyricViewController paramLyricViewController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.c != null) {
      this.this$0.c.a(this.a, this.b);
    }
    if ((this.this$0.b != null) && (this.this$0.c != null))
    {
      if (LyricViewController.a(this.this$0))
      {
        AEQLog.a("ModuleController", "current is selecting lyric. not auto scroll.");
        return;
      }
      int i = this.this$0.c.getTopScroll();
      if (LyricViewController.b(this.this$0) == i) {
        return;
      }
      if (i == 0)
      {
        this.this$0.b.b(i);
        return;
      }
      this.this$0.b.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewController.6
 * JD-Core Version:    0.7.0.1
 */