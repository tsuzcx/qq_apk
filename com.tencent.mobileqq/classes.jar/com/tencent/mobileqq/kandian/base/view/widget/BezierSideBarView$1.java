package com.tencent.mobileqq.kandian.base.view.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class BezierSideBarView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BezierSideBarView$1(BezierSideBarView paramBezierSideBarView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BezierSideBarView.a(this.b, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.b.invalidate();
    ValueAnimator.AnimatorUpdateListener localAnimatorUpdateListener = this.a;
    if (localAnimatorUpdateListener != null) {
      localAnimatorUpdateListener.onAnimationUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BezierSideBarView.1
 * JD-Core Version:    0.7.0.1
 */