package com.tencent.mobileqq.guild.chatpie.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.Button;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.XEditTextEx;

class GuildInputBarHelper$6
  extends AnimatorListenerAdapter
{
  GuildInputBarHelper$6(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.e.setScaleX(1.0F);
    this.a.e.setScaleY(1.0F);
    this.a.e.setAlpha(1.0F);
    if (((IGuildTextUtil)QRoute.api(IGuildTextUtil.class)).filterTailSpace(this.a.f.getText()).length() <= 0) {
      this.a.e.setBackgroundResource(this.a.C());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.6
 * JD-Core Version:    0.7.0.1
 */