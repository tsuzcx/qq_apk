package com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import com.tencent.mobileqq.guild.mainframe.helper.GuildAnimatorHelper.AnimatorInfo;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemViewHolder;
import com.tencent.mobileqq.guild.mainframe.leftbar.animation.LeftBarAnimationUtils;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;

public class LeftBarJoinGuildLocalAnimator
  implements IGuildMFAnimator
{
  private GuildBaseListItemLayout a;
  private AnimatorSet b;
  
  public LeftBarJoinGuildLocalAnimator(Object paramObject)
  {
    if ((paramObject instanceof GuildBaseListItemLayout)) {
      this.a = ((GuildBaseListItemLayout)paramObject);
    }
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AnimatorSet)localObject).cancel();
      this.b = null;
    }
    localObject = this.a;
    if ((localObject != null) && (((GuildBaseListItemLayout)localObject).getHolder() != null)) {
      this.a.getHolder().a.setTranslationY(0.0F);
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
      this.b = new AnimatorSet();
      paramAnimatorInfo = this.a.getHolder();
      paramAnimatorInfo.a.setVisibility(0);
      float f = GuildListItemBaseBuilder.b;
      paramObject = LeftBarAnimationUtils.a(paramAnimatorInfo.a, new float[] { f, 0.0F }, 300L);
      this.b.addListener(new LeftBarJoinGuildLocalAnimator.1(this, paramAnimatorInfo));
      this.b.playTogether(new Animator[] { paramObject });
      this.b.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.animator.LeftBarJoinGuildLocalAnimator
 * JD-Core Version:    0.7.0.1
 */