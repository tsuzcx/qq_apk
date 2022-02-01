package com.tencent.mobileqq.troop.troopsetting.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingApi;
import mqq.app.AppRuntime;

public class TroopSettingApiImpl
  implements ITroopSettingApi
{
  AppRuntime appRuntime;
  
  public String getSimpleNameForTroopSettingActivity()
  {
    return TroopSettingActivity.class.getSimpleName();
  }
  
  public Class<?> getTroopSettingActivityClass()
  {
    return TroopSettingActivity.class;
  }
  
  public boolean isInstanceOfTroopSettingActivity(Activity paramActivity)
  {
    return paramActivity instanceof TroopSettingActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.api.impl.TroopSettingApiImpl
 * JD-Core Version:    0.7.0.1
 */