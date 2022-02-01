package com.tencent.mobileqq.guild.api.impl;

import android.animation.Animator;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GuildTempApiImpl$1
  extends D8SafeAnimatorListener
{
  GuildTempApiImpl$1(GuildTempApiImpl paramGuildTempApiImpl, TabWidget paramTabWidget, MainFragment paramMainFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    GuildTempApiImpl.access$002(this.c, null);
    GuildTempApiImpl.access$100(this.c, this.a, this.b.K, true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    GuildTempApiImpl.access$002(this.c, null);
    GuildTempApiImpl.access$100(this.c, this.a, this.b.K, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTempApiImpl.1
 * JD-Core Version:    0.7.0.1
 */