package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TwoDigitYearField
  implements FastDateFormat.NumberRule
{
  static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append((char)(paramInt / 10 + 48));
    paramStringBuffer.append((char)(paramInt % 10 + 48));
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    appendTo(paramStringBuffer, paramCalendar.get(1) % 100);
  }
  
  public int estimateLength()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TwoDigitYearField
 * JD-Core Version:    0.7.0.1
 */