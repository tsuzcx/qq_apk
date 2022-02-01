package com.tencent.rmonitor.common.network.ssl;

import javax.net.ssl.SSLContext;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/ssl/ISslContextBuilder;", "", "sslContext", "Ljavax/net/ssl/SSLContext;", "getSslContext", "()Ljavax/net/ssl/SSLContext;", "build", "initSslContext", "", "ssl", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract interface ISslContextBuilder
{
  @Nullable
  public abstract SSLContext b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.ISslContextBuilder
 * JD-Core Version:    0.7.0.1
 */