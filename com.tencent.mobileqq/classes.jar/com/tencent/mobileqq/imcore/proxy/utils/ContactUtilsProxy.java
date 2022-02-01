package com.tencent.mobileqq.imcore.proxy.utils;

import com.tencent.common.app.business.BaseQQAppInterface;

public class ContactUtilsProxy
{
  private static ContactUtilsProxy.Proxy a;
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    ContactUtilsProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramBaseQQAppInterface, paramString, paramBoolean);
    }
    return paramString;
  }
  
  public static void a(ContactUtilsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static String b(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    ContactUtilsProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.b(paramBaseQQAppInterface, paramString, paramBoolean);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy
 * JD-Core Version:    0.7.0.1
 */