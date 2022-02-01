package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class VariableSizeTextView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VariableSizeTextView$1(VariableSizeTextView paramVariableSizeTextView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == this.b.c)
    {
      this.b.setFocusable(true);
      this.b.setClickable(true);
    }
    paramValueAnimator = this.a;
    paramValueAnimator.height = ((int)(f + 0.5F));
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.VariableSizeTextView.1
 * JD-Core Version:    0.7.0.1
 */