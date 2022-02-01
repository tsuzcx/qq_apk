package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.MalformedURLException;
import java.net.URL;

public class DomainConfig
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  private static final int needCheckPort = 0;
  public String host;
  public int port;
  
  public DomainConfig(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public static DomainConfig getDomainConfig(String paramString)
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
    int i;
    try
    {
      URL localURL1 = new URL((String)localObject);
      paramString = localURL1.getHost();
      i = localURL1.getPort();
    }
    catch (MalformedURLException localMalformedURLException) {}
    try
    {
      paramString = new StringBuilder();
      paramString.append("https://");
      paramString.append((String)localObject);
      URL localURL2 = new URL(paramString.toString());
      paramString = localURL2.getHost();
      i = localURL2.getPort();
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = paramString;
        if (paramString.startsWith("www.")) {
          localObject = paramString.substring(4);
        }
      }
      return new DomainConfig((String)localObject, i);
    }
    catch (MalformedURLException paramString)
    {
      label248:
      break label248;
    }
    paramString = new StringBuilder();
    paramString.append("getDomainConfig url error");
    paramString.append((String)localObject);
    QMLog.e("[mini] http.", paramString.toString(), localMalformedURLException);
    return null;
  }
  
  public static boolean isDomainConfigMatch(DomainConfig paramDomainConfig1, DomainConfig paramDomainConfig2)
  {
    if (paramDomainConfig1 != null)
    {
      if (paramDomainConfig2 == null) {
        return false;
      }
      boolean bool = isDomainMatchRfc2019(paramDomainConfig1.host, paramDomainConfig2);
      int i;
      if (paramDomainConfig1.port == paramDomainConfig2.port) {
        i = 1;
      } else {
        i = 0;
      }
      int j = i;
      if (i == 0)
      {
        j = i;
        if (paramDomainConfig1.port <= 0)
        {
          i = paramDomainConfig2.port;
          if ((i != 80) && (i != 8080) && (i > 0)) {
            j = 0;
          } else {
            j = 1;
          }
        }
      }
      if ((j == 0) && (paramDomainConfig2.port <= 0)) {
        i = paramDomainConfig1.port;
      }
      return bool;
    }
    return false;
  }
  
  public static boolean isDomainMatchRfc2019(String paramString, DomainConfig paramDomainConfig)
  {
    if (paramDomainConfig == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isDomainMatchRfc2019 allowedDomainHost=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", requestDomain=");
    localStringBuilder.append(paramDomainConfig);
    QMLog.d("domainValid", localStringBuilder.toString());
    return ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramDomainConfig.host)) && (paramString.startsWith(".")) && (paramString.split("\\.").length >= 1) && (paramDomainConfig.host.endsWith(paramString))) || (paramString.equals(paramDomainConfig.host));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DomainConfig)paramObject;
      if (this.port != paramObject.port) {
        return false;
      }
      return this.host.equals(paramObject.host);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.host.hashCode() * 31 + this.port;
  }
  
  public String toString()
  {
    Object localObject;
    if (this.port > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", port=");
      ((StringBuilder)localObject).append(this.port);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DomainConfig{host='");
    localStringBuilder.append(this.host);
    localStringBuilder.append('\'');
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.DomainConfig
 * JD-Core Version:    0.7.0.1
 */