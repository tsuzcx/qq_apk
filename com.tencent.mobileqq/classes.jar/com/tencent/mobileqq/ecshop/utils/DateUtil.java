package com.tencent.mobileqq.ecshop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil
{
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.DateUtil
 * JD-Core Version:    0.7.0.1
 */