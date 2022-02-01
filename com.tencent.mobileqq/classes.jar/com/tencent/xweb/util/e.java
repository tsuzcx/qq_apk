package com.tencent.xweb.util;

import android.text.TextUtils;
import java.util.Calendar;
import org.xwalk.core.Log;

public class e
{
  public static double a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    Double.isNaN(d2);
    d2 /= 60.0D;
    Double.isNaN(d1);
    return d1 + d2;
  }
  
  public static long a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    return (24 - i) * 3600000L - j * 60000L;
  }
  
  public static long a(Calendar paramCalendar)
  {
    int i = paramCalendar.get(11);
    int j = paramCalendar.get(12);
    int k = paramCalendar.get(13);
    return (24 - i) * 3600000L - j * 60000L - k * 1000;
  }
  
  public static e.a a(String paramString)
  {
    e.a locala = new e.a();
    try
    {
      locala.b = Double.valueOf(Double.parseDouble(paramString));
      locala.a = true;
      return locala;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safeGetDouble failed : ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("NumberUtil", localStringBuilder.toString());
    }
    return locala;
  }
  
  public static double b()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(11);
    double d2 = localCalendar.get(12);
    double d1 = i;
    Double.isNaN(d2);
    d2 /= 60.0D;
    Double.isNaN(d1);
    return d1 + d2;
  }
  
  public static double b(Calendar paramCalendar)
  {
    int i = paramCalendar.get(11);
    double d2 = paramCalendar.get(12);
    double d1 = i;
    Double.isNaN(d2);
    d2 /= 60.0D;
    Double.isNaN(d1);
    return d1 + d2;
  }
  
  public static e.a b(String paramString)
  {
    e.a locala = new e.a();
    try
    {
      for (paramString = paramString.trim(); (paramString.startsWith("0")) && (paramString.length() > 1); paramString = paramString.substring(1)) {}
      locala.b = Integer.valueOf(Integer.parseInt(paramString));
      locala.a = true;
      return locala;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("safeParseInt failed : ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("NumberUtil", localStringBuilder.toString());
    }
    return locala;
  }
  
  public static double c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1.0D;
    }
    paramString = paramString.split(":");
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return -1.0D;
      }
      e.a locala = a(paramString[0]);
      if (!locala.a) {
        return -1.0D;
      }
      double d2 = locala.a();
      double d1 = d2;
      if (paramString.length == 2)
      {
        int i = b(paramString[1]).b();
        if (i >= 0)
        {
          if (i >= 60) {
            return -1.0D;
          }
          d1 = i;
          Double.isNaN(d1);
          d1 = d2 + d1 * 1.0D / 60.0D;
        }
        else
        {
          return -1.0D;
        }
      }
      if (d1 >= 0.0D)
      {
        if (d1 > 24.0D) {
          return -1.0D;
        }
        return d1;
      }
    }
    return -1.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */