package com.tencent.mobileqq.ptt;

import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class LSRecordPanel$2
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  LSRecordPanel$2(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
    }
    LSRecordPanel.c(this.a).post(new LSRecordPanel.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.2
 * JD-Core Version:    0.7.0.1
 */