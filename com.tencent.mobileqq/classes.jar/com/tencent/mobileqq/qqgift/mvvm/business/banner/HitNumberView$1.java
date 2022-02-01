package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.qphone.base.util.QLog;

class HitNumberView$1
  implements Animator.AnimatorListener
{
  HitNumberView$1(HitNumberView paramHitNumberView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("scale onAnimationCancel curNum:");
      paramAnimator.append(HitNumberView.b(this.a));
      paramAnimator.append(" target:");
      paramAnimator.append(HitNumberView.c(this.a));
      QLog.i("Gift_Banner_HitNumberView", 1, paramAnimator.toString());
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!HitNumberView.a(this.a)) {
      return;
    }
    paramAnimator = this.a;
    HitNumberView.a(paramAnimator, HitNumberView.b(paramAnimator));
    if (HitNumberView.b(this.a) < HitNumberView.c(this.a))
    {
      paramAnimator = this.a;
      paramAnimator.setNum(HitNumberView.b(paramAnimator) + 1);
      HitNumberView.d(this.a).b();
      HitNumberView.d(this.a).a();
      HitNumberView.e(this.a);
      return;
    }
    HitNumberView.a(this.a, false);
    if (HitNumberView.f(this.a) != null) {
      HitNumberView.f(this.a).e();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.HitNumberView.1
 * JD-Core Version:    0.7.0.1
 */