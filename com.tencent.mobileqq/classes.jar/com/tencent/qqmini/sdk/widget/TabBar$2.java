package com.tencent.qqmini.sdk.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

class TabBar$2
  extends AnimatorListenerAdapter
{
  TabBar$2(TabBar paramTabBar) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.this$0.setVisibility(8);
    this.this$0.animate().setListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.TabBar.2
 * JD-Core Version:    0.7.0.1
 */