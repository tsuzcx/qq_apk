package com.tencent.viola.ui.view.list;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;

final class DefaultRecycleItemAnimator$3
  implements Animator.AnimatorListener
{
  DefaultRecycleItemAnimator$3(int paramInt, View paramView, DefaultRecycleItemAnimator.onSpecialRemoveAnimationListener paramonSpecialRemoveAnimationListener) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.val$height, 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new DefaultRecycleItemAnimator.3.1(this));
    localValueAnimator.addListener(new DefaultRecycleItemAnimator.3.2(this));
    this.val$convertView.setTag(paramAnimator);
    localValueAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.3
 * JD-Core Version:    0.7.0.1
 */