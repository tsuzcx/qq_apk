package com.tencent.viola.ui.view.list;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class DefaultRecycleItemAnimator$2
  implements ValueAnimator.AnimatorUpdateListener
{
  DefaultRecycleItemAnimator$2(View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$convertView.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.DefaultRecycleItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */