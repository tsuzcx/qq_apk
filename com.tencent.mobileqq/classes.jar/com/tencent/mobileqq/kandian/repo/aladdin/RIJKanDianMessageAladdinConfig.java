package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJKanDianMessageAladdinConfig;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "getConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "setConfig", "(Lcom/tencent/aladdin/config/AladdinConfig;)V", "getMessageRedDotStyle", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJKanDianMessageAladdinConfig
{
  @NotNull
  private static AladdinConfig a;
  public static final RIJKanDianMessageAladdinConfig a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinRIJKanDianMessageAladdinConfig = new RIJKanDianMessageAladdinConfig();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(215);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…NFIG_KANDIAN_MESSAGE_TIP)");
    jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = localAladdinConfig;
  }
  
  public final int a()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("message_reddot_style", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianMessageAladdinConfig
 * JD-Core Version:    0.7.0.1
 */