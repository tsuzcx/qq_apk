package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat.EditorCompat;
import android.text.TextUtils;

public class SPUtils
{
  public static final String LAST_APP_HEART_BEAT_MAP = "last_app_heart_beat_map";
  public static final String LAST_AUDIO_HEART_BEAT_MAP = "last_audio_heart_beat_map";
  public static final String PREF_DEVICE_ACTIVATED = "pref_device_activated";
  private static final String VIDEO_REPORT_PROFILE = "video_report_profile";
  public static SharedPreferences sSharePreferences;
  
  @NonNull
  public static <E> E get(@NonNull Context paramContext, @NonNull String paramString, @NonNull E paramE)
  {
    return get(paramContext, null, paramString, paramE);
  }
  
  @NonNull
  public static <E> E get(@NonNull Context paramContext, String paramString1, @NonNull String paramString2, @NonNull E paramE)
  {
    paramContext = init(paramContext, paramString1).getString(paramString2, String.valueOf(paramE));
    if ((paramE instanceof String)) {
      return paramContext;
    }
    if ((paramE instanceof Integer)) {
      return Integer.valueOf(paramContext);
    }
    if ((paramE instanceof Boolean)) {
      return Boolean.valueOf(paramContext);
    }
    if ((paramE instanceof Float)) {
      return Float.valueOf(paramContext);
    }
    if ((paramE instanceof Long)) {
      return Long.valueOf(paramContext);
    }
    if ((paramE instanceof Double)) {
      return Double.valueOf(paramContext);
    }
    return paramE;
  }
  
  public static SharedPreferences.Editor getEdit(@NonNull Context paramContext, String paramString)
  {
    return init(paramContext, paramString).edit();
  }
  
  private static SharedPreferences init(@NonNull Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = sSharePreferences;
      if (paramString == null)
      {
        paramContext = paramContext.getSharedPreferences("video_report_profile", 0);
        sSharePreferences = paramContext;
        return paramContext;
      }
      return paramString;
    }
    return paramContext.getSharedPreferences(paramString, 0);
  }
  
  public static <E> void put(@NonNull Context paramContext, @NonNull String paramString, @NonNull E paramE)
  {
    put(paramContext, null, paramString, paramE);
  }
  
  public static <E> void put(@NonNull Context paramContext, String paramString1, @NonNull String paramString2, @NonNull E paramE)
  {
    paramContext = init(paramContext, null).edit();
    if (((paramE instanceof String)) || ((paramE instanceof Integer)) || ((paramE instanceof Boolean)) || ((paramE instanceof Float)) || ((paramE instanceof Long)) || ((paramE instanceof Double))) {
      paramContext.putString(paramString2, String.valueOf(paramE));
    }
    SharedPreferencesCompat.EditorCompat.getInstance().apply(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SPUtils
 * JD-Core Version:    0.7.0.1
 */