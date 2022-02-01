package com.tencent.mobileqq.guild.chatpie.net;

import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;

class GuildMessageObserverHandler$2
  extends GuildEventFlowObserver
{
  GuildMessageObserverHandler$2(GuildMessageObserverHandler paramGuildMessageObserverHandler) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (!this.a.a.T().equals(paramString)) {
      return;
    }
    GuildMessageObserverHandler.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GuildMessageObserverHandler.2
 * JD-Core Version:    0.7.0.1
 */