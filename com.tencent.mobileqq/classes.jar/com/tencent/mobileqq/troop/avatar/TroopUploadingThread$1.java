package com.tencent.mobileqq.troop.avatar;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

class TroopUploadingThread$1
  implements HostnameVerifier
{
  TroopUploadingThread$1(TroopUploadingThread paramTroopUploadingThread, HttpsURLConnection paramHttpsURLConnection) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    String str = this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getRequestProperty("Host");
    paramString = str;
    if (str == null) {
      paramString = this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.getURL().getHost();
    }
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.TroopUploadingThread.1
 * JD-Core Version:    0.7.0.1
 */