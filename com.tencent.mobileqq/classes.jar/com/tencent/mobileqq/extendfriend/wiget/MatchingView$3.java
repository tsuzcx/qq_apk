package com.tencent.mobileqq.extendfriend.wiget;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;

class MatchingView$3
  extends AnimatorListenerAdapter
{
  MatchingView$3(MatchingView paramMatchingView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (MatchingView.a(this.a)) {
      MatchingView.a(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.MatchingView.3
 * JD-Core Version:    0.7.0.1
 */