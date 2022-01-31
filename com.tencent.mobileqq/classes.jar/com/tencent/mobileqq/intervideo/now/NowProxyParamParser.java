package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;

public class NowProxyParamParser
{
  public static long a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return 0L;
      paramBundle = paramBundle.getString("roomid", "");
    } while (TextUtils.isEmpty(paramBundle));
    return Long.parseLong(paramBundle);
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("roomtype", "");
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("&");
    int i = 0;
    if (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {}
      while (!"vid".equals(arrayOfString[0]))
      {
        i += 1;
        break;
      }
      return arrayOfString[1];
    }
    return "";
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return true;
    }
    return paramBundle.getString("enter_record_if_finish", "1").equals("1");
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("is_record", "");
  }
  
  public static String c(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("startsrc", "");
  }
  
  public static String d(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("fromid", "");
  }
  
  public static String e(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64Util.decode(paramBundle.getString("nowapp_ext", ""), 0));
  }
  
  public static String f(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64Util.decode(paramBundle.getString("nowplugin_ext", ""), 0));
  }
  
  public static String g(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return new String(Base64Util.decode(paramBundle.getString("h5_ext", ""), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowProxyParamParser
 * JD-Core Version:    0.7.0.1
 */