package cooperation.qzone.util;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Calendar;

public class DateUtils
{
  public static final String BEFOREY_YESTERDAY;
  public static final String COLON = ":";
  public static final String DAY = HardCodeUtil.a(2131703008);
  public static final long DAY_MILLIS_SECOND = 86400000L;
  public static final int DAY_SECOND = 86400;
  public static final String JUST_MINS = HardCodeUtil.a(2131703012);
  public static final String MONTH;
  public static final String TODAY;
  public static final long TWO_DAY_MILLIS_SECOND = 172800000L;
  public static final String YEAR;
  public static final String YESTERDAY = HardCodeUtil.a(2131702984);
  
  static
  {
    TODAY = HardCodeUtil.a(2131702966);
    BEFOREY_YESTERDAY = HardCodeUtil.a(2131703005);
    YEAR = HardCodeUtil.a(2131702975);
    MONTH = HardCodeUtil.a(2131702970);
  }
  
  static String doubleD(int paramInt)
  {
    if (paramInt < 10)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('0');
      localStringBuilder.append(String.valueOf(paramInt));
      return localStringBuilder.toString();
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
      if (l2 < 0L)
      {
        paramCalendar = new StringBuilder();
        paramCalendar.append(TODAY);
        paramCalendar.append(doubleD(i));
        paramCalendar.append(":");
        paramCalendar.append(doubleD(j));
        return paramCalendar.toString();
      }
      if ((l2 >= 0L) && (l2 < 86400000L))
      {
        paramCalendar = new StringBuilder();
        paramCalendar.append(YESTERDAY);
        paramCalendar.append(doubleD(i));
        paramCalendar.append(":");
        paramCalendar.append(doubleD(j));
        return paramCalendar.toString();
      }
      if ((l2 >= 86400000L) && (l2 <= 172800500L))
      {
        paramCalendar = new StringBuilder();
        paramCalendar.append(BEFOREY_YESTERDAY);
        paramCalendar.append(doubleD(i));
        paramCalendar.append(":");
        paramCalendar.append(doubleD(j));
        return paramCalendar.toString();
      }
    }
    else if ((l2 < 0L) && (isSameDay(paramCalendar.getTimeInMillis(), paramLong)))
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append(TODAY);
      paramCalendar.append(doubleD(i));
      paramCalendar.append(":");
      paramCalendar.append(doubleD(j));
      return paramCalendar.toString();
    }
    int k = localCalendar.get(1);
    int m = localCalendar.get(2) + 1;
    int n = localCalendar.get(5);
    if (paramCalendar.get(1) != k)
    {
      paramCalendar = new StringBuilder();
      paramCalendar.append(k);
      paramCalendar.append(YEAR);
      paramCalendar.append(doubleD(m));
      paramCalendar.append(MONTH);
      paramCalendar.append(doubleD(n));
      paramCalendar.append(DAY);
      paramCalendar.append(" ");
      paramCalendar.append(doubleD(i));
      paramCalendar.append(":");
      paramCalendar.append(doubleD(j));
      return paramCalendar.toString();
    }
    paramCalendar = new StringBuilder();
    paramCalendar.append(doubleD(m));
    paramCalendar.append(MONTH);
    paramCalendar.append(doubleD(n));
    paramCalendar.append(DAY);
    paramCalendar.append(doubleD(i));
    paramCalendar.append(":");
    paramCalendar.append(doubleD(j));
    return paramCalendar.toString();
  }
  
  public static final String getDisplayTimeForFeedEntry(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    paramLong = ((Calendar)localObject).getTimeInMillis();
    long l2 = getTodayTime0((Calendar)localObject);
    long l1 = localCalendar.getTimeInMillis();
    l2 -= localCalendar.getTimeInMillis();
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
    if ((l2 >= 86400000L) && (l2 <= 777600000L))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append((int)(l2 / 86400000L));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131702993));
      return ((StringBuilder)localObject).toString();
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