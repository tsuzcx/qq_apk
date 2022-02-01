package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TwoDigitMonthField
  implements FastDateFormat.NumberRule
{
  static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append((char)(paramInt / 10 + 48));
    paramStringBuffer.append((char)(paramInt % 10 + 48));
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    appendTo(paramStringBuffer, paramCalendar.get(2) + 1);
  }
  
  public int estimateLength()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TwoDigitMonthField
 * JD-Core Version:    0.7.0.1
 */