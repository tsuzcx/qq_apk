package org.apache.commons.lang.time;

import java.util.Calendar;

abstract interface FastDateFormat$Rule
{
  public abstract void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar);
  
  public abstract int estimateLength();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.Rule
 * JD-Core Version:    0.7.0.1
 */