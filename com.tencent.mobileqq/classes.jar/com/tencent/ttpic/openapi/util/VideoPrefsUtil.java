package com.tencent.ttpic.openapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.lang.ref.WeakReference;

public class VideoPrefsUtil
{
  public static final String AGE_DETECTOR_DOWLOADED = "AGE_DETECTOR_DOWLOADED";
  public static final String AI_BEAUTY_PARAMS_SETTING_PATH = "AI_BEAUTY_PARAMS_SETTING_PATH";
  public static final String DEVICE_CONFIG_JSON_PATH = "DEVICE_CONFIG_JSON_PATH";
  public static final String GENDER_DETECTOR_DOWLOADED = "GENDER_DETECTOR_DOWLOADED";
  public static final String INTELLIGENT_BEAUTY_ENABLE = "INTELLIGENT_BEAUTY_ENABLE";
  public static final String PREFS_KEY_DOWNGRADE_LEVEL = "prefs_key_downgrade_level";
  public static final String PREFS_KEY_ENCODE_WIDTH = "prefs_key_encode_width";
  public static final String PREFS_KEY_IS_MATERIAL_MUTE = "prefs_key_is_material_mute";
  public static final String PREFS_KEY_SEGMENT_ON_CPU = "prefs_key_segment_on_cpu";
  public static final String PREFS_KEY_STORAGE = "pref_key_storage";
  public static final String PREFS_KEY_USE_HARDWARE_DECODER = "prefs_key_use_hardware_decoder";
  public static final String PREFS_KEY_WATERMARK_COUNTDOWN = "prefs_key_watermark_countdown";
  public static final String PREFS_KEY_WATERMARK_SINCE = "prefs_key_watermark_since";
  public static final String PREF_ANIMOJI_LIB_DOWNLOADED = "animoji_lib_downloaded";
  public static final String PREF_ANIMOJI_LIB_MD5 = "animoji_lib_md5";
  public static final String PREF_ANIMOJI_LIB_NEED_LOAD = "animoji_lib_need_load";
  public static final String PREF_BODY_LIB_DOWNLOADED = "body_lib_downloaded";
  public static final String PREF_BODY_LIB_MD5 = "body_lib_md5";
  public static final String PREF_BODY_LIB_NEED_LOAD = "body_lib_need_load";
  public static final String PREF_GESTURE_LIB_DOWNLOADED = "gesture_lib_downloaded";
  public static final String PREF_GESTURE_LIB_MD5 = "gesture_lib_md5";
  public static final String PREF_GESTURE_LIB_NEED_LOAD = "gesture_lib_need_load";
  public static final String PREF_KEY_WATERMARK = "pref_key_watermark";
  public static final String PREF_SEGMENT_LIB_DOWNLOADED = "segment_lib_downloaded";
  public static final String PREF_SEGMENT_LIB_MD5 = "segment_lib_md5";
  public static final String PREF_SEGMENT_LIB_NEED_LOAD = "segment_lib_need_load";
  private static final String TAG = "VideoPrefsUtil";
  private static WeakReference<Context> mContext;
  private static SharedPreferences mPrefs;
  private static SharedPreferences mSoPrefs;
  
  public static void ageSDKDownloaded()
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putBoolean("AGE_DETECTOR_DOWLOADED", true).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, ageSDKDownloaded failed!!");
  }
  
  public static void genderSDKDownloaded()
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putBoolean("GENDER_DETECTOR_DOWLOADED", true).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, genderSDKDownloaded failed!!");
  }
  
  public static String getAiBeautyParamsSettingPath()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getString("AI_BEAUTY_PARAMS_SETTING_PATH", null);
    }
    return null;
  }
  
  public static SharedPreferences getDefaultPrefs()
  {
    if (mPrefs == null)
    {
      WeakReference localWeakReference = mContext;
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences((Context)mContext.get());
      }
    }
    return mPrefs;
  }
  
  public static String getDeviceConfigJsonPath()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getString("DEVICE_CONFIG_JSON_PATH", null);
    }
    return null;
  }
  
  public static int getDowngradeLevel()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getInt("prefs_key_downgrade_level", -1);
    }
    return -1;
  }
  
  public static boolean getMaterialMute()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getBoolean("prefs_key_is_material_mute", false);
    }
    return false;
  }
  
  public static int getNormalEncodeWidth()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getInt("prefs_key_encode_width", 720);
    }
    return 720;
  }
  
  public static SharedPreferences getSoPrefs()
  {
    return mSoPrefs;
  }
  
  public static String getStringParam(String paramString)
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getString(paramString, null);
    }
    return null;
  }
  
  public static boolean getUseHardwareDecoder()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getBoolean("prefs_key_use_hardware_decoder", true);
    }
    return true;
  }
  
  public static void init(Context paramContext)
  {
    init(paramContext, null);
  }
  
  public static void init(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    if (paramSharedPreferences != null) {
      mPrefs = paramSharedPreferences;
    }
    if (mPrefs == null) {
      mPrefs = PreferenceManager.getDefaultSharedPreferences(paramContext);
    }
    mContext = new WeakReference(paramContext);
    if (AEModule.getContext() != null) {
      paramContext = AEModule.getContext();
    }
    if (paramContext == null) {
      return;
    }
    mSoPrefs = paramContext.getSharedPreferences("puding_so", 0);
  }
  
  public static boolean isAgeSDKDownload()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getBoolean("AGE_DETECTOR_DOWLOADED", false);
    }
    return false;
  }
  
  public static boolean isCouldIntelligentBeauty()
  {
    return (isGenderSDKDownload()) && (isAgeSDKDownload()) && (isIntelligentBeautyEnable());
  }
  
  public static boolean isGenderSDKDownload()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getBoolean("GENDER_DETECTOR_DOWLOADED", false);
    }
    return false;
  }
  
  public static boolean isIntelligentBeautyEnable()
  {
    if (getDefaultPrefs() != null) {
      return getDefaultPrefs().getBoolean("INTELLIGENT_BEAUTY_ENABLE", false);
    }
    return false;
  }
  
  public static void setAiBeautyParamsSettingPath(String paramString)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putString("AI_BEAUTY_PARAMS_SETTING_PATH", paramString).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setAiBeautyParamsSettingPath failed!!");
  }
  
  public static void setDeviceConfigJsonPath(String paramString)
  {
    AEModule.updatePhoneAttrs(paramString);
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putString("DEVICE_CONFIG_JSON_PATH", paramString).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setDeviceConfigJsonPath failed!!");
  }
  
  public static void setDowngradeLevel(int paramInt)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putInt("prefs_key_downgrade_level", paramInt).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setDowngradeLevel failed!!");
  }
  
  public static void setIntelligentBeautyEnable(boolean paramBoolean)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putBoolean("INTELLIGENT_BEAUTY_ENABLE", paramBoolean).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setIntelligentBeautyEnable failed!!");
  }
  
  public static void setMaterialMute(boolean paramBoolean)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putBoolean("prefs_key_is_material_mute", paramBoolean).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setMaterialMute failed!!");
  }
  
  public static void setNormalEncodeWidth(int paramInt)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putInt("prefs_key_encode_width", paramInt).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setNormalEncodeWidth failed!!");
  }
  
  public static void setStringParam(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (getDefaultPrefs() != null))
    {
      getDefaultPrefs().edit().putString(paramString1, paramString2).apply();
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("getDefaultPrefs is null, setStringParam failed:");
    paramString1.append(paramString2);
    LogUtils.e("VideoPrefsUtil", paramString1.toString());
  }
  
  public static void setUseHardWareDecoder(boolean paramBoolean)
  {
    if (getDefaultPrefs() != null)
    {
      getDefaultPrefs().edit().putBoolean("prefs_key_use_hardware_decoder", paramBoolean).apply();
      return;
    }
    LogUtils.e("VideoPrefsUtil", "getDefaultPrefs is null, setUseHardWareDecoder failed!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoPrefsUtil
 * JD-Core Version:    0.7.0.1
 */