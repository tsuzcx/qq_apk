package com.tencent.mobileqq.guild.live.widget;

import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

public class GuildLiveSwipeBackLayout$SwipeLayoutHandler
  extends Handler
{
  private final WeakReference<GuildLiveSwipeBackLayout> a;
  
  GuildLiveSwipeBackLayout$SwipeLayoutHandler(GuildLiveSwipeBackLayout paramGuildLiveSwipeBackLayout)
  {
    this.a = new WeakReference(paramGuildLiveSwipeBackLayout);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GuildLiveSwipeBackLayout localGuildLiveSwipeBackLayout = (GuildLiveSwipeBackLayout)this.a.get();
    if ((localGuildLiveSwipeBackLayout != null) && (paramMessage.what == 1))
    {
      if (!GuildLiveSwipeBackLayout.a(localGuildLiveSwipeBackLayout))
      {
        GuildLiveSwipeBackLayout.a(localGuildLiveSwipeBackLayout, true);
        localGuildLiveSwipeBackLayout.m = true;
        if (localGuildLiveSwipeBackLayout.q != null) {
          localGuildLiveSwipeBackLayout.q.g();
        }
      }
    }
    else {
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.SwipeLayoutHandler
 * JD-Core Version:    0.7.0.1
 */