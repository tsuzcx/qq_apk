package com.tencent.mobileqq.kandian.biz.skin;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideActiveAnimController$6
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideActiveAnimController$6(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    SlideActiveAnimController.d(this.a).setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController.6
 * JD-Core Version:    0.7.0.1
 */