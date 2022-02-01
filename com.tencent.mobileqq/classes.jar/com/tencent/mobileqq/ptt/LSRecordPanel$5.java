package com.tencent.mobileqq.ptt;

import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class LSRecordPanel$5
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  LSRecordPanel$5(LSRecordPanel paramLSRecordPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startSideAnimation onAnimationEnd");
    }
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.5
 * JD-Core Version:    0.7.0.1
 */