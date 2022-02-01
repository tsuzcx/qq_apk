package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TickerView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TickerView$1(TickerView paramTickerView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TickerView.a(this.a).a(paramValueAnimator.getAnimatedFraction());
    TickerView.b(this.a);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView.1
 * JD-Core Version:    0.7.0.1
 */