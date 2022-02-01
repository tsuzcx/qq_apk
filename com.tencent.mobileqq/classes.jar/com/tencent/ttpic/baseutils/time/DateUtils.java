package com.tencent.ttpic.baseutils.time;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
  public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
  public static final SimpleDateFormat DEFAULT_DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");
  public static final SimpleDateFormat DEFAULT_FORMAT;
  public static final SimpleDateFormat EXIF_DATE_FORMAT;
  public static final SimpleDateFormat SERVER_DATE_FORMAT;
  private static final String TAG = DateUtils.class.getSimpleName();
  
  static
  {
    DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SERVER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmm");
    EXIF_DATE_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }
  
  public static long calcTimeCost(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static int daysBetween(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd");
      paramString1 = ((SimpleDateFormat)localObject).parse(paramString1);
      paramString2 = ((SimpleDateFormat)localObject).parse(paramString2);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString1);
      long l = ((Calendar)localObject).getTimeInMillis();
      ((Calendar)localObject).setTime(paramString2);
      l = (((Calendar)localObject).getTimeInMillis() - l) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString1)
    {
      LogUtils.e(TAG, paramString1.getMessage());
    }
    return 0;
  }
  
  public static String format(Date paramDate)
  {
    return DEFAULT_FORMAT.format(paramDate);
  }
  
  public static String getCurrentServerFormat()
  {
    try
    {
      Object localObject1 = new Date();
      localObject1 = SERVER_DATE_FORMAT.format((Date)localObject1);
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public static Date getDefaultDate(String paramString)
  {
    try
    {
      paramString = parse(paramString, DEFAULT_FORMAT);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String getFormattedCurrentDate()
  {
    Date localDate = new Date();
    return DEFAULT_DATE_FORMAT.format(localDate);
  }
  
  public static String getFormattedCurrentDay()
  {
    Date localDate = new Date();
    return DEFAULT_DAY_FORMAT.format(localDate);
  }
  
  public static String getFormattedDayByDate(Date paramDate)
  {
    return DEFAULT_DAY_FORMAT.format(paramDate);
  }
  
  public static Date getServerDate(String paramString)
  {
    try
    {
      paramString = parse(paramString, SERVER_DATE_FORMAT);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static Date parse(String paramString)
  {
    try
    {
      paramString = DEFAULT_FORMAT.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  public static Date parse(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new SimpleDateFormat(paramString2).parse(paramString1);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      LogUtils.e(paramString1);
    }
    return null;
  }
  
  public static Date parse(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    try
    {
      paramString = paramSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.time.DateUtils
 * JD-Core Version:    0.7.0.1
 */