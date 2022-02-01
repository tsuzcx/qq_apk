package com.tencent.qapmsdk.common.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/ssl/DefaultNameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "()V", "verify", "", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "common_release"}, k=1, mv={1, 1, 15})
public final class DefaultNameVerifier
  implements HostnameVerifier
{
  public boolean verify(@NotNull String paramString, @NotNull SSLSession paramSSLSession)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    Intrinsics.checkParameterIsNotNull(paramSSLSession, "session");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.DefaultNameVerifier
 * JD-Core Version:    0.7.0.1
 */