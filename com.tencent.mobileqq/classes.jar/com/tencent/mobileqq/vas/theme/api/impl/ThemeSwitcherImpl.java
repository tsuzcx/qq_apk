package com.tencent.mobileqq.vas.theme.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback;
import com.tencent.mobileqq.vas.theme.api.IThemeSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitcher;", "()V", "isEnableAnimate", "", "bundle", "Landroid/os/Bundle;", "startSwitch", "", "themeId", "", "from", "callback", "Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitchCallback;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeSwitcherImpl
  implements IThemeSwitcher
{
  public boolean isEnableAnimate(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    return ThemeSwitchManager.a(paramBundle);
  }
  
  public void startSwitch(@NotNull String paramString1, @NotNull String paramString2, @NotNull IThemeSwitchCallback paramIThemeSwitchCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "themeId");
    Intrinsics.checkParameterIsNotNull(paramString2, "from");
    Intrinsics.checkParameterIsNotNull(paramIThemeSwitchCallback, "callback");
    ThemeSwitcher.a(paramString1, "vaildLocal", (IThemeSwitchCallback)paramIThemeSwitchCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl
 * JD-Core Version:    0.7.0.1
 */