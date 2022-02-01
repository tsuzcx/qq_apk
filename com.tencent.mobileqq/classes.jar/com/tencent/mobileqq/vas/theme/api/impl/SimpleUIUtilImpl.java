package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/SimpleUIUtilImpl;", "Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIUtil;", "()V", "isThemeSimpleDayUI", "", "currentThemeId", "", "isThemeSimpleUI", "themeId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SimpleUIUtilImpl
  implements ISimpleUIUtil
{
  public boolean isThemeSimpleDayUI(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "currentThemeId");
    return QQTheme.isThemeSimpleDayUI(paramString);
  }
  
  public boolean isThemeSimpleUI(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "themeId");
    return QQTheme.isThemeSimpleUI(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.SimpleUIUtilImpl
 * JD-Core Version:    0.7.0.1
 */