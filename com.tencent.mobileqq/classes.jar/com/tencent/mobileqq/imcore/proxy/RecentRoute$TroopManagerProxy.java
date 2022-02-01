package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.data.TroopInfoStub;

public class RecentRoute$TroopManagerProxy
{
  private static RecentRoute.TroopManagerProxy.Proxy proxy;
  
  public static TroopInfoStub getTroopInfo(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString)
  {
    if (proxy != null) {
      return proxy.getTroopInfo(paramIMCoreAppRuntime, paramString);
    }
    return null;
  }
  
  public static void registerProxy(RecentRoute.TroopManagerProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.TroopManagerProxy
 * JD-Core Version:    0.7.0.1
 */