package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat.EditorCompat;

public class SPUtils
{
  public static final String LAST_APP_HEART_BEAT = "last_app_heart_beat";
  public static final String LAST_AUDIO_HEART_BEAT_MAP = "last_audio_heart_beat_map";
  public static final String PREF_DEVICE_ACTIVATED = "pref_device_activated";
  private static final String VIDEO_REPORT_PROFILE = "video_report_profile";
  public static SharedPreferences sp;
  
  @NonNull
  public static <E> E get(@NonNull Context paramContext, @NonNull String paramString, @NonNull E paramE)
  {
    paramString = init(paramContext).getString(paramString, String.valueOf(paramE));
    if ((paramE instanceof String)) {
      paramContext = paramString;
    }
    do
    {
      return paramContext;
      if ((paramE instanceof Integer)) {
        return Integer.valueOf(paramString);
      }
      if ((paramE instanceof Boolean)) {
        return Boolean.valueOf(paramString);
      }
      if ((paramE instanceof Float)) {
        return Float.valueOf(paramString);
      }
      if ((paramE instanceof Long)) {
        return Long.valueOf(paramString);
      }
      paramContext = paramE;
    } while (!(paramE instanceof Double));
    return Double.valueOf(paramString);
  }
  
  private static SharedPreferences init(@NonNull Context paramContext)
  {
    if (sp == null)
    {
      paramContext = paramContext.getSharedPreferences("video_report_profile", 0);
      sp = paramContext;
      return paramContext;
    }
    return sp;
  }
  
  public static <E> void put(@NonNull Context paramContext, @NonNull String paramString, @NonNull E paramE)
  {
    paramContext = init(paramContext).edit();
    if (((paramE instanceof String)) || ((paramE instanceof Integer)) || ((paramE instanceof Boolean)) || ((paramE instanceof Float)) || ((paramE instanceof Long)) || ((paramE instanceof Double))) {
      paramContext.putString(paramString, String.valueOf(paramE));
    }
    SharedPreferencesCompat.EditorCompat.getInstance().apply(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SPUtils
 * JD-Core Version:    0.7.0.1
 */