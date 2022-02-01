package com.tencent.mobileqq.msg.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import mqq.app.AppRuntime;

public class MessageRecordFactoryImpl
  implements IMessageRecordFactory
{
  public MessageRecord createMsgRecordByMsgType(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
  
  public MessageRecord createMsgRecordFromDB(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3)
  {
    return MessageRecordFactory.a(paramInt1, paramArrayOfByte, paramInt2, paramString, paramInt3);
  }
  
  public MessageRecord createResendMsg(MessageRecord paramMessageRecord)
  {
    return MessageRecordFactory.a(paramMessageRecord);
  }
  
  public MessageRecord createSendMSg_BlessPTV(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return MessageRecordFactory.b((QQAppInterface)paramBaseQQAppInterface, paramString1, paramString2, paramInt);
    }
    return null;
  }
  
  public MessageRecord createSendMSg_Pic(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    return MessageRecordFactory.a((QQAppInterface)paramAppInterface, paramString1, paramString2, paramInt);
  }
  
  public MessageRecord createSendMSg_ShortVideo(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      return MessageRecordFactory.a((QQAppInterface)paramBaseQQAppInterface, paramString1, paramString2, paramInt);
    }
    return null;
  }
  
  public void setSendingMsgRecordBaseInfo(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      MessageRecordFactory.a((QQAppInterface)paramAppRuntime, paramMessageRecord, paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.MessageRecordFactoryImpl
 * JD-Core Version:    0.7.0.1
 */