package com.tencent.proxyinner.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public class NetworkUtil
{
  public static int getNetworkSubType(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return 30;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (paramContext == null);
    if (!paramContext.isAvailable()) {
      return 31;
    }
    return paramContext.getSubtype();
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return 30;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    } while (paramContext == null);
    if (!paramContext.isAvailable()) {
      return 31;
    }
    return paramContext.getType();
  }
  
  public static boolean hasProxy()
  {
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
  }
  
  public static String replaceDomainWithIp(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          str = replaceIp(paramString1, "http://" + paramString2 + "/");
        }
      }
      return str;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String replaceIp(String paramString1, String paramString2)
  {
    String str1 = paramString1;
    String str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (paramString2 != null)
      {
        str2 = str1;
        if (paramString2.length() > 0) {
          str2 = paramString1.replaceFirst("http://[^/\\s]*/", paramString2);
        }
      }
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */