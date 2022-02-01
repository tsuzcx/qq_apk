package com.tencent.mobileqq.troop.homework.utils;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class HomeworkURLUtil$1
  implements HostnameVerifier
{
  HomeworkURLUtil$1(URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a.getHost(), paramSSLSession);
    if (bool) {
      QLog.d("URLUtil", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.a.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.utils.HomeworkURLUtil.1
 * JD-Core Version:    0.7.0.1
 */