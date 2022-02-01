package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.mobileqq.guild.message.GuildGuestMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildMessageManager;
import com.tencent.mobileqq.guild.message.GuildMsgProxyUtils;
import com.tencent.mobileqq.guild.message.GuildOfflineMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildOnlineMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildRoamMessageEventFlowProcessor;
import com.tencent.mobileqq.guild.message.GuildRoamMessageProcessor;
import com.tencent.mobileqq.guild.message.GuildSystemMessageProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi;
import com.tencent.mobileqq.guild.message.base.IGuildMessageCallback;

public class GuildMessageCallbackApiImpl
  implements IGuildMessageCallbackApi
{
  public void setGuildGuestMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildGuestMessageProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setGuildMessageManagerCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildMessageManager.a(paramIGuildMessageCallback);
  }
  
  public void setGuildOfflineMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildOfflineMessageProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setGuildPushMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildOnlineMessageProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setGuildRoamMessageEventFlowProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildRoamMessageEventFlowProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setGuildRoamMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildRoamMessageProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setGuildSystemMessageProcessorCallback(IGuildMessageCallback paramIGuildMessageCallback)
  {
    GuildSystemMessageProcessor.a(paramIGuildMessageCallback);
  }
  
  public void setMsgProxyCallback(MsgProxyUtils.Callback paramCallback)
  {
    GuildMsgProxyUtils.a(paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageCallbackApiImpl
 * JD-Core Version:    0.7.0.1
 */