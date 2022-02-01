import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ozr
{
  public static final String a = anzj.a(2131711612);
  public static final String b = anzj.a(2131711816);
  public static final String c = anzj.a(2131711851);
  public static final String d = anzj.a(2131711596);
  public static final String e = anzj.a(2131711967);
  public static final String f = anzj.a(2131711866);
  public static final String g = anzj.a(2131711708);
  public static final String h = anzj.a(2131711632);
  public static final String i = anzj.a(2131711626);
  public static final String j = anzj.a(2131711945);
  public static final String k = anzj.a(2131711857);
  public static final String l = anzj.a(2131711646);
  public static final String m = anzj.a(2131711662);
  public static final String n = anzj.a(2131711668);
  public static final String o = anzj.a(2131711643);
  public static final String p = anzj.a(2131711811);
  
  public static long a()
  {
    return NetConnInfoCenter.getServerTime();
  }
  
  public static String a(long paramLong)
  {
    paramLong *= 1000L;
    Object localObject1 = null;
    try
    {
      Object localObject2 = new Date(paramLong);
      localObject2 = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyTimeUtils", 2, "getDateTimeString() ERROR millisTime=" + paramLong);
    }
    return localObject1;
    return null;
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
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      paramLong = a() * 1000L;
      if (paramLong != localCalendar1.getTimeInMillis()) {
        localCalendar1.setTimeInMillis(paramLong);
      }
      localCalendar2.setTimeInMillis(l1);
      l2 = (paramLong - l1) / 1000L;
      localObject2 = c(localCalendar2);
      localObject1 = "";
      if (l2 < 0L) {
        localObject1 = localObject2;
      }
      if (!a(l1, paramLong)) {
        break label254;
      }
      if (l2 >= 60L) {
        break label176;
      }
      localObject1 = a;
      label103:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label321;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTimeUtils", 2, new Object[] { "getRelativeDisplayTimeString = ", localObject2, ", now = ", c(localCalendar1), ", publish = ", c(localCalendar2) });
      }
      return localObject2;
      paramLong = localCalendar1.getTimeInMillis();
      break;
      label176:
      if (l2 < 3600L)
      {
        localObject1 = l2 / 60L + b;
        break label103;
      }
      if (l2 >= 86400L) {
        break label103;
      }
      localObject1 = l2 / 3600L + c;
      break label103;
      label254:
      if (c(l1, paramLong))
      {
        localObject1 = e + " " + a(localCalendar2);
        break label103;
      }
      if (b(l1, paramLong))
      {
        localObject1 = b(localCalendar2);
        break label103;
      }
      localObject1 = localObject2;
      break label103;
      label321:
      localObject2 = localObject1;
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
 * Qualified Name:     ozr
 * JD-Core Version:    0.7.0.1
 */