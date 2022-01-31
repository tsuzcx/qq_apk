package com.tencent.mobileqq.listentogether.lyrics;

import arss;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$2
  implements Runnable
{
  public LyricsController$2(arss paramarss) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "mDelayUpdateLyricsFloatWindowRunnable isForeground: " + this.this$0.jdField_a_of_type_Boolean + " mFloatParams:" + this.this$0.jdField_a_of_type_Arsq);
    }
    arss.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.2
 * JD-Core Version:    0.7.0.1
 */