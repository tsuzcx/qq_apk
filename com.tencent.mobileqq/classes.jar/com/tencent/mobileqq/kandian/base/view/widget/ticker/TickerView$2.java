package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class TickerView$2
  extends AnimatorListenerAdapter
{
  TickerView$2(TickerView paramTickerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TickerView.a(this.a).b();
    TickerView.b(this.a);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView.2
 * JD-Core Version:    0.7.0.1
 */