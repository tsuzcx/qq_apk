package com.tencent.mobileqq.intervideo.now;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;

public class NowProxyParamParser
{
  public static long a(Bundle paramBundle)
  {
    long l = 0L;
    if (paramBundle == null) {
      return 0L;
    }
    paramBundle = paramBundle.getString("roomid", "");
    if (!TextUtils.isEmpty(paramBundle)) {
      l = Long.parseLong(paramBundle);
    }
    return l;
  }
  
  public static String a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    String str = paramBundle.getString("roomtype");
    paramBundle = str;
    if (TextUtils.isEmpty(str)) {
      paramBundle = "0";
    }
    return paramBundle;
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
    return paramBundle.getString("shakespearetime", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.NowProxyParamParser
 * JD-Core Version:    0.7.0.1
 */