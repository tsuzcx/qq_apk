package com.tencent.mobileqq.kandian.base.video.player.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/player/config/QuicConfig;", "", "()V", "enableConnectionMigration", "", "getEnableConnectionMigration", "()Z", "setEnableConnectionMigration", "(Z)V", "enablePlainText", "getEnablePlainText", "setEnablePlainText", "quicCongestionType", "", "getQuicCongestionType", "()I", "setQuicCongestionType", "(I)V", "quicHostListStr", "", "getQuicHostListStr", "()Ljava/lang/String;", "setQuicHostListStr", "(Ljava/lang/String;)V", "wifiEnableQuicMode", "getWifiEnableQuicMode", "setWifiEnableQuicMode", "xgEnableQuicMode", "getXgEnableQuicMode", "setXgEnableQuicMode", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class QuicConfig
{
  private static int jdField_a_of_type_Int;
  public static final QuicConfig a;
  @NotNull
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static boolean jdField_b_of_type_Boolean;
  private static int c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerConfigQuicConfig = new QuicConfig();
  }
  
  public final int a()
  {
    return jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public final void b(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public final int c()
  {
    return c;
  }
  
  public final void c(int paramInt)
  {
    c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.config.QuicConfig
 * JD-Core Version:    0.7.0.1
 */