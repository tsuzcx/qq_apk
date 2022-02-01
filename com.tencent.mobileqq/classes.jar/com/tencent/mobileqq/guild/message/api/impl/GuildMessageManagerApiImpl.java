package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.guild.message.GuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi;
import mqq.app.AppRuntime;

public class GuildMessageManagerApiImpl
  implements IGuildMessageManagerApi
{
  public BaseGuildMessageManager newGuildMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    return new GuildMessageManager(paramAppRuntime, paramMsgPool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMessageManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */