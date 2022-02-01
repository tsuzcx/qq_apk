package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TextField
  implements FastDateFormat.Rule
{
  private final int mField;
  private final String[] mValues;
  
  FastDateFormat$TextField(int paramInt, String[] paramArrayOfString)
  {
    this.mField = paramInt;
    this.mValues = paramArrayOfString;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    paramStringBuffer.append(this.mValues[paramCalendar.get(this.mField)]);
  }
  
  public int estimateLength()
  {
    int i = this.mValues.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (k < 0) {
        break;
      }
      int m = this.mValues[k].length();
      i = k;
      if (m > j)
      {
        j = m;
        i = k;
      }
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TextField
 * JD-Core Version:    0.7.0.1
 */