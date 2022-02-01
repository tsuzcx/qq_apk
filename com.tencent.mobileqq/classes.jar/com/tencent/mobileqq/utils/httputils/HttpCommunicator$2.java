package com.tencent.mobileqq.utils.httputils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class HttpCommunicator$2
  implements HostnameVerifier
{
  HttpCommunicator$2(HttpCommunicator paramHttpCommunicator, String paramString, HttpMsg paramHttpMsg) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$reqHost, paramSSLSession);
    this.this$0.logHttpCommunicator(this.val$msg, "httpsSSLProcess,HostnameVerifier", "reqhost = " + this.val$reqHost + ",address = " + paramSSLSession.getPeerHost() + "result:isverify = " + bool);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.2
 * JD-Core Version:    0.7.0.1
 */