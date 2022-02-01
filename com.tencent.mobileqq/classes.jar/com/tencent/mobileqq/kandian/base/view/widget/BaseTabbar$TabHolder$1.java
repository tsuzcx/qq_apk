package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class BaseTabbar$TabHolder$1
  extends D8SafeAnimatorListener
{
  BaseTabbar$TabHolder$1(BaseTabbar.TabHolder paramTabHolder, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.b, this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseTabbar.TabHolder.a(this.b, this.a);
    BaseTabbar.TabHolder.a(this.b);
    this.b.e.clearAnimation();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder.1
 * JD-Core Version:    0.7.0.1
 */