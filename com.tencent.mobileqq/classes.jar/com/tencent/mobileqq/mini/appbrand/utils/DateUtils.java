package com.tencent.mobileqq.mini.appbrand.utils;

import alud;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils
{
  private static final String TAG = "DateUtils";
  
  public static long dateToLong(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static long dateToLong(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      long l = paramSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static Date getDateByStrTime(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      paramString = paramSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int getDayByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(5);
  }
  
  public static int getHour(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(11);
  }
  
  public static int getMinute(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(12);
  }
  
  public static int getMonthByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(2);
  }
  
  public static Date getSmartDateByTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat;
    if (paramString.length() >= 10) {
      if (Pattern.compile(alud.a(2131703215)).matcher(paramString).matches()) {
        localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      }
    }
    for (;;)
    {
      if (localSimpleDateFormat == null)
      {
        return null;
        localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        continue;
        if (paramString.length() >= 7)
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
          continue;
        }
        if (paramString.length() >= 4) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy");
        }
      }
      else
      {
        try
        {
          paramString = localSimpleDateFormat.parse(paramString);
          return paramString;
        }
        catch (ParseException paramString)
        {
          paramString.printStackTrace();
          QLog.e("DateUtils", 1, "getDateByStrTime exception." + paramString);
          return null;
        }
      }
      localSimpleDateFormat = null;
    }
  }
  
  public static Date getTimeByStrTime(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int getYearByDateStr(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */