package com.tencent.rmonitor.common.network.ssl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/ssl/DefaultNameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "verify", "", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DefaultNameVerifier
  implements HostnameVerifier
{
  public boolean verify(@NotNull String paramString, @NotNull SSLSession paramSSLSession)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramSSLSession, "session");
    try
    {
      paramSSLSession = new URL("https://rmonitor.qq.com");
      URL localURL = new URL("https://h.trace.qq.com/kv");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.DefaultNameVerifier
 * JD-Core Version:    0.7.0.1
 */