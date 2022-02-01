package com.tencent.mobileqq.kandian.base.bandwidth;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig;", "", "()V", "bitrateWeight", "", "getBitrateWeight", "()F", "setBitrateWeight", "(F)V", "bufferRangeReportTag", "", "getBufferRangeReportTag", "()Ljava/lang/String;", "setBufferRangeReportTag", "(Ljava/lang/String;)V", "defaultPreloadCount", "", "getDefaultPreloadCount", "()I", "setDefaultPreloadCount", "(I)V", "idleBandwithThreshold", "getIdleBandwithThreshold", "setIdleBandwithThreshold", "maxPreloadCount", "getMaxPreloadCount", "setMaxPreloadCount", "preloadStrategy", "Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "getPreloadStrategy", "()Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "setPreloadStrategy", "(Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;)V", "preplayTimeLimit", "getPreplayTimeLimit", "setPreplayTimeLimit", "resetTimeSecForWifi", "getResetTimeSecForWifi", "setResetTimeSecForWifi", "resetTimeSecForXg", "getResetTimeSecForXg", "setResetTimeSecForXg", "getDecodeConfigsStr", "key", "preloadStrategyEnable", "", "PreloadStrategy", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BandWidthConfig
{
  private static float jdField_a_of_type_Float = 2.0F;
  private static int jdField_a_of_type_Int;
  @Nullable
  private static BandWidthConfig.PreloadStrategy jdField_a_of_type_ComTencentMobileqqKandianBaseBandwidthBandWidthConfig$PreloadStrategy;
  public static final BandWidthConfig a;
  @Nullable
  private static String jdField_a_of_type_JavaLangString;
  private static int b;
  private static int c;
  private static int d = 1500;
  private static int e = 4;
  private static int f = 4;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseBandwidthBandWidthConfig = new BandWidthConfig();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Int = 3600;
    b = 600;
    c = 6;
  }
  
  public final float a()
  {
    return jdField_a_of_type_Float;
  }
  
  public final int a()
  {
    return jdField_a_of_type_Int;
  }
  
  @Nullable
  public final String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final String a(@Nullable String paramString)
  {
    BandWidthConfig.PreloadStrategy localPreloadStrategy = jdField_a_of_type_ComTencentMobileqqKandianBaseBandwidthBandWidthConfig$PreloadStrategy;
    if (localPreloadStrategy != null) {
      return localPreloadStrategy.a(paramString);
    }
    return "";
  }
  
  public final void a(float paramFloat)
  {
    jdField_a_of_type_Float = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable BandWidthConfig.PreloadStrategy paramPreloadStrategy)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseBandwidthBandWidthConfig$PreloadStrategy = paramPreloadStrategy;
  }
  
  public final void a(@Nullable String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final boolean a(@Nullable String paramString)
  {
    BandWidthConfig.PreloadStrategy localPreloadStrategy = jdField_a_of_type_ComTencentMobileqqKandianBaseBandwidthBandWidthConfig$PreloadStrategy;
    if (localPreloadStrategy != null) {
      return localPreloadStrategy.a(paramString);
    }
    return false;
  }
  
  public final int b()
  {
    return b;
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
  }
  
  public final int c()
  {
    return c;
  }
  
  public final void c(int paramInt)
  {
    c = paramInt;
  }
  
  public final int d()
  {
    return d;
  }
  
  public final void d(int paramInt)
  {
    d = paramInt;
  }
  
  public final int e()
  {
    return e;
  }
  
  public final void e(int paramInt)
  {
    e = paramInt;
  }
  
  public final int f()
  {
    return f;
  }
  
  public final void f(int paramInt)
  {
    f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig
 * JD-Core Version:    0.7.0.1
 */