package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/IThemeSwitchCallback;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "beforeSwitch", "", "themeLocator", "Lcom/tencent/mobileqq/vas/theme/api/ThemeLocator;", "beginSwitch", "", "onProgress", "dwProgress", "", "dwProgressMax", "postSwitch", "errorCode", "", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IThemeSwitchCallback
  extends QRouteApi
{
  public abstract boolean beforeSwitch(@Nullable ThemeLocator paramThemeLocator);
  
  public abstract void beginSwitch();
  
  public abstract void onProgress(long paramLong1, long paramLong2);
  
  public abstract boolean postSwitch(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.IThemeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */