package com.tencent.oskplayer.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class SSLUtil$2
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    paramSSLSession = new StringBuilder();
    paramSSLSession.append("verifying ");
    paramSSLSession.append(paramString);
    PlayerUtils.log(3, "SSLUtil", paramSSLSession.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.util.SSLUtil.2
 * JD-Core Version:    0.7.0.1
 */