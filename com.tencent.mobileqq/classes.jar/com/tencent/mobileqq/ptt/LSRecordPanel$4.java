package com.tencent.mobileqq.ptt;

import android.view.animation.Animation;
import com.tencent.qphone.base.util.QLog;

class LSRecordPanel$4
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  LSRecordPanel$4(LSRecordPanel paramLSRecordPanel) {}
  
  public void a(Animation paramAnimation, float paramFloat)
  {
    if ((this.a.d == null) && (this.a.a != null) && (paramFloat >= 0.5F)) {
      this.a.f();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation onAnimationEnd");
    }
    if (paramAnimation == this.a.a) {
      this.a.i();
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.4
 * JD-Core Version:    0.7.0.1
 */