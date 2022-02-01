package com.tencent.mobileqq.guild.animate;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;

class RectangleRevealAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  RectangleRevealAnimator$1(RectangleRevealAnimator paramRectangleRevealAnimator, RectangleClipCompatLayout paramRectangleClipCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RectF localRectF = new RectF();
    localRectF.top = ((Float)paramValueAnimator.getAnimatedValue("top")).floatValue();
    localRectF.left = ((Float)paramValueAnimator.getAnimatedValue("left")).floatValue();
    localRectF.right = (localRectF.left + ((Float)paramValueAnimator.getAnimatedValue("width")).floatValue());
    localRectF.bottom = (localRectF.top + ((Float)paramValueAnimator.getAnimatedValue("height")).floatValue());
    this.a.setClipRect(localRectF, ((Float)paramValueAnimator.getAnimatedValue("radius")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.animate.RectangleRevealAnimator.1
 * JD-Core Version:    0.7.0.1
 */