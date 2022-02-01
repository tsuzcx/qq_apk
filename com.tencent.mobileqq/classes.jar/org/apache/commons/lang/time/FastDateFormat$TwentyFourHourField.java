package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TwentyFourHourField
  implements FastDateFormat.NumberRule
{
  private final FastDateFormat.NumberRule mRule;
  
  FastDateFormat$TwentyFourHourField(FastDateFormat.NumberRule paramNumberRule)
  {
    this.mRule = paramNumberRule;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, int paramInt)
  {
    this.mRule.appendTo(paramStringBuffer, paramInt);
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int j = paramCalendar.get(11);
    int i = j;
    if (j == 0) {
      i = paramCalendar.getMaximum(11) + 1;
    }
    this.mRule.appendTo(paramStringBuffer, i);
  }
  
  public int estimateLength()
  {
    return this.mRule.estimateLength();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TwentyFourHourField
 * JD-Core Version:    0.7.0.1
 */