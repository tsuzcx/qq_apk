package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isThemeSimpleDayUI", "", "currentThemeId", "", "isThemeSimpleUI", "themeId", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISimpleUIUtil
  extends QRouteApi
{
  public abstract boolean isThemeSimpleDayUI(@NotNull String paramString);
  
  public abstract boolean isThemeSimpleUI(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ISimpleUIUtil
 * JD-Core Version:    0.7.0.1
 */