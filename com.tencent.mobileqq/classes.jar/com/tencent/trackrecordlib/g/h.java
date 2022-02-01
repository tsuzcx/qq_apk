package com.tencent.trackrecordlib.g;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class h
{
  private static final String a = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  private static final String b = "yyyyMMddHH";
  
  public static String a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(new Date());
  }
  
  public static String a(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(paramDate);
  }
  
  public static String b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHH", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(new Date());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.h
 * JD-Core Version:    0.7.0.1
 */