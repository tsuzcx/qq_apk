package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.guild.message.GuildMessageCache;
import com.tencent.mobileqq.guild.message.base.IGuildMessageProcessor;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildMsgFactory
  extends IRuntimeService
{
  public abstract IGuildMessageProcessor getMessageProcessor(int paramInt);
  
  public abstract GuildMessageCache getMsgCache();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMsgFactory
 * JD-Core Version:    0.7.0.1
 */