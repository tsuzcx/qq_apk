package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TabBarView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  TabBarView$4(TabBarView paramTabBarView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.e;
    int j = this.a;
    paramValueAnimator.o = (j + (this.b - j) * i / 100);
    j = this.c;
    paramValueAnimator.p = (j + (this.d - j) * i / 100);
    if (i == 100) {
      paramValueAnimator.c();
    }
    this.e.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView.4
 * JD-Core Version:    0.7.0.1
 */