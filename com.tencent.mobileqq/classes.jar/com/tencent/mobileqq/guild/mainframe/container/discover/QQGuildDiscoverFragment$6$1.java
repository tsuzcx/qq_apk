package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.qphone.base.util.QLog;

class QQGuildDiscoverFragment$6$1
  extends AnimatorListenerAdapter
{
  QQGuildDiscoverFragment$6$1(QQGuildDiscoverFragment.6 param6) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QLog.i("GuildDiscover.QQGuildDiscoverFragment", 2, "onAnimationEnd.");
    QQGuildDiscoverFragment.a = true;
    QQGuildDiscoverFragment.o(this.a.a).k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    QQGuildDiscoverFragment.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment.6.1
 * JD-Core Version:    0.7.0.1
 */