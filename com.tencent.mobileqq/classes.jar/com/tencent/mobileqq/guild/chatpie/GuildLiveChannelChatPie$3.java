package com.tencent.mobileqq.guild.chatpie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.view.View;

class GuildLiveChannelChatPie$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GuildLiveChannelChatPie$3(GuildLiveChannelChatPie paramGuildLiveChannelChatPie, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.getBackground().setAlpha(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveChannelChatPie.3
 * JD-Core Version:    0.7.0.1
 */