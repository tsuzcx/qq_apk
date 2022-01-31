package com.tencent.wxop.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class l
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  private static String d = null;
  private static Random e = null;
  private static DisplayMetrics f = null;
  private static String g = null;
  private static String h = "";
  private static String i = "";
  private static int j = -1;
  private static StatLogger k = null;
  private static String l = null;
  private static String m = null;
  private static volatile int n = -1;
  private static String o = null;
  private static String p = null;
  private static long q = -1L;
  private static String r = "";
  private static o s = null;
  private static String t = "__MTA_FIRST_ACTIVATE__";
  private static int u = -1;
  private static long v = -1L;
  private static int w = 0;
  private static String x = "";
  
  public static String A(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    } while ((paramContext.activityInfo == null) || (paramContext.activityInfo.packageName.equals("android")));
    return paramContext.activityInfo.packageName;
  }
  
  private static long B(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  public static int a()
  {
    return g().nextInt(2147483647);
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      w = y(paramContext);
    }
    return w;
  }
  
  public static Long a(String paramString1, String paramString2, int paramInt1, int paramInt2, Long paramLong)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return paramLong;
      String str;
      if (!paramString2.equalsIgnoreCase("."))
      {
        str = paramString2;
        if (!paramString2.equalsIgnoreCase("|")) {}
      }
      else
      {
        str = "\\" + paramString2;
      }
      paramString2 = paramString1.split(str);
    } while (paramString2.length != paramInt2);
    try
    {
      paramString1 = Long.valueOf(0L);
      paramInt2 = 0;
      while (paramInt2 < paramString2.length)
      {
        long l1 = paramInt1;
        long l2 = paramString1.longValue();
        long l3 = Long.valueOf(paramString2[paramInt2]).longValue();
        paramInt2 += 1;
        paramString1 = Long.valueOf(l1 * (l2 + l3));
      }
      return paramString1;
    }
    catch (NumberFormatException paramString1) {}
    return paramLong;
  }
  
  public static String a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.roll(6, paramInt);
    return new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str = paramString;
    if (StatConfig.isEnableConcurrentProcess() == true)
    {
      if (m == null) {
        m = o(paramContext);
      }
      str = paramString;
      if (m != null) {
        str = paramString + "_" + m;
      }
    }
    return str;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i1 = 0;
      while (i1 < paramString.length)
      {
        int i2 = paramString[i1] & 0xFF;
        if (i2 < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(i2));
        i1 += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (Throwable paramString) {}
    return "0";
  }
  
  public static HttpHost a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    do
    {
      try
      {
        if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
          return null;
        }
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          return null;
        }
        if ((paramContext.getTypeName() != null) && (paramContext.getTypeName().equalsIgnoreCase("WIFI"))) {
          return null;
        }
        paramContext = paramContext.getExtraInfo();
        if (paramContext == null) {
          return null;
        }
        if ((paramContext.equals("cmwap")) || (paramContext.equals("3gwap")) || (paramContext.equals("uniwap")))
        {
          paramContext = new HttpHost("10.0.0.172", 80);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
        return null;
      }
      if (paramContext.equals("ctwap")) {
        return new HttpHost("10.0.0.200", 80);
      }
      paramContext = Proxy.getDefaultHost();
    } while ((paramContext == null) || (paramContext.trim().length() <= 0));
    paramContext = new HttpHost(paramContext, Proxy.getDefaultPort());
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    w = paramInt;
    q.b(paramContext, "mta.qq.com.difftime", paramInt);
  }
  
  public static boolean a(StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (paramStatSpecifyReportedInfo == null) {
      return false;
    }
    return c(paramStatSpecifyReportedInfo.getAppKey());
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte = new byte[4096];
    paramArrayOfByte = new ByteArrayOutputStream(paramArrayOfByte.length * 2);
    for (;;)
    {
      int i1 = localGZIPInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      paramArrayOfByte.write(arrayOfByte, 0, i1);
    }
    arrayOfByte = paramArrayOfByte.toByteArray();
    localByteArrayInputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static long b(String paramString)
  {
    return a(paramString, ".", 100, 3, Long.valueOf(0L)).longValue();
  }
  
  public static StatLogger b()
  {
    try
    {
      if (k == null)
      {
        localStatLogger = new StatLogger("MtaSDK");
        k = localStatLogger;
        localStatLogger.setDebugEnable(false);
      }
      StatLogger localStatLogger = k;
      return localStatLogger;
    }
    finally {}
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   6: ifnull +24 -> 30
    //   9: getstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   12: invokevirtual 352	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 355	java/lang/String:length	()I
    //   18: ifeq +12 -> 30
    //   21: getstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic 420	com/tencent/wxop/stat/common/r:a	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore_0
    //   35: aload_0
    //   36: putstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   39: aload_0
    //   40: ifnull +15 -> 55
    //   43: getstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   46: invokevirtual 352	java/lang/String:trim	()Ljava/lang/String;
    //   49: invokevirtual 355	java/lang/String:length	()I
    //   52: ifne +17 -> 69
    //   55: invokestatic 164	com/tencent/wxop/stat/common/l:g	()Ljava/util/Random;
    //   58: ldc 165
    //   60: invokevirtual 171	java/util/Random:nextInt	(I)I
    //   63: invokestatic 422	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   66: putstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   69: getstatic 39	com/tencent/wxop/stat/common/l:a	Ljava/lang/String;
    //   72: astore_0
    //   73: goto -48 -> 25
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	25	76	finally
    //   30	39	76	finally
    //   43	55	76	finally
    //   55	69	76	finally
    //   69	73	76	finally
  }
  
  public static long c()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      return l1 + 86400000L;
    }
    catch (Throwable localThrowable)
    {
      k.e(localThrowable);
    }
    return System.currentTimeMillis() + 86400000L;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      if ((c == null) || (c.trim().length() == 0)) {
        c = r.b(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static DisplayMetrics d(Context paramContext)
  {
    if (f == null)
    {
      f = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
    }
    return f;
  }
  
  public static String d()
  {
    if (c(p)) {
      return p;
    }
    long l1 = e() / 1000000L;
    Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = ((StatFs)localObject).getBlockSize();
    l2 = ((StatFs)localObject).getAvailableBlocks() * l2 / 1000000L;
    localObject = String.valueOf(l2) + "/" + String.valueOf(l1);
    p = (String)localObject;
    return localObject;
  }
  
  public static long e()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l1;
  }
  
  public static boolean e(Context paramContext)
  {
    try
    {
      if (!r.a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        break label71;
      }
      paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
      if (paramContext == null) {
        break label100;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext == null) {
        break label100;
      }
      i1 = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i1;
        label71:
        k.e(paramContext);
        continue;
        i1 += 1;
      }
    }
    if (i1 < paramContext.length) {
      if ((paramContext[i1].getTypeName().equalsIgnoreCase("WIFI")) && (paramContext[i1].isConnected()))
      {
        return true;
        k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return false;
      }
    }
    label100:
    return false;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getClass().getName();
  }
  
  public static String g(Context paramContext)
  {
    if (g != null) {
      return g;
    }
    for (;;)
    {
      try
      {
        if (!r.a(paramContext, "android.permission.READ_PHONE_STATE")) {
          continue;
        }
        if (i(paramContext))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            g = paramContext.getSimOperator();
          }
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
        continue;
      }
      return g;
      k.e("Could not get permission of android.permission.READ_PHONE_STATE");
    }
  }
  
  private static Random g()
  {
    try
    {
      if (e == null) {
        e = new Random();
      }
      Random localRandom = e;
      return localRandom;
    }
    finally {}
  }
  
  private static long h()
  {
    if (q > 0L) {
      return q;
    }
    long l2 = 1L;
    long l1 = l2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      l1 = l2;
      l2 = Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
      l1 = l2;
      localBufferedReader.close();
      l1 = l2;
    }
    catch (Exception localException)
    {
      label74:
      break label74;
    }
    q = l1;
    return l1;
  }
  
  public static String h(Context paramContext)
  {
    if (c(h)) {
      return h;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      h = paramContext;
      if (paramContext == null) {
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return h;
  }
  
  public static boolean i(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0;
  }
  
  public static String j(Context paramContext)
  {
    Object localObject;
    try
    {
      if ((r.a(paramContext, "android.permission.INTERNET")) && (r.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
          break label122;
        }
        paramContext = ((NetworkInfo)localObject).getTypeName();
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (paramContext == null) {
          break label122;
        }
        if (paramContext.equalsIgnoreCase("WIFI")) {
          return "WIFI";
        }
        if (!paramContext.equalsIgnoreCase("MOBILE")) {
          break label116;
        }
        if (localObject != null) {
          return localObject;
        }
      }
      else
      {
        k.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
      return "";
    }
    return "MOBILE";
    label116:
    if (localObject != null)
    {
      return localObject;
      label122:
      paramContext = "";
    }
    return paramContext;
  }
  
  public static Integer k(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int i1 = paramContext.getNetworkType();
        return Integer.valueOf(i1);
      }
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String l(Context paramContext)
  {
    if (c(i)) {
      return i;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      i = paramContext;
      if ((paramContext == null) || (i.length() == 0)) {
        return "unknown";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return i;
  }
  
  public static int m(Context paramContext)
  {
    if (j != -1) {
      return j;
    }
    try
    {
      if (p.a()) {
        j = 1;
      }
      j = 0;
      return 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        k.e(paramContext);
      }
    }
  }
  
  public static String n(Context paramContext)
  {
    if (c(l)) {
      return l;
    }
    try
    {
      if (!r.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        break label142;
      }
      paramContext = Environment.getExternalStorageState();
      if ((paramContext != null) && (paramContext.equals("mounted")))
      {
        paramContext = Environment.getExternalStorageDirectory().getPath();
        if (paramContext != null)
        {
          paramContext = new StatFs(paramContext);
          long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
          long l2 = paramContext.getAvailableBlocks();
          l2 = paramContext.getBlockSize() * l2 / 1000000L;
          paramContext = String.valueOf(l2) + "/" + String.valueOf(l1);
          l = paramContext;
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return null;
    label142:
    k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
    return null;
  }
  
  static String o(Context paramContext)
  {
    try
    {
      if (m != null) {
        return m;
      }
      int i1 = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i1) {
          m = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label66:
      break label66;
    }
    return m;
  }
  
  public static String p(Context paramContext)
  {
    return a(paramContext, StatConstants.DATABASE_NAME);
  }
  
  public static Integer q(Context paramContext)
  {
    int i1 = 0;
    for (;;)
    {
      int i2;
      try
      {
        if (n > 0)
        {
          i2 = n;
          if (i2 % 1000 == 0) {}
          try
          {
            i2 = n;
            if (n < 2147383647) {
              break label107;
            }
            q.b(paramContext, "MTA_EVENT_INDEX", i1);
          }
          catch (Throwable paramContext)
          {
            k.w(paramContext);
            continue;
          }
          i1 = n + 1;
          n = i1;
          return Integer.valueOf(i1);
        }
      }
      finally {}
      n = q.a(paramContext, "MTA_EVENT_INDEX", 0);
      q.b(paramContext, "MTA_EVENT_INDEX", n + 1000);
      continue;
      label107:
      i1 = i2 + 1000;
    }
  }
  
  public static String r(Context paramContext)
  {
    try
    {
      long l1 = B(paramContext) / 1000000L;
      long l2 = h() / 1000000L;
      paramContext = String.valueOf(l1) + "/" + String.valueOf(l2);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject s(Context paramContext)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("n", m.a());
      String str = m.d();
      if ((str != null) && (str.length() > 0)) {
        paramContext.put("na", str);
      }
      int i1 = m.b();
      if (i1 > 0) {
        paramContext.put("fx", i1 / 1000000);
      }
      i1 = m.c();
      if (i1 > 0) {
        paramContext.put("fn", i1 / 1000000);
      }
      return paramContext;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MtaSDK", "get cpu error", localThrowable);
    }
    return paramContext;
  }
  
  public static String t(Context paramContext)
  {
    if (c(r)) {
      return r;
    }
    try
    {
      paramContext = (SensorManager)paramContext.getSystemService("sensor");
      if (paramContext == null) {
        break label115;
      }
      paramContext = paramContext.getSensorList(-1);
      if (paramContext == null) {
        break label115;
      }
      localStringBuilder = new StringBuilder(paramContext.size() * 10);
      i1 = 0;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        int i1;
        label115:
        k.e(paramContext);
        continue;
        i1 += 1;
      }
    }
    if (i1 < paramContext.size())
    {
      localStringBuilder.append(((Sensor)paramContext.get(i1)).getType());
      if (i1 != paramContext.size() - 1) {
        localStringBuilder.append(",");
      }
    }
    else
    {
      r = localStringBuilder.toString();
      return r;
    }
  }
  
  /* Error */
  public static int u(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 85	com/tencent/wxop/stat/common/l:u	I
    //   6: iconst_m1
    //   7: if_icmpeq +12 -> 19
    //   10: getstatic 85	com/tencent/wxop/stat/common/l:u	I
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokestatic 715	com/tencent/wxop/stat/common/l:v	(Landroid/content/Context;)V
    //   23: getstatic 85	com/tencent/wxop/stat/common/l:u	I
    //   26: istore_1
    //   27: goto -13 -> 14
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramContext	Context
    //   13	14	1	i1	int
    // Exception table:
    //   from	to	target	type
    //   3	14	30	finally
    //   19	27	30	finally
  }
  
  public static void v(Context paramContext)
  {
    int i1 = q.a(paramContext, t, 1);
    u = i1;
    if (i1 == 1) {
      q.b(paramContext, t, 0);
    }
  }
  
  public static boolean w(Context paramContext)
  {
    if (v < 0L) {
      v = q.a(paramContext, "mta.qq.com.checktime", 0L);
    }
    return Math.abs(System.currentTimeMillis() - v) > 86400000L;
  }
  
  public static void x(Context paramContext)
  {
    v = System.currentTimeMillis();
    q.b(paramContext, "mta.qq.com.checktime", v);
  }
  
  public static int y(Context paramContext)
  {
    return q.a(paramContext, "mta.qq.com.difftime", 0);
  }
  
  public static boolean z(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    paramContext = paramContext.getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.startsWith(paramContext)) {
        return localRunningAppProcessInfo.importance == 400;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.common.l
 * JD-Core Version:    0.7.0.1
 */