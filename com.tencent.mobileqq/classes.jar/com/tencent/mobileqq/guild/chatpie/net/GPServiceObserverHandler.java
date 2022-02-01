package com.tencent.mobileqq.guild.chatpie.net;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

public class GPServiceObserverHandler
  extends GuildChatPieNetHandler
{
  private GPServiceObserver c = new GPServiceObserverHandler.1(this);
  
  public GPServiceObserverHandler(GuildChatContext paramGuildChatContext, QQAppInterface paramQQAppInterface)
  {
    super(paramGuildChatContext, paramQQAppInterface);
  }
  
  public void a()
  {
    if (this.b != null) {
      ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).addObserver(this.c);
    }
  }
  
  public void b()
  {
    if (this.b != null) {
      ((IGPSService)this.b.getRuntimeService(IGPSService.class, "")).deleteObserver(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GPServiceObserverHandler
 * JD-Core Version:    0.7.0.1
 */