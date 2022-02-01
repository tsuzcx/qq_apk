package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.data.HotChatInfoStub;

public class RecentRoute$HotChatManagerProxy
{
  private static RecentRoute.HotChatManagerProxy.Proxy proxy;
  
  public static HotChatInfoStub getHotCatInfo(IMCoreAppRuntime paramIMCoreAppRuntime, String paramString)
  {
    if (proxy != null) {
      return proxy.getHotCatInfo(paramIMCoreAppRuntime, paramString);
    }
    return null;
  }
  
  public static void registerProxy(RecentRoute.HotChatManagerProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.HotChatManagerProxy
 * JD-Core Version:    0.7.0.1
 */