package com.tencent.mobileqq.config.business.qflutter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/PreloadEngineOption;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "ALWAYS_PRELOAD", "RED_POINT_PRELOAD", "ACTIVE_USER_PRELOAD", "NEVER_PRELOAD", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum PreloadEngineOption
{
  public static final PreloadEngineOption.Companion Companion = new PreloadEngineOption.Companion(null);
  @NotNull
  private final String desc;
  
  static
  {
    PreloadEngineOption localPreloadEngineOption1 = new PreloadEngineOption("ALWAYS_PRELOAD", 0, "always");
    ALWAYS_PRELOAD = localPreloadEngineOption1;
    PreloadEngineOption localPreloadEngineOption2 = new PreloadEngineOption("RED_POINT_PRELOAD", 1, "red_point");
    RED_POINT_PRELOAD = localPreloadEngineOption2;
    PreloadEngineOption localPreloadEngineOption3 = new PreloadEngineOption("ACTIVE_USER_PRELOAD", 2, "active_user");
    ACTIVE_USER_PRELOAD = localPreloadEngineOption3;
    PreloadEngineOption localPreloadEngineOption4 = new PreloadEngineOption("NEVER_PRELOAD", 3, "never");
    NEVER_PRELOAD = localPreloadEngineOption4;
    $VALUES = new PreloadEngineOption[] { localPreloadEngineOption1, localPreloadEngineOption2, localPreloadEngineOption3, localPreloadEngineOption4 };
  }
  
  private PreloadEngineOption(String paramString)
  {
    this.desc = paramString;
  }
  
  @NotNull
  public final String getDesc()
  {
    return this.desc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.PreloadEngineOption
 * JD-Core Version:    0.7.0.1
 */