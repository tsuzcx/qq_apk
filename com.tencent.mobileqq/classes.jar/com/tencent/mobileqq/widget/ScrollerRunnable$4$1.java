package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;

class ScrollerRunnable$4$1
  implements Animator.AnimatorListener
{
  ScrollerRunnable$4$1(ScrollerRunnable.4 param4, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable$4.a.postDelayed(new ScrollerRunnable.4.1.1(this), 500L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.4.1
 * JD-Core Version:    0.7.0.1
 */