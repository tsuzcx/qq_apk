package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TabLayoutCompat$SlidingTabStrip$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayoutCompat$SlidingTabStrip$1(TabLayoutCompat.SlidingTabStrip paramSlidingTabStrip, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabLayoutCompat$SlidingTabStrip.a(a(this.jdField_a_of_type_Int, this.b, f), a(this.c, this.d, f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabLayoutCompat.SlidingTabStrip.1
 * JD-Core Version:    0.7.0.1
 */