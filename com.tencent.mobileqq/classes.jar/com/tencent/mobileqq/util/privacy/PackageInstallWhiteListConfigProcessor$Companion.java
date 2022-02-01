package com.tencent.mobileqq.util.privacy;

import com.tencent.mobileqq.config.QConfigManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getWhiteList", "Lorg/json/JSONArray;", "key", "QQCommon_release"}, k=1, mv={1, 1, 16})
public final class PackageInstallWhiteListConfigProcessor$Companion
{
  @Nullable
  public final JSONArray a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Object localObject = QConfigManager.b().b(776);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return (JSONArray)((PackageInstallWhiteListConfigProcessor.Config)localObject).a().get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */