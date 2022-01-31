package com.tencent.mobileqq.msf.core.net.patch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PatchSharedPreUtil
{
  private static final String KEY_CONFIG_VERSION_PATCH = "key_config_version_patch";
  private static final String KEY_COUNT_FAIL_INSTALL_PATCH = "key_count_fail_install_patch_";
  private static final String KEY_COUNT_FAIL_STARTUP_PATCH = "key_count_fail_startup_patch_";
  private static final String KEY_PREFIX_CONFIG_PATCH = "key_config_patch_";
  private static final String KEY_TIME_PULL_PATCH_RECONNECT = "key_time_pull_patch_reconnect";
  private static final String KEY_VERIFY_STATUS_PATCH = "key_verify_status_patch_";
  public static final String SHARED_PREFERENCE_HOTPATCH = "hotpatch_preference";
  
  public static int getCountFailInstallPatch(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_count_fail_install_patch_" + paramString1 + paramString2, 0);
  }
  
  public static int getCountFailStartupPatch(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_count_fail_startup_patch_" + paramString1 + paramString2, 0);
  }
  
  public static long getLastTimePullPatchReconnect(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getLong("key_time_pull_patch_reconnect", 0L);
  }
  
  public static String getPatchConfig(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getString("key_config_patch_" + paramString, null);
  }
  
  public static int getPatchConfigVersion(Context paramContext)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getInt("key_config_version_patch", 0);
  }
  
  public static String getPatchReportInfo(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getString(paramString, null);
  }
  
  public static boolean getPatchVerifyStatus(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("hotpatch_preference", 4).getBoolean("key_verify_status_patch_" + paramString, false);
  }
  
  public static void updateCountFailInstallPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_count_fail_install_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void updateCountFailStartupPatch(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_count_fail_startup_patch_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void updateLastTimePullPatchReconnect(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putLong("key_time_pull_patch_reconnect", paramLong);
    paramContext.commit();
  }
  
  public static void updatePatchConfig(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putString("key_config_patch_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void updatePatchConfigVersion(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putInt("key_config_version_patch", paramInt);
    paramContext.commit();
  }
  
  public static void updatePatchReportInfo(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void updatePatchVerifyStatus(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("hotpatch_preference", 4).edit();
    paramContext.putBoolean("key_verify_status_patch_" + paramString, paramBoolean);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil
 * JD-Core Version:    0.7.0.1
 */