package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;

class LeftBarJoinGuildAnimator$1
  extends AnimatorListenerAdapter
{
  LeftBarJoinGuildAnimator$1(LeftBarJoinGuildAnimator paramLeftBarJoinGuildAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    LeftBarJoinGuildAnimator.a(this.a).c();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildAnimator.1
 * JD-Core Version:    0.7.0.1
 */