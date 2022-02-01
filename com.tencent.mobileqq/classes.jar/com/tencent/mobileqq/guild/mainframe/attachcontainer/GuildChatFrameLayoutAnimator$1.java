package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.animation.Animator;
import android.view.View;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GuildChatFrameLayoutAnimator$1
  extends D8SafeAnimatorListener
{
  GuildChatFrameLayoutAnimator$1(GuildChatFrameLayoutAnimator paramGuildChatFrameLayoutAnimator, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((GuildChatFrameLayoutAnimator.a(this.b).a() != 2) && (GuildChatFrameLayoutAnimator.a(this.b).a() != 1)) {
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
    if (GuildChatFrameLayoutAnimator.a(this.b).a() != 0) {
      return;
    }
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
    paramAnimator = GuildChatFrameLayoutAnimator.a(this.b);
    int i = 1;
    paramAnimator.a(1);
    GuildChatFrameLayoutAnimator.a(this.b).d(3);
    paramAnimator = GuildChatFrameLayoutAnimator.a(this.b);
    if (!this.a) {
      i = 2;
    }
    paramAnimator.c(i);
    GuildChatFrameLayoutAnimator.a(this.b).b(GuildChatFrameLayoutAnimator.b(this.b));
    GuildChatFrameLayoutAnimator.a(this.b).a(GuildChatFrameLayoutAnimator.c(this.b).getTranslationX());
    GuildChatFrameLayoutAnimator.a(this.b).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameLayoutAnimator.1
 * JD-Core Version:    0.7.0.1
 */