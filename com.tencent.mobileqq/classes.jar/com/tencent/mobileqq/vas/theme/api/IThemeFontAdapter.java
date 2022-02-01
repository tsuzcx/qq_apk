package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/IThemeFontAdapter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "switchFont", "", "fontId", "", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IThemeFontAdapter
  extends QRouteApi
{
  public abstract void switchFont(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.IThemeFontAdapter
 * JD-Core Version:    0.7.0.1
 */