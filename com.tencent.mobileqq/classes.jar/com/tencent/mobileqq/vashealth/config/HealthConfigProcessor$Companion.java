package com.tencent.mobileqq.vashealth.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getConfig", "Lcom/tencent/mobileqq/vashealth/config/HealthConfigBean;", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthConfigProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final HealthConfigBean a()
  {
    Object localObject = QConfigManager.b().b(671);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return (HealthConfigBean)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */