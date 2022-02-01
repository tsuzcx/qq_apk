package com.tencent.mobileqq.imcore.proxy.utils;

import com.tencent.common.app.business.BaseQQAppInterface;

public class ContactUtilsProxy
{
  private static ContactUtilsProxy.Proxy a;
  
  public static String a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (a != null) {
      str = a.a(paramBaseQQAppInterface, paramString, paramBoolean);
    }
    return str;
  }
  
  public static void a(ContactUtilsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
  
  public static String b(BaseQQAppInterface paramBaseQQAppInterface, String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (a != null) {
      str = a.b(paramBaseQQAppInterface, paramString, paramBoolean);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy
 * JD-Core Version:    0.7.0.1
 */