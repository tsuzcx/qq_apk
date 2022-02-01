package com.tencent.mobileqq.colornote.anim;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.RectF;

class RectangleRevealAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.RectangleRevealAnimator.1
 * JD-Core Version:    0.7.0.1
 */