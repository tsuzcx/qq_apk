package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$StringLiteral
  implements FastDateFormat.Rule
{
  private final String mValue;
  
  FastDateFormat$StringLiteral(String paramString)
  {
    this.mValue = paramString;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    paramStringBuffer.append(this.mValue);
  }
  
  public int estimateLength()
  {
    return this.mValue.length();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.StringLiteral
 * JD-Core Version:    0.7.0.1
 */