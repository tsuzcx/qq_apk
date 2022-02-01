package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;

public class ConversationFacadeProxy
{
  private static ConversationFacadeProxy.Proxy a;
  
  public static int a(Message paramMessage, int paramInt, BaseQQAppInterface paramBaseQQAppInterface)
  {
    ConversationFacadeProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramMessage, paramInt, paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static int a(Message paramMessage, BaseQQAppInterface paramBaseQQAppInterface)
  {
    ConversationFacadeProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramMessage, paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    ConversationFacadeProxy.Proxy localProxy = a;
    if (localProxy != null) {
      localProxy.a(paramBaseQQAppInterface, paramString, paramInt1, paramInt2);
    }
  }
  
  public static void a(ConversationFacadeProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy
 * JD-Core Version:    0.7.0.1
 */