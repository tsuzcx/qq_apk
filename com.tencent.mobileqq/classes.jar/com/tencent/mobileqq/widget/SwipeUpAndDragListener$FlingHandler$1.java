package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.tencent.widget.RoundRectImageView;

class SwipeUpAndDragListener$FlingHandler$1
  implements Animation.AnimationListener
{
  SwipeUpAndDragListener$FlingHandler$1(SwipeUpAndDragListener.FlingHandler paramFlingHandler) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(false);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.a.B.getWidth() / 2, this.a.B.getHeight() / 2);
    paramAnimation.addAnimation(this.a.F);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.setDuration(200L);
    this.a.B.startAnimation(paramAnimation);
    paramAnimation.setAnimationListener(this.a.C);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.FlingHandler.1
 * JD-Core Version:    0.7.0.1
 */