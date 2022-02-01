package com.tencent.qapmsdk.base.reporter.uploaddata.verifier;

import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UrlMeta;
import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/verifier/QAPMNameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "verify", "", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class QAPMNameVerifier
  implements HostnameVerifier
{
  public boolean verify(@NotNull String paramString, @NotNull SSLSession paramSSLSession)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramSSLSession, "session");
    try
    {
      paramSSLSession = new URL(BaseInfo.urlMeta.qapmDomain);
      URL localURL = new URL(BaseInfo.urlMeta.athenaDomain);
      if (!Intrinsics.areEqual(paramString, paramSSLSession.getHost()))
      {
        boolean bool = Intrinsics.areEqual(paramString, localURL.getHost());
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    catch (MalformedURLException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.verifier.QAPMNameVerifier
 * JD-Core Version:    0.7.0.1
 */