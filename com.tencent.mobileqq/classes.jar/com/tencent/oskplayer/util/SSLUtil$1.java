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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" Server certificate ");
        i += 1;
        localStringBuilder.append(i);
        localStringBuilder.append(":");
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Subject DN: ");
        localStringBuilder.append(paramString.getSubjectX500Principal());
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Issuer DN: ");
        localStringBuilder.append(paramString.getIssuerX500Principal());
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Signature Algorithm: ");
        localStringBuilder.append(paramString.getSigAlgName());
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Valid from: ");
        localStringBuilder.append(paramString.getNotBefore());
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Valid until: ");
        localStringBuilder.append(paramString.getNotAfter());
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("  Serial #: ");
        localStringBuilder.append(paramString.getSerialNumber().toString(16));
        PlayerUtils.log(3, "SSLUtil", localStringBuilder.toString());
      }
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.util.SSLUtil.1
 * JD-Core Version:    0.7.0.1
 */