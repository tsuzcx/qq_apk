package com.tencent.mobileqq.guild.message.api;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={""})
public abstract interface IGuildMessageManagerApi
  extends QRouteApi
{
  public abstract BaseGuildMessageManager newGuildMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildMessageManagerApi
 * JD-Core Version:    0.7.0.1
 */