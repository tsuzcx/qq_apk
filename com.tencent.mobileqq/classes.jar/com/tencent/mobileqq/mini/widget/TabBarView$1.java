package com.tencent.mobileqq.mini.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

class TabBarView$1
  extends AnimatorListenerAdapter
{
  TabBarView$1(TabBarView paramTabBarView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.this$0.setVisibility(8);
    this.this$0.animate().setListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.TabBarView.1
 * JD-Core Version:    0.7.0.1
 */