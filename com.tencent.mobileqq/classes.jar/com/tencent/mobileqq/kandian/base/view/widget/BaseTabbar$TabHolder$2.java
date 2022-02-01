package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class BaseTabbar$TabHolder$2
  extends D8SafeAnimatorListener
{
  BaseTabbar$TabHolder$2(BaseTabbar.TabHolder paramTabHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    QLog.d("TabBarView", 4, "onAnimationEnd");
    BaseTabbar.TabHolder.b(this.a);
    this.a.e.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder.2
 * JD-Core Version:    0.7.0.1
 */