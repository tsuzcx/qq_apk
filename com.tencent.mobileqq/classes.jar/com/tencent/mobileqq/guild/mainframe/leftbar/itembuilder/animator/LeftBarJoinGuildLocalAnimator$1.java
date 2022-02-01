package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;

class LeftBarJoinGuildLocalAnimator$1
  extends AnimatorListenerAdapter
{
  LeftBarJoinGuildLocalAnimator$1(LeftBarJoinGuildLocalAnimator paramLeftBarJoinGuildLocalAnimator, GuildBaseItemViewHolder paramGuildBaseItemViewHolder) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (LeftBarJoinGuildLocalAnimator.a(this.b) != null)
    {
      LeftBarJoinGuildLocalAnimator.a(this.b).c();
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildLocalAnimator.1
 * JD-Core Version:    0.7.0.1
 */