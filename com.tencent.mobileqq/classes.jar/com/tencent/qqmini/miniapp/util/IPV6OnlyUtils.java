package com.tencent.qqmini.miniapp.util;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.MalformedURLException;
import java.net.URL;

public class IPV6OnlyUtils
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String TAG = "IPV6OnlyUtils";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  
  private static boolean checkEnableIPV6Only()
  {
    return WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
  }
  
  public static String getDomain(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    String str1;
    if (paramString.startsWith("wss://"))
    {
      str1 = paramString;
      if (paramString.length() > 6) {
        str1 = "https://" + paramString.substring(6);
      }
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str1);
        String str2 = paramString.getHost();
        paramString.getPort();
        paramString = str2;
        if (TextUtils.isEmpty(str2)) {
          break;
        }
        paramString = str2;
        if (!str2.startsWith("www.")) {
          break;
        }
        return str2.substring(4);
      }
      catch (MalformedURLException paramString)
      {
        QMLog.e("IPV6OnlyUtils", "getDomainConfig url error" + str1, paramString);
      }
      str1 = paramString;
      if (!paramString.startsWith("https://")) {
        if (paramString.startsWith("http://")) {
          str1 = "https://" + paramString.substring("http://".length());
        } else {
          str1 = "https://" + paramString;
        }
      }
    }
    return null;
  }
  
  public static String getEncoding(String paramString)
  {
    QMLog.d("IPV6OnlyUtils", "getMiniType " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return "utf-8";
    }
    try
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.trim().toLowerCase().startsWith("charset"))
        {
          paramString = localObject.split("=")[1];
          return paramString;
        }
        i += 1;
      }
      return "utf-8";
    }
    catch (Exception paramString)
    {
      QMLog.e("IPV6OnlyUtils", "getEncoding failed, ", paramString);
    }
  }
  
  public static String getMimeType(String paramString)
  {
    QMLog.d("IPV6OnlyUtils", "getMiniType " + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "text/html";
      return paramString;
    }
    String[] arrayOfString = paramString.split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label84;
      }
      String str = arrayOfString[i];
      paramString = str;
      if (!str.trim().toLowerCase().startsWith("charset")) {
        break;
      }
      i += 1;
    }
    label84:
    return "text/html";
  }
  
  public static boolean isDomainMatchRfc2109(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    QMLog.d("IPV6OnlyUtils", "isDomainMatchRfc2109 candidateDomain=" + paramString1 + ", checkDomain=" + paramString2);
    paramString1 = paramString1.toLowerCase();
    paramString2 = paramString2.toLowerCase();
    if (paramString2.startsWith(".")) {
      return paramString1.endsWith(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean isIPV6Enable()
  {
    RequestStrategyProxy localRequestStrategyProxy = (RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class);
    if (localRequestStrategyProxy != null) {
      return (checkEnableIPV6Only()) && (localRequestStrategyProxy.isIPV6Only());
    }
    return false;
  }
  
  public static boolean isIPV6Enable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!isIPV6Enable()) || ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https:"))) || (!isUrlAllowedProxy(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean isUrlAllowedProxy(String paramString)
  {
    Object localObject1 = WnsConfig.getConfig("qqminiapp", "ipv6_domain_black_list", ".idqqimg.com,.qq.com");
    Object localObject2 = WnsConfig.getConfig("qqminiapp", "ipv6_domain_white_list", ".huanle.qq.com");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      return true;
      paramString = getDomain(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = ((String)localObject2).split(",");
        int j = localObject2.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label80;
          }
          if (isDomainMatchRfc2109(paramString, localObject2[i])) {
            break;
          }
          i += 1;
        }
        label80:
        localObject1 = ((String)localObject1).split(",");
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          if (isDomainMatchRfc2109(paramString, localObject1[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.IPV6OnlyUtils
 * JD-Core Version:    0.7.0.1
 */