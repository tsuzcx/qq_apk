package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.HotChatInfoStub;

public class HotChatManagerProxy
{
  private static HotChatManagerProxy.Proxy a;
  
  public static HotChatInfoStub a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    HotChatManagerProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramBaseQQAppInterface, paramString);
    }
    return null;
  }
  
  public static void a(HotChatManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.HotChatManagerProxy
 * JD-Core Version:    0.7.0.1
 */