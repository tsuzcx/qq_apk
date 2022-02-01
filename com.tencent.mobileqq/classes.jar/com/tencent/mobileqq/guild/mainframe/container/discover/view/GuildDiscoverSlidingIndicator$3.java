package com.tencent.mobileqq.guild.mainframe.container.discover.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GuildDiscoverSlidingIndicator$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GuildDiscoverSlidingIndicator$3(GuildDiscoverSlidingIndicator paramGuildDiscoverSlidingIndicator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.j = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.view.GuildDiscoverSlidingIndicator.3
 * JD-Core Version:    0.7.0.1
 */