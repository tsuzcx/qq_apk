package com.tencent.mobileqq.guild.message.api;

import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildMessageCallbackApi
  extends QRouteApi
{
  public abstract void setGuildGuestMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildMessageManagerCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildOfflineMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildPushMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildRoamMessageEventFlowProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildRoamMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setGuildSystemMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback);
  
  public abstract void setMsgProxyCallback(MsgProxyUtils.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
 * JD-Core Version:    0.7.0.1
 */