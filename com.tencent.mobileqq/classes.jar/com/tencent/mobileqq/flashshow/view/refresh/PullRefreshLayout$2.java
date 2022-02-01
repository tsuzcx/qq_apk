package com.tencent.mobileqq.flashshow.view.refresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class PullRefreshLayout$2
  extends AnimatorListenerAdapter
{
  PullRefreshLayout$2(PullRefreshLayout paramPullRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    PullRefreshLayout.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.refresh.PullRefreshLayout.2
 * JD-Core Version:    0.7.0.1
 */