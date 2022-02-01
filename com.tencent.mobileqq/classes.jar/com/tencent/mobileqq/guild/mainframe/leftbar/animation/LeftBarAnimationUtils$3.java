package com.tencent.mobileqq.guild.mainframe.leftbar.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class LeftBarAnimationUtils$3
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramValueAnimator.getAnimatedValue());
    localStringBuilder.append("");
    int i = Integer.parseInt(localStringBuilder.toString());
    paramValueAnimator = this.a.getLayoutParams();
    paramValueAnimator.width = i;
    this.a.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils.3
 * JD-Core Version:    0.7.0.1
 */