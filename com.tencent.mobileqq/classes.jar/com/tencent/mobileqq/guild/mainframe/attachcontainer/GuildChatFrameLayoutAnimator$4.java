package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class GuildChatFrameLayoutAnimator$4
  implements ValueAnimator.AnimatorUpdateListener
{
  GuildChatFrameLayoutAnimator$4(GuildChatFrameLayoutAnimator paramGuildChatFrameLayoutAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (GuildChatFrameLayoutAnimator.a(this.a).a() != 2) {
      return;
    }
    GuildChatFrameLayoutAnimator.a(this.a).b(GuildChatFrameLayoutAnimator.b(this.a));
    GuildChatFrameLayoutAnimator.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameLayoutAnimator.4
 * JD-Core Version:    0.7.0.1
 */