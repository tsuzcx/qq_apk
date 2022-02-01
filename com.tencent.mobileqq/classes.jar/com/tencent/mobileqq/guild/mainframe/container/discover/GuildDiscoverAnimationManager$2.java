package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import com.tencent.qphone.base.util.QLog;

final class GuildDiscoverAnimationManager$2
  extends AnimatorListenerAdapter
{
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QLog.i("GuildDiscover.GuildDiscoverAnimationManager", 2, "QQGuildFacadeFragment mContentView.alpha onAnimationEnd");
    this.a.setVisibility(8);
    GuildDiscoverAnimationManager.b = true;
    GuildDiscoverAnimationManager.a = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    QLog.i("GuildDiscover.GuildDiscoverAnimationManager", 2, "QQGuildFacadeFragment mContentView.alpha onAnimationStart");
    GuildDiscoverAnimationManager.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager.2
 * JD-Core Version:    0.7.0.1
 */