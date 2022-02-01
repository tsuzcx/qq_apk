package com.tencent.mobileqq.guild.chatpie;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.net.GPServiceObserverHandler;
import com.tencent.mobileqq.guild.chatpie.net.GuildChatPieNetHandler;
import com.tencent.mobileqq.guild.chatpie.net.GuildMessageObserverHandler;
import java.util.ArrayList;
import java.util.Iterator;

class GuildChatPieNetModule
{
  private QQAppInterface a;
  private GuildChatContext b;
  private ArrayList<GuildChatPieNetHandler> c = new ArrayList();
  
  public GuildChatPieNetModule(QQAppInterface paramQQAppInterface, GuildChatContext paramGuildChatContext)
  {
    this.a = paramQQAppInterface;
    this.b = paramGuildChatContext;
    c();
  }
  
  private void a(GuildChatPieNetHandler paramGuildChatPieNetHandler)
  {
    this.c.add(paramGuildChatPieNetHandler);
  }
  
  private void c()
  {
    a(new GuildMessageObserverHandler(this.b, this.a));
    a(new GPServiceObserverHandler(this.b, this.a));
  }
  
  private void d()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GuildChatPieNetHandler)localIterator.next()).a();
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GuildChatPieNetHandler)localIterator.next()).b();
    }
  }
  
  public void a()
  {
    d();
  }
  
  public void b()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatPieNetModule
 * JD-Core Version:    0.7.0.1
 */