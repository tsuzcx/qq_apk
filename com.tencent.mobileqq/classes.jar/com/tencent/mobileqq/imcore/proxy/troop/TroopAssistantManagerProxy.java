package com.tencent.mobileqq.imcore.proxy.troop;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.TroopAssistantDataStub;

public class TroopAssistantManagerProxy
{
  private static TroopAssistantManagerProxy.Proxy a;
  
  public static int a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    TroopAssistantManagerProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static void a(TroopAssistantManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static TroopAssistantDataStub b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    TroopAssistantManagerProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.c(paramBaseQQAppInterface);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.troop.TroopAssistantManagerProxy
 * JD-Core Version:    0.7.0.1
 */