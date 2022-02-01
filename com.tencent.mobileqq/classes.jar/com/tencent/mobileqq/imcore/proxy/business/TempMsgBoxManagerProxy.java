package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;

public class TempMsgBoxManagerProxy
{
  private static TempMsgBoxManagerProxy.Proxy a;
  
  public static void a(TempMsgBoxManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a == null) {
      return false;
    }
    return a.a(paramBaseQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy
 * JD-Core Version:    0.7.0.1
 */