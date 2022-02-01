package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;

class LeftBarJoinGuildItemSwitchEnlargeAnimator$1
  extends AnimatorListenerAdapter
{
  LeftBarJoinGuildItemSwitchEnlargeAnimator$1(LeftBarJoinGuildItemSwitchEnlargeAnimator paramLeftBarJoinGuildItemSwitchEnlargeAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (LeftBarJoinGuildItemSwitchEnlargeAnimator.a(this.a) != null) {
      LeftBarJoinGuildItemSwitchEnlargeAnimator.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildItemSwitchEnlargeAnimator.1
 * JD-Core Version:    0.7.0.1
 */