package com.tencent.mobileqq.doutu.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.doutu.api.IDoutuSPUtil;

public class DoutuSPUtilImpl
  implements IDoutuSPUtil
{
  public long getComboDuration(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_duration_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public long getComboKeep(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_keep_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public boolean getDoutuComboSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_combo_config_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public int getDoutuConfigAppId(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("doutu_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public long getDoutuDuration(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duration_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public boolean getDoutuResDamaged(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_res_damaged", false);
  }
  
  public String getDoutuResMd5(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_md5_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public String getDoutuResUrl(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_url_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public boolean getDoutuSettingSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_setting_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public boolean getDoutuSmartSwitchNew(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_recommend_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public boolean getDoutuSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public int getDuiTimes(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duitimes_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public int getSmartPicCount(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_smart_default_count_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public void removeComboDuration(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_duration_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeComboKeep(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_keep_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuComboSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_combo_config_switch_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuDuration(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duration_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuResMd5(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_md5_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuResUrl(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_url_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuSmartSwitchNew(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_recommend_switch_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDoutuSwitch(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_switch_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeDuiTimes(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duitimes_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void removeSmartPicCount(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_smart_default_count_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public void updateComboDuration(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_duration_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public void updateComboKeep(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_combo_keep_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public void updateDoutuComboSwitch(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_combo_config_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public void updateDoutuConfigAppId(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("doutu_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public void updateDoutuConfigVersion(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public void updateDoutuDuration(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duration_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public void updateDoutuResDamaged(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_res_damaged", paramBoolean);
    paramContext.commit();
  }
  
  public void updateDoutuResMd5(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_md5_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public void updateDoutuResUrl(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_res_url_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public void updateDoutuSettingSwitch(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_setting_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public void updateDoutuSmartSwitchNew(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_recommend_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public void updateDoutuSwitch(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public void updateDuiTimes(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_duitimes_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public void updateSmartPicCount(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_smart_default_count_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuSPUtilImpl
 * JD-Core Version:    0.7.0.1
 */