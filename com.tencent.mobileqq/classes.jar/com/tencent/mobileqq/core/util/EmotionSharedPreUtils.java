package com.tencent.mobileqq.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EmotionSharedPreUtils
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_last_tab");
    return paramContext.getInt(localStringBuilder.toString(), -1);
  }
  
  public static Object a(String paramString, Object paramObject)
  {
    return BaseSharedPreUtil.a(MobileQQ.getContext(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), paramString, paramObject);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_last_tab");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_remove_emoticon_package_time_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_edit_guide_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void a(String paramString, Object paramObject)
  {
    BaseSharedPreUtil.a(MobileQQ.getContext(), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), true, paramString, paramObject);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_edit_guide_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.core.util.EmotionSharedPreUtils
 * JD-Core Version:    0.7.0.1
 */