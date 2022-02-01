package com.tencent.rmonitor.common.network.ssl;

import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/network/ssl/NameVerifierFactory;", "", "()V", "DEFAULT_NAME_VERIFIER", "Ljavax/net/ssl/HostnameVerifier;", "value", "nameVerifier", "getNameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setNameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class NameVerifierFactory
{
  @JvmField
  @NotNull
  public static final HostnameVerifier a = (HostnameVerifier)new DefaultNameVerifier();
  public static final NameVerifierFactory b = new NameVerifierFactory();
  @Nullable
  private static HostnameVerifier c = a;
  
  @Nullable
  public final HostnameVerifier a()
  {
    HostnameVerifier localHostnameVerifier = c;
    if (localHostnameVerifier != null) {
      return localHostnameVerifier;
    }
    return a;
  }
  
  public final void a(@Nullable HostnameVerifier paramHostnameVerifier)
  {
    try
    {
      c = paramHostnameVerifier;
      paramHostnameVerifier = Unit.INSTANCE;
      return;
    }
    finally
    {
      paramHostnameVerifier = finally;
      throw paramHostnameVerifier;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.network.ssl.NameVerifierFactory
 * JD-Core Version:    0.7.0.1
 */