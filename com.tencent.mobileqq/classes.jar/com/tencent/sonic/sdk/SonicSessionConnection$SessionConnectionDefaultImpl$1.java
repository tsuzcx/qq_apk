package com.tencent.sonic.sdk;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class SonicSessionConnection$SessionConnectionDefaultImpl$1
  implements HostnameVerifier
{
  SonicSessionConnection$SessionConnectionDefaultImpl$1(SonicSessionConnection.SessionConnectionDefaultImpl paramSessionConnectionDefaultImpl, URL paramURL, String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    long l = System.currentTimeMillis();
    if (this.val$finalUrl.getHost().equals(paramString))
    {
      boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$finalOriginHost, paramSSLSession);
      paramString = new StringBuilder();
      paramString.append("verify hostname cost ");
      paramString.append(System.currentTimeMillis() - l);
      paramString.append(" ms.");
      SonicUtils.log("SonicSdk_SonicSessionConnection", 3, paramString.toString());
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.1
 * JD-Core Version:    0.7.0.1
 */