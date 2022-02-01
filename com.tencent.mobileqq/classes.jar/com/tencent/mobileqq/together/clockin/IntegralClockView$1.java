package com.tencent.mobileqq.together.clockin;

import android.animation.Animator;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class IntegralClockView$1
  extends D8SafeAnimatorListener
{
  IntegralClockView$1(IntegralClockView paramIntegralClockView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (IntegralClockView.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntegralClockView", 2, "integralLottieView play end");
      }
      IntegralClockView.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntegralClockView", 2, "integralLottieView play start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.IntegralClockView.1
 * JD-Core Version:    0.7.0.1
 */