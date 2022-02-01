package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJRedDotAladdinConfig;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "getConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "setConfig", "(Lcom/tencent/aladdin/config/AladdinConfig;)V", "getUserNewRoute", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRedDotAladdinConfig
{
  public static final RIJRedDotAladdinConfig a = new RIJRedDotAladdinConfig();
  @NotNull
  private static AladdinConfig b;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(186);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…CONFIG_RED_DOT_NEW_ROUTE)");
    b = localAladdinConfig;
  }
  
  public final int a()
  {
    return b.getIntegerFromString("use_new_route", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJRedDotAladdinConfig
 * JD-Core Version:    0.7.0.1
 */