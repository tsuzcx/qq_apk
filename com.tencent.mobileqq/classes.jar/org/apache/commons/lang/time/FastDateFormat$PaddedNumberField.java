package org.apache.commons.lang.time;

import java.util.Calendar;
import org.apache.commons.lang.Validate;

class FastDateFormat$PaddedNumberField
  implements FastDateFormat.NumberRule
{
  private final int mField;
  private final int mSize;
  
  FastDateFormat$PaddedNumberField(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 3)
    {
      this.mField = paramInt1;
      this.mSize = paramInt2;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    int i;
    if (paramInt < 100)
    {
      i = this.mSize;
      for (;;)
      {
        i -= 1;
        if (i < 2) {
          break;
        }
        paramStringBuffer.append('0');
      }
      paramStringBuffer.append((char)(paramInt / 10 + 48));
      paramStringBuffer.append((char)(paramInt % 10 + 48));
      return;
    }
    if (paramInt < 1000)
    {
      i = 3;
    }
    else
    {
      boolean bool;
      if (paramInt > -1) {
        bool = true;
      } else {
        bool = false;
      }
      Validate.isTrue(bool, "Negative values should not be possible", paramInt);
      i = Integer.toString(paramInt).length();
    }
    int j = this.mSize;
    for (;;)
    {
      j -= 1;
      if (j < i) {
        break;
      }
      paramStringBuffer.append('0');
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
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.PaddedNumberField
 * JD-Core Version:    0.7.0.1
 */