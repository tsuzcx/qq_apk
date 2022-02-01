import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pax
{
  public static final String a = amtj.a(2131711844);
  public static final String b = amtj.a(2131712048);
  public static final String c = amtj.a(2131712083);
  public static final String d = amtj.a(2131711828);
  public static final String e = amtj.a(2131712199);
  public static final String f = amtj.a(2131712098);
  public static final String g = amtj.a(2131711940);
  public static final String h = amtj.a(2131711864);
  public static final String i = amtj.a(2131711858);
  public static final String j = amtj.a(2131712177);
  public static final String k = amtj.a(2131712089);
  public static final String l = amtj.a(2131711878);
  public static final String m = amtj.a(2131711894);
  public static final String n = amtj.a(2131711900);
  public static final String o = amtj.a(2131711875);
  public static final String p = amtj.a(2131712043);
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(1000L * paramLong);
    return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    return b(paramLong, paramBoolean);
  }
  
  public static String a(Calendar paramCalendar)
  {
    return new SimpleDateFormat("HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
  
  private static String b(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong * 1000L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    long l2;
    String str;
    if (paramBoolean)
    {
      paramLong = a() * 1000L;
      if (paramLong != localCalendar1.getTimeInMillis()) {
        localCalendar1.setTimeInMillis(paramLong);
      }
      localCalendar2.setTimeInMillis(l1);
      l2 = (paramLong - l1) / 1000L;
      str = c(localCalendar2);
      if (l2 >= 0L) {
        break label138;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTimeUtils", 2, new Object[] { "getRelativeDisplayTimeString = ", str, ", now = ", c(localCalendar1), ", publish = ", c(localCalendar2) });
      }
      return str;
      paramLong = localCalendar1.getTimeInMillis();
      break;
      label138:
      if (a(l1, paramLong))
      {
        if (l2 < 60L) {
          str = a;
        } else if (l2 < 3600L) {
          str = l2 / 60L + b;
        } else if (l2 < 86400L) {
          str = l2 / 3600L + c;
        }
      }
      else if (c(l1, paramLong)) {
        str = e + " " + a(localCalendar2);
      } else if (b(l1, paramLong)) {
        str = b(localCalendar2);
      } else {}
    }
  }
  
  public static String b(Calendar paramCalendar)
  {
    return new SimpleDateFormat("MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean b(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static String c(Calendar paramCalendar)
  {
    return new SimpleDateFormat("yy-MM-dd HH:mm").format(paramCalendar.getTime());
  }
  
  public static boolean c(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong2);
    localCalendar1.add(6, -1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong1);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pax
 * JD-Core Version:    0.7.0.1
 */