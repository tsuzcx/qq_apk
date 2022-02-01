package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator.2
 * JD-Core Version:    0.7.0.1
 */