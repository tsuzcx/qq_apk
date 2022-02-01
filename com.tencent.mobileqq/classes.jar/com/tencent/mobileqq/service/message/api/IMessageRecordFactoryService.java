package com.tencent.mobileqq.service.message.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMessageRecordFactoryService
  extends QRouteApi
{
  public abstract MessageRecord createMsgRecordByMsgType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService
 * JD-Core Version:    0.7.0.1
 */