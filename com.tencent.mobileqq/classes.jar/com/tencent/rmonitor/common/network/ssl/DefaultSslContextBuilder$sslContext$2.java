package com.tencent.rmonitor.common.network.ssl;

import com.tencent.rmonitor.common.logger.Logger;
import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljavax/net/ssl/SSLContext;", "invoke"}, k=3, mv={1, 1, 15})
final class DefaultSslContextBuilder$sslContext$2
  extends Lambda
  implements Function0<SSLContext>
{
  DefaultSslContextBuilder$sslContext$2(DefaultSslContextBuilder paramDefaultSslContextBuilder)
  {
    super(0);
  }
  
  @Nullable
  public final SSLContext invoke()
  {
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      Intrinsics.checkExpressionValueIsNotNull(localSSLContext, "SSLContext.getInstance(\"TLS\")");
      this.this$0.a(localSSLContext);
      return localSSLContext;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_common_DefaultSslContextBuilder", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.DefaultSslContextBuilder.sslContext.2
 * JD-Core Version:    0.7.0.1
 */