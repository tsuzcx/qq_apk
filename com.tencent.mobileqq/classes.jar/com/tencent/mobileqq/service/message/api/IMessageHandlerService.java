package com.tencent.mobileqq.service.message.api;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IMessageHandlerService
  extends QRouteApi
{
  public abstract void getRoamMsgInOneDay(AppRuntime paramAppRuntime, String paramString, long paramLong1, short paramShort, Bundle paramBundle, long paramLong2);
  
  public abstract void handleGetBlackList(AppInterface paramAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.IMessageHandlerService
 * JD-Core Version:    0.7.0.1
 */