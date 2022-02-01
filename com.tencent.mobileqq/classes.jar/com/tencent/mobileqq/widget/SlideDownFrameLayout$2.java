package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideDownFrameLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideDownFrameLayout$2(SlideDownFrameLayout paramSlideDownFrameLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    SlideDownFrameLayout.a(this.a).a().setY(f);
    SlideDownFrameLayout.a(this.a).a(f, SlideDownFrameLayout.a(this.a).a().getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideDownFrameLayout.2
 * JD-Core Version:    0.7.0.1
 */