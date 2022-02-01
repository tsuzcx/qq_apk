package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.file.GuildFileHandler;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildMessagePushHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildRevokeMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowHandler;
import com.tencent.mobileqq.guild.message.guest.GuildGuestHandler;
import com.tencent.mobileqq.guild.message.mobapremadesteam.MobaPremadesTeamHandler;
import com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyMsgHandler;

public class GuildHandlerNameApiImpl
  implements IGuildHandlerNameApi
{
  public String getGuildFileHandlerName()
  {
    return GuildFileHandler.class.getName();
  }
  
  public String getGuildGuestHandlerName()
  {
    return GuildGuestHandler.class.getName();
  }
  
  public String getGuildMessageEventHandlerName()
  {
    return GuildEventFlowHandler.class.getName();
  }
  
  public String getGuildMsgBoxHandlerName()
  {
    return GuildMessageBoxHandler.class.getName();
  }
  
  public String getGuildPushMsgHandlerName()
  {
    return GuildMessagePushHandler.class.getName();
  }
  
  public String getGuildRegisterProxyMsgHandlerName()
  {
    return GuildRegisterProxyMsgHandler.class.getName();
  }
  
  public String getGuildRevokeMessageHandlerName()
  {
    return GuildRevokeMessageHandler.class.getName();
  }
  
  public String getGuildRoamMsgHandlerName()
  {
    return GuildRoamMessageHandler.class.getName();
  }
  
  public String getGuildSendMsgHandlerName()
  {
    return GuildSendMessageHandler.class.getName();
  }
  
  public String getMobaPremadesTeamHandlerName()
  {
    return MobaPremadesTeamHandler.class.getName();
  }
  
  public String getQQGuildHandlerName()
  {
    return QQGuildHandler.class.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildHandlerNameApiImpl
 * JD-Core Version:    0.7.0.1
 */