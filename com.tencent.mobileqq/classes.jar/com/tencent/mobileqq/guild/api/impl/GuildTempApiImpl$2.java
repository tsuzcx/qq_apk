package com.tencent.mobileqq.guild.api.impl;

import android.animation.Animator;
import android.widget.TabWidget;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GuildTempApiImpl$2
  extends D8SafeAnimatorListener
{
  GuildTempApiImpl$2(GuildTempApiImpl paramGuildTempApiImpl, TabWidget paramTabWidget, MainFragment paramMainFragment) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    GuildTempApiImpl.access$202(this.c, null);
    GuildTempApiImpl.access$100(this.c, this.a, this.b.K, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    GuildTempApiImpl.access$202(this.c, null);
    GuildTempApiImpl.access$100(this.c, this.a, this.b.K, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildTempApiImpl.2
 * JD-Core Version:    0.7.0.1
 */