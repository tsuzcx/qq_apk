package com.tencent.weseevideo.model.template.light;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.weishi.module.publisher.interfaces.XffectsDownloadListener;
import com.tencent.weseevideo.model.utils.LocaleUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LightPatterHelper
{
  public static final float DEFAULT_LATITUDE = 9.0E+008F;
  public static final float DEFAULT_LONGITUDE = 9.0E+008F;
  public static final String DEFAULT_NICKNAME = "微视用户";
  public static final String FORMAT_DAY_IN_CHINESE = "date.d.zh_Hans";
  public static final String FORMAT_WEEK_IN_CHINESE = "date.EEE.zh_Hans";
  public static final String FORMAT_YEAR_IN_CHINESE = "date.yyyy.zh_Hans";
  public static final String KEY_AVATAR = "user.avatar";
  public static final String KEY_DATE = "date";
  public static final String KEY_LOCATION = "location";
  public static final String KEY_LOCATION_CITY = "location.city";
  public static final String KEY_LOCATION_COUNTRY = "location.country";
  public static final String KEY_LOCATION_LATITUDE = "location.latitude";
  public static final String KEY_LOCATION_LONGITUDE = "location.longitude";
  public static final String KEY_LOCATION_PROVINCE = "location.province";
  public static final String KEY_NICKNAME = "user.nickname";
  public static final String KEY_WATERMARK = "watermark";
  public static final String KEY_WEATHER = "weather";
  public static final String KEY_WEATHER_NAME = "weather.name";
  public static final String KEY_WEATHER_TEMPERATURE = "weather.temperature";
  private static final String TAG = "LightPatterHelper";
  @VisibleForTesting
  protected static HashMap<String, String> mDownloadImageMap = new HashMap();
  private static String[] numbs = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
  private static String[] pos_units = { "", "十", "百", "千" };
  private static String[] weight_units = { "", "万", "亿" };
  
  public static void fillAvatar(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString, XffectsDownloadListener paramXffectsDownloadListener)
  {
    if ((paramHashMap1 != null) && (!paramHashMap1.containsKey("user.avatar"))) {}
  }
  
  public static void fillDate(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2)
  {
    if ((paramHashMap1 == null) || (paramHashMap1.isEmpty())) {}
    for (;;)
    {
      return;
      paramHashMap1 = paramHashMap1.keySet().iterator();
      while (paramHashMap1.hasNext())
      {
        String str1 = (String)paramHashMap1.next();
        if (str1.startsWith("date"))
        {
          String str2 = getDateValueByKey(str1);
          if (!TextUtils.isEmpty(str2)) {
            paramHashMap2.put(str1, str2);
          }
        }
      }
    }
  }
  
  public static void fillLocation(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) {}
  
  public static void fillNickName(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) {}
  
  public static void fillWatermark(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) {}
  
  public static void fillWeather(HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2) {}
  
  private static String format(Date paramDate, String paramString1, String paramString2)
  {
    try
    {
      Logger.d("LightPatterHelper", "Date format: " + paramString1 + ", locale : " + paramString2);
      paramDate = new SimpleDateFormat(paramString1, LocaleUtils.getLocale(paramString2)).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      Logger.e("LightPatterHelper", "", paramDate);
    }
    return null;
  }
  
  @VisibleForTesting
  protected static Date getCurrentDate()
  {
    return new Date(System.currentTimeMillis());
  }
  
  private static String getDateValueByKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Logger.i("LightPatterHelper", "fillDate >> presetData中没有date信息.");
      return null;
    }
    if ("date.yyyy.zh_Hans".equals(paramString)) {
      return getYearInChinese(getDateValueByKey("date.yyyy"));
    }
    if ("date.EEE.zh_Hans".equals(paramString)) {
      return getWeekChinese(getCurrentDate());
    }
    if ("date.d.zh_Hans".equals(paramString)) {
      return numberToChinese(Integer.parseInt(getDateValueByKey("date.d")));
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length < 2)
    {
      Logger.e("LightPatterHelper", "fillDate >> 日期key格式不对. dateKey：" + paramString + ". spiltFormats:" + arrayOfString);
      return null;
    }
    String str = arrayOfString[1];
    paramString = "";
    if (arrayOfString.length >= 3) {
      paramString = arrayOfString[2];
    }
    return format(getCurrentDate(), str, paramString);
  }
  
  public static String getWeekChinese(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    switch (localCalendar.get(7))
    {
    default: 
      return "周六";
    case 1: 
      return "周日";
    case 2: 
      return "周一";
    case 3: 
      return "周二";
    case 4: 
      return "周三";
    case 5: 
      return "周四";
    }
    return "周五";
  }
  
  private static String getYearInChinese(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      int i = 0;
      while (i < paramString.length())
      {
        ((StringBuilder)localObject).append(numbs[Integer.parseInt(String.valueOf(paramString.charAt(i)))]);
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return paramString;
  }
  
  public static String numberToChinese(int paramInt)
  {
    Object localObject1;
    if (paramInt == 0) {
      localObject1 = "零";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject1 = "";
      int k = 0;
      int i = 0;
      int j = paramInt;
      paramInt = k;
      if (j > 0)
      {
        k = j % 10000;
        localObject2 = localObject1;
        if (paramInt != 0) {
          localObject2 = numbs[0] + (String)localObject1;
        }
        String str = sectionTrans(k);
        localObject1 = str;
        if (k != 0) {
          localObject1 = str + weight_units[i];
        }
        localObject1 = (String)localObject1 + (String)localObject2;
        Logger.d("LightPatterHelper", "");
        if ((k < 1000) && (k > 0)) {}
        for (paramInt = 1;; paramInt = 0)
        {
          j /= 10000;
          i += 1;
          break;
        }
      }
      if (((String)localObject1).length() != 2)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() != 3) {}
      }
      else
      {
        localObject2 = localObject1;
        if (((String)localObject1).contains("一十")) {
          localObject2 = ((String)localObject1).substring(1, ((String)localObject1).length());
        }
      }
      localObject1 = localObject2;
    } while (((String)localObject2).indexOf("一十") != 0);
    return ((String)localObject2).replaceFirst("一十", "十");
  }
  
  public static String sectionTrans(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 1;
    int j = 0;
    int i = paramInt;
    if (i > 0)
    {
      paramInt = i % 10;
      if (paramInt == 0)
      {
        paramInt = k;
        if (k == 0) {
          localStringBuilder.insert(0, numbs[0]);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        j += 1;
        i /= 10;
        k = paramInt;
        break;
        localStringBuilder.insert(0, pos_units[j]);
        localStringBuilder.insert(0, numbs[paramInt]);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightPatterHelper
 * JD-Core Version:    0.7.0.1
 */