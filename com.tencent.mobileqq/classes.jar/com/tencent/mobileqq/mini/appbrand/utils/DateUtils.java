package com.tencent.mobileqq.mini.appbrand.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
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
    Object localObject;
    if (paramString.length() >= 10)
    {
      if (Pattern.compile(HardCodeUtil.a(2131702994)).matcher(paramString).matches()) {
        localObject = new SimpleDateFormat("yyyy年MM月dd日");
      } else {
        localObject = new SimpleDateFormat("yyyy-MM-dd");
      }
    }
    else if (paramString.length() >= 7) {
      localObject = new SimpleDateFormat("yyyy-MM");
    } else if (paramString.length() >= 4) {
      localObject = new SimpleDateFormat("yyyy");
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDateByStrTime exception.");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("DateUtils", 1, ((StringBuilder)localObject).toString());
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */