package org.libpag;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class PAGView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PAGView$1(PAGView paramPAGView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    PAGView.access$202(this.this$0, paramValueAnimator.getCurrentPlayTime());
    paramValueAnimator = this.this$0;
    PAGView.access$400(paramValueAnimator, ((Float)PAGView.access$300(paramValueAnimator).getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGView.1
 * JD-Core Version:    0.7.0.1
 */