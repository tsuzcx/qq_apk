package org.apache.commons.lang.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

class FastDateFormat$TimeZoneNameRule
  implements FastDateFormat.Rule
{
  private final String mDaylight;
  private final Locale mLocale;
  private final String mStandard;
  private final int mStyle;
  private final TimeZone mTimeZone;
  private final boolean mTimeZoneForced;
  
  FastDateFormat$TimeZoneNameRule(TimeZone paramTimeZone, boolean paramBoolean, Locale paramLocale, int paramInt)
  {
    this.mTimeZone = paramTimeZone;
    this.mTimeZoneForced = paramBoolean;
    this.mLocale = paramLocale;
    this.mStyle = paramInt;
    if (paramBoolean)
    {
      this.mStandard = FastDateFormat.getTimeZoneDisplay(paramTimeZone, false, paramInt, paramLocale);
      this.mDaylight = FastDateFormat.getTimeZoneDisplay(paramTimeZone, true, paramInt, paramLocale);
      return;
    }
    this.mStandard = null;
    this.mDaylight = null;
  }
  
  public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
  {
    if (this.mTimeZoneForced)
    {
      if ((this.mTimeZone.useDaylightTime()) && (paramCalendar.get(16) != 0))
      {
        paramStringBuffer.append(this.mDaylight);
        return;
      }
      paramStringBuffer.append(this.mStandard);
      return;
    }
    TimeZone localTimeZone = paramCalendar.getTimeZone();
    if ((localTimeZone.useDaylightTime()) && (paramCalendar.get(16) != 0))
    {
      paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, true, this.mStyle, this.mLocale));
      return;
    }
    paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, false, this.mStyle, this.mLocale));
  }
  
  public int estimateLength()
  {
    if (this.mTimeZoneForced) {
      return Math.max(this.mStandard.length(), this.mDaylight.length());
    }
    if (this.mStyle == 0) {
      return 4;
    }
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TimeZoneNameRule
 * JD-Core Version:    0.7.0.1
 */