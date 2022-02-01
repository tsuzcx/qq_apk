package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "loadConfig", "Lcom/tencent/mobileqq/qqgamepub/config/DnFlutterConfigBean;", "qqgamepubaccount-api_release"}, k=1, mv={1, 1, 16})
public final class DnFlutterConfProcessor$Companion
{
  @NotNull
  public final DnFlutterConfigBean a()
  {
    Object localObject = QConfigManager.b().b(753);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return (DnFlutterConfigBean)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.DnFlutterConfProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */