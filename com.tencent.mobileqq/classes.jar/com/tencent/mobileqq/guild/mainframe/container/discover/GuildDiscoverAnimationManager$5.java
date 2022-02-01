package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;

final class GuildDiscoverAnimationManager$5
  extends AnimatorListenerAdapter
{
  GuildDiscoverAnimationManager$5(ViewGroup paramViewGroup, RoundRectUrlImageView paramRoundRectUrlImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager.5
 * JD-Core Version:    0.7.0.1
 */