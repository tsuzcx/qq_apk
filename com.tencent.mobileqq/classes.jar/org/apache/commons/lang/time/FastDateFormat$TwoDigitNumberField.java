package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TwoDigitNumberField
  implements FastDateFormat.NumberRule
{
  private final int mField;
  
  FastDateFormat$TwoDigitNumberField(int paramInt)
  {
    this.mField = paramInt;
  }
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    if (paramInt < 100)
    {
      paramStringBuffer.append((char)(paramInt / 10 + 48));
      paramStringBuffer.append((char)(paramInt % 10 + 48));
      return;
    }
    paramStringBuffer.append(Integer.toString(paramInt));
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    appendTo(paramStringBuffer, paramCalendar.get(this.mField));
  }
  
  public int estimateLength()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TwoDigitNumberField
 * JD-Core Version:    0.7.0.1
 */