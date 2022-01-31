package com.tencent.qapmsdk.common.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qapmsdk/common/ssl/DefaultSslContextBuilder$initSslContext$1", "Ljavax/net/ssl/X509TrustManager;", "checkClientTrusted", "", "x509Certificates", "", "Ljava/security/cert/X509Certificate;", "s", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "common_release"}, k=1, mv={1, 1, 15})
public final class DefaultSslContextBuilder$initSslContext$1
  implements X509TrustManager
{
  public void checkClientTrusted(@NotNull X509Certificate[] paramArrayOfX509Certificate, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfX509Certificate, "x509Certificates");
    Intrinsics.checkParameterIsNotNull(paramString, "s");
  }
  
  public void checkServerTrusted(@Nullable X509Certificate[] paramArrayOfX509Certificate, @Nullable String paramString)
  {
    int j = 1;
    if (paramArrayOfX509Certificate != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfX509Certificate.length == 0)
        {
          i = 1;
          if ((i == 0) && (paramString != null))
          {
            if (((CharSequence)paramString).length() != 0) {
              break label76;
            }
            i = j;
            break label82;
          }
          throw ((Throwable)new IllegalArgumentException("null or zero-length parameter"));
        }
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        throw ((Throwable)new CertificateException("error in validating certificate", (Throwable)paramArrayOfX509Certificate));
      }
      int i = 0;
      continue;
      label76:
      i = 0;
      label82:
      while (i == 0) {
        return;
      }
    }
  }
  
  @NotNull
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.DefaultSslContextBuilder.initSslContext.1
 * JD-Core Version:    0.7.0.1
 */