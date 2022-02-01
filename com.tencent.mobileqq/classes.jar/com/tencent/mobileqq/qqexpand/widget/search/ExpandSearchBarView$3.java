package com.tencent.mobileqq.qqexpand.widget.search;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ExpandSearchBarView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ExpandSearchBarView$3(ExpandSearchBarView paramExpandSearchBarView, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-ExpandSearchBarView.a(this.c) * f);
    paramValueAnimator = this.a;
    paramValueAnimator.topMargin = i;
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.3
 * JD-Core Version:    0.7.0.1
 */