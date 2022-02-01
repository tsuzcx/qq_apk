package com.tencent.xweb.xwalk.updater;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public abstract class Scheduler
{
  public static boolean c = false;
  static boolean d = false;
  protected String b;
  c e;
  
  public Scheduler()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("Scheduler");
    this.b = localStringBuilder.toString();
  }
  
  public static double a(double paramDouble)
  {
    if (paramDouble >= 0.0D)
    {
      if (paramDouble > 24.0D) {
        return 0.0D;
      }
      return paramDouble;
    }
    return 0.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, List<Scheduler.a> paramList)
  {
    paramList = paramList.iterator();
    double d1 = 0.0D;
    while (paramList.hasNext())
    {
      double d2 = ((Scheduler.a)paramList.next()).b(paramDouble1, paramDouble2) * paramDouble3;
      if (d2 > d1) {
        d1 = d2;
      }
    }
    return d1;
  }
  
  public static double a(String paramString)
  {
    return a(paramString, e.b());
  }
  
  public static double a(String paramString, double paramDouble)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 1.0D;
    }
    paramString = c(paramString);
    if ((paramString != null) && (paramString.length != 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = com.tencent.xweb.internal.i.b((String)localObject);
          if ((localObject != null) && (paramDouble >= ((com.tencent.xweb.internal.i)localObject).a) && (paramDouble <= ((com.tencent.xweb.internal.i)localObject).b)) {
            return ((com.tencent.xweb.internal.i)localObject).a(paramDouble);
          }
        }
        i += 1;
      }
      return 1.0D;
    }
    d = true;
    return 1.0D;
  }
  
  static long a(a.a parama)
  {
    long l = parama.j * 60 * 1000;
    if (0L == l) {
      return 0L;
    }
    int i = parama.c.m;
    int k = 10000;
    if ((i > 0) && (parama.c.m <= 10000)) {
      i = parama.c.m;
    } else {
      i = 0;
    }
    int j = k;
    if (parama.c.n > 0)
    {
      j = k;
      if (parama.c.n <= 10000) {
        j = parama.c.n;
      }
    }
    k = j - i + 1;
    j = k;
    if (k <= 0) {
      j = 1;
    }
    double d2 = (XWalkEnvironment.getGrayValue() - i) * l;
    double d1 = j;
    Double.isNaN(d2);
    Double.isNaN(d1);
    d2 /= d1;
    double d3 = l * (XWalkEnvironment.getGrayValue() + 1 - i);
    Double.isNaN(d3);
    Double.isNaN(d1);
    d1 = d3 / d1;
    return (d2 + Math.random() * (d1 - d2));
  }
  
  public static long a(a.a parama, String paramString)
  {
    long l;
    if (!TextUtils.isEmpty(parama.g))
    {
      l = b(parama, paramString);
      parama = new StringBuilder();
      parama.append(paramString);
      parama.append(" schedul after ");
      parama.append(l / 60L / 1000L);
      parama.append(" minute to update");
      XWalkInitializer.addXWalkInitializeLog(parama.toString());
      return System.currentTimeMillis() + l;
    }
    if (parama.j > 0)
    {
      l = a(parama);
      parama = new StringBuilder();
      parama.append(paramString);
      parama.append(" schedul after ");
      parama.append(l / 60L / 1000L);
      parama.append(" minute to update");
      XWalkInitializer.addXWalkInitializeLog(parama.toString());
      return System.currentTimeMillis() + l;
    }
    parama = new StringBuilder();
    parama.append(paramString);
    parama.append(" no schedule time");
    XWalkInitializer.addXWalkInitializeLog(parama.toString());
    return 100L;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    if (paramDouble1 >= 0.0D)
    {
      if (paramDouble1 > 24.0D) {
        return false;
      }
      if (paramDouble2 >= 0.0D)
      {
        if (paramDouble2 > 24.0D) {
          return false;
        }
        return paramDouble2 >= paramDouble1;
      }
    }
    return false;
  }
  
  static boolean a(long paramLong)
  {
    return (paramLong >= 1800000L) && (paramLong < 259200000L);
  }
  
  public static double b(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 < paramDouble1) {
      return 24.0D;
    }
    if (paramDouble2 >= 0.0D)
    {
      if (paramDouble2 > 32.0D) {
        return 24.0D;
      }
      return paramDouble2;
    }
    return 24.0D;
  }
  
  public static double b(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if ((paramDouble1 <= paramDouble3) && (paramDouble3 >= paramDouble2))
    {
      if (paramDouble2 >= paramDouble1) {
        paramDouble1 = paramDouble2;
      }
      return paramDouble1 + Math.random() * (paramDouble3 - paramDouble1);
    }
    Log.e("Scheduler", "srandTime cur hour is bigger than endhour ");
    return 0.0D;
  }
  
  static long b(a.a parama, String paramString)
  {
    int[] arrayOfInt = parama.a();
    Object localObject = new SimpleDateFormat("yyyyMMdd");
    Date localDate3 = new Date();
    Date localDate1 = localDate3;
    Date localDate2;
    try
    {
      if (!TextUtils.isEmpty(parama.h)) {
        localDate1 = ((SimpleDateFormat)localObject).parse(parama.h);
      }
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" parse version release date failed ");
      ((StringBuilder)localObject).append(localException.getMessage());
      XWalkEnvironment.addXWalkInitializeLog(paramString, ((StringBuilder)localObject).toString());
      h.a(903L, 158L, 1L);
      localDate2 = localDate3;
    }
    double d1 = new Date().getTime() - localDate2.getTime();
    Double.isNaN(d1);
    d1 /= 86400000.0D;
    int j = (int)d1;
    int i = j;
    if (d1 < 0.0D) {
      i = j - 1;
    }
    d1 = Math.abs(d1);
    int m = 0;
    if (d1 > 365.0D) {
      i = 0;
    }
    if ((arrayOfInt != null) && (arrayOfInt.length != 0))
    {
      j = parama.c.m;
      int n = 10000;
      if ((j > 0) && (parama.c.m <= 10000)) {
        j = parama.c.m;
      } else {
        j = 0;
      }
      int k = n;
      if (parama.c.n > 0)
      {
        k = n;
        if (parama.c.n <= 10000) {
          k = parama.c.n;
        }
      }
      d1 = XWalkEnvironment.getGrayValue() - j;
      Double.isNaN(d1);
      double d2 = k - j + 1;
      Double.isNaN(d2);
      d1 = d1 * 10000.0D / d2;
      j = m;
      while ((j < arrayOfInt.length) && (d1 > arrayOfInt[j])) {
        j += 1;
      }
      Calendar.getInstance();
      d1 = e.b();
      d2 = a(parama.e);
      double d3 = b(parama.e, parama.f);
      j -= i;
      i = j;
      if (j <= 0)
      {
        if ((parama.n) && (d1 > d2)) {
          Log.i("Scheduler", "low priority version. schedule to next day to update");
        } else {
          if (d1 < d3) {
            break label435;
          }
        }
        i = 1;
        break label451;
        label435:
        return ((b(d1, d2, d3) - d1) * 3600000.0D);
      }
      label451:
      d1 = b(0.0D, d2, d3);
      d2 = (i - 1) * 86400000L;
      Double.isNaN(d2);
      d3 = e.a();
      Double.isNaN(d3);
      return (d1 * 3600000.0D + d2 + d3);
    }
    return 0L;
  }
  
  static Scheduler.a b(String paramString)
  {
    Scheduler.a locala = new Scheduler.a();
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.trim().replace("=>", "_").split("_");
    if ((paramString != null) && (paramString.length == 2))
    {
      locala.a = com.tencent.xweb.internal.i.b(paramString[0]);
      if (locala.a == null)
      {
        Log.e("getTimeRangePairItem", "parse rangefrom failed");
        return null;
      }
      locala.b = com.tencent.xweb.internal.i.b(paramString[1]);
      if (locala.b == null)
      {
        Log.e("getTimeRangePairItem", "parse rangeTo failed");
        return null;
      }
      return locala;
    }
    Log.e("getTimeRangePairItem", "strRanges error");
    return null;
  }
  
  public static XWebCoreScheduler b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      localXWebCoreScheduler = i.y();
      return localXWebCoreScheduler;
    }
    finally {}
    XWebCoreScheduler localXWebCoreScheduler = XWebCoreScheduler.z();
    return localXWebCoreScheduler;
  }
  
  static boolean c(double paramDouble1, double paramDouble2)
  {
    return Math.abs(paramDouble1 - paramDouble2) < 1.E-005D;
  }
  
  static String[] c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.split(";");
  }
  
  public static void l()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = b(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.n().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.r().b = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void m()
  {
    try
    {
      XWebCoreScheduler localXWebCoreScheduler = b(false);
      SharedPreferences.Editor localEditor = localXWebCoreScheduler.n().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      localXWebCoreScheduler.r().b = 0L;
      localXWebCoreScheduler.r().k = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static long p()
  {
    long l = a.a().a("force_cmd_period", "tools", 0) * 60000L;
    if (a(l)) {
      return l;
    }
    l = XWalkEnvironment.getConfigFetchPeriod();
    if (a(l)) {
      return l;
    }
    l = a.i();
    if (a(l)) {
      return l;
    }
    return 86400000L;
  }
  
  public static boolean x()
  {
    Scheduler.2 local2 = new Scheduler.2();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 15, 0, 0, 0);
    List localList = local2.s();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 15, 0, 58, 5);
    double d1 = e.b((Calendar)localObject);
    a(d1, 21.0D, a(local2.d(false), d1) / 5.0D, localList);
    d = false;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    for (double d2 = 0.0D; localCalendar.get(10) <= 8.0D; d2 = d1)
    {
      double d3 = e.b(localCalendar);
      double d4 = a(local2.d(false), d3) / 5.0D;
      localObject = Calendar.getInstance();
      ((Calendar)localObject).set(2020, 6, 15, 6, 30, 0);
      d1 = 0.0D;
      while (((Calendar)localObject).get(5) < 16)
      {
        d1 += a(d3, e.b((Calendar)localObject), d4, localList) * 10000.0D;
        ((Calendar)localObject).add(12, 30);
      }
      localObject = localSimpleDateFormat.format(localCalendar.getTime());
      if (d2 != 0.0D) {
        Math.abs((d1 - d2) / d2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rate\t");
      localStringBuilder.append(d1);
      localStringBuilder.append("\ttime\t");
      localStringBuilder.append((String)localObject);
      Log.e("andrewu", localStringBuilder.toString());
      localCalendar.add(13, 1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sParseScheduleConfigFailed = ");
    ((StringBuilder)localObject).append(d);
    Log.e("andrewu", ((StringBuilder)localObject).toString());
    return true;
  }
  
  private String y()
  {
    if (!TextUtils.isEmpty(r().B)) {
      return r().B;
    }
    return c();
  }
  
  public c a(c paramc)
  {
    Object localObject1 = r();
    Object localObject2;
    if (paramc == null)
    {
      XWalkInitializer.addXWalkInitializeLog(this.b, "got no schedule need download");
      if (h())
      {
        if (localObject1 != null)
        {
          localObject2 = this.b;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clear current scheduler version = ");
          localStringBuilder.append(((c)localObject1).l);
          XWalkInitializer.addXWalkInitializeLog((String)localObject2, localStringBuilder.toString());
        }
        b(paramc);
      }
      return null;
    }
    if (a(paramc, (c)localObject1))
    {
      int i = 0;
      if (!a(paramc.z, ((c)localObject1).z))
      {
        ((c)localObject1).z = paramc.z;
        i = 1;
      }
      if (!a(paramc.A, ((c)localObject1).A))
      {
        ((c)localObject1).A = paramc.A;
        i = 1;
      }
      if (!a(paramc.B, ((c)localObject1).B))
      {
        ((c)localObject1).B = paramc.B;
        i = 1;
      }
      if (i != 0) {
        b((c)localObject1);
      }
      XWalkInitializer.addXWalkInitializeLog(this.b, "got same version to scheduler, use last version ");
      return localObject1;
    }
    if (h())
    {
      h.a(903L, 149L, 1L);
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("got new scheduler replace current , version is ");
      ((StringBuilder)localObject2).append(paramc.l);
      XWalkInitializer.addXWalkInitializeLog((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    b(paramc);
    return paramc;
  }
  
  public abstract String a();
  
  protected abstract String a(boolean paramBoolean);
  
  public void a(int paramInt) {}
  
  void a(SharedPreferences.Editor paramEditor, int paramInt)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = paramInt * 7200000L;
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rescheduler update time after ");
      localStringBuilder.append(l2 / 60000L);
      localStringBuilder.append(" minute");
      XWalkInitializer.addXWalkInitializeLog(str, localStringBuilder.toString());
      paramEditor.putLong("nTimeToUpdate", l1 + l2);
      return;
    }
    finally {}
  }
  
  boolean a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    d = false;
    Object localObject1 = s();
    if (d)
    {
      XWalkEnvironment.addXWalkInitializeLog(this.b, "parse range schedule config failed");
      h.a(903L, b() + 163, 1L);
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Scheduler.a)((Iterator)localObject2).next();
      if (((Scheduler.a)localObject1).a(paramDouble1, paramDouble2, paramDouble3))
      {
        localObject2 = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("matched timerange zone cur time is ");
        localStringBuilder.append(paramDouble1);
        localStringBuilder.append(" scheduleHour is ");
        localStringBuilder.append(paramDouble2);
        localStringBuilder.append("time range is ");
        localStringBuilder.append(((Scheduler.a)localObject1).c(paramDouble1, paramDouble2));
        XWalkInitializer.addXWalkInitializeLog((String)localObject2, localStringBuilder.toString());
        return true;
      }
    }
    return false;
  }
  
  boolean a(long paramLong, double paramDouble)
  {
    return a(e.b(), e.a(paramLong), paramDouble);
  }
  
  boolean a(long paramLong1, long paramLong2)
  {
    long l = p();
    if ((paramLong1 <= paramLong2 + l) && (paramLong1 + l >= paramLong2))
    {
      XWalkInitializer.addXWalkInitializeLog(this.b, "the most recent time to fetch config is too close");
      return false;
    }
    return true;
  }
  
  protected boolean a(c paramc1, c paramc2)
  {
    if ((paramc1.l == paramc2.l) && (paramc1.q == paramc2.q) && (paramc1.r == paramc2.r) && (paramc1.f == paramc2.f) && (a(paramc1.d, paramc2.d)) && (a(paramc1.j, paramc2.j)) && (a(paramc1.t, paramc2.t)))
    {
      if (paramc1.u != paramc2.u) {
        return false;
      }
      return (!paramc1.f) || (a(paramc1.m, paramc2.m));
    }
    return false;
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return true;
    }
    if (paramString1 == null) {
      return paramString1 == paramString2;
    }
    return paramString1.equals(paramString2);
  }
  
  public boolean a(Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l3 = paramCalendar1.getTimeInMillis();
    long l1 = paramCalendar2.getTimeInMillis();
    long l2 = e.a(paramCalendar1);
    l3 += l2;
    boolean bool1;
    if (l1 - 180000L < l3 - 86400000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (l1 + 180000L > l3) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3;
    if ((l2 >= 180000L) && (l2 + 180000L <= 86400000L)) {
      bool3 = false;
    } else {
      bool3 = true;
    }
    if ((bool1 == paramBoolean1) && (bool2 == paramBoolean2)) {
      return bool3 == paramBoolean3;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, int paramInt)
  {
    if (paramInt > 2) {}
    try
    {
      XWalkEnvironment.addXWalkInitializeLog(this.b, "isTimeToUpdate abort cause depth > 2");
      return false;
    }
    finally {}
    boolean bool1 = h();
    if (!bool1) {
      return false;
    }
    Object localObject1;
    long l2;
    double d1;
    double d2;
    long l1;
    int i;
    StringBuilder localStringBuilder;
    long l3;
    long l4;
    long l5;
    int j;
    label364:
    int k;
    int m;
    if ((!i()) && (!c))
    {
      localObject1 = a.a("DELAY_UPDATE_TIME", "tools");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = e.a((String)localObject1);
        if ((((e.a)localObject1).a) && (((e.a)localObject1).a() >= 0.0D) && (((e.a)localObject1).a() <= 24.0D)) {
          ((e.a)localObject1).a();
        }
      }
      l2 = System.currentTimeMillis();
      d1 = t();
      if (d)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.b, "parse update speed failed");
        h.a(903L, b() + 163, 1L);
      }
      d2 = u();
      if (d)
      {
        XWalkEnvironment.addXWalkInitializeLog(this.b, "parse update forward speed failed");
        h.a(903L, b() + 163, 1L);
      }
      l1 = r().k;
      if (l1 > 1000L) {
        break label885;
      }
      if (!paramBoolean) {
        return true;
      }
      l1 = l2 - (Math.random() * 3600000.0D);
      XWalkInitializer.addXWalkInitializeLog(this.b, "not have schedule time ,just random a time in one hour");
      h.a(903L, b() + 155, 1L);
      i = 0;
      localObject1 = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduled time is after ");
      localStringBuilder.append((l1 - l2) / 60000L);
      localStringBuilder.append(" minutes later");
      XWalkInitializer.addXWalkInitializeLog((String)localObject1, localStringBuilder.toString());
      l3 = l2 - l1;
      l4 = e.a();
      l5 = l4 + l2;
      if (l1 - 180000L >= l5 - 86400000L) {
        break label891;
      }
      j = 1;
      break label894;
      if (i == 0)
      {
        Log.i(this.b, "has no scheduler , ignore dangers time ");
      }
      else
      {
        if (j != 0)
        {
          XWalkInitializer.addXWalkInitializeLog(this.b, "isPastDaySchedule need reschedule to next day ");
          v();
          h.a(903L, 146L, 1L);
          paramBoolean = a(false, paramInt + 1);
          return paramBoolean;
        }
        if (k != 0)
        {
          XWalkInitializer.addXWalkInitializeLog(this.b, "isFutureDaySchedule no need download now ");
          h.a(903L, 147L, 1L);
          return false;
        }
        if (m != 0)
        {
          XWalkInitializer.addXWalkInitializeLog(this.b, "dangerous time do not update");
          h.a(903L, 148L, 1L);
          return false;
        }
      }
      if ((l3 < 0L) || (l3 > 3600000L)) {
        break label952;
      }
      h.a(903L, b() + 154, 1L);
      bool1 = true;
      break label955;
    }
    for (;;)
    {
      boolean bool2 = paramBoolean;
      if (l3 < 0L)
      {
        bool2 = paramBoolean;
        if (-l3 < d2)
        {
          h.a(903L, b() + 161, 1L);
          bool2 = true;
        }
      }
      if ((bool1) && (!bool2)) {
        h.a(903L, b() + 150, 1L);
      }
      if ((!bool1) && (bool2)) {
        h.a(903L, b() + 151, 1L);
      }
      localObject1 = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldUpdateDefault = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append("shouldUpdateFromConfig = ");
      localStringBuilder.append(bool2);
      XWalkInitializer.addXWalkInitializeLog((String)localObject1, localStringBuilder.toString());
      if (bool2)
      {
        XWalkInitializer.addXWalkInitializeLog(this.b, "time to update");
        h.a(903L, b() + 152, 1L);
        return true;
      }
      if (k())
      {
        XWalkInitializer.addXWalkInitializeLog(this.b, "time to update because of in free update time zone");
        h.a(903L, b() + 153, 1L);
        return true;
      }
      d1 /= 18000000.0D;
      if (a(l1, d1))
      {
        h.a(903L, b() + 162, 1L);
        return true;
      }
      if ((i != 0) && ((l2 - r().k > 0L) || (Math.abs(l2 - r().k) > 7776000000L)))
      {
        v();
        h.a(903L, b() + 156, 1L);
      }
      else
      {
        XWalkInitializer.addXWalkInitializeLog(this.b, "has scheduler waiting for update, but time is not up");
      }
      return false;
      h.a(903L, b() + 157, 1L);
      return true;
      label885:
      i = 1;
      break;
      label891:
      j = 0;
      label894:
      if (l1 + 180000L > l5) {
        k = 1;
      } else {
        k = 0;
      }
      if ((l4 >= 180000L) && (l4 + 180000L <= 86400000L))
      {
        m = 0;
        break label364;
      }
      m = 1;
      break label364;
      label952:
      bool1 = false;
      label955:
      if ((l3 >= 0L) && (l3 < d1)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == -10)
    {
      localObject = n();
      paramInt = ((SharedPreferences)localObject).getInt("nTryUseSharedCoreCount", 0);
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFailed shared mode, current nTryUseSharedCoreCount: ");
      localStringBuilder.append(paramInt);
      XWalkInitializer.addXWalkInitializeLog(str, localStringBuilder.toString());
      paramInt += 1;
      r().p = paramInt;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("nTryUseSharedCoreCount", paramInt);
      a((SharedPreferences.Editor)localObject, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable()) {
      return;
    }
    Object localObject = n();
    int j = ((SharedPreferences)localObject).getInt("nTryCnt", 0) + 1;
    int i;
    if ((paramInt != -3) && (paramInt != -4))
    {
      i = j;
      if (paramInt <= -2)
      {
        i = j;
        if (paramInt >= -5) {
          i = (int)(j + 3L);
        }
      }
    }
    else
    {
      r().f = false;
      r().h = r().j;
      r().q = false;
      b(r());
      XWalkInitializer.addXWalkInitializeLog(this.b, "switch to full package update");
      i = j;
    }
    if (i > 3L)
    {
      XWalkInitializer.addXWalkInitializeLog(this.b, "FailedTooManytimes at this version");
      e();
      return;
    }
    r().o = i;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nTryCnt", i);
    a((SharedPreferences.Editor)localObject, i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void b(c paramc)
  {
    try
    {
      this.e = paramc;
      if (paramc == null) {
        this.e = new c();
      }
      this.e.a = a();
      paramc = n().edit();
      paramc.putString("strMd5", this.e.d);
      paramc.putString("strUrl", this.e.h);
      paramc.putString("strFullPackageUrl", this.e.j);
      paramc.putString("strConfigVer", this.e.e);
      paramc.putBoolean("bIsPatchUpdate", this.e.f);
      paramc.putBoolean("bCanUseCellular", this.e.q);
      paramc.putBoolean("bUseCdn", this.e.r);
      paramc.putLong("nTimeToUpdate", this.e.k);
      paramc.putInt("version", this.e.l);
      paramc.putInt("nTryCnt", this.e.o);
      paramc.putInt("nPatchTargetVersion", this.e.g);
      paramc.putInt("nTryUseSharedCoreCount", this.e.p);
      paramc.putString("patchMd5", this.e.m);
      paramc.putString("strVersionDetail", this.e.n);
      paramc.putBoolean("bTryUseSharedCore", this.e.s);
      paramc.putBoolean("skipSubFileMD5Check", this.e.x);
      paramc.putString("strAbi", this.e.t);
      paramc.putString("path", this.e.y);
      paramc.putInt("versionId", this.e.u);
      paramc.putFloat("timeHourStart", this.e.v);
      paramc.putFloat("timeHourEnd", this.e.w);
      paramc.putString("UPDATE_SPEED_CONFIG", this.e.z);
      paramc.putString("UPDATE_FORWARD_SPEED_CONFIG", this.e.A);
      paramc.putString("UPDATE_SCHEDULE_TIME_RANGE_BIND", this.e.B);
      paramc.commit();
      return;
    }
    finally {}
  }
  
  protected String c()
  {
    return a.a("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
  }
  
  public boolean c(boolean paramBoolean)
  {
    try
    {
      paramBoolean = a(paramBoolean, 0);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected String d()
  {
    return a.a("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
  }
  
  public final String d(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(r().A))) {
      return r().A;
    }
    if ((!paramBoolean) && (!TextUtils.isEmpty(r().z))) {
      return r().z;
    }
    return a(paramBoolean);
  }
  
  public void e()
  {
    XWalkInitializer.addXWalkInitializeLog(this.b, "abandon Current Scheduler");
    b(null);
  }
  
  public String f()
  {
    if (g())
    {
      localObject = new Date(r().k);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(":has scheduler for ver = ");
      localStringBuilder.append(r().l);
      localStringBuilder.append(" version id = ");
      localStringBuilder.append(r().u);
      localStringBuilder.append(" update time in ");
      localStringBuilder.append(((Date)localObject).toString());
      boolean bool = TextUtils.isEmpty(r().z);
      String str = "";
      if (!bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" update speed config:");
        ((StringBuilder)localObject).append(r().z);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      if (!TextUtils.isEmpty(r().A))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" update forward speed config:");
        ((StringBuilder)localObject).append(r().A);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localObject = str;
      if (!TextUtils.isEmpty(r().B))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" update time range config:");
        ((StringBuilder)localObject).append(r().B);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      return localStringBuilder.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(":has no scheduler");
    return ((StringBuilder)localObject).toString();
  }
  
  public boolean g()
  {
    if (!h()) {
      return false;
    }
    XWalkInitializer.addXWalkInitializeLog(this.b, "has scheduler for update");
    return true;
  }
  
  public boolean h()
  {
    try
    {
      if ((r() != null) && (r().l > 0) && (r().h != null))
      {
        boolean bool = r().h.isEmpty();
        if (!bool) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean i()
  {
    return false;
  }
  
  public boolean j()
  {
    String[] arrayOfString = c(d());
    boolean bool = false;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return false;
      }
      double d1 = e.b();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = com.tencent.xweb.internal.i.b((String)localObject);
          if ((localObject != null) && (d1 >= ((com.tencent.xweb.internal.i)localObject).a) && (d1 <= ((com.tencent.xweb.internal.i)localObject).b))
          {
            if (XWalkEnvironment.getTodayGrayValue() < ((com.tencent.xweb.internal.i)localObject).d * 10000.0D) {
              bool = true;
            }
            return bool;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean k()
  {
    Object localObject1 = a.a("free_update_time_zone", "tools");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return false;
    }
    if (!((String)localObject1).contains("-")) {
      return false;
    }
    Object localObject2 = ((String)localObject1).split("-");
    if (localObject2 != null)
    {
      if (localObject2.length != 2) {
        return false;
      }
      localObject1 = e.a(localObject2[0]);
      if (!((e.a)localObject1).a) {
        return false;
      }
      localObject2 = e.a(localObject2[1]);
      if (!((e.a)localObject2).a) {
        return false;
      }
      if (!a(((e.a)localObject1).a(), ((e.a)localObject2).a())) {
        return false;
      }
      double d1 = e.b();
      if (d1 < ((e.a)localObject1).a()) {
        return false;
      }
      return d1 <= ((e.a)localObject2).a();
    }
    return false;
  }
  
  SharedPreferences n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("xweb_scheduler_");
    localStringBuilder.append(a());
    return XWalkEnvironment.getMMKVSharedPreferences(localStringBuilder.toString());
  }
  
  public void o()
  {
    r().b = System.currentTimeMillis();
    r().c = XWalkEnvironment.getRuntimeAbi();
    SharedPreferences.Editor localEditor = n().edit();
    localEditor.putLong("nLastFetchConfigTime", r().b);
    localEditor.putString("strLastFetchAbi", r().c);
    localEditor.commit();
  }
  
  /* Error */
  public boolean q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 772	org/xwalk/core/XWalkEnvironment:getRuntimeAbi	()Ljava/lang/String;
    //   5: aload_0
    //   6: invokevirtual 333	com/tencent/xweb/xwalk/updater/Scheduler:r	()Lcom/tencent/xweb/xwalk/updater/c;
    //   9: getfield 774	com/tencent/xweb/xwalk/updater/c:c	Ljava/lang/String;
    //   12: invokevirtual 780	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   15: ifne +92 -> 107
    //   18: aload_0
    //   19: invokevirtual 333	com/tencent/xweb/xwalk/updater/Scheduler:r	()Lcom/tencent/xweb/xwalk/updater/c;
    //   22: getfield 774	com/tencent/xweb/xwalk/updater/c:c	Ljava/lang/String;
    //   25: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +79 -> 107
    //   31: ldc_w 782
    //   34: ldc_w 784
    //   37: ldc_w 351
    //   40: invokestatic 788	com/tencent/xweb/b:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokevirtual 780	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   46: istore_1
    //   47: iload_1
    //   48: ifne +59 -> 107
    //   51: aload_0
    //   52: monitorexit
    //   53: iconst_1
    //   54: ireturn
    //   55: astore 6
    //   57: goto +142 -> 199
    //   60: astore 6
    //   62: aload_0
    //   63: getfield 36	com/tencent/xweb/xwalk/updater/Scheduler:b	Ljava/lang/String;
    //   66: astore 7
    //   68: new 20	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   75: astore 8
    //   77: aload 8
    //   79: ldc_w 790
    //   82: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 8
    //   88: aload 6
    //   90: invokevirtual 207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 7
    //   99: aload 8
    //   101: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 209	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: invokevirtual 792	com/tencent/xweb/xwalk/updater/Scheduler:j	()Z
    //   111: ifeq +17 -> 128
    //   114: aload_0
    //   115: getfield 36	com/tencent/xweb/xwalk/updater/Scheduler:b	Ljava/lang/String;
    //   118: ldc_w 794
    //   121: invokestatic 209	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: monitorexit
    //   126: iconst_1
    //   127: ireturn
    //   128: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   131: lstore_2
    //   132: aload_0
    //   133: lload_2
    //   134: aload_0
    //   135: invokevirtual 333	com/tencent/xweb/xwalk/updater/Scheduler:r	()Lcom/tencent/xweb/xwalk/updater/c;
    //   138: getfield 338	com/tencent/xweb/xwalk/updater/c:b	J
    //   141: invokevirtual 796	com/tencent/xweb/xwalk/updater/Scheduler:a	(JJ)Z
    //   144: ifeq +51 -> 195
    //   147: aload_0
    //   148: invokevirtual 312	com/tencent/xweb/xwalk/updater/Scheduler:n	()Landroid/content/SharedPreferences;
    //   151: ldc_w 320
    //   154: lconst_0
    //   155: invokeinterface 800 4 0
    //   160: lstore 4
    //   162: aload_0
    //   163: invokevirtual 333	com/tencent/xweb/xwalk/updater/Scheduler:r	()Lcom/tencent/xweb/xwalk/updater/c;
    //   166: lload 4
    //   168: putfield 338	com/tencent/xweb/xwalk/updater/c:b	J
    //   171: aload_0
    //   172: lload_2
    //   173: lload 4
    //   175: invokevirtual 796	com/tencent/xweb/xwalk/updater/Scheduler:a	(JJ)Z
    //   178: ifeq +17 -> 195
    //   181: aload_0
    //   182: getfield 36	com/tencent/xweb/xwalk/updater/Scheduler:b	Ljava/lang/String;
    //   185: ldc_w 802
    //   188: invokestatic 429	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_0
    //   192: monitorexit
    //   193: iconst_1
    //   194: ireturn
    //   195: aload_0
    //   196: monitorexit
    //   197: iconst_0
    //   198: ireturn
    //   199: aload_0
    //   200: monitorexit
    //   201: aload 6
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	Scheduler
    //   46	2	1	bool	boolean
    //   131	42	2	l1	long
    //   160	14	4	l2	long
    //   55	1	6	localObject	Object
    //   60	142	6	localException	Exception
    //   66	32	7	str	String
    //   75	25	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	47	55	finally
    //   62	107	55	finally
    //   107	124	55	finally
    //   128	191	55	finally
    //   2	47	60	java/lang/Exception
  }
  
  public c r()
  {
    try
    {
      if (this.e != null)
      {
        localObject1 = this.e;
        return localObject1;
      }
      this.e = new c();
      this.e.a = a();
      Object localObject1 = n();
      this.e.b = ((SharedPreferences)localObject1).getLong("nLastFetchConfigTime", 0L);
      this.e.c = ((SharedPreferences)localObject1).getString("strLastFetchAbi", "");
      if (!((SharedPreferences)localObject1).contains("strUrl"))
      {
        localObject1 = this.e;
        return localObject1;
      }
      this.e.d = ((SharedPreferences)localObject1).getString("strMd5", "");
      this.e.u = ((SharedPreferences)localObject1).getInt("versionId", 0);
      this.e.v = ((SharedPreferences)localObject1).getFloat("timeHourStart", -1.0F);
      this.e.w = ((SharedPreferences)localObject1).getFloat("timeHourEnd", -1.0F);
      this.e.h = ((SharedPreferences)localObject1).getString("strUrl", "");
      this.e.j = ((SharedPreferences)localObject1).getString("strFullPackageUrl", "");
      this.e.e = ((SharedPreferences)localObject1).getString("strConfigVer", "");
      this.e.f = ((SharedPreferences)localObject1).getBoolean("bIsPatchUpdate", false);
      this.e.k = ((SharedPreferences)localObject1).getLong("nTimeToUpdate", 0L);
      this.e.l = ((SharedPreferences)localObject1).getInt("version", 0);
      this.e.o = ((SharedPreferences)localObject1).getInt("nTryCnt", 0);
      this.e.g = ((SharedPreferences)localObject1).getInt("nPatchTargetVersion", 0);
      this.e.p = ((SharedPreferences)localObject1).getInt("nTryUseSharedCoreCount", 0);
      this.e.m = ((SharedPreferences)localObject1).getString("patchMd5", "");
      this.e.n = ((SharedPreferences)localObject1).getString("strVersionDetail", "");
      this.e.q = ((SharedPreferences)localObject1).getBoolean("bCanUseCellular", false);
      this.e.r = ((SharedPreferences)localObject1).getBoolean("bUseCdn", false);
      this.e.s = ((SharedPreferences)localObject1).getBoolean("bTryUseSharedCore", true);
      this.e.x = ((SharedPreferences)localObject1).getBoolean("skipSubFileMD5Check", true);
      this.e.t = ((SharedPreferences)localObject1).getString("strAbi", "");
      this.e.y = ((SharedPreferences)localObject1).getString("path", "");
      this.e.z = ((SharedPreferences)localObject1).getString("UPDATE_SPEED_CONFIG", "");
      this.e.A = ((SharedPreferences)localObject1).getString("UPDATE_FORWARD_SPEED_CONFIG", "");
      this.e.B = ((SharedPreferences)localObject1).getString("UPDATE_SCHEDULE_TIME_RANGE_BIND", "");
      localObject1 = this.e;
      return localObject1;
    }
    finally {}
  }
  
  List<Scheduler.a> s()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = y();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localArrayList;
    }
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 != null) && (localObject1.length != 0))
    {
      e.b();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = b((String)localObject2);
          if (localObject2 == null) {
            d = true;
          } else {
            localArrayList.add(localObject2);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    d = true;
    return localArrayList;
  }
  
  public double t()
  {
    d = false;
    return a(d(false)) * 3600000.0D;
  }
  
  public double u()
  {
    d = false;
    return a(d(true)) * 3600000.0D;
  }
  
  public void v()
  {
    double d1 = e.b();
    if ((d1 >= r().v) && (d1 >= 6.0D))
    {
      l1 = e.a();
    }
    else
    {
      str = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("rescheduleToNextDay: cur hour is ");
      localStringBuilder.append(d1);
      localStringBuilder.append(", so still schedule in today");
      XWalkInitializer.addXWalkInitializeLog(str, localStringBuilder.toString());
      l1 = -(d1 * 3600000.0D);
    }
    d1 = b(0.0D, a(r().v), b(r().v, r().w));
    double d2 = l1;
    Double.isNaN(d2);
    long l1 = (d2 + d1 * 3600000.0D);
    long l2 = System.currentTimeMillis();
    r().k = (l2 + l1);
    b(r());
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rescheduleToNextDay: ");
    localStringBuilder.append(l1 / 60000L);
    localStringBuilder.append(" minutes later");
    XWalkInitializer.addXWalkInitializeLog(str, localStringBuilder.toString());
  }
  
  public boolean w()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 17, 30);
    if (!c(e.a(((Calendar)localObject).getTimeInMillis()), 17.5D))
    {
      Log.e(this.b, "unitTestRangeSchedule error 0");
      return false;
    }
    long l = System.currentTimeMillis();
    localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    ((Calendar)localObject).set(13, 0);
    if (e.a() != e.a((Calendar)localObject))
    {
      Log.e(this.b, "unitest Time to next day error 0");
      return false;
    }
    localObject = Calendar.getInstance();
    ((Calendar)localObject).set(2020, 6, 13, 23, 59, 1);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(2020, 6, 13, 0, 1);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.b, "unitTestDangerousTime error 0");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 2, 59);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.b, "unitTestDangerousTime error 1");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 2, 59);
    localCalendar.set(2020, 6, 15, 0, 1);
    if (!a((Calendar)localObject, localCalendar, true, false, true))
    {
      Log.e(this.b, "unitTestDangerousTime error 2");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 0, 3, 1);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, false))
    {
      Log.e(this.b, "unitTestDangerousTime error 3");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 57, 1);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, true))
    {
      Log.e(this.b, "unitTestDangerousTime error 4");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 56, 59);
    localCalendar.set(2020, 6, 15, 23, 59);
    if (!a((Calendar)localObject, localCalendar, false, true, false))
    {
      Log.e(this.b, "unitTestDangerousTime error 5");
      return false;
    }
    ((Calendar)localObject).set(2020, 6, 15, 23, 56, 59);
    localCalendar.set(2020, 6, 15, 22, 59);
    if (!a((Calendar)localObject, localCalendar, false, false, false))
    {
      Log.e(this.b, "unitTestDangerousTime error 6");
      return false;
    }
    localObject = new Scheduler.1(this).s();
    if ((localObject != null) && (((List)localObject).size() == 3))
    {
      ((Scheduler.a)((List)localObject).get(0)).c(1.5D, 19.0D);
      if (!c(((Scheduler.a)((List)localObject).get(0)).b(1.5D, 19.0D), 0.325D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 2");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 3249;
      if (!((Scheduler.a)((List)localObject).get(0)).a(1.5D, 19.0D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 3");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 3250;
      if (((Scheduler.a)((List)localObject).get(0)).a(1.5D, 19.0D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 4");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 9899;
      if (!c(((Scheduler.a)((List)localObject).get(0)).b(3.0D, 20.0D), 1.0D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 5 ");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 5000;
      if (((Scheduler.a)((List)localObject).get(2)).a(3.9D, 17.0D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 6");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 4998;
      if (!((Scheduler.a)((List)localObject).get(2)).a(3.9D, 17.0D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 7");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 1499;
      if (!((Scheduler.a)((List)localObject).get(1)).a(4.0D, 20.5D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 8");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 1500;
      if (((Scheduler.a)((List)localObject).get(1)).a(4.0D, 20.5D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 9");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 1499;
      if (a(4L, 20.5D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 10");
        return false;
      }
      XWalkEnvironment.sNDeviceRd = 1500;
      if (a(4L, 20.5D))
      {
        Log.e(this.b, "unitTestRangeSchedule error 11");
        return false;
      }
      Log.e(this.b, "unitTestRangeSchedule pass");
      return true;
    }
    Log.e(this.b, "unitTestRangeSchedule error 1");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.Scheduler
 * JD-Core Version:    0.7.0.1
 */