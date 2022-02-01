package com.tencent.mobileqq.kandian.base.bandwidth;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig;", "", "()V", "bitrateWeight", "", "getBitrateWeight", "()F", "setBitrateWeight", "(F)V", "bufferRangeReportTag", "", "getBufferRangeReportTag", "()Ljava/lang/String;", "setBufferRangeReportTag", "(Ljava/lang/String;)V", "defaultPreloadCount", "", "getDefaultPreloadCount", "()I", "setDefaultPreloadCount", "(I)V", "idleBandwithThreshold", "getIdleBandwithThreshold", "setIdleBandwithThreshold", "maxPreloadCount", "getMaxPreloadCount", "setMaxPreloadCount", "preloadStrategy", "Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "getPreloadStrategy", "()Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;", "setPreloadStrategy", "(Lcom/tencent/mobileqq/kandian/base/bandwidth/BandWidthConfig$PreloadStrategy;)V", "preplayTimeLimit", "getPreplayTimeLimit", "setPreplayTimeLimit", "resetTimeSecForWifi", "getResetTimeSecForWifi", "setResetTimeSecForWifi", "resetTimeSecForXg", "getResetTimeSecForXg", "setResetTimeSecForXg", "getDecodeConfigsStr", "key", "preloadStrategyEnable", "", "PreloadStrategy", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BandWidthConfig
{
  public static final BandWidthConfig a = new BandWidthConfig();
  @Nullable
  private static String b = "";
  private static int c = 3600;
  private static int d = 600;
  private static int e = 6;
  @Nullable
  private static BandWidthConfig.PreloadStrategy f;
  private static float g = 2.0F;
  private static int h = 1500;
  private static int i = 4;
  private static int j = 4;
  
  @Nullable
  public final String a()
  {
    return b;
  }
  
  public final void a(float paramFloat)
  {
    g = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    c = paramInt;
  }
  
  public final void a(@Nullable BandWidthConfig.PreloadStrategy paramPreloadStrategy)
  {
    f = paramPreloadStrategy;
  }
  
  public final void a(@Nullable String paramString)
  {
    b = paramString;
  }
  
  public final int b()
  {
    return c;
  }
  
  public final void b(int paramInt)
  {
    d = paramInt;
  }
  
  public final boolean b(@Nullable String paramString)
  {
    BandWidthConfig.PreloadStrategy localPreloadStrategy = f;
    if (localPreloadStrategy != null) {
      return localPreloadStrategy.a(paramString);
    }
    return false;
  }
  
  public final int c()
  {
    return d;
  }
  
  @NotNull
  public final String c(@Nullable String paramString)
  {
    BandWidthConfig.PreloadStrategy localPreloadStrategy = f;
    if (localPreloadStrategy != null) {
      return localPreloadStrategy.b(paramString);
    }
    return "";
  }
  
  public final void c(int paramInt)
  {
    e = paramInt;
  }
  
  public final int d()
  {
    return e;
  }
  
  public final void d(int paramInt)
  {
    h = paramInt;
  }
  
  public final float e()
  {
    return g;
  }
  
  public final void e(int paramInt)
  {
    i = paramInt;
  }
  
  public final int f()
  {
    return h;
  }
  
  public final void f(int paramInt)
  {
    j = paramInt;
  }
  
  public final int g()
  {
    return i;
  }
  
  public final int h()
  {
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.bandwidth.BandWidthConfig
 * JD-Core Version:    0.7.0.1
 */