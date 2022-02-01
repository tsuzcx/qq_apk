package com.tencent.open.agent;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;

class BaseCardContainer$4
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseCardContainer$4(BaseCardContainer paramBaseCardContainer, ImageView paramImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.getLayoutParams().height = i;
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.4
 * JD-Core Version:    0.7.0.1
 */