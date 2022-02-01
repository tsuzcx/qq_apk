package com.tencent.mobileqq.vas.theme.api.impl;

import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitcher;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitcher;", "()V", "startSwitch", "", "themeId", "", "from", "callback", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitchCallback;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeSwitcherImpl
  implements IThemeSwitcher
{
  public static final ThemeSwitcherImpl.Companion Companion = new ThemeSwitcherImpl.Companion(null);
  
  @JvmStatic
  public static final boolean downloadExtraTabIcon(@Nullable String paramString, boolean paramBoolean)
  {
    return Companion.a(paramString, paramBoolean);
  }
  
  @JvmStatic
  private static final boolean downloadIcon(String paramString1, String paramString2, String paramString3, File paramFile, boolean paramBoolean)
  {
    return ThemeSwitcherImpl.Companion.a(Companion, paramString1, paramString2, paramString3, paramFile, paramBoolean);
  }
  
  @JvmStatic
  public static final void onComplete(@NotNull String paramString, int paramInt)
  {
    Companion.a(paramString, paramInt);
  }
  
  @JvmStatic
  public static final boolean searchNameByFile(@NotNull String paramString, @NotNull File paramFile)
  {
    return Companion.a(paramString, paramFile);
  }
  
  public void startSwitch(@NotNull String paramString1, @NotNull String paramString2, @NotNull IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "themeId");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    Intrinsics.checkParameterIsNotNull(paramIThemeSwitchCallback, "callback");
    ThemeSwitcher.a(paramString1, "vaildLocal", paramIThemeSwitchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl
 * JD-Core Version:    0.7.0.1
 */