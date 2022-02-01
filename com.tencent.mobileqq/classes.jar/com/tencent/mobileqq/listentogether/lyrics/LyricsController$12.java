package com.tencent.mobileqq.listentogether.lyrics;

import avut;
import avuv;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$12
  implements Runnable
{
  public LyricsController$12(avuv paramavuv) {}
  
  public void run()
  {
    this.this$0.a.f = true;
    if (this.this$0.b)
    {
      if (avuv.a(this.this$0)) {
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
    avuv.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.12
 * JD-Core Version:    0.7.0.1
 */