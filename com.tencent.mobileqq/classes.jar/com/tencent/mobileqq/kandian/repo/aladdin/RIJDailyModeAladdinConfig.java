package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJDailyModeAladdinConfig;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "getConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "setConfig", "(Lcom/tencent/aladdin/config/AladdinConfig;)V", "getDynamicHeaderEnable", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDailyModeAladdinConfig
{
  public static final RIJDailyModeAladdinConfig a = new RIJDailyModeAladdinConfig();
  @NotNull
  private static AladdinConfig b;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(157);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…FIG_DAILY_DYNAMIC_HEADER)");
    b = localAladdinConfig;
  }
  
  public final int a()
  {
    return b.getIntegerFromString("enable_dynamic_header", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJDailyModeAladdinConfig
 * JD-Core Version:    0.7.0.1
 */