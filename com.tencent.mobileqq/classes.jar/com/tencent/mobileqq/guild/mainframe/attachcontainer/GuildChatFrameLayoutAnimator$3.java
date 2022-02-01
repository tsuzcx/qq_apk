package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GuildChatFrameLayoutAnimator$3
  extends D8SafeAnimatorListener
{
  GuildChatFrameLayoutAnimator$3(GuildChatFrameLayoutAnimator paramGuildChatFrameLayoutAnimator, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (GuildChatFrameLayoutAnimator.a(this.b).a() != 2) {
      return;
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
    GuildChatFrameLayoutAnimator.a(this.b).b(GuildChatFrameLayoutAnimator.c(this.b).getTranslationX());
    GuildChatFrameLayoutAnimator.a(this.b).a(3);
    paramAnimator = GuildChatFrameLayoutAnimator.a(this.b);
    int i;
    if (this.a) {
      i = 1000;
    } else {
      i = 0;
    }
    paramAnimator.b(i);
    GuildChatFrameLayoutAnimator.a(this.b).c();
    GuildChatFrameLayoutAnimator.a(this.b).a(0);
    GuildChatFrameLayoutAnimator.a(this.b).c(0);
    GuildChatFrameLayoutAnimator.a(this.b).c();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (GuildChatFrameLayoutAnimator.a(this.b).a() != 2) {
      return;
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
    GuildChatFrameLayoutAnimator.a(this.b).b(GuildChatFrameLayoutAnimator.b(this.b));
    GuildChatFrameLayoutAnimator.a(this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameLayoutAnimator.3
 * JD-Core Version:    0.7.0.1
 */