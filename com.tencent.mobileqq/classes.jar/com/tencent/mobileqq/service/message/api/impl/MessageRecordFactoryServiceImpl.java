package com.tencent.mobileqq.service.message.api.impl;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;

public class MessageRecordFactoryServiceImpl
  implements IMessageRecordFactoryService
{
  public MessageRecord createMsgRecordByMsgType(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.impl.MessageRecordFactoryServiceImpl
 * JD-Core Version:    0.7.0.1
 */