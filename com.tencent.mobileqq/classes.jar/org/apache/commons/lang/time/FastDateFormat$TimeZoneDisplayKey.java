package org.apache.commons.lang.time;

import java.util.Locale;
import java.util.TimeZone;

class FastDateFormat$TimeZoneDisplayKey
{
  private final Locale mLocale;
  private final int mStyle;
  private final TimeZone mTimeZone;
  
  FastDateFormat$TimeZoneDisplayKey(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
  {
    this.mTimeZone = paramTimeZone;
    int i = paramInt;
    if (paramBoolean) {
      i = paramInt | 0x80000000;
    }
    this.mStyle = i;
    this.mLocale = paramLocale;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof TimeZoneDisplayKey))
    {
      paramObject = (TimeZoneDisplayKey)paramObject;
      return (this.mTimeZone.equals(paramObject.mTimeZone)) && (this.mStyle == paramObject.mStyle) && (this.mLocale.equals(paramObject.mLocale));
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mStyle * 31 + this.mLocale.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.FastDateFormat.TimeZoneDisplayKey
 * JD-Core Version:    0.7.0.1
 */