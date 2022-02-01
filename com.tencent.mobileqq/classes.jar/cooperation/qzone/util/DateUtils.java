package cooperation.qzone.util;

import amtj;
import java.util.Calendar;

public class DateUtils
{
  public static final String BEFOREY_YESTERDAY;
  public static final String COLON = ":";
  public static final String DAY = amtj.a(2131701978);
  public static final long DAY_MILLIS_SECOND = 86400000L;
  public static final int DAY_SECOND = 86400;
  public static final String JUST_MINS = amtj.a(2131701983);
  public static final String MONTH;
  public static final String TODAY;
  public static final long TWO_DAY_MILLIS_SECOND = 172800000L;
  public static final String YEAR;
  public static final String YESTERDAY = amtj.a(2131701954);
  
  static
  {
    TODAY = amtj.a(2131701935);
    BEFOREY_YESTERDAY = amtj.a(2131701975);
    YEAR = amtj.a(2131701945);
    MONTH = amtj.a(2131701939);
  }
  
  static String doubleD(int paramInt)
  {
    if (paramInt < 10) {
      return '0' + String.valueOf(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  public static final String getDisplayTime(long paramLong, Calendar paramCalendar)
  {
    long l2 = paramCalendar.getTimeInMillis();
    long l3 = paramCalendar.get(11) * 60 * 60 * 1000;
    long l4 = paramCalendar.get(12) * 60 * 1000;
    long l5 = paramCalendar.get(13) * 1000;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    long l1 = paramCalendar.getTimeInMillis();
    l2 = l2 - l3 - l4 - l5 - paramLong;
    int i = localCalendar.get(11);
    int j = localCalendar.get(12);
    if (l1 - paramLong >= 0L)
    {
      if (l2 < 0L) {
        return TODAY + doubleD(i) + ":" + doubleD(j);
      }
      if ((l2 >= 0L) && (l2 < 86400000L)) {
        return YESTERDAY + doubleD(i) + ":" + doubleD(j);
      }
      if ((l2 >= 86400000L) && (l2 <= 172800500L)) {
        return BEFOREY_YESTERDAY + doubleD(i) + ":" + doubleD(j);
      }
    }
    else if ((l2 < 0L) && (isSameDay(paramCalendar.getTimeInMillis(), paramLong)))
    {
      return TODAY + doubleD(i) + ":" + doubleD(j);
    }
    int k = localCalendar.get(1);
    int m = localCalendar.get(2) + 1;
    int n = localCalendar.get(5);
    if (paramCalendar.get(1) != k) {
      return k + YEAR + doubleD(m) + MONTH + doubleD(n) + DAY + " " + doubleD(i) + ":" + doubleD(j);
    }
    return doubleD(m) + MONTH + doubleD(n) + DAY + doubleD(i) + ":" + doubleD(j);
  }
  
  public static final String getDisplayTimeForFeedEntry(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong);
    paramLong = localCalendar1.getTimeInMillis();
    long l2 = getTodayTime0(localCalendar1);
    long l1 = localCalendar2.getTimeInMillis();
    l2 -= localCalendar2.getTimeInMillis();
    paramLong = (paramLong - l1) / 1000L;
    if ((paramLong >= 0L) && (paramLong < 7200L)) {
      return JUST_MINS;
    }
    if (l2 < 0L) {
      return TODAY;
    }
    if ((l2 > 0L) && (l2 < 86400000L)) {
      return YESTERDAY;
    }
    if ((l2 >= 86400000L) && (l2 <= 777600000L)) {
      return (int)(l2 / 86400000L) + amtj.a(2131701963);
    }
    return "";
  }
  
  public static final long getTodayTime0(Calendar paramCalendar)
  {
    return paramCalendar.getTimeInMillis() - paramCalendar.get(11) * 60 * 60 * 1000 - paramCalendar.get(12) * 60 * 1000 - paramCalendar.get(13) * 1000 - paramCalendar.get(14);
  }
  
  public static boolean isSameDay(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.DateUtils
 * JD-Core Version:    0.7.0.1
 */