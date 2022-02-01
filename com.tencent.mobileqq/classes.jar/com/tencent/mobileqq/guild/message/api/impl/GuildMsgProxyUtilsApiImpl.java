package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.GuildMsgProxyUtils;
import com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi;
import mqq.app.AppRuntime;

public class GuildMsgProxyUtilsApiImpl
  implements IGuildMsgProxyUtilsApi
{
  public boolean compGuildMsgContent(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return GuildMsgProxyUtils.a(paramAppRuntime, paramMessageRecord1, paramMessageRecord2, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildMsgProxyUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */