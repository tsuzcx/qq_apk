package com.tencent.open.virtual;

import com.tencent.open.agent.util.SSOLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class OpenSdkVirtualUtil$1
  implements HostnameVerifier
{
  OpenSdkVirtualUtil$1(URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a.getHost(), paramSSLSession);
    if (!bool) {
      SSOLog.a("BaseOpenSdkVirtualUtil", new Object[] { "OpenVirtual.HostnameVerifier.host:", this.a.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualUtil.1
 * JD-Core Version:    0.7.0.1
 */