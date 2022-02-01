package com.tencent.mobileqq.troop.troopsetting.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ITroopSettingApi
  extends QRouteApi
{
  public abstract String getSimpleNameForTroopSettingActivity();
  
  public abstract Class<?> getTroopSettingActivityClass();
  
  public abstract boolean isInstanceOfTroopSettingActivity(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi
 * JD-Core Version:    0.7.0.1
 */