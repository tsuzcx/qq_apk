package com.tencent.pts.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

final class PTSAnimationUtil$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PTSAnimationUtil$2(FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.val$lp.topMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.val$view.setLayoutParams(this.val$lp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSAnimationUtil.2
 * JD-Core Version:    0.7.0.1
 */