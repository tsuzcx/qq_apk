package com.tencent.mobileqq.vas.manager.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.StyleCallBack;
import kotlin.Metadata;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/manager/api/IThemeSwitchManager;", "Lmqq/manager/Manager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "clearOnErr", "", "doScreenShot", "getIsEnableAnimate", "", "bundle", "Landroid/os/Bundle;", "getstyleCallBack", "Lcom/tencent/mobileqq/vas/theme/diy/ThemeDiyStyleLogic$StyleCallBack;", "onPostThemeChanged", "openSwitchDialog", "activity", "Landroid/app/Activity;", "setstyleCallBack", "callback", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IThemeSwitchManager
  extends IVasManager, Manager
{
  public abstract void clearOnErr();
  
  public abstract void doScreenShot();
  
  public abstract boolean getIsEnableAnimate(@NotNull Bundle paramBundle);
  
  @NotNull
  public abstract ThemeDiyStyleLogic.StyleCallBack getstyleCallBack();
  
  public abstract void onPostThemeChanged();
  
  public abstract void openSwitchDialog(@Nullable Activity paramActivity);
  
  public abstract void setstyleCallBack(@NotNull ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager
 * JD-Core Version:    0.7.0.1
 */