package com.tencent.mobileqq.flashshow.personal.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FSRefreshHeaderView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  FSRefreshHeaderView$3(FSRefreshHeaderView paramFSRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.b.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.a == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0))
    {
      this.b.setState(0);
      FSRefreshHeaderView.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.widget.FSRefreshHeaderView.3
 * JD-Core Version:    0.7.0.1
 */