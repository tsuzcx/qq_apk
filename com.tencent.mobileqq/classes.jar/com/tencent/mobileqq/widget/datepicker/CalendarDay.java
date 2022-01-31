package com.tencent.mobileqq.widget.datepicker;

import java.io.Serializable;
import java.util.Calendar;

public class CalendarDay
  implements Serializable
{
  private static Calendar a;
  private static final long serialVersionUID = -5456695978688356202L;
  private Calendar calendar;
  public int day;
  public int month;
  public int year;
  
  public CalendarDay(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.calendar == null) {
      this.calendar = Calendar.getInstance();
    }
    this.calendar.set(paramInt1, paramInt2, paramInt3, 0, 0, 0);
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
  }
  
  public CalendarDay(long paramLong)
  {
    if (this.calendar == null) {
      this.calendar = Calendar.getInstance();
    }
    this.calendar.setTimeInMillis(paramLong);
    this.month = this.calendar.get(2);
    this.year = this.calendar.get(1);
    this.day = this.calendar.get(5);
  }
  
  public static long dayToTimeMillis(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2, paramInt3, 0, 0, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static int getDaysInMonth(int paramInt1, int paramInt2)
  {
    try
    {
      if (a == null) {
        a = Calendar.getInstance();
      }
      a.clear();
      a.set(1, paramInt1);
      a.set(2, paramInt2);
      paramInt1 = a.getActualMaximum(5);
      return paramInt1;
    }
    finally {}
  }
  
  public long getTimeInMillis()
  {
    if (this.calendar != null) {
      return this.calendar.getTimeInMillis();
    }
    return 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ year: ");
    localStringBuilder.append(this.year);
    localStringBuilder.append(", month: ");
    localStringBuilder.append(this.month);
    localStringBuilder.append(", day: ");
    localStringBuilder.append(this.day);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.CalendarDay
 * JD-Core Version:    0.7.0.1
 */