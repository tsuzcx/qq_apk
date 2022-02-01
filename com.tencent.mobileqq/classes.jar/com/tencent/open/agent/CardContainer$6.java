package com.tencent.open.agent;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;

class CardContainer$6
  implements ValueAnimator.AnimatorUpdateListener
{
  CardContainer$6(CardContainer paramCardContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.a.setLayoutParams(paramValueAnimator);
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.6
 * JD-Core Version:    0.7.0.1
 */