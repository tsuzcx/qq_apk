package com.tencent.mobileqq.guild.chatpie.net;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;

public abstract class GuildChatPieNetHandler
{
  GuildChatContext a;
  QQAppInterface b;
  
  public GuildChatPieNetHandler(GuildChatContext paramGuildChatContext, QQAppInterface paramQQAppInterface)
  {
    this.a = paramGuildChatContext;
    this.b = paramQQAppInterface;
  }
  
  public abstract void a();
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.net.GuildChatPieNetHandler
 * JD-Core Version:    0.7.0.1
 */