package com.tencent.qapmsdk.common.ssl;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/ssl/DefaultSslContextBuilder;", "Lcom/tencent/qapmsdk/common/ssl/ISslContextBuilder;", "()V", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "sslContext$delegate", "Lkotlin/Lazy;", "build", "initSslContext", "", "ssl", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DefaultSslContextBuilder
  implements ISslContextBuilder
{
  public static final DefaultSslContextBuilder.Companion Companion = new DefaultSslContextBuilder.Companion(null);
  @NotNull
  public static final String TAG = "QAPM_common_DefaultSslContextBuilder";
  @Nullable
  private final Lazy sslContext$delegate = LazyKt.lazy((Function0)new DefaultSslContextBuilder.sslContext.2(this));
  
  @Nullable
  public SSLContext build()
  {
    return getSslContext();
  }
  
  @Nullable
  public SSLContext getSslContext()
  {
    Lazy localLazy = this.sslContext$delegate;
    KProperty localKProperty = $$delegatedProperties[0];
    return (SSLContext)localLazy.getValue();
  }
  
  public void initSslContext(@NotNull SSLContext paramSSLContext)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLContext, "ssl");
    paramSSLContext.init(null, new TrustManager[] { (TrustManager)new DefaultSslContextBuilder.initSslContext.1() }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.DefaultSslContextBuilder
 * JD-Core Version:    0.7.0.1
 */