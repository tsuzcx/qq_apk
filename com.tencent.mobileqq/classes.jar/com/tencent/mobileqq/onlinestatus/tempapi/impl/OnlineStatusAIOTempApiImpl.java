package com.tencent.mobileqq.onlinestatus.tempapi.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi;
import com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi.PaiYiPaiCallback;
import com.tencent.mobileqq.paiyipai.PaiYiPaiHandler;

public class OnlineStatusAIOTempApiImpl
  implements IOnlineStatusAIOTempApi
{
  public BusinessObserver getPaiYiPaiObserver(AppInterface paramAppInterface, IOnlineStatusAIOTempApi.PaiYiPaiCallback paramPaiYiPaiCallback)
  {
    return new OnlineStatusAIOTempApiImpl.1(this, paramPaiYiPaiCallback);
  }
  
  public void sendPaiYiPaiReq(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    ((PaiYiPaiHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.PAI_YI_PAI_HANDLER)).a(paramString1, paramString2, 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.tempapi.impl.OnlineStatusAIOTempApiImpl
 * JD-Core Version:    0.7.0.1
 */