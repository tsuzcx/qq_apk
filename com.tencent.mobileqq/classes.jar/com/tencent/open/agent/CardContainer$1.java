package com.tencent.open.agent;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class CardContainer$1
  implements ValueAnimator.AnimatorUpdateListener
{
  CardContainer$1(CardContainer paramCardContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.a.k.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.k.setLayoutParams(paramValueAnimator);
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.1
 * JD-Core Version:    0.7.0.1
 */