package com.tencent.mobileqq.vashealth.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/StepConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getConfig", "Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class StepConfigProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final StepConfigBean a()
  {
    Object localObject = QConfigManager.b().b(738);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return (StepConfigBean)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.StepConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */