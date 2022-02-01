package com.tencent.mobileqq.config.business.qflutter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption$Companion;", "", "()V", "parse", "Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "engine", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PreloadEngineOption$Companion
{
  @NotNull
  public final PreloadEngineOption a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "engine");
    int i = paramString.hashCode();
    if (i != -1414557169)
    {
      if (i != -1051289244)
      {
        if ((i == 1421475938) && (paramString.equals("red_point"))) {
          return PreloadEngineOption.RED_POINT_PRELOAD;
        }
      }
      else if (paramString.equals("active_user")) {
        return PreloadEngineOption.ACTIVE_USER_PRELOAD;
      }
    }
    else if (paramString.equals("always")) {
      return PreloadEngineOption.ALWAYS_PRELOAD;
    }
    return PreloadEngineOption.NEVER_PRELOAD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.PreloadEngineOption.Companion
 * JD-Core Version:    0.7.0.1
 */