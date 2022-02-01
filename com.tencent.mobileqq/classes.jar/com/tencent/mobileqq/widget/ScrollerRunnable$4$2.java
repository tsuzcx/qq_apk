package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ScrollerRunnable$4$2
  extends D8SafeAnimatorListener
{
  ScrollerRunnable$4$2(ScrollerRunnable.4 param4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a.getParent() != null)
    {
      this.a.a.clearAnimation();
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
      paramAnimator.append(this.a.a.hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.a.getParent());
      QLog.i("ScrollerRunnable", 2, paramAnimator.toString());
    }
    if ((TroopAioNavigateUtil.a(this.a.this$0.k)) && (this.a.this$0.a != null)) {
      this.a.this$0.a.obtainMessage(50).sendToTarget();
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
      paramAnimator.append(this.a.a.hashCode());
      paramAnimator.append(",");
      paramAnimator.append(this.a.a.getParent());
      QLog.i("ScrollerRunnable", 2, paramAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.4.2
 * JD-Core Version:    0.7.0.1
 */