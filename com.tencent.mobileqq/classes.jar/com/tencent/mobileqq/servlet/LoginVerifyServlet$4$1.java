package com.tencent.mobileqq.servlet;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class LoginVerifyServlet$4$1
  implements HostnameVerifier
{
  LoginVerifyServlet$4$1(LoginVerifyServlet.4 param4, URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a.getHost(), paramSSLSession);
    if (!bool) {
      QLog.d("LoginVerifyServlet", 1, new Object[] { "OpenVirtual.HostnameVerifier.host:", this.a.getHost(), ",address:", paramSSLSession.getPeerHost(), ",isverify:", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.LoginVerifyServlet.4.1
 * JD-Core Version:    0.7.0.1
 */