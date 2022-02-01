package org.apache.commons.lang.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatUtils
{
  public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
  public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
  public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
  public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
  public static final FastDateFormat ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
  public static final FastDateFormat ISO_TIME_NO_T_FORMAT = FastDateFormat.getInstance("HH:mm:ss");
  public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = FastDateFormat.getInstance("HH:mm:ssZZ");
  public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
  public static final FastDateFormat SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
  
  public static String format(long paramLong, String paramString)
  {
    return format(new Date(paramLong), paramString, null, null);
  }
  
  public static String format(long paramLong, String paramString, Locale paramLocale)
  {
    return format(new Date(paramLong), paramString, null, paramLocale);
  }
  
  public static String format(long paramLong, String paramString, TimeZone paramTimeZone)
  {
    return format(new Date(paramLong), paramString, paramTimeZone, null);
  }
  
  public static String format(long paramLong, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return format(new Date(paramLong), paramString, paramTimeZone, paramLocale);
  }
  
  public static String format(Calendar paramCalendar, String paramString)
  {
    return format(paramCalendar, paramString, null, null);
  }
  
  public static String format(Calendar paramCalendar, String paramString, Locale paramLocale)
  {
    return format(paramCalendar, paramString, null, paramLocale);
  }
  
  public static String format(Calendar paramCalendar, String paramString, TimeZone paramTimeZone)
  {
    return format(paramCalendar, paramString, paramTimeZone, null);
  }
  
  public static String format(Calendar paramCalendar, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return FastDateFormat.getInstance(paramString, paramTimeZone, paramLocale).format(paramCalendar);
  }
  
  public static String format(Date paramDate, String paramString)
  {
    return format(paramDate, paramString, null, null);
  }
  
  public static String format(Date paramDate, String paramString, Locale paramLocale)
  {
    return format(paramDate, paramString, null, paramLocale);
  }
  
  public static String format(Date paramDate, String paramString, TimeZone paramTimeZone)
  {
    return format(paramDate, paramString, paramTimeZone, null);
  }
  
  public static String format(Date paramDate, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return FastDateFormat.getInstance(paramString, paramTimeZone, paramLocale).format(paramDate);
  }
  
  public static String formatUTC(long paramLong, String paramString)
  {
    return format(new Date(paramLong), paramString, DateUtils.UTC_TIME_ZONE, null);
  }
  
  public static String formatUTC(long paramLong, String paramString, Locale paramLocale)
  {
    return format(new Date(paramLong), paramString, DateUtils.UTC_TIME_ZONE, paramLocale);
  }
  
  public static String formatUTC(Date paramDate, String paramString)
  {
    return format(paramDate, paramString, DateUtils.UTC_TIME_ZONE, null);
  }
  
  public static String formatUTC(Date paramDate, String paramString, Locale paramLocale)
  {
    return format(paramDate, paramString, DateUtils.UTC_TIME_ZONE, paramLocale);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.DateFormatUtils
 * JD-Core Version:    0.7.0.1
 */