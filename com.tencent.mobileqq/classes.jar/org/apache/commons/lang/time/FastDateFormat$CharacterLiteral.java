package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$CharacterLiteral
  implements FastDateFormat.Rule
{
  private final char mValue;
  
  FastDateFormat$CharacterLiteral(char paramChar)
  {
    this.mValue = paramChar;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    paramStringBuffer.append(this.mValue);
  }
  
  public int estimateLength()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.CharacterLiteral
 * JD-Core Version:    0.7.0.1
 */