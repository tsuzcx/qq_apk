package com.tencent.mobileqq.listentogether.lyrics;

import atjl;
import atjn;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$12
  implements Runnable
{
  public LyricsController$12(atjn paramatjn) {}
  
  public void run()
  {
    this.this$0.a.f = true;
    if (this.this$0.b)
    {
      if (atjn.a(this.this$0)) {
        break label77;
      }
      int i = this.this$0.a.e;
      String str = this.this$0.a.b;
      this.this$0.b(i, str);
      if (QLog.isColorLevel()) {
        QLog.d("LyricsController", 2, "ACTION_QQ_FOREGROUND no permission hideLyrics");
      }
    }
    return;
    label77:
    atjn.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.12
 * JD-Core Version:    0.7.0.1
 */