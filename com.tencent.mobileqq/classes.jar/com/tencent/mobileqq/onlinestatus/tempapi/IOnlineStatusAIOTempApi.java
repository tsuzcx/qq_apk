package com.tencent.mobileqq.onlinestatus.tempapi;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOnlineStatusAIOTempApi
  extends QRouteApi
{
  public abstract BusinessObserver getPaiYiPaiObserver(AppInterface paramAppInterface, IOnlineStatusAIOTempApi.PaiYiPaiCallback paramPaiYiPaiCallback);
  
  public abstract void sendPaiYiPaiReq(AppInterface paramAppInterface, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.tempapi.IOnlineStatusAIOTempApi
 * JD-Core Version:    0.7.0.1
 */