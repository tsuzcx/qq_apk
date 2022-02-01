package com.tencent.mobileqq.imcore.proxy.troop;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopManagerProxy
{
  private static TroopManagerProxy.Proxy a;
  
  public static TroopInfo a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    TroopManagerProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramBaseQQAppInterface, paramString);
    }
    return null;
  }
  
  public static void a(TroopManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.troop.TroopManagerProxy
 * JD-Core Version:    0.7.0.1
 */