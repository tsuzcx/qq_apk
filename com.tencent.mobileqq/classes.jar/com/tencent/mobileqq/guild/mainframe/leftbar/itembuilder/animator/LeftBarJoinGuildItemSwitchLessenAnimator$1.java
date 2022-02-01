package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;

class LeftBarJoinGuildItemSwitchLessenAnimator$1
  extends AnimatorListenerAdapter
{
  LeftBarJoinGuildItemSwitchLessenAnimator$1(LeftBarJoinGuildItemSwitchLessenAnimator paramLeftBarJoinGuildItemSwitchLessenAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (LeftBarJoinGuildItemSwitchLessenAnimator.a(this.a) != null) {
      LeftBarJoinGuildItemSwitchLessenAnimator.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildItemSwitchLessenAnimator.1
 * JD-Core Version:    0.7.0.1
 */