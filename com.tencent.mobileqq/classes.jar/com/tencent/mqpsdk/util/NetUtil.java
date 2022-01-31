package com.tencent.mqpsdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class NetUtil
{
  public static String a = "ctnet";
  public static String b = "ctwap";
  public static String c = "cmnet";
  public static String d = "cmwap";
  public static String e = "uninet";
  public static String f = "uniwap";
  public static String g = "3gnet";
  public static String h = "3gwap";
  
  public static int a(Context paramContext)
  {
    switch ()
    {
    default: 
      return 0;
    case 0: 
      switch (AppNetConnInfo.getMobileInfo())
      {
      default: 
        return 0;
      case 1: 
        return 2;
      case 2: 
        return 3;
      }
      return 4;
    }
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    String str1 = "nomatch";
    String str2 = AppNetConnInfo.getCurrentAPN();
    paramContext = str1;
    if (!TextUtils.isEmpty(str2))
    {
      if (!str2.startsWith(a)) {
        break label32;
      }
      paramContext = a;
    }
    label32:
    do
    {
      return paramContext;
      if (str2.startsWith(b)) {
        return b;
      }
      if (str2.startsWith(c)) {
        return c;
      }
      if (str2.startsWith(d)) {
        return d;
      }
      if (str2.startsWith(e)) {
        return e;
      }
      if (str2.startsWith(f)) {
        return f;
      }
      if (str2.startsWith(g)) {
        return g;
      }
      paramContext = str1;
    } while (!str2.startsWith(h));
    return h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.mqpsdk.util.NetUtil
 * JD-Core Version:    0.7.0.1
 */