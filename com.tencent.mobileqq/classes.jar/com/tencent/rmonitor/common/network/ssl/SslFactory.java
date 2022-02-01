package com.tencent.rmonitor.common.network.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/ssl/SslFactory;", "", "()V", "DEFAULT_SSL_CONTEXT", "Lcom/tencent/rmonitor/common/network/ssl/ISslContextBuilder;", "value", "sslBuilder", "getSslBuilder", "()Lcom/tencent/rmonitor/common/network/ssl/ISslContextBuilder;", "setSslBuilder", "(Lcom/tencent/rmonitor/common/network/ssl/ISslContextBuilder;)V", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SslFactory
{
  @JvmField
  @NotNull
  public static final ISslContextBuilder a = (ISslContextBuilder)new DefaultSslContextBuilder();
  public static final SslFactory b = new SslFactory();
  private static ISslContextBuilder c = a;
  @Nullable
  private static final SSLSocketFactory d;
  
  private final ISslContextBuilder b()
  {
    ISslContextBuilder localISslContextBuilder = c;
    if (localISslContextBuilder != null) {
      return localISslContextBuilder;
    }
    return a;
  }
  
  @Nullable
  public final SSLSocketFactory a()
  {
    Object localObject = d;
    if (localObject != null) {
      return localObject;
    }
    localObject = b();
    if (localObject != null)
    {
      localObject = ((ISslContextBuilder)localObject).b();
      if (localObject != null) {
        return ((SSLContext)localObject).getSocketFactory();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.SslFactory
 * JD-Core Version:    0.7.0.1
 */