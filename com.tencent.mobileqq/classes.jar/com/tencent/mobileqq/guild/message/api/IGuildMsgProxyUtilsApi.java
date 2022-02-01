package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGuildMsgProxyUtilsApi
  extends QRouteApi
{
  public abstract boolean compGuildMsgContent(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi
 * JD-Core Version:    0.7.0.1
 */