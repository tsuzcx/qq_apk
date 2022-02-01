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
    boolean bool = false;
    if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String getDomain(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (paramString.startsWith("wss://"))
    {
      localObject1 = paramString;
      if (paramString.length() > 6)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("https://");
        ((StringBuilder)localObject1).append(paramString.substring(6));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = paramString;
      if (!paramString.startsWith("https://")) {
        if (paramString.startsWith("http://"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append(paramString.substring(7));
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    try
    {
      paramString = new URL((String)localObject1);
      localObject2 = paramString.getHost();
      paramString.getPort();
      paramString = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramString = (String)localObject2;
        if (((String)localObject2).startsWith("www.")) {
          paramString = ((String)localObject2).substring(4);
        }
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDomainConfig url error");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.e("IPV6OnlyUtils", ((StringBuilder)localObject2).toString(), paramString);
    }
    return null;
  }
  
  public static String getEncoding(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMiniType ");
    localStringBuilder.append(paramString);
    QMLog.d("IPV6OnlyUtils", localStringBuilder.toString());
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
        localStringBuilder = paramString[i];
        if (localStringBuilder.trim().toLowerCase().startsWith("charset"))
        {
          paramString = localStringBuilder.split("=")[1];
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMiniType ");
    localStringBuilder.append(paramString);
    QMLog.d("IPV6OnlyUtils", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      return "text/html";
    }
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder = paramString[i];
      if (!localStringBuilder.trim().toLowerCase().startsWith("charset")) {
        return localStringBuilder;
      }
      i += 1;
    }
    return "text/html";
  }
  
  public static boolean isDomainMatchRfc2109(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDomainMatchRfc2109 candidateDomain=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", checkDomain=");
      localStringBuilder.append(paramString2);
      QMLog.d("IPV6OnlyUtils", localStringBuilder.toString());
      paramString1 = paramString1.toLowerCase();
      paramString2 = paramString2.toLowerCase();
      if (paramString2.startsWith(".")) {
        return paramString1.endsWith(paramString2);
      }
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static boolean isIPV6Enable()
  {
    RequestStrategyProxy localRequestStrategyProxy = (RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localRequestStrategyProxy != null)
    {
      bool1 = bool2;
      if (checkEnableIPV6Only())
      {
        bool1 = bool2;
        if (localRequestStrategyProxy.isIPV6Only()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isIPV6Enable(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (isIPV6Enable()) {
      if (!paramString.toLowerCase().startsWith("http://"))
      {
        bool1 = bool2;
        if (!paramString.toLowerCase().startsWith("https:")) {}
      }
      else
      {
        bool1 = bool2;
        if (isUrlAllowedProxy(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isUrlAllowedProxy(String paramString)
  {
    Object localObject1 = WnsConfig.getConfig("qqminiapp", "ipv6_domain_black_list", ".idqqimg.com,.qq.com");
    Object localObject2 = WnsConfig.getConfig("qqminiapp", "ipv6_domain_white_list", ".huanle.qq.com");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    paramString = getDomain(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    localObject2 = ((String)localObject2).split(",");
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      if (isDomainMatchRfc2109(paramString, localObject2[i])) {
        return true;
      }
      i += 1;
    }
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
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.IPV6OnlyUtils
 * JD-Core Version:    0.7.0.1
 */