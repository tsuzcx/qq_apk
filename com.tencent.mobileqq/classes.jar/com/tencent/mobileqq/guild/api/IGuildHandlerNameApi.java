package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildHandlerNameApi
  extends QRouteApi
{
  public abstract String getGuildFileHandlerName();
  
  public abstract String getGuildGuestHandlerName();
  
  public abstract String getGuildMessageEventHandlerName();
  
  public abstract String getGuildMsgBoxHandlerName();
  
  public abstract String getGuildPushMsgHandlerName();
  
  public abstract String getGuildRegisterProxyMsgHandlerName();
  
  public abstract String getGuildRevokeMessageHandlerName();
  
  public abstract String getGuildRoamMsgHandlerName();
  
  public abstract String getGuildSendMsgHandlerName();
  
  public abstract String getMobaPremadesTeamHandlerName();
  
  public abstract String getQQGuildHandlerName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
 * JD-Core Version:    0.7.0.1
 */