package com.tencent.mobileqq.guild.channel.create.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;

class QQGuildSubChannelCreateMainFragment$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGuildSubChannelCreateMainFragment$1(QQGuildSubChannelCreateMainFragment paramQQGuildSubChannelCreateMainFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = QQGuildSubChannelCreateMainFragment.a(this.a).getLayoutParams();
    paramValueAnimator.height = i;
    QQGuildSubChannelCreateMainFragment.a(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment.1
 * JD-Core Version:    0.7.0.1
 */