package com.tencent.mobileqq.kandian.base.video.player.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/QuicConfig;", "", "()V", "enableConnectionMigration", "", "getEnableConnectionMigration", "()Z", "setEnableConnectionMigration", "(Z)V", "enablePlainText", "getEnablePlainText", "setEnablePlainText", "quicCongestionType", "", "getQuicCongestionType", "()I", "setQuicCongestionType", "(I)V", "quicHostListStr", "", "getQuicHostListStr", "()Ljava/lang/String;", "setQuicHostListStr", "(Ljava/lang/String;)V", "wifiEnableQuicMode", "getWifiEnableQuicMode", "setWifiEnableQuicMode", "xgEnableQuicMode", "getXgEnableQuicMode", "setXgEnableQuicMode", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class QuicConfig
{
  public static final QuicConfig a = new QuicConfig();
  private static int b;
  private static int c;
  private static boolean d;
  private static boolean e;
  private static int f;
  @NotNull
  private static String g = "";
  
  public final int a()
  {
    return b;
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    g = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public final int b()
  {
    return c;
  }
  
  public final void b(int paramInt)
  {
    c = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public final void c(int paramInt)
  {
    f = paramInt;
  }
  
  public final boolean c()
  {
    return d;
  }
  
  public final boolean d()
  {
    return e;
  }
  
  public final int e()
  {
    return f;
  }
  
  @NotNull
  public final String f()
  {
    return g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.QuicConfig
 * JD-Core Version:    0.7.0.1
 */