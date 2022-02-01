package com.tencent.open.agent;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;

class BaseCardContainer$5
  extends AnimatorListenerAdapter
{
  BaseCardContainer$5(BaseCardContainer paramBaseCardContainer, ImageView paramImageView) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.b.setBackgroundColor(0);
    this.a.getLayoutParams().width = -1;
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.5
 * JD-Core Version:    0.7.0.1
 */