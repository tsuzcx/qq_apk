package com.tencent.mobileqq.imcore.proxy.troop;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.TroopAssistantDataStub;

public class TroopAssistantManagerProxy
{
  private static TroopAssistantManagerProxy.Proxy a;
  
  public static int a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a != null) {
      return a.a(paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static TroopAssistantDataStub a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a != null) {
      return a.a(paramBaseQQAppInterface);
    }
    return null;
  }
  
  public static void a(TroopAssistantManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.troop.TroopAssistantManagerProxy
 * JD-Core Version:    0.7.0.1
 */