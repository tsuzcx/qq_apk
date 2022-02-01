package com.tencent.mobileqq.kandian.repo.aladdin;

import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJKanDianUserDataAladdinConfig;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "getConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "setConfig", "(Lcom/tencent/aladdin/config/AladdinConfig;)V", "getUserDataAlertContent", "", "context", "Landroid/content/Context;", "getUserDataAlertInterval", "", "getUserDataAlertSwitch", "getUserDataSwitchSwitch", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJKanDianUserDataAladdinConfig
{
  @NotNull
  private static AladdinConfig a;
  public static final RIJKanDianUserDataAladdinConfig a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinRIJKanDianUserDataAladdinConfig = new RIJKanDianUserDataAladdinConfig();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(232);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…CONFIG_KANDIAN_USER_DATA)");
    jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = localAladdinConfig;
  }
  
  public final int a()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("user_data_alert_switch", 0);
  }
  
  @NotNull
  public final String a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getString("user_data_alert_content", paramContext.getString(2131718092));
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "config.getString(\"user_d…er_data_content_default))");
    return paramContext;
  }
  
  public final int b()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("user_data_switch_switch", 0);
  }
  
  public final int c()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("user_data_alert_interval", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianUserDataAladdinConfig
 * JD-Core Version:    0.7.0.1
 */