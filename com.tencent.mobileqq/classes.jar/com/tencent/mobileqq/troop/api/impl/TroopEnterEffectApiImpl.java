package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import mqq.app.AppRuntime;

public class TroopEnterEffectApiImpl
  implements ITroopEnterEffectApi
{
  public void sendGetBaseVipInfoReq(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((VipInfoHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramString1, paramString2);
    }
  }
  
  public void sendTroopEnterEffectCMD(AppRuntime paramAppRuntime, long paramLong1, long paramLong2)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      ((IApolloExtensionHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(8192L, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopEnterEffectApiImpl
 * JD-Core Version:    0.7.0.1
 */