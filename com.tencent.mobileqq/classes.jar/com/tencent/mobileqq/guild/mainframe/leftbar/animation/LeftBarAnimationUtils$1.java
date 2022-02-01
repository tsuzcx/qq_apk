package com.tencent.mobileqq.guild.mainframe.leftbar.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

final class LeftBarAnimationUtils$1
  implements ValueAnimator.AnimatorUpdateListener
{
  LeftBarAnimationUtils$1(View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ColorAniData)paramValueAnimator.getAnimatedValue();
    GradientDrawable localGradientDrawable = (GradientDrawable)this.a.getBackground();
    localGradientDrawable.setColors(new int[] { paramValueAnimator.a, paramValueAnimator.b });
    this.a.setBackground(localGradientDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils.1
 * JD-Core Version:    0.7.0.1
 */