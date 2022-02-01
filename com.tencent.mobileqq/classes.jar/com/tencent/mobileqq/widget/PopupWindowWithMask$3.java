package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class PopupWindowWithMask$3
  implements ValueAnimator.AnimatorUpdateListener
{
  PopupWindowWithMask$3(PopupWindowWithMask paramPopupWindowWithMask) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (PopupWindowWithMask.a(this.a) != null)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      PopupWindowWithMask.a(this.a).setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PopupWindowWithMask.3
 * JD-Core Version:    0.7.0.1
 */