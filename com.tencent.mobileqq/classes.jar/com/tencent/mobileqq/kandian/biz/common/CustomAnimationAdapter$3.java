package com.tencent.mobileqq.kandian.biz.common;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

class CustomAnimationAdapter$3
  implements ValueAnimator.AnimatorUpdateListener
{
  CustomAnimationAdapter$3(CustomAnimationAdapter paramCustomAnimationAdapter, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      ((LinearLayout.LayoutParams)localLayoutParams).topMargin = paramValueAnimator.intValue();
      this.a.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter.3
 * JD-Core Version:    0.7.0.1
 */