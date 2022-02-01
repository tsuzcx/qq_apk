package com.tencent.mobileqq.doutu.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoutuSPUtil
  extends QRouteApi
{
  public abstract long getComboDuration(Context paramContext, String paramString);
  
  public abstract long getComboKeep(Context paramContext, String paramString);
  
  public abstract boolean getDoutuComboSwitch(Context paramContext, String paramString);
  
  public abstract int getDoutuConfigAppId(Context paramContext, String paramString);
  
  public abstract long getDoutuDuration(Context paramContext, String paramString);
  
  public abstract boolean getDoutuResDamaged(Context paramContext);
  
  public abstract String getDoutuResMd5(Context paramContext, String paramString);
  
  public abstract String getDoutuResUrl(Context paramContext, String paramString);
  
  public abstract boolean getDoutuSettingSwitch(Context paramContext, String paramString);
  
  public abstract boolean getDoutuSmartSwitchNew(Context paramContext, String paramString);
  
  public abstract boolean getDoutuSwitch(Context paramContext, String paramString);
  
  public abstract int getDuiTimes(Context paramContext, String paramString);
  
  public abstract int getSmartPicCount(Context paramContext, String paramString);
  
  public abstract void removeComboDuration(Context paramContext, String paramString);
  
  public abstract void removeComboKeep(Context paramContext, String paramString);
  
  public abstract void removeDoutuComboSwitch(Context paramContext, String paramString);
  
  public abstract void removeDoutuDuration(Context paramContext, String paramString);
  
  public abstract void removeDoutuResMd5(Context paramContext, String paramString);
  
  public abstract void removeDoutuResUrl(Context paramContext, String paramString);
  
  public abstract void removeDoutuSmartSwitchNew(Context paramContext, String paramString);
  
  public abstract void removeDoutuSwitch(Context paramContext, String paramString);
  
  public abstract void removeDuiTimes(Context paramContext, String paramString);
  
  public abstract void removeSmartPicCount(Context paramContext, String paramString);
  
  public abstract void updateComboDuration(Context paramContext, String paramString, long paramLong);
  
  public abstract void updateComboKeep(Context paramContext, String paramString, long paramLong);
  
  public abstract void updateDoutuComboSwitch(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void updateDoutuConfigAppId(Context paramContext, String paramString, int paramInt);
  
  public abstract void updateDoutuConfigVersion(Context paramContext, String paramString, int paramInt);
  
  public abstract void updateDoutuDuration(Context paramContext, String paramString, long paramLong);
  
  public abstract void updateDoutuResDamaged(Context paramContext, boolean paramBoolean);
  
  public abstract void updateDoutuResMd5(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateDoutuResUrl(Context paramContext, String paramString1, String paramString2);
  
  public abstract void updateDoutuSettingSwitch(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void updateDoutuSmartSwitchNew(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void updateDoutuSwitch(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void updateDuiTimes(Context paramContext, String paramString, int paramInt);
  
  public abstract void updateSmartPicCount(Context paramContext, String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.IDoutuSPUtil
 * JD-Core Version:    0.7.0.1
 */