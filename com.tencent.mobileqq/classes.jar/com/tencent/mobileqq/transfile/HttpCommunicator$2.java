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
    paramString = this.this$0;
    HttpMsg localHttpMsg = this.val$msg;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqhost = ");
    localStringBuilder.append(this.val$reqHost);
    localStringBuilder.append(",address = ");
    localStringBuilder.append(paramSSLSession.getPeerHost());
    localStringBuilder.append("result:isverify = ");
    localStringBuilder.append(bool);
    paramString.logHttpCommunicator(localHttpMsg, "httpsSSLProcess,HostnameVerifier", localStringBuilder.toString());
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator.2
 * JD-Core Version:    0.7.0.1
 */