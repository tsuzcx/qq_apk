package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/aladdin/RIJStudyModeClassEntryAladdinConfig;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "getConfig", "()Lcom/tencent/aladdin/config/AladdinConfig;", "setConfig", "(Lcom/tencent/aladdin/config/AladdinConfig;)V", "getStudyModeSelectGradeEntryEnable", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJStudyModeClassEntryAladdinConfig
{
  public static final RIJStudyModeClassEntryAladdinConfig a = new RIJStudyModeClassEntryAladdinConfig();
  @NotNull
  private static AladdinConfig b;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(315);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…G_STUDY_MODE_CLASS_ENTRY)");
    b = localAladdinConfig;
  }
  
  public final int a()
  {
    return b.getIntegerFromString("study_mode_select_grade_entry_enable", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJStudyModeClassEntryAladdinConfig
 * JD-Core Version:    0.7.0.1
 */