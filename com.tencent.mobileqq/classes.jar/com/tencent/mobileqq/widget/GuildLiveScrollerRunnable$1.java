package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;

class GuildLiveScrollerRunnable$1
  implements ValueAnimator.AnimatorUpdateListener
{
  GuildLiveScrollerRunnable$1(GuildLiveScrollerRunnable paramGuildLiveScrollerRunnable, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.getBackground().setAlpha(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuildLiveScrollerRunnable.1
 * JD-Core Version:    0.7.0.1
 */