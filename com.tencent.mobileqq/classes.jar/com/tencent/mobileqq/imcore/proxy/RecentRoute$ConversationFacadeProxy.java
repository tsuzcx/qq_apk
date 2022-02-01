package com.tencent.mobileqq.imcore.proxy;

import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;

public class RecentRoute$ConversationFacadeProxy
{
  private static RecentRoute.ConversationFacadeProxy.Proxy proxy;
  
  public static int getUnreadCount(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (proxy != null) {
      return proxy.getUnreadCount(paramIMCoreMessageStub, paramInt, paramIMCoreAppRuntime);
    }
    return 0;
  }
  
  public static int getUnreadCount(IMCoreMessageStub paramIMCoreMessageStub, IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    if (proxy != null) {
      return proxy.getUnreadCount(paramIMCoreMessageStub, paramIMCoreAppRuntime);
    }
    return 0;
  }
  
  public static void registerProxy(RecentRoute.ConversationFacadeProxy.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.ConversationFacadeProxy
 * JD-Core Version:    0.7.0.1
 */