package com.tencent.qapmsdk.impl.g;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.MalformedURLException;
import java.net.URL;

public class a
{
  private static String a = "QAPM_Impl_StringUtil";
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      paramString = paramString.split(";")[0];
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      URL localURL = new URL(paramString);
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(localURL.getProtocol());
      localStringBuffer.append("://");
      if (paramString.startsWith("file")) {
        localStringBuffer.append("localfile");
      }
      localStringBuffer.append(localURL.getHost());
      if (localURL.getPort() != -1)
      {
        localStringBuffer.append(":");
        localStringBuffer.append(localURL.getPort());
      }
      localStringBuffer.append(localURL.getPath());
      return localStringBuffer.toString();
    }
    catch (MalformedURLException localMalformedURLException) {}
    return paramString;
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      String str = new URL(paramString).getHost();
      return str;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { a, "getHostFromUrl is error:", localException.getMessage() + ", url:", paramString });
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.g.a
 * JD-Core Version:    0.7.0.1
 */