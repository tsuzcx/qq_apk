package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;

public class ConversationFacadeProxy
{
  private static ConversationFacadeProxy.Proxy a;
  
  public static int a(IMCoreMessageStub paramIMCoreMessageStub, int paramInt, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a != null) {
      return a.a(paramIMCoreMessageStub, paramInt, paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static int a(IMCoreMessageStub paramIMCoreMessageStub, BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a != null) {
      return a.a(paramIMCoreMessageStub, paramBaseQQAppInterface);
    }
    return 0;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (a != null) {
      a.a(paramBaseQQAppInterface, paramString, paramInt1, paramInt2);
    }
  }
  
  public static void a(ConversationFacadeProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.ConversationFacadeProxy
 * JD-Core Version:    0.7.0.1
 */