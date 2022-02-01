package com.tencent.oskplayer.util;

import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class SSLUtil
{
  static final String TAG = "SSLUtil";
  
  @Deprecated
  public static boolean disableSSLCertVerify(HttpsURLConnection paramHttpsURLConnection)
  {
    Object localObject = new SSLUtil.1();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("SSL");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localObject }, localSecureRandom);
      paramHttpsURLConnection.setSSLSocketFactory(localSSLContext.getSocketFactory());
      paramHttpsURLConnection.setHostnameVerifier(new SSLUtil.2());
      return true;
    }
    catch (Exception paramHttpsURLConnection)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("disableSSLCertVerify failed ");
      ((StringBuilder)localObject).append(paramHttpsURLConnection);
      PlayerUtils.log(6, "SSLUtil", ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.SSLUtil
 * JD-Core Version:    0.7.0.1
 */