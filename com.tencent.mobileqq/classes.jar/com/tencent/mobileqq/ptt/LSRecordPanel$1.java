package com.tencent.mobileqq.ptt;

import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class LSRecordPanel$1
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  LSRecordPanel$1(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startRecordingBarAnimation onAnimationEnd");
    }
    this.a.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.1
 * JD-Core Version:    0.7.0.1
 */