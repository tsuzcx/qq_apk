package com.tencent.mobileqq.kandian.biz.notecard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyNoteCardUtil
{
  static float a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(217);
    if (Build.MODEL.startsWith("NXT")) {
      return localAladdinConfig.getFloatFromString("blow_level_android_huawei_mate_8", 0.95F);
    }
    return localAladdinConfig.getFloatFromString("blow_level_android", 1.0F);
  }
  
  public static int a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(217);
    int i = 0;
    if (localAladdinConfig != null) {
      i = localAladdinConfig.getIntegerFromString("zhitiao_feedsrefresh_type", 0);
    }
    return i;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyNoteCardRspCount_");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (TextUtils.isEmpty(paramContext)) {
      return 0;
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      if (DateUtils.isToday(paramContext.optLong("timeStamp")))
      {
        int i = paramContext.optInt("count");
        return i;
      }
      return 0;
    }
    catch (JSONException paramContext) {}
    return 0;
  }
  
  public static String a()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_return_maintext", "");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyNoteCardShowGuideCountByRowKey_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("count", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyNoteCardRspCount_");
    localStringBuilder.append(paramString);
    paramContext.putString(localStringBuilder.toString(), localJSONObject.toString());
    paramContext.apply();
  }
  
  public static int b()
  {
    return Aladdin.getConfig(217).getIntegerFromString("guide_card_max_sum", 5);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyNoteCardShowGuideCountByRowKey_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String b()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_return_smalltext", "");
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("count", paramLong);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyTodayShowGuideCount_");
    localStringBuilder.append(paramString);
    paramContext.putString(localStringBuilder.toString(), localJSONObject.toString());
    paramContext.apply();
  }
  
  public static int c()
  {
    return Aladdin.getConfig(217).getIntegerFromString("guide_card_max_daily", 3);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyTodayShowGuideCount_");
    localStringBuilder.append(paramString);
    paramContext = paramContext.getString(localStringBuilder.toString(), "");
    if (TextUtils.isEmpty(paramContext)) {
      return 0;
    }
    try
    {
      paramContext = new JSONObject(paramContext);
      if (DateUtils.isToday(paramContext.optLong("timeStamp")))
      {
        int i = paramContext.optInt("count");
        return i;
      }
      return 0;
    }
    catch (JSONException paramContext) {}
    return 0;
  }
  
  public static String c()
  {
    return Aladdin.getConfig(217).getString("zhitiao_feeds_text", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.notecard.ReadInJoyNoteCardUtil
 * JD-Core Version:    0.7.0.1
 */