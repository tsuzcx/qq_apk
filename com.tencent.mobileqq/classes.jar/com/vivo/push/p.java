package com.vivo.push;

import android.net.Uri;

public final class p
{
  public static final Uri a = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
  public static final Uri b = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
  public static final Uri c = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
  public static final Uri d = Uri.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2008: 
      return "method_stop";
    case 2007: 
      return "method_sdk_unbind";
    case 2006: 
      return "method_sdk_bind";
    case 2005: 
      return "method_tag_unbind";
    case 2004: 
      return "method_tag_bind";
    case 2003: 
      return "method_alias_unbind";
    }
    return "method_alias_bind";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.p
 * JD-Core Version:    0.7.0.1
 */