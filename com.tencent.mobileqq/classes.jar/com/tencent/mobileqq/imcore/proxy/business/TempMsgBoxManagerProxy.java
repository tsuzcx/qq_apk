package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;

public class TempMsgBoxManagerProxy
{
  private static TempMsgBoxManagerProxy.Proxy a;
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    TempMsgBoxManagerProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return;
    }
    localProxy.a(paramBaseQQAppInterface, paramBoolean);
  }
  
  public static void a(TempMsgBoxManagerProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    TempMsgBoxManagerProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return false;
    }
    return localProxy.a(paramBaseQQAppInterface);
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    TempMsgBoxManagerProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return false;
    }
    return localProxy.a(paramBaseQQAppInterface, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy
 * JD-Core Version:    0.7.0.1
 */