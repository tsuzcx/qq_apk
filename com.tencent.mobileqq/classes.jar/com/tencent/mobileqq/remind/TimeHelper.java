package com.tencent.mobileqq.remind;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeHelper
{
  public static int a = 25568;
  public static String[] b = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };
  public static String[] c = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" };
  
  public static int a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(11);
  }
  
  public static long a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramInt1 * 86400L * 1000L);
    localCalendar.set(11, paramInt2);
    localCalendar.set(12, paramInt3);
    try
    {
      long l = localCalendar.getTimeInMillis();
      return l;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label44:
      break label44;
    }
    return new Date().getTime();
  }
  
  public static String a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date();
    localDate.setTime(paramInt * 86400L * 1000L);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 E");
    if (localSimpleDateFormat.format(localDate).equals(localSimpleDateFormat.format(localCalendar.getTime()))) {
      return HardCodeUtil.a(2131912262);
    }
    return localSimpleDateFormat.format(localDate);
  }
  
  public static int b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localCalendar.get(12);
  }
  
  public static long c(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(1970, 0, 1, 0, 0, 0);
    long l3 = ((Calendar)localObject).getTime().getTime();
    long l4 = paramLong - l3;
    long l2 = l4 / 1000L / 86400L;
    long l1 = l2;
    if (l2 > 25568L) {
      l1 = 25568L;
    }
    l2 = l1;
    if (l1 < 0L) {
      l2 = 0L;
    }
    if (QLog.isDevelopLevel())
    {
      double d = l4 / 86400L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(d);
      QLog.d("remind", 4, ((StringBuilder)localObject).toString());
    }
    return l2;
  }
  
  public static String d(long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 E HH:mm");
    try
    {
      localObject = ((Calendar)localObject).getTime();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label27:
      break label27;
    }
    localObject = new Date();
    return localSimpleDateFormat.format((Date)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.TimeHelper
 * JD-Core Version:    0.7.0.1
 */