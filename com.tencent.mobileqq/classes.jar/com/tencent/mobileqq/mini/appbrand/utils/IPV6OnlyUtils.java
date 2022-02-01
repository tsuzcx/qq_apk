package com.tencent.mobileqq.mini.appbrand.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
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
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static String getDomain(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject;
    if (paramString.startsWith("wss://"))
    {
      localObject = paramString;
      if (paramString.length() > 6)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString.substring(6));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    else
    {
      localObject = paramString;
      if (!paramString.startsWith("https://")) {
        if (paramString.startsWith("http://"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://");
          ((StringBuilder)localObject).append(paramString.substring(7));
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    try
    {
      URL localURL1 = new URL((String)localObject);
      paramString = localURL1.getHost();
      localURL1.getPort();
    }
    catch (MalformedURLException localMalformedURLException) {}
    try
    {
      paramString = new StringBuilder();
      paramString.append("https://");
      paramString.append((String)localObject);
      URL localURL2 = new URL(paramString.toString());
      paramString = localURL2.getHost();
      localURL2.getPort();
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (paramString.startsWith("www.")) {
          localObject = paramString.substring(4);
        }
      }
      return localObject;
    }
    catch (MalformedURLException paramString)
    {
      label237:
      break label237;
    }
    paramString = new StringBuilder();
    paramString.append("getDomainConfig url error");
    paramString.append((String)localObject);
    QLog.e("IPV6OnlyUtils", 1, paramString.toString(), localMalformedURLException);
    return null;
  }
  
  public static String getEncoding(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMiniType ");
    localStringBuilder.append(paramString);
    QLog.d("IPV6OnlyUtils", 2, localStringBuilder.toString());
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
      QLog.e("IPV6OnlyUtils", 1, "getEncoding failed, ", paramString);
    }
  }
  
  public static String getMimeType(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMiniType ");
    localStringBuilder.append(paramString);
    QLog.d("IPV6OnlyUtils", 2, localStringBuilder.toString());
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
      QLog.e("IPV6OnlyUtils", 1, localStringBuilder.toString());
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
    return (checkEnableIPV6Only()) && (RequestStrategy.g.isIPv6Only());
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
    Object localObject1 = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_domain_black_list", ".idqqimg.com,.qq.com");
    Object localObject2 = QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_domain_white_list", ".huanle.qq.com");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.IPV6OnlyUtils
 * JD-Core Version:    0.7.0.1
 */