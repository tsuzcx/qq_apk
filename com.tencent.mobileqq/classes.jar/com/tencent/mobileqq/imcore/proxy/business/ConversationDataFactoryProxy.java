package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;

public class ConversationDataFactoryProxy
{
  private static ConversationDataFactoryProxy.Proxy a;
  
  public static int a(BaseQQAppInterface paramBaseQQAppInterface, int paramInt)
  {
    if (a == null) {
      return paramInt;
    }
    return a.a(paramBaseQQAppInterface, paramInt);
  }
  
  public static void a(ConversationDataFactoryProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.ConversationDataFactoryProxy
 * JD-Core Version:    0.7.0.1
 */