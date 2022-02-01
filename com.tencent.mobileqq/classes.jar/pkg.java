import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class pkg
{
  public static final String a = anvx.a(2131712191);
  public static final String b = anvx.a(2131712395);
  public static final String c = anvx.a(2131712430);
  public static final String d = anvx.a(2131712175);
  public static final String e = anvx.a(2131712546);
  public static final String f = anvx.a(2131712445);
  public static final String g = anvx.a(2131712287);
  public static final String h = anvx.a(2131712211);
  public static final String i = anvx.a(2131712205);
  public static final String j = anvx.a(2131712524);
  public static final String k = anvx.a(2131712436);
  public static final String l = anvx.a(2131712225);
  public static final String m = anvx.a(2131712241);
  public static final String n = anvx.a(2131712247);
  public static final String o = anvx.a(2131712222);
  public static final String p = anvx.a(2131712390);
  
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
 * Qualified Name:     pkg
 * JD-Core Version:    0.7.0.1
 */