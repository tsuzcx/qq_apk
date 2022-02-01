package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$UnpaddedNumberField
  implements FastDateFormat.NumberRule
{
  private final int mField;
  
  FastDateFormat$UnpaddedNumberField(int paramInt)
  {
    this.mField = paramInt;
  }
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    if (paramInt < 10)
    {
      paramStringBuffer.append((char)(paramInt + 48));
      return;
    }
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
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.UnpaddedNumberField
 * JD-Core Version:    0.7.0.1
 */