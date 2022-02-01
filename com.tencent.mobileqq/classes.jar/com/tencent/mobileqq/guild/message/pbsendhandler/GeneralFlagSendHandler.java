package com.tencent.mobileqq.guild.message.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62.ReqBody;

public class GeneralFlagSendHandler
  implements IBeforeSendGuildMsgPbHandler
{
  public Oidb0xf62.ReqBody a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, Oidb0xf62.ReqBody paramReqBody)
  {
    return paramReqBody;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.pbsendhandler.GeneralFlagSendHandler
 * JD-Core Version:    0.7.0.1
 */