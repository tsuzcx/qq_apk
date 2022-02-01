package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.AnimatorSet;
import com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper.AnimatorInfo;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;
import com.tencent.mobileqq.utils.ViewUtils;

public class LeftBarJoinGuildAnimator
  implements IGuildMFAnimator
{
  private GuildBaseListItemLayout a;
  private AnimatorSet b = new AnimatorSet();
  
  public LeftBarJoinGuildAnimator(Object paramObject)
  {
    if ((paramObject instanceof GuildBaseListItemLayout)) {
      this.a = ((GuildBaseListItemLayout)paramObject);
    }
  }
  
  public void a()
  {
    AnimatorSet localAnimatorSet = this.b;
    if (localAnimatorSet != null) {
      localAnimatorSet.cancel();
    }
  }
  
  public void a(GuildAnimatorHelper.AnimatorInfo paramAnimatorInfo, Object paramObject)
  {
    paramAnimatorInfo = this.a;
    if (paramAnimatorInfo != null)
    {
      if (paramAnimatorInfo.getHolder() == null) {
        return;
      }
      LeftBarAnimationUtils.a(this.a.getHolder().e, LeftBarAnimationUtils.a, ViewUtils.dpToPx(24.0F), ViewUtils.dpToPx(12.0F));
      this.b.addListener(new LeftBarJoinGuildAnimator.1(this));
      this.b.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildAnimator
 * JD-Core Version:    0.7.0.1
 */