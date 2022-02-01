package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

final class GuildDiscoverAnimationManager$3
  extends AnimatorListenerAdapter
{
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    QLog.i("GuildDiscover.GuildDiscoverAnimationManager", 2, "mock GuildShareElement.move onAnimationStart");
    this.a.setAlpha(0.0F);
    GuildDiscoverAnimationManager.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager.3
 * JD-Core Version:    0.7.0.1
 */