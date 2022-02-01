package com.tencent.mobileqq.guild.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.MixMsgParams;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IMixedMsgTempService
  extends IRuntimeService
{
  public abstract void sendTextPicsMixedMsg(AppInterface paramAppInterface, IGuildSendMessageHandler.MixMsgParams paramMixMsgParams, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IMixedMsgTempService
 * JD-Core Version:    0.7.0.1
 */