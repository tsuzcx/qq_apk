package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.data.TroopAssistantDataStub;

public class RecentRoute$TroopAssistantManagerProxy
{
  private static RecentRoute.TroopAssistantManagerProxy.Proxy proxy;
  
  public static TroopAssistantDataStub getFirstData(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (proxy != null) {
      return proxy.getFirstData(paramIMCoreAppRuntime);
    }
    return null;
  }
  
  public static int getTroopAssistantUnreadNum(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (proxy != null) {
      return proxy.getTroopAssistantUnreadNum(paramIMCoreAppRuntime);
    }
    return 0;
  }
  
  public static void registerProxy(RecentRoute.TroopAssistantManagerProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopAssistantManagerProxy
 * JD-Core Version:    0.7.0.1
 */