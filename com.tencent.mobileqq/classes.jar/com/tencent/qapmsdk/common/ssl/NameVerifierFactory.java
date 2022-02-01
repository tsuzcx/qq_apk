package com.tencent.qapmsdk.common.ssl;

import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/ssl/NameVerifierFactory;", "", "()V", "DEFAULT_NAME_VERIFIER", "Ljavax/net/ssl/HostnameVerifier;", "value", "nameVerifier", "getNameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setNameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "common_release"}, k=1, mv={1, 1, 15})
public final class NameVerifierFactory
{
  @JvmField
  @NotNull
  public static final HostnameVerifier DEFAULT_NAME_VERIFIER = (HostnameVerifier)new DefaultNameVerifier();
  public static final NameVerifierFactory INSTANCE = new NameVerifierFactory();
  @Nullable
  private static HostnameVerifier nameVerifier = DEFAULT_NAME_VERIFIER;
  
  @Nullable
  public final HostnameVerifier getNameVerifier()
  {
    HostnameVerifier localHostnameVerifier = nameVerifier;
    if (localHostnameVerifier != null) {
      return localHostnameVerifier;
    }
    return DEFAULT_NAME_VERIFIER;
  }
  
  public final void setNameVerifier(@Nullable HostnameVerifier paramHostnameVerifier)
  {
    try
    {
      nameVerifier = paramHostnameVerifier;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.ssl.NameVerifierFactory
 * JD-Core Version:    0.7.0.1
 */