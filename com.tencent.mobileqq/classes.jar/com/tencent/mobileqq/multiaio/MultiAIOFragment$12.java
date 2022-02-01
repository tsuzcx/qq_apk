package com.tencent.mobileqq.multiaio;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

class MultiAIOFragment$12
  implements ValueAnimator.AnimatorUpdateListener
{
  MultiAIOFragment$12(MultiAIOFragment paramMultiAIOFragment, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    int k = this.b;
    paramValueAnimator.leftMargin = (k + Math.round((this.c - k) * f1));
    k = this.d;
    paramValueAnimator.topMargin = (k + Math.round((this.e - k) * f1));
    k = this.f;
    paramValueAnimator.width = (k + Math.round((this.g - k) * f1));
    k = this.h;
    int m = MultiAIOFragment.d(this.j).getHeight() - MultiAIOFragment.d(this.j).getPaddingTop() - MultiAIOFragment.d(this.j).getPaddingBottom();
    if (m > 0) {
      k = m;
    }
    m = this.i;
    paramValueAnimator.height = (m + Math.round((k - m) * f1));
    this.a.setLayoutParams(paramValueAnimator);
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.12
 * JD-Core Version:    0.7.0.1
 */