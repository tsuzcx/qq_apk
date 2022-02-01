package org.apache.commons.lang.time;

import java.util.Calendar;

class FastDateFormat$TimeZoneNumberRule
  implements FastDateFormat.Rule
{
  static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
  static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
  final boolean mColon;
  
  FastDateFormat$TimeZoneNumberRule(boolean paramBoolean)
  {
    this.mColon = paramBoolean;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    int i = paramCalendar.get(15) + paramCalendar.get(16);
    if (i < 0)
    {
      paramStringBuffer.append('-');
      i = -i;
    }
    else
    {
      paramStringBuffer.append('+');
    }
    int j = i / 3600000;
    paramStringBuffer.append((char)(j / 10 + 48));
    paramStringBuffer.append((char)(j % 10 + 48));
    if (this.mColon) {
      paramStringBuffer.append(':');
    }
    i = i / 60000 - j * 60;
    paramStringBuffer.append((char)(i / 10 + 48));
    paramStringBuffer.append((char)(i % 10 + 48));
  }
  
  public int estimateLength()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TimeZoneNumberRule
 * JD-Core Version:    0.7.0.1
 */