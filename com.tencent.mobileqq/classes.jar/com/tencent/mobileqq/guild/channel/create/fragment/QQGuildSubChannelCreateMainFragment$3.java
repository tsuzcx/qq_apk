package com.tencent.mobileqq.guild.channel.create.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.FrameLayout;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;

class QQGuildSubChannelCreateMainFragment$3
  extends AnimatorListenerAdapter
{
  QQGuildSubChannelCreateMainFragment$3(QQGuildSubChannelCreateMainFragment paramQQGuildSubChannelCreateMainFragment) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    QQGuildSubChannelCreateMainFragment.c(this.a).setVisibility(0);
    if (this.a.b.d == 6)
    {
      QQGuildSubChannelCreateMainFragment.d(this.a);
      return;
    }
    QQGuildSubChannelCreateMainFragment.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildSubChannelCreateMainFragment.3
 * JD-Core Version:    0.7.0.1
 */