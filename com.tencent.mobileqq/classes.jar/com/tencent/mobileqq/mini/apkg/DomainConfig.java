package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class DomainConfig
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  private static ConcurrentHashMap<String, DomainConfig> domainConfigMap = new ConcurrentHashMap();
  private static final int needCheckPost = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDomainNeedCheckPort", 0);
  public String host;
  public int port;
  
  public DomainConfig(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public static DomainConfig getDomainConfig(String paramString)
  {
    return getDomainConfig(paramString, false);
  }
  
  public static DomainConfig getDomainConfig(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (domainConfigMap.contains(paramString)) {
      return (DomainConfig)domainConfigMap.get(paramString);
    }
    long l = System.currentTimeMillis();
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
    int i;
    try
    {
      URL localURL1 = new URL((String)localObject1);
      paramString = localURL1.getHost();
      i = localURL1.getPort();
    }
    catch (MalformedURLException localMalformedURLException) {}
    try
    {
      paramString = new StringBuilder();
      paramString.append("https://");
      paramString.append((String)localObject1);
      URL localURL2 = new URL(paramString.toString());
      paramString = localURL2.getHost();
      i = localURL2.getPort();
      localObject2 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = paramString;
        if (paramString.startsWith("www.")) {
          localObject2 = paramString.substring(4);
        }
      }
      paramString = new DomainConfig((String)localObject2, i);
      if (paramBoolean) {
        domainConfigMap.put(localObject1, paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDomainConfig url for ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" costTime:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.i("[mini] http.", 2, ((StringBuilder)localObject2).toString());
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      Object localObject2;
      label377:
      break label377;
    }
    paramString = new StringBuilder();
    paramString.append("getDomainConfig url error");
    paramString.append((String)localObject1);
    QLog.e("[mini] http.", 1, paramString.toString(), (Throwable)localObject2);
    return null;
  }
  
  public static boolean isDomainConfigMatch(DomainConfig paramDomainConfig1, DomainConfig paramDomainConfig2)
  {
    boolean bool2 = false;
    if (paramDomainConfig1 != null)
    {
      if (paramDomainConfig2 == null) {
        return false;
      }
      boolean bool3 = isDomainMatchRfc2019(paramDomainConfig1.host, paramDomainConfig2);
      if (paramDomainConfig1.port == paramDomainConfig2.port) {
        j = 1;
      } else {
        j = 0;
      }
      int i = j;
      if (j == 0)
      {
        i = j;
        if (paramDomainConfig1.port <= 0)
        {
          i = paramDomainConfig2.port;
          if ((i != 80) && (i != 8080) && (i > 0)) {
            i = 0;
          } else {
            i = 1;
          }
        }
      }
      int j = i;
      if (i == 0)
      {
        j = i;
        if (paramDomainConfig2.port <= 0)
        {
          i = paramDomainConfig1.port;
          if ((i != 80) && (i != 8080) && (i > 0)) {
            j = 0;
          } else {
            j = 1;
          }
        }
      }
      if (needCheckPost > 0)
      {
        paramDomainConfig1 = new StringBuilder();
        paramDomainConfig1.append("isDomainConfigMatch needCheckPost:");
        paramDomainConfig1.append(needCheckPost);
        QLog.i("[mini] http.", 1, paramDomainConfig1.toString());
        boolean bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (j != 0) {
            bool1 = true;
          }
        }
        return bool1;
      }
      return bool3;
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
    QLog.d("domainValid", 1, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.DomainConfig
 * JD-Core Version:    0.7.0.1
 */