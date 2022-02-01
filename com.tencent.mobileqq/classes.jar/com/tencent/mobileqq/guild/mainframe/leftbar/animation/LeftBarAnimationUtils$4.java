package com.tencent.mobileqq.guild.mainframe.leftbar.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;

final class LeftBarAnimationUtils$4
  implements ValueAnimator.AnimatorUpdateListener
{
  LeftBarAnimationUtils$4(View paramView) {}
  
  @RequiresApi(api=21)
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramValueAnimator.getAnimatedValue());
    localStringBuilder.append("");
    int i = Integer.parseInt(localStringBuilder.toString());
    ((RadiusFrameLayout)this.a).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils.4
 * JD-Core Version:    0.7.0.1
 */