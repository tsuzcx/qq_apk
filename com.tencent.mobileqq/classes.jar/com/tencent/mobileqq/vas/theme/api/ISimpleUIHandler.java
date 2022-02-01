package com.tencent.mobileqq.vas.theme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/ISimpleUIHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onPostThemeChanged", "", "sendSwitchAndSetSimpleUI", "", "bSwitch", "", "prefId", "", "bSwitchElsePref", "setReqTs", "ts", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISimpleUIHandler
  extends QRouteApi
{
  public abstract void onPostThemeChanged();
  
  public abstract long sendSwitchAndSetSimpleUI(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract void setReqTs(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ISimpleUIHandler
 * JD-Core Version:    0.7.0.1
 */