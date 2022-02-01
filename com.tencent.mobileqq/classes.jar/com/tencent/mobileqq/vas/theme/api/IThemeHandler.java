package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/IThemeHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isNeedAuth", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendThemeAuth", "", "sendThemeVersionCheck", "themeId", "", "version", "isBackAuth", "", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IThemeHandler
  extends QRouteApi
{
  @Nullable
  public abstract AtomicBoolean isNeedAuth();
  
  public abstract void sendThemeAuth();
  
  public abstract void sendThemeVersionCheck(@NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.IThemeHandler
 * JD-Core Version:    0.7.0.1
 */