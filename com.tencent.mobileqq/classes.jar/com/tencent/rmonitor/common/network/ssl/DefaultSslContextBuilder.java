package com.tencent.rmonitor.common.network.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/ssl/DefaultSslContextBuilder;", "Lcom/tencent/rmonitor/common/network/ssl/ISslContextBuilder;", "()V", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "sslContext$delegate", "Lkotlin/Lazy;", "build", "initSslContext", "", "ssl", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DefaultSslContextBuilder
  implements ISslContextBuilder
{
  public static final DefaultSslContextBuilder.Companion b = new DefaultSslContextBuilder.Companion(null);
  @Nullable
  private final Lazy c = LazyKt.lazy((Function0)new DefaultSslContextBuilder.sslContext.2(this));
  
  @Nullable
  public SSLContext a()
  {
    Lazy localLazy = this.c;
    KProperty localKProperty = a[0];
    return (SSLContext)localLazy.getValue();
  }
  
  public void a(@NotNull SSLContext paramSSLContext)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLContext, "ssl");
    paramSSLContext.init(null, new TrustManager[] { (TrustManager)new DefaultSslContextBuilder.initSslContext.1() }, null);
  }
  
  @Nullable
  public SSLContext b()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.DefaultSslContextBuilder
 * JD-Core Version:    0.7.0.1
 */