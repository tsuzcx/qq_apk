package com.tencent.mobileqq.service.message.api.impl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.receivesuccess.GetBlackList;
import com.tencent.mobileqq.service.message.api.IMessageHandlerService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

public class MessageHandlerServiceImpl
  implements IMessageHandlerService
{
  public void getRoamMsgInOneDay(AppRuntime paramAppRuntime, String paramString, long paramLong1, short paramShort, Bundle paramBundle, long paramLong2)
  {
    ((QQAppInterface)paramAppRuntime).getMsgHandler().a(paramString, paramLong1, paramShort, paramBundle, paramLong2);
  }
  
  public void handleGetBlackList(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    GetBlackList.a((MessageHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER), paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.impl.MessageHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */