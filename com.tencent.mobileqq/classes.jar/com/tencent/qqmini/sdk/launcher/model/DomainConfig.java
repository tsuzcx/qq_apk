package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.log.QMLog;
import java.net.MalformedURLException;
import java.net.URL;

public class DomainConfig
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  private static final int needCheckPost = 0;
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
    String str;
    if (paramString.startsWith("wss://"))
    {
      str = paramString;
      if (paramString.length() > 6) {
        str = "https://" + paramString.substring(6);
      }
    }
    try
    {
      for (;;)
      {
        URL localURL1 = new URL(str);
        paramString = localURL1.getHost();
        i = localURL1.getPort();
        str = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str = paramString;
          if (paramString.startsWith("www.")) {
            str = paramString.substring(4);
          }
        }
        return new DomainConfig(str, i);
        str = paramString;
        if (!paramString.startsWith("https://")) {
          str = "https://" + paramString;
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      try
      {
        URL localURL2 = new URL("https://" + str);
        paramString = localURL2.getHost();
        int i = localURL2.getPort();
      }
      catch (MalformedURLException paramString)
      {
        QMLog.e("[mini] http.", "getDomainConfig url error" + str, localMalformedURLException);
      }
    }
    return null;
  }
  
  public static boolean isDomainConfigMatch(DomainConfig paramDomainConfig1, DomainConfig paramDomainConfig2)
  {
    int j = 0;
    if ((paramDomainConfig1 == null) || (paramDomainConfig2 == null)) {
      return false;
    }
    boolean bool = TextUtils.equals(paramDomainConfig1.host, paramDomainConfig2.host);
    int i;
    if (paramDomainConfig1.port == paramDomainConfig2.port)
    {
      i = 1;
      if ((i != 0) || (paramDomainConfig1.port > 0)) {
        break label124;
      }
      if ((paramDomainConfig2.port != 80) && (paramDomainConfig2.port != 8080))
      {
        i = j;
        if (paramDomainConfig2.port > 0) {}
      }
      else
      {
        i = 1;
      }
    }
    label124:
    for (;;)
    {
      if ((i == 0) && (paramDomainConfig2.port <= 0) && (paramDomainConfig1.port != 80) && (paramDomainConfig1.port != 8080) && (paramDomainConfig1.port <= 0)) {}
      return bool;
      i = 0;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (DomainConfig)paramObject;
      bool1 = bool2;
    } while (this.port != paramObject.port);
    return this.host.equals(paramObject.host);
  }
  
  public int hashCode()
  {
    return this.host.hashCode() * 31 + this.port;
  }
  
  public String toString()
  {
    if (this.port > 0) {}
    for (String str = ", port=" + this.port;; str = "") {
      return "DomainConfig{host='" + this.host + '\'' + str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.DomainConfig
 * JD-Core Version:    0.7.0.1
 */