package com.tencent.mobileqq.mini.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/model/OpenType;", "", "()V", "ALL_TYPE", "", "", "getALL_TYPE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "NAVIGATE_BACK", "NAVIGATE_TO", "REDIRECT_TO", "RE_LAUNCH", "SWITCH_TAB", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class OpenType
{
  @NotNull
  private static final String[] ALL_TYPE = { "reLaunch", "navigateTo", "switchTab", "navigateBack", "redirectTo" };
  public static final OpenType INSTANCE = new OpenType();
  @NotNull
  public static final String NAVIGATE_BACK = "navigateBack";
  @NotNull
  public static final String NAVIGATE_TO = "navigateTo";
  @NotNull
  public static final String REDIRECT_TO = "redirectTo";
  @NotNull
  public static final String RE_LAUNCH = "reLaunch";
  @NotNull
  public static final String SWITCH_TAB = "switchTab";
  
  @NotNull
  public final String[] getALL_TYPE()
  {
    return ALL_TYPE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.OpenType
 * JD-Core Version:    0.7.0.1
 */