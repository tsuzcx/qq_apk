package com.tencent.mobileqq.msf.core.net.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class b
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.b
 * JD-Core Version:    0.7.0.1
 */