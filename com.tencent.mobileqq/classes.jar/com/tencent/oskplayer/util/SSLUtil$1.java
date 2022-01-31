package com.tencent.oskplayer.util;

import com.tencent.oskplayer.PlayerConfig;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class SSLUtil$1
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    PlayerUtils.log(3, "SSLUtil", "checkClientTrusted");
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (PlayerConfig.g().isDebugVersion())
    {
      int i = 0;
      while (i < paramArrayOfX509Certificate.length)
      {
        paramString = paramArrayOfX509Certificate[i];
        PlayerUtils.log(3, "SSLUtil", " Server certificate " + (i + 1) + ":");
        PlayerUtils.log(3, "SSLUtil", "  Subject DN: " + paramString.getSubjectX500Principal());
        PlayerUtils.log(3, "SSLUtil", "  Issuer DN: " + paramString.getIssuerX500Principal());
        PlayerUtils.log(3, "SSLUtil", "  Signature Algorithm: " + paramString.getSigAlgName());
        PlayerUtils.log(3, "SSLUtil", "  Valid from: " + paramString.getNotBefore());
        PlayerUtils.log(3, "SSLUtil", "  Valid until: " + paramString.getNotAfter());
        PlayerUtils.log(3, "SSLUtil", "  Serial #: " + paramString.getSerialNumber().toString(16));
        i += 1;
      }
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.util.SSLUtil.1
 * JD-Core Version:    0.7.0.1
 */