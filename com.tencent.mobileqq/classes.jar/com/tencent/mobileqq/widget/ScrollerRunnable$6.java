package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ScrollerRunnable$6
  extends D8SafeAnimatorListener
{
  ScrollerRunnable$6(ScrollerRunnable paramScrollerRunnable, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.getParent() != null)
    {
      this.a.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
      }
    }
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationEnd:");
      paramAnimator.append(hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.getParent());
      QLog.i("ScrollerRunnable", 2, paramAnimator.toString());
    }
    if ((TroopAioNavigateUtil.a(this.b.o)) && (this.b.p != null)) {
      this.b.p.obtainMessage(50).sendToTarget();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("onAnimationStart:");
      paramAnimator.append(hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.getParent());
      QLog.i("ScrollerRunnable", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.6
 * JD-Core Version:    0.7.0.1
 */