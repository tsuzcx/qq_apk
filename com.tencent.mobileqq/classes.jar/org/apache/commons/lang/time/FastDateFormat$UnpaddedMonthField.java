package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$UnpaddedMonthField
  implements FastDateFormat.NumberRule
{
  static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    if (paramInt < 10)
    {
      paramStringBuffer.append((char)(paramInt + 48));
      return;
    }
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
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.UnpaddedMonthField
 * JD-Core Version:    0.7.0.1
 */