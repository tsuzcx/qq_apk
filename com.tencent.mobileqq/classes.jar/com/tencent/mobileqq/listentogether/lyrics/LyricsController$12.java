package com.tencent.mobileqq.listentogether.lyrics;

import com.tencent.qphone.base.util.QLog;

class LyricsController$12
  implements Runnable
{
  LyricsController$12(LyricsController paramLyricsController) {}
  
  public void run()
  {
    this.this$0.d.k = true;
    if (this.this$0.e) {
      if (!LyricsController.b(this.this$0))
      {
        int i = this.this$0.d.m;
        String str = this.this$0.d.n;
        this.this$0.b(i, str);
        if (QLog.isColorLevel()) {
          QLog.d("LyricsController", 2, "ACTION_QQ_FOREGROUND no permission hideLyrics");
        }
      }
      else
      {
        LyricsController.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.12
 * JD-Core Version:    0.7.0.1
 */