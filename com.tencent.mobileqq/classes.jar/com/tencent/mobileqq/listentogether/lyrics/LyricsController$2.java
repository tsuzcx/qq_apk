package com.tencent.mobileqq.listentogether.lyrics;

import com.tencent.qphone.base.util.QLog;

class LyricsController$2
  implements Runnable
{
  LyricsController$2(LyricsController paramLyricsController) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mDelayUpdateLyricsFloatWindowRunnable isForeground: ");
      localStringBuilder.append(this.this$0.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mFloatParams:");
      localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    LyricsController.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.2
 * JD-Core Version:    0.7.0.1
 */