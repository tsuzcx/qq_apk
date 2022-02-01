package com.tencent.mobileqq.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.pic.Logger;

class SwipeUpAndDragListener$DragHandler$1
  implements Animation.AnimationListener
{
  SwipeUpAndDragListener$DragHandler$1(SwipeUpAndDragListener.DragHandler paramDragHandler, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new StringBuilder();
    paramAnimation.append(" flyOutAnimation End fAnimLayout:");
    paramAnimation.append(this.b.s);
    paramAnimation.append(",## dy = ");
    paramAnimation.append(this.a - this.b.o.k);
    Logger.a("PhotoListPanel", "DragHandler", paramAnimation.toString());
    paramAnimation = (RelativeLayout.LayoutParams)this.b.A.getLayoutParams();
    paramAnimation.topMargin = this.b.v.topMargin;
    this.b.A.setLayoutParams(paramAnimation);
    paramAnimation = new AnimationSet(false);
    Object localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, this.b.A.getWidth() / 2, this.b.A.getHeight() / 2);
    paramAnimation.addAnimation(this.b.F);
    paramAnimation.addAnimation((Animation)localObject);
    paramAnimation.setDuration(200L);
    this.b.A.startAnimation(paramAnimation);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startReemergeAnimation fAnimLayout:");
    ((StringBuilder)localObject).append(this.b.s);
    Logger.a("PhotoListPanel", "DragHandler", ((StringBuilder)localObject).toString());
    paramAnimation.setAnimationListener(this.b.C);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    Logger.a("PhotoListPanel", "DragHandler", "@#flyOutAnimation, onAnimationStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SwipeUpAndDragListener.DragHandler.1
 * JD-Core Version:    0.7.0.1
 */