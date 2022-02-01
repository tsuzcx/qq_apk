package com.tencent.mobileqq.guild.live.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GuildLiveJoinRoomMsgAnimView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  GuildLiveJoinRoomMsgAnimView$3(GuildLiveJoinRoomMsgAnimView paramGuildLiveJoinRoomMsgAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setAlpha(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveJoinRoomMsgAnimView.3
 * JD-Core Version:    0.7.0.1
 */