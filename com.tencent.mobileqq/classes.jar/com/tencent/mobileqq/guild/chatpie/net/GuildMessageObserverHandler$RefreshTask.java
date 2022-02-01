package com.tencent.mobileqq.guild.chatpie.net;

import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import mqq.util.WeakReference;

class GuildMessageObserverHandler$RefreshTask
  implements Runnable
{
  WeakReference<GuildChatContext> a;
  
  public GuildMessageObserverHandler$RefreshTask(GuildChatContext paramGuildChatContext)
  {
    this.a = new WeakReference(paramGuildChatContext);
  }
  
  public void run()
  {
    GuildMessageObserverHandler.a(false);
    if (this.a.get() != null) {
      ((GuildChatContext)this.a.get()).e().f().a(196608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GuildMessageObserverHandler.RefreshTask
 * JD-Core Version:    0.7.0.1
 */