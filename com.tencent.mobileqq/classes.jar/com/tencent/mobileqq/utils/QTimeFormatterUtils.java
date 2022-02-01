package com.tencent.mobileqq.utils;

import java.util.Calendar;

public class QTimeFormatterUtils
{
  public static long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L) {
      l = System.currentTimeMillis();
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l / 1000L * 1000L);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QTimeFormatterUtils
 * JD-Core Version:    0.7.0.1
 */