package com.tencent.qqperf.monitor.backgroundcpu;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.ProcessStats;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MainService;
import mqq.app.MobileQQ;

public class BackgroundCpuMonitor
  implements Handler.Callback
{
  public static long a = 0L;
  public static int b = -1000;
  private static BackgroundCpuMonitor d;
  private static final String u;
  private static final String v;
  private static final String w;
  BackgroundCpuMonitor.BgCpuTotalCost c = new BackgroundCpuMonitor.BgCpuTotalCost();
  private SharedPreferences e;
  private boolean f = false;
  private int g = 0;
  private int h = 10;
  private int i = 15;
  private boolean j = false;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private long o = 0L;
  private long p = 0L;
  private long q = 0L;
  private boolean r = false;
  private boolean s = false;
  private Handler t = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/msflogs/");
    localStringBuilder.append("com.tencent.mobileqq".replace(".", File.separator));
    localStringBuilder.append(File.separator);
    u = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(u);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append("temp.trace");
    v = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(u);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append("baseInfo.txt");
    w = localStringBuilder.toString();
  }
  
  public static BackgroundCpuMonitor a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new BackgroundCpuMonitor();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static String a(long paramLong)
  {
    String str1 = QLog.getLogPath();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(MobileQQ.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2.replace(":", "_"));
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, Map<String, Long> paramMap)
  {
    Object[] arrayOfObject = ProcessStats.b("-2");
    long l3 = -1L;
    long l1;
    long l2;
    if (arrayOfObject != null)
    {
      l1 = ((Long)arrayOfObject[1]).longValue() + ((Long)arrayOfObject[2]).longValue();
      l2 = ((Long)arrayOfObject[1]).longValue();
    }
    else
    {
      l1 = -1L;
      l2 = l1;
    }
    long l4 = ProcessStats.a("-1");
    if (MobileQQ.sProcessId != 4) {
      l3 = ProcessStats.a(String.valueOf(MainService.sNativeTidOfReceiver));
    }
    long l5 = MainService.sReceiverCpuTime;
    long l6 = a;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "cpuInfo: ", Long.valueOf(l1), ", ", Long.valueOf(l2), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", Long.valueOf(l5), ", ", Long.valueOf(l6) });
    if ((l1 > 0L) && (l2 > 0L) && (l4 > 0L) && ((MobileQQ.sProcessId == 4) || (l3 > 0L)))
    {
      if (paramBoolean2)
      {
        long l7 = l1 - this.k;
        if ((l7 > 0L) && (l2 > this.l))
        {
          long l8 = this.m;
          if (l4 > l8)
          {
            l8 = l4 - l8;
            int i3 = (int)(l8 * 100L / l7);
            if (paramMap != null)
            {
              paramMap.put("elapse", Long.valueOf(l7));
              paramMap.put("qqConsume", Long.valueOf(l8));
              paramMap.put("qqRatio", Long.valueOf(i3));
            }
            int i1;
            if (MobileQQ.sProcessId != 4)
            {
              l8 = this.n;
              if (l3 < l8)
              {
                QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.n) });
                return false;
              }
              l8 = l3 - l8;
              int i2 = (int)(100L * l8 / l7);
              i1 = i2;
              if (paramMap != null)
              {
                paramMap.put("msfConsume", Long.valueOf(l8));
                paramMap.put("msfRatio", Long.valueOf(i2));
                i1 = i2;
              }
            }
            else
            {
              paramMap.put("msfConsume", Long.valueOf(0L));
              paramMap.put("msfRatio", Long.valueOf(0L));
              i1 = -1;
            }
            paramMap.put("msfTime", Long.valueOf(l5 - this.o));
            paramMap.put("ftsTime", Long.valueOf(l6 - this.p));
            QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(i3), ", msf-receiver cpuRatio = ", Integer.valueOf(i1), ", remainRptCount = ", Integer.valueOf(this.g) });
            break label739;
          }
        }
        paramMap = new StringBuilder(256);
        paramMap.append("bad cpu value2.");
        paramMap.append(l1);
        paramMap.append(",");
        paramMap.append(this.k);
        paramMap.append(",");
        paramMap.append(l2);
        paramMap.append(",");
        paramMap.append(this.l);
        paramMap.append(",");
        paramMap.append(l4);
        paramMap.append(",");
        paramMap.append(this.m);
        QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
        return false;
      }
      label739:
      if (paramBoolean1)
      {
        this.k = l1;
        this.l = l2;
        this.m = l4;
        this.n = l3;
        this.o = l5;
        this.p = l6;
      }
      return true;
    }
    QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
    return false;
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(u);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".trace.zip");
    return localStringBuilder.toString();
  }
  
  private static void f()
  {
    Object localObject1 = new File(u);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int i3 = localObject1.length;
        int i1 = 0;
        while (i1 < i3)
        {
          Object localObject2 = localObject1[i1];
          int i2;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("bg_cpu_"))) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if ((i2 != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
            localObject2.delete();
          }
          i1 += 1;
        }
      }
    }
  }
  
  void a(String paramString)
  {
    int i2 = MobileQQ.sProcessId;
    int i1 = 1;
    if ((i2 != 1) && (MobileQQ.sProcessId != 4)) {
      return;
    }
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config = ");
    localStringBuilder.append(paramString);
    QLog.d("BatteryStats.BgCpu", 2, localStringBuilder.toString());
    for (;;)
    {
      try
      {
        if (this.e == null) {
          this.e = MobileQQ.getContext().getSharedPreferences("bgCpu", 4);
        }
        long l1 = this.e.getLong("rand_time", 0L);
        bool1 = this.e.getBoolean("rand_rs", false);
        paramString = paramString.split(";");
        l1 = Math.abs(System.currentTimeMillis() - l1);
        if (l1 > 86400000L)
        {
          float f2 = Float.valueOf(paramString[1]).floatValue();
          float f1 = f2;
          if (QLog.isColorLevel())
          {
            f1 = f2;
            if (paramString.length >= 9) {
              f1 = f2 * Integer.valueOf(paramString[8]).intValue();
            }
          }
          if (Math.random() >= f1) {
            break label463;
          }
          bool1 = true;
          this.e.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label469;
          }
          break label472;
          this.h = Integer.valueOf(paramString[i2]).intValue();
          if (i1 == 0) {
            break label489;
          }
          i1 = 3;
          this.i = Integer.valueOf(paramString[i1]).intValue();
          this.g = (Integer.valueOf(paramString[6]).intValue() - this.e.getInt("times", 0));
          if (this.g <= 0) {
            bool1 = false;
          }
          this.j = "1".equals(paramString[7]);
          bool2 = bool1;
        }
        this.f = bool2;
        if ((this.f) && (MobileQQ.sProcessId == 4) && (this.t == null)) {
          this.t = new Handler(ThreadManager.getFileThreadLooper(), this);
        }
        if (paramString.length >= 10)
        {
          this.e.edit().putBoolean("enable_nor_sensor", "1".equals(paramString[9])).commit();
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BatteryStats.BgCpu", 2, "", paramString);
        }
      }
      return;
      label463:
      boolean bool1 = false;
      continue;
      label469:
      i1 = 0;
      label472:
      if (i1 != 0)
      {
        i2 = 2;
      }
      else
      {
        i2 = 4;
        continue;
        label489:
        i1 = 5;
      }
    }
  }
  
  public boolean b()
  {
    if (this.e == null) {
      this.e = MobileQQ.getContext().getSharedPreferences("bgCpu", 4);
    }
    return this.e.getBoolean("enable_nor_sensor", true);
  }
  
  void c()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground,sCountActivity = ", Integer.valueOf(Foreground.getActivityCount()) });
    if (this.s)
    {
      QLog.d("BatteryStats.BgCpu", 1, "BackgroundCpuMonitor onAppBackground");
      return;
    }
    if (this.t == null) {
      this.t = new Handler(ThreadManager.getFileThreadLooper(), this);
    }
    this.t.sendEmptyMessage(10);
    this.s = true;
    if (this.f)
    {
      if (Looper.myLooper() != ThreadManager.getFileThreadLooper()) {
        return;
      }
      if (!a(true, false, null)) {
        return;
      }
      this.t.sendEmptyMessageDelayed(0, 300000L);
    }
  }
  
  void d()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppForeground,sCountActivity = ", Integer.valueOf(Foreground.getActivityCount()) });
    this.s = false;
    Handler localHandler = this.t;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(11);
    this.t.removeMessages(10);
    this.t.removeMessages(0);
    this.t.removeMessages(1);
    if (this.q > 0L)
    {
      QLog.d("BatteryStats.BgCpu", 1, "stop trace bg cpu");
      try
      {
        Debug.stopMethodTracing();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("BatteryStats.BgCpu", 1, localThrowable, new Object[0]);
      }
      this.q = 0L;
    }
    if (!this.r)
    {
      f();
      this.r = true;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(21)
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 519	android/os/Message:what	I
    //   4: istore_2
    //   5: iconst_0
    //   6: invokestatic 524	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   9: astore 16
    //   11: iload_2
    //   12: bipush 10
    //   14: if_icmpne +25 -> 39
    //   17: aload_0
    //   18: getfield 128	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:c	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   21: invokevirtual 526	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:a	()V
    //   24: aload_0
    //   25: getfield 136	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:t	Landroid/os/Handler;
    //   28: bipush 10
    //   30: ldc2_w 485
    //   33: invokevirtual 490	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   36: pop
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 519	android/os/Message:what	I
    //   43: bipush 11
    //   45: if_icmpne +13 -> 58
    //   48: aload_0
    //   49: getfield 128	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:c	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   52: invokevirtual 528	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:b	()V
    //   55: goto -18 -> 37
    //   58: aload_1
    //   59: getfield 519	android/os/Message:what	I
    //   62: iconst_2
    //   63: if_icmpne +10 -> 73
    //   66: aload_0
    //   67: invokevirtual 530	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:c	()V
    //   70: goto -33 -> 37
    //   73: aload_1
    //   74: getfield 519	android/os/Message:what	I
    //   77: ifne +744 -> 821
    //   80: new 532	java/util/HashMap
    //   83: dup
    //   84: iconst_5
    //   85: invokespecial 533	java/util/HashMap:<init>	(I)V
    //   88: astore_1
    //   89: aload_0
    //   90: iconst_1
    //   91: iconst_1
    //   92: aload_1
    //   93: invokespecial 484	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   96: ifeq -59 -> 37
    //   99: aload_1
    //   100: ldc_w 268
    //   103: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   106: ifeq -69 -> 37
    //   109: aload_1
    //   110: ldc_w 276
    //   113: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   116: ifeq -79 -> 37
    //   119: aload_1
    //   120: ldc_w 268
    //   123: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 208	java/lang/Long
    //   129: invokevirtual 211	java/lang/Long:longValue	()J
    //   132: lstore 5
    //   134: aload_1
    //   135: ldc_w 276
    //   138: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   141: ifeq +20 -> 161
    //   144: aload_1
    //   145: ldc_w 276
    //   148: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 208	java/lang/Long
    //   154: invokevirtual 211	java/lang/Long:longValue	()J
    //   157: lstore_3
    //   158: goto +5 -> 163
    //   161: lconst_0
    //   162: lstore_3
    //   163: ldc 235
    //   165: iconst_1
    //   166: bipush 6
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 542
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: lload 5
    //   181: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: ldc_w 296
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: lload_3
    //   194: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: dup
    //   199: iconst_4
    //   200: ldc 242
    //   202: aastore
    //   203: dup
    //   204: iconst_5
    //   205: aload 16
    //   207: aastore
    //   208: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   211: lload 5
    //   213: lload_3
    //   214: lsub
    //   215: aload_0
    //   216: getfield 107	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:h	I
    //   219: i2l
    //   220: lcmp
    //   221: ifgt +13 -> 234
    //   224: lload_3
    //   225: aload_0
    //   226: getfield 109	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:i	I
    //   229: i2l
    //   230: lcmp
    //   231: ifle -194 -> 37
    //   234: new 532	java/util/HashMap
    //   237: dup
    //   238: iconst_2
    //   239: invokespecial 533	java/util/HashMap:<init>	(I)V
    //   242: astore 16
    //   244: new 44	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   251: astore 17
    //   253: aload 17
    //   255: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   258: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 17
    //   264: ldc_w 547
    //   267: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 17
    //   273: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: astore 17
    //   278: new 44	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   285: astore 18
    //   287: aload 18
    //   289: aload_1
    //   290: ldc_w 268
    //   293: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 18
    //   302: ldc_w 461
    //   305: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 16
    //   311: aload 17
    //   313: aload 18
    //   315: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   321: pop
    //   322: new 44	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   329: astore 17
    //   331: aload 17
    //   333: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   336: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 17
    //   342: ldc_w 553
    //   345: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 17
    //   351: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore 17
    //   356: new 44	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   363: astore 18
    //   365: aload 18
    //   367: aload_1
    //   368: ldc_w 276
    //   371: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   374: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 18
    //   380: ldc_w 461
    //   383: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 16
    //   389: aload 17
    //   391: aload 18
    //   393: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: new 44	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   407: astore 17
    //   409: aload 17
    //   411: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   414: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 17
    //   420: ldc_w 555
    //   423: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 17
    //   429: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: astore 17
    //   434: new 44	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   441: astore 18
    //   443: aload 18
    //   445: aload_1
    //   446: ldc_w 258
    //   449: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   452: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 18
    //   458: ldc_w 461
    //   461: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 16
    //   467: aload 17
    //   469: aload 18
    //   471: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   477: pop
    //   478: new 44	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   485: astore 17
    //   487: aload 17
    //   489: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   492: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 17
    //   498: ldc_w 557
    //   501: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 17
    //   507: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: astore 17
    //   512: new 44	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   519: astore 18
    //   521: aload 18
    //   523: aload_1
    //   524: ldc_w 266
    //   527: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   530: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 18
    //   536: ldc_w 461
    //   539: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 16
    //   545: aload 17
    //   547: aload 18
    //   549: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   555: pop
    //   556: new 44	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   563: astore 17
    //   565: aload 17
    //   567: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   570: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 17
    //   576: ldc_w 559
    //   579: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 17
    //   585: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: astore 17
    //   590: new 44	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   597: astore 18
    //   599: aload 18
    //   601: aload_1
    //   602: ldc_w 274
    //   605: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   608: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 18
    //   614: ldc_w 461
    //   617: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 16
    //   623: aload 17
    //   625: aload 18
    //   627: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: aload 16
    //   636: ldc_w 561
    //   639: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   642: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   645: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   648: pop
    //   649: aload 16
    //   651: ldc_w 563
    //   654: getstatic 358	android/os/Build$VERSION:SDK_INT	I
    //   657: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   660: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: pop
    //   664: invokestatic 171	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   667: invokestatic 568	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   670: aconst_null
    //   671: ldc_w 570
    //   674: iconst_1
    //   675: lconst_0
    //   676: lconst_0
    //   677: aload 16
    //   679: aconst_null
    //   680: invokevirtual 574	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   683: new 55	java/io/File
    //   686: dup
    //   687: getstatic 95	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:v	Ljava/lang/String;
    //   690: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   693: astore_1
    //   694: aload_1
    //   695: invokevirtual 577	java/io/File:getParentFile	()Ljava/io/File;
    //   698: ifnull +21 -> 719
    //   701: aload_1
    //   702: invokevirtual 577	java/io/File:getParentFile	()Ljava/io/File;
    //   705: invokevirtual 317	java/io/File:exists	()Z
    //   708: ifeq +11 -> 719
    //   711: aload_1
    //   712: invokevirtual 577	java/io/File:getParentFile	()Ljava/io/File;
    //   715: invokevirtual 580	java/io/File:mkdirs	()Z
    //   718: pop
    //   719: aload_1
    //   720: invokevirtual 317	java/io/File:exists	()Z
    //   723: ifeq +8 -> 731
    //   726: aload_1
    //   727: invokevirtual 351	java/io/File:delete	()Z
    //   730: pop
    //   731: aload_0
    //   732: getfield 111	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:j	Z
    //   735: ifeq +7 -> 742
    //   738: iconst_2
    //   739: invokestatic 583	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   742: getstatic 95	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:v	Ljava/lang/String;
    //   745: ldc_w 584
    //   748: sipush 1000
    //   751: invokestatic 588	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   754: aload_0
    //   755: invokestatic 593	android/os/SystemClock:uptimeMillis	()J
    //   758: putfield 130	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:q	J
    //   761: aload_0
    //   762: getfield 136	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:t	Landroid/os/Handler;
    //   765: aload_0
    //   766: getfield 136	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:t	Landroid/os/Handler;
    //   769: iconst_1
    //   770: aload 16
    //   772: invokestatic 597	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   775: ldc2_w 485
    //   778: invokevirtual 601	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   781: pop
    //   782: goto -745 -> 37
    //   785: astore_1
    //   786: aload_0
    //   787: iconst_0
    //   788: putfield 103	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:f	Z
    //   791: ldc 235
    //   793: iconst_1
    //   794: ldc_w 603
    //   797: aload_1
    //   798: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: invokestatic 504	android/os/Debug:stopMethodTracing	()V
    //   804: goto -767 -> 37
    //   807: astore_1
    //   808: ldc 235
    //   810: iconst_1
    //   811: ldc_w 461
    //   814: aload_1
    //   815: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   818: goto -781 -> 37
    //   821: aload_1
    //   822: getfield 519	android/os/Message:what	I
    //   825: iconst_3
    //   826: if_icmpne +13 -> 839
    //   829: aload_1
    //   830: getfield 608	android/os/Message:arg1	I
    //   833: invokestatic 583	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   836: goto -799 -> 37
    //   839: aload_1
    //   840: getfield 519	android/os/Message:what	I
    //   843: iconst_1
    //   844: if_icmpne -807 -> 37
    //   847: invokestatic 504	android/os/Debug:stopMethodTracing	()V
    //   850: goto +17 -> 867
    //   853: astore_1
    //   854: ldc 235
    //   856: iconst_1
    //   857: ldc_w 461
    //   860: aload_1
    //   861: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   864: goto -14 -> 850
    //   867: aload_0
    //   868: lconst_0
    //   869: putfield 130	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:q	J
    //   872: new 532	java/util/HashMap
    //   875: dup
    //   876: iconst_5
    //   877: invokespecial 533	java/util/HashMap:<init>	(I)V
    //   880: astore 17
    //   882: aload_0
    //   883: iconst_1
    //   884: iconst_1
    //   885: aload 17
    //   887: invokespecial 484	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   890: ifeq -853 -> 37
    //   893: aload 17
    //   895: ldc_w 268
    //   898: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   901: ifeq -864 -> 37
    //   904: aload 17
    //   906: ldc_w 276
    //   909: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   912: ifeq -875 -> 37
    //   915: aload 17
    //   917: ldc_w 268
    //   920: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   923: checkcast 208	java/lang/Long
    //   926: invokevirtual 211	java/lang/Long:longValue	()J
    //   929: lstore 7
    //   931: aload 17
    //   933: ldc_w 276
    //   936: invokevirtual 536	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   939: ifeq +21 -> 960
    //   942: aload 17
    //   944: ldc_w 276
    //   947: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   950: checkcast 208	java/lang/Long
    //   953: invokevirtual 211	java/lang/Long:longValue	()J
    //   956: lstore_3
    //   957: goto +5 -> 962
    //   960: lconst_0
    //   961: lstore_3
    //   962: ldc 235
    //   964: iconst_1
    //   965: bipush 6
    //   967: anewarray 4	java/lang/Object
    //   970: dup
    //   971: iconst_0
    //   972: ldc_w 610
    //   975: aastore
    //   976: dup
    //   977: iconst_1
    //   978: lload 7
    //   980: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   983: aastore
    //   984: dup
    //   985: iconst_2
    //   986: ldc_w 296
    //   989: aastore
    //   990: dup
    //   991: iconst_3
    //   992: lload_3
    //   993: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   996: aastore
    //   997: dup
    //   998: iconst_4
    //   999: ldc_w 296
    //   1002: aastore
    //   1003: dup
    //   1004: iconst_5
    //   1005: aload 16
    //   1007: aastore
    //   1008: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1011: lload 7
    //   1013: lload_3
    //   1014: lsub
    //   1015: aload_0
    //   1016: getfield 107	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:h	I
    //   1019: i2l
    //   1020: lcmp
    //   1021: ifgt +56 -> 1077
    //   1024: lload_3
    //   1025: aload_0
    //   1026: getfield 109	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:i	I
    //   1029: i2l
    //   1030: lcmp
    //   1031: ifle +6 -> 1037
    //   1034: goto +43 -> 1077
    //   1037: ldc 235
    //   1039: iconst_1
    //   1040: iconst_4
    //   1041: anewarray 4	java/lang/Object
    //   1044: dup
    //   1045: iconst_0
    //   1046: ldc_w 612
    //   1049: aastore
    //   1050: dup
    //   1051: iconst_1
    //   1052: lload 7
    //   1054: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1057: aastore
    //   1058: dup
    //   1059: iconst_2
    //   1060: ldc_w 461
    //   1063: aastore
    //   1064: dup
    //   1065: iconst_3
    //   1066: lload_3
    //   1067: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1070: aastore
    //   1071: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1074: goto -1037 -> 37
    //   1077: aload 17
    //   1079: ldc_w 258
    //   1082: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: checkcast 208	java/lang/Long
    //   1088: invokevirtual 211	java/lang/Long:longValue	()J
    //   1091: lstore 9
    //   1093: aload 17
    //   1095: ldc_w 266
    //   1098: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: checkcast 208	java/lang/Long
    //   1104: invokevirtual 211	java/lang/Long:longValue	()J
    //   1107: lstore 11
    //   1109: aload 17
    //   1111: ldc_w 274
    //   1114: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1117: checkcast 208	java/lang/Long
    //   1120: invokevirtual 211	java/lang/Long:longValue	()J
    //   1123: lstore 13
    //   1125: new 55	java/io/File
    //   1128: dup
    //   1129: getstatic 95	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:v	Ljava/lang/String;
    //   1132: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   1135: astore_1
    //   1136: new 614	java/util/ArrayList
    //   1139: dup
    //   1140: iconst_4
    //   1141: invokespecial 615	java/util/ArrayList:<init>	(I)V
    //   1144: astore 20
    //   1146: aload 20
    //   1148: aload_1
    //   1149: invokevirtual 618	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1152: invokeinterface 623 2 0
    //   1157: pop
    //   1158: new 55	java/io/File
    //   1161: dup
    //   1162: getstatic 99	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:w	Ljava/lang/String;
    //   1165: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   1168: astore_1
    //   1169: aload_1
    //   1170: invokevirtual 317	java/io/File:exists	()Z
    //   1173: ifeq +8 -> 1181
    //   1176: aload_1
    //   1177: invokevirtual 351	java/io/File:delete	()Z
    //   1180: pop
    //   1181: aload 20
    //   1183: aload_1
    //   1184: invokevirtual 618	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1187: invokeinterface 623 2 0
    //   1192: pop
    //   1193: new 625	java/io/BufferedOutputStream
    //   1196: dup
    //   1197: new 627	java/io/FileOutputStream
    //   1200: dup
    //   1201: aload_1
    //   1202: invokespecial 630	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1205: invokespecial 633	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1208: astore 19
    //   1210: aload 19
    //   1212: astore 16
    //   1214: aload 19
    //   1216: ldc_w 635
    //   1219: invokevirtual 639	java/lang/String:getBytes	()[B
    //   1222: invokevirtual 643	java/io/BufferedOutputStream:write	([B)V
    //   1225: aload 19
    //   1227: astore 16
    //   1229: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   1232: istore_2
    //   1233: iload_2
    //   1234: iconst_1
    //   1235: if_icmpne +10 -> 1245
    //   1238: ldc_w 645
    //   1241: astore_1
    //   1242: goto +7 -> 1249
    //   1245: ldc_w 647
    //   1248: astore_1
    //   1249: aload 19
    //   1251: astore 16
    //   1253: aload 19
    //   1255: aload_1
    //   1256: invokevirtual 639	java/lang/String:getBytes	()[B
    //   1259: invokevirtual 643	java/io/BufferedOutputStream:write	([B)V
    //   1262: aload 19
    //   1264: astore 16
    //   1266: new 44	java/lang/StringBuilder
    //   1269: dup
    //   1270: sipush 200
    //   1273: invokespecial 289	java/lang/StringBuilder:<init>	(I)V
    //   1276: astore 22
    //   1278: aload 19
    //   1280: astore 16
    //   1282: aload 22
    //   1284: ldc_w 649
    //   1287: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 19
    //   1293: astore 16
    //   1295: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   1298: lstore 5
    //   1300: ldc 235
    //   1302: astore 21
    //   1304: aload 19
    //   1306: astore 16
    //   1308: aload 22
    //   1310: lload 5
    //   1312: ldc2_w 650
    //   1315: lsub
    //   1316: ldc_w 653
    //   1319: invokestatic 165	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1322: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload 19
    //   1328: astore 16
    //   1330: aload 22
    //   1332: ldc_w 655
    //   1335: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload 19
    //   1341: astore 16
    //   1343: aload 22
    //   1345: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   1348: ldc_w 653
    //   1351: invokestatic 165	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1354: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload 19
    //   1360: astore 16
    //   1362: aload 22
    //   1364: ldc_w 657
    //   1367: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 19
    //   1373: astore 16
    //   1375: aload 22
    //   1377: ldc_w 659
    //   1380: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload 19
    //   1386: astore 16
    //   1388: aload 22
    //   1390: lload 7
    //   1392: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 19
    //   1398: astore 16
    //   1400: aload 22
    //   1402: ldc_w 661
    //   1405: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 19
    //   1411: astore 16
    //   1413: aload 22
    //   1415: lload_3
    //   1416: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: aload 19
    //   1422: astore 16
    //   1424: aload 22
    //   1426: ldc_w 663
    //   1429: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: pop
    //   1433: aload 19
    //   1435: astore 16
    //   1437: aload 22
    //   1439: lload 9
    //   1441: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload 19
    //   1447: astore 16
    //   1449: aload 22
    //   1451: ldc_w 665
    //   1454: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: aload 19
    //   1460: astore 16
    //   1462: aload 22
    //   1464: lload 11
    //   1466: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1469: pop
    //   1470: aload 19
    //   1472: astore 16
    //   1474: aload 22
    //   1476: ldc_w 667
    //   1479: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload 19
    //   1485: astore 16
    //   1487: aload 22
    //   1489: lload 13
    //   1491: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1494: pop
    //   1495: aload 19
    //   1497: astore 16
    //   1499: aload 22
    //   1501: ldc_w 669
    //   1504: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: pop
    //   1508: aload 19
    //   1510: astore 16
    //   1512: aload 22
    //   1514: aload 17
    //   1516: ldc_w 278
    //   1519: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1522: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1525: pop
    //   1526: aload 19
    //   1528: astore 16
    //   1530: aload 22
    //   1532: ldc_w 671
    //   1535: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: pop
    //   1539: aload 19
    //   1541: astore 16
    //   1543: aload 22
    //   1545: aload 17
    //   1547: ldc_w 280
    //   1550: invokevirtual 540	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1553: invokevirtual 550	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload 19
    //   1559: astore 16
    //   1561: aload 22
    //   1563: ldc_w 657
    //   1566: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1569: pop
    //   1570: aload 19
    //   1572: astore 16
    //   1574: aload 19
    //   1576: aload 22
    //   1578: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: invokevirtual 639	java/lang/String:getBytes	()[B
    //   1584: invokevirtual 643	java/io/BufferedOutputStream:write	([B)V
    //   1587: aload 19
    //   1589: astore 16
    //   1591: invokestatic 171	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1594: invokevirtual 675	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1597: astore_1
    //   1598: aload 19
    //   1600: astore 16
    //   1602: aload_1
    //   1603: ldc 67
    //   1605: sipush 128
    //   1608: invokevirtual 681	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1611: astore 17
    //   1613: aload 19
    //   1615: astore 16
    //   1617: new 44	java/lang/StringBuilder
    //   1620: dup
    //   1621: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   1624: astore 18
    //   1626: aload 19
    //   1628: astore 16
    //   1630: aload 18
    //   1632: aload 17
    //   1634: getfield 686	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1637: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: pop
    //   1641: aload 19
    //   1643: astore 16
    //   1645: aload 18
    //   1647: ldc 69
    //   1649: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: pop
    //   1653: aload 19
    //   1655: astore 16
    //   1657: aload 18
    //   1659: aload 17
    //   1661: getfield 689	android/content/pm/PackageInfo:versionCode	I
    //   1664: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1667: pop
    //   1668: aload 19
    //   1670: astore 16
    //   1672: aload 18
    //   1674: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1677: astore 18
    //   1679: aload 19
    //   1681: astore 16
    //   1683: aload_1
    //   1684: ldc 67
    //   1686: sipush 128
    //   1689: invokevirtual 693	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1692: getfield 699	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1695: ldc_w 701
    //   1698: invokevirtual 706	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1701: invokevirtual 707	java/lang/Object:toString	()Ljava/lang/String;
    //   1704: astore_1
    //   1705: aload 19
    //   1707: astore 16
    //   1709: getstatic 711	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   1712: aconst_null
    //   1713: invokevirtual 715	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1716: invokevirtual 720	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1719: invokestatic 723	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1722: lstore 5
    //   1724: ldc_w 725
    //   1727: astore 17
    //   1729: goto +51 -> 1780
    //   1732: astore 17
    //   1734: goto +23 -> 1757
    //   1737: astore 17
    //   1739: aconst_null
    //   1740: astore_1
    //   1741: goto +16 -> 1757
    //   1744: astore 17
    //   1746: goto +5 -> 1751
    //   1749: astore 17
    //   1751: aconst_null
    //   1752: astore 18
    //   1754: aload 18
    //   1756: astore_1
    //   1757: aload 19
    //   1759: astore 16
    //   1761: aload 21
    //   1763: iconst_1
    //   1764: ldc_w 461
    //   1767: aload 17
    //   1769: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1772: lconst_0
    //   1773: lstore 5
    //   1775: ldc_w 727
    //   1778: astore 17
    //   1780: aload 19
    //   1782: astore 16
    //   1784: aload 22
    //   1786: iconst_0
    //   1787: aload 22
    //   1789: invokevirtual 730	java/lang/StringBuilder:length	()I
    //   1792: invokevirtual 733	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1795: pop
    //   1796: aload 19
    //   1798: astore 16
    //   1800: aload 22
    //   1802: ldc_w 735
    //   1805: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload 19
    //   1811: astore 16
    //   1813: aload 22
    //   1815: lload 5
    //   1817: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1820: pop
    //   1821: aload 19
    //   1823: astore 16
    //   1825: aload 22
    //   1827: ldc_w 737
    //   1830: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1833: pop
    //   1834: aload 19
    //   1836: astore 16
    //   1838: aload 22
    //   1840: aload 18
    //   1842: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: pop
    //   1846: aload 19
    //   1848: astore 16
    //   1850: aload 22
    //   1852: ldc_w 739
    //   1855: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: pop
    //   1859: aload 19
    //   1861: astore 16
    //   1863: aload 22
    //   1865: aload_1
    //   1866: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: pop
    //   1870: aload 19
    //   1872: astore 16
    //   1874: aload 22
    //   1876: ldc_w 741
    //   1879: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: pop
    //   1883: aload 19
    //   1885: astore 16
    //   1887: aload 22
    //   1889: aload 17
    //   1891: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: pop
    //   1895: aload 19
    //   1897: astore 16
    //   1899: aload 22
    //   1901: ldc_w 743
    //   1904: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: pop
    //   1908: aload 19
    //   1910: astore 16
    //   1912: aload 22
    //   1914: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   1917: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1920: pop
    //   1921: aload 19
    //   1923: astore 16
    //   1925: aload 22
    //   1927: ldc_w 745
    //   1930: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1933: pop
    //   1934: aload 19
    //   1936: astore 16
    //   1938: aload 22
    //   1940: invokestatic 402	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1943: invokevirtual 748	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1946: pop
    //   1947: aload 19
    //   1949: astore 16
    //   1951: aload 19
    //   1953: aload 22
    //   1955: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1958: invokevirtual 639	java/lang/String:getBytes	()[B
    //   1961: invokevirtual 643	java/io/BufferedOutputStream:write	([B)V
    //   1964: aload 19
    //   1966: astore 16
    //   1968: aload 19
    //   1970: invokevirtual 751	java/io/BufferedOutputStream:flush	()V
    //   1973: aload 19
    //   1975: invokevirtual 754	java/io/BufferedOutputStream:close	()V
    //   1978: ldc 235
    //   1980: astore 16
    //   1982: goto +103 -> 2085
    //   1985: astore_1
    //   1986: goto +20 -> 2006
    //   1989: astore 17
    //   1991: aload 21
    //   1993: astore_1
    //   1994: aload 19
    //   1996: astore 18
    //   1998: goto +44 -> 2042
    //   2001: astore_1
    //   2002: goto +4 -> 2006
    //   2005: astore_1
    //   2006: ldc 235
    //   2008: astore 16
    //   2010: aload_1
    //   2011: astore 17
    //   2013: aload 16
    //   2015: astore_1
    //   2016: aload 19
    //   2018: astore 18
    //   2020: goto +22 -> 2042
    //   2023: astore 17
    //   2025: goto +11 -> 2036
    //   2028: astore_1
    //   2029: aconst_null
    //   2030: astore 16
    //   2032: goto +793 -> 2825
    //   2035: astore_1
    //   2036: ldc 235
    //   2038: astore_1
    //   2039: aconst_null
    //   2040: astore 18
    //   2042: aload 18
    //   2044: astore 16
    //   2046: invokestatic 402	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2049: ifeq +17 -> 2066
    //   2052: aload 18
    //   2054: astore 16
    //   2056: aload_1
    //   2057: iconst_2
    //   2058: ldc_w 461
    //   2061: aload 17
    //   2063: invokestatic 464	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2066: aload_1
    //   2067: astore 16
    //   2069: aload 18
    //   2071: ifnull +14 -> 2085
    //   2074: aload 18
    //   2076: invokevirtual 754	java/io/BufferedOutputStream:close	()V
    //   2079: aload_1
    //   2080: astore 16
    //   2082: goto +3 -> 2085
    //   2085: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   2088: invokestatic 756	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   2091: astore_1
    //   2092: invokestatic 310	java/lang/System:currentTimeMillis	()J
    //   2095: ldc2_w 757
    //   2098: lsub
    //   2099: invokestatic 756	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   2102: astore 17
    //   2104: aload 20
    //   2106: aload_1
    //   2107: invokeinterface 623 2 0
    //   2112: pop
    //   2113: aload_1
    //   2114: aload 17
    //   2116: invokevirtual 446	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2119: ifne +13 -> 2132
    //   2122: aload 20
    //   2124: aload 17
    //   2126: invokeinterface 623 2 0
    //   2131: pop
    //   2132: invokestatic 760	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:e	()Ljava/lang/String;
    //   2135: astore 18
    //   2137: aload 20
    //   2139: aload 18
    //   2141: invokestatic 766	com/tencent/mobileqq/utils/FileUtils:zipFiles	(Ljava/util/List;Ljava/lang/String;)Z
    //   2144: ifeq +182 -> 2326
    //   2147: aload_0
    //   2148: aload_0
    //   2149: getfield 105	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:g	I
    //   2152: iconst_1
    //   2153: isub
    //   2154: putfield 105	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:g	I
    //   2157: aload_0
    //   2158: getfield 362	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:e	Landroid/content/SharedPreferences;
    //   2161: invokeinterface 417 1 0
    //   2166: ldc_w 429
    //   2169: aload_0
    //   2170: getfield 362	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:e	Landroid/content/SharedPreferences;
    //   2173: ldc_w 429
    //   2176: iconst_0
    //   2177: invokeinterface 440 3 0
    //   2182: iconst_1
    //   2183: iadd
    //   2184: invokeinterface 433 3 0
    //   2189: invokeinterface 436 1 0
    //   2194: pop
    //   2195: new 768	org/json/JSONObject
    //   2198: dup
    //   2199: invokespecial 769	org/json/JSONObject:<init>	()V
    //   2202: astore_1
    //   2203: new 768	org/json/JSONObject
    //   2206: dup
    //   2207: invokespecial 769	org/json/JSONObject:<init>	()V
    //   2210: astore 17
    //   2212: aload 17
    //   2214: ldc_w 771
    //   2217: aload 18
    //   2219: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2222: pop
    //   2223: new 768	org/json/JSONObject
    //   2226: dup
    //   2227: invokespecial 769	org/json/JSONObject:<init>	()V
    //   2230: astore 18
    //   2232: aload 18
    //   2234: ldc_w 776
    //   2237: ldc_w 442
    //   2240: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2243: pop
    //   2244: aload_1
    //   2245: ldc_w 778
    //   2248: aload 17
    //   2250: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2253: pop
    //   2254: aload_1
    //   2255: ldc_w 780
    //   2258: aload 18
    //   2260: invokevirtual 774	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2263: pop
    //   2264: aload_1
    //   2265: ldc_w 782
    //   2268: bipush 126
    //   2270: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2273: pop
    //   2274: new 787	com/tencent/qqperf/repoter/ResultObject
    //   2277: dup
    //   2278: iconst_0
    //   2279: ldc_w 789
    //   2282: iconst_1
    //   2283: lconst_1
    //   2284: lconst_1
    //   2285: aload_1
    //   2286: iconst_1
    //   2287: iconst_1
    //   2288: getstatic 793	com/tencent/qqperf/MagnifierSDK:b	J
    //   2291: invokespecial 796	com/tencent/qqperf/repoter/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   2294: invokestatic 801	com/tencent/qqperf/repoter/ReporterMachine:a	(Lcom/tencent/qqperf/repoter/ResultObject;)V
    //   2297: aload 16
    //   2299: iconst_2
    //   2300: ldc_w 803
    //   2303: invokestatic 299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2306: goto +14 -> 2320
    //   2309: astore_1
    //   2310: aload 16
    //   2312: iconst_1
    //   2313: ldc_w 805
    //   2316: aload_1
    //   2317: invokestatic 605	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2320: iconst_1
    //   2321: istore 15
    //   2323: goto +6 -> 2329
    //   2326: iconst_0
    //   2327: istore 15
    //   2329: new 532	java/util/HashMap
    //   2332: dup
    //   2333: iconst_2
    //   2334: invokespecial 533	java/util/HashMap:<init>	(I)V
    //   2337: astore_1
    //   2338: new 44	java/lang/StringBuilder
    //   2341: dup
    //   2342: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2345: astore 16
    //   2347: aload 16
    //   2349: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2352: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2355: pop
    //   2356: aload 16
    //   2358: ldc_w 547
    //   2361: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2364: pop
    //   2365: aload 16
    //   2367: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: astore 16
    //   2372: new 44	java/lang/StringBuilder
    //   2375: dup
    //   2376: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2379: astore 17
    //   2381: aload 17
    //   2383: lload 7
    //   2385: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2388: pop
    //   2389: aload 17
    //   2391: ldc_w 461
    //   2394: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2397: pop
    //   2398: aload_1
    //   2399: aload 16
    //   2401: aload 17
    //   2403: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2406: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2409: pop
    //   2410: new 44	java/lang/StringBuilder
    //   2413: dup
    //   2414: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2417: astore 16
    //   2419: aload 16
    //   2421: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2424: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2427: pop
    //   2428: aload 16
    //   2430: ldc_w 553
    //   2433: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2436: pop
    //   2437: aload 16
    //   2439: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2442: astore 16
    //   2444: new 44	java/lang/StringBuilder
    //   2447: dup
    //   2448: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2451: astore 17
    //   2453: aload 17
    //   2455: lload_3
    //   2456: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2459: pop
    //   2460: aload 17
    //   2462: ldc_w 461
    //   2465: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: pop
    //   2469: aload_1
    //   2470: aload 16
    //   2472: aload 17
    //   2474: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2477: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2480: pop
    //   2481: new 44	java/lang/StringBuilder
    //   2484: dup
    //   2485: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2488: astore 16
    //   2490: aload 16
    //   2492: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2495: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2498: pop
    //   2499: aload 16
    //   2501: ldc_w 555
    //   2504: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2507: pop
    //   2508: aload 16
    //   2510: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2513: astore 16
    //   2515: new 44	java/lang/StringBuilder
    //   2518: dup
    //   2519: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2522: astore 17
    //   2524: aload 17
    //   2526: lload 9
    //   2528: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2531: pop
    //   2532: aload 17
    //   2534: ldc_w 461
    //   2537: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2540: pop
    //   2541: aload_1
    //   2542: aload 16
    //   2544: aload 17
    //   2546: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2549: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2552: pop
    //   2553: new 44	java/lang/StringBuilder
    //   2556: dup
    //   2557: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2560: astore 16
    //   2562: aload 16
    //   2564: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2567: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2570: pop
    //   2571: aload 16
    //   2573: ldc_w 557
    //   2576: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: pop
    //   2580: aload 16
    //   2582: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2585: astore 16
    //   2587: new 44	java/lang/StringBuilder
    //   2590: dup
    //   2591: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2594: astore 17
    //   2596: aload 17
    //   2598: lload 11
    //   2600: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2603: pop
    //   2604: aload 17
    //   2606: ldc_w 461
    //   2609: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: pop
    //   2613: aload_1
    //   2614: aload 16
    //   2616: aload 17
    //   2618: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2621: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2624: pop
    //   2625: new 44	java/lang/StringBuilder
    //   2628: dup
    //   2629: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2632: astore 16
    //   2634: aload 16
    //   2636: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2639: invokevirtual 545	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2642: pop
    //   2643: aload 16
    //   2645: ldc_w 559
    //   2648: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2651: pop
    //   2652: aload 16
    //   2654: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2657: astore 16
    //   2659: new 44	java/lang/StringBuilder
    //   2662: dup
    //   2663: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   2666: astore 17
    //   2668: aload 17
    //   2670: lload 13
    //   2672: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2675: pop
    //   2676: aload 17
    //   2678: ldc_w 461
    //   2681: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2684: pop
    //   2685: aload_1
    //   2686: aload 16
    //   2688: aload 17
    //   2690: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2693: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2696: pop
    //   2697: aload_1
    //   2698: ldc_w 561
    //   2701: getstatic 219	mqq/app/MobileQQ:sProcessId	I
    //   2704: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2707: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2710: pop
    //   2711: aload_1
    //   2712: ldc_w 563
    //   2715: getstatic 358	android/os/Build$VERSION:SDK_INT	I
    //   2718: invokestatic 228	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2721: invokevirtual 551	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2724: pop
    //   2725: invokestatic 171	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2728: invokestatic 568	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2731: aconst_null
    //   2732: ldc_w 807
    //   2735: iload 15
    //   2737: lconst_0
    //   2738: lconst_0
    //   2739: aload_1
    //   2740: aconst_null
    //   2741: invokevirtual 574	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2744: aload 20
    //   2746: invokeinterface 811 1 0
    //   2751: astore_1
    //   2752: aload_1
    //   2753: invokeinterface 816 1 0
    //   2758: ifeq -2721 -> 37
    //   2761: aload_1
    //   2762: invokeinterface 820 1 0
    //   2767: checkcast 74	java/lang/String
    //   2770: astore 16
    //   2772: aload 16
    //   2774: ldc 183
    //   2776: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2779: ifne -27 -> 2752
    //   2782: aload 16
    //   2784: ldc_w 825
    //   2787: invokevirtual 823	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2790: ifeq +6 -> 2796
    //   2793: goto -41 -> 2752
    //   2796: new 55	java/io/File
    //   2799: dup
    //   2800: aload 16
    //   2802: invokespecial 313	java/io/File:<init>	(Ljava/lang/String;)V
    //   2805: astore 16
    //   2807: aload 16
    //   2809: invokevirtual 317	java/io/File:exists	()Z
    //   2812: ifeq -60 -> 2752
    //   2815: aload 16
    //   2817: invokevirtual 351	java/io/File:delete	()Z
    //   2820: pop
    //   2821: goto -69 -> 2752
    //   2824: astore_1
    //   2825: aload 16
    //   2827: ifnull +8 -> 2835
    //   2830: aload 16
    //   2832: invokevirtual 754	java/io/BufferedOutputStream:close	()V
    //   2835: aload_1
    //   2836: athrow
    //   2837: astore_1
    //   2838: goto -860 -> 1978
    //   2841: astore 16
    //   2843: aload_1
    //   2844: astore 16
    //   2846: goto -761 -> 2085
    //   2849: astore 16
    //   2851: goto -16 -> 2835
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2854	0	this	BackgroundCpuMonitor
    //   0	2854	1	paramMessage	android.os.Message
    //   4	1232	2	i1	int
    //   157	1259	3	l1	long
    //   132	1684	5	l2	long
    //   929	462	7	l3	long
    //   1091	349	9	l4	long
    //   1107	358	11	l5	long
    //   1123	367	13	l6	long
    //   9	2022	16	localObject1	Object
    //   251	1477	17	localObject2	Object
    //   1732	1	17	localException1	Exception
    //   1737	1	17	localException2	Exception
    //   1744	1	17	localException3	Exception
    //   1749	19	17	localException4	Exception
    //   1778	112	17	str1	String
    //   1989	1	17	localException5	Exception
    //   2011	1	17	localMessage	android.os.Message
    //   2023	1	17	localException6	Exception
    //   285	1734	18	localObject3	Object
    //   1208	809	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1144	38	20	localArrayList	java.util.ArrayList
    //   1302	690	21	str2	String
    //   1276	678	22	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   742	782	785	java/lang/Throwable
    //   801	804	807	java/lang/Throwable
    //   847	850	853	java/lang/Throwable
    //   1709	1724	1732	java/lang/Exception
    //   1683	1705	1737	java/lang/Exception
    //   1630	1641	1744	java/lang/Exception
    //   1645	1653	1744	java/lang/Exception
    //   1657	1668	1744	java/lang/Exception
    //   1672	1679	1744	java/lang/Exception
    //   1591	1598	1749	java/lang/Exception
    //   1602	1613	1749	java/lang/Exception
    //   1617	1626	1749	java/lang/Exception
    //   1784	1796	1985	java/lang/Exception
    //   1800	1809	1985	java/lang/Exception
    //   1813	1821	1985	java/lang/Exception
    //   1825	1834	1985	java/lang/Exception
    //   1838	1846	1985	java/lang/Exception
    //   1850	1859	1985	java/lang/Exception
    //   1863	1870	1985	java/lang/Exception
    //   1874	1883	1985	java/lang/Exception
    //   1887	1895	1985	java/lang/Exception
    //   1899	1908	1985	java/lang/Exception
    //   1912	1921	1985	java/lang/Exception
    //   1925	1934	1985	java/lang/Exception
    //   1938	1947	1985	java/lang/Exception
    //   1951	1964	1985	java/lang/Exception
    //   1968	1973	1985	java/lang/Exception
    //   1761	1772	1989	java/lang/Exception
    //   1308	1326	2001	java/lang/Exception
    //   1330	1339	2001	java/lang/Exception
    //   1343	1358	2001	java/lang/Exception
    //   1362	1371	2001	java/lang/Exception
    //   1375	1384	2001	java/lang/Exception
    //   1388	1396	2001	java/lang/Exception
    //   1400	1409	2001	java/lang/Exception
    //   1413	1420	2001	java/lang/Exception
    //   1424	1433	2001	java/lang/Exception
    //   1437	1445	2001	java/lang/Exception
    //   1449	1458	2001	java/lang/Exception
    //   1462	1470	2001	java/lang/Exception
    //   1474	1483	2001	java/lang/Exception
    //   1487	1495	2001	java/lang/Exception
    //   1499	1508	2001	java/lang/Exception
    //   1512	1526	2001	java/lang/Exception
    //   1530	1539	2001	java/lang/Exception
    //   1543	1557	2001	java/lang/Exception
    //   1561	1570	2001	java/lang/Exception
    //   1574	1587	2001	java/lang/Exception
    //   1214	1225	2005	java/lang/Exception
    //   1229	1233	2005	java/lang/Exception
    //   1253	1262	2005	java/lang/Exception
    //   1266	1278	2005	java/lang/Exception
    //   1282	1291	2005	java/lang/Exception
    //   1295	1300	2005	java/lang/Exception
    //   1193	1210	2023	java/lang/Exception
    //   1193	1210	2028	finally
    //   2195	2306	2309	java/lang/Exception
    //   1214	1225	2824	finally
    //   1229	1233	2824	finally
    //   1253	1262	2824	finally
    //   1266	1278	2824	finally
    //   1282	1291	2824	finally
    //   1295	1300	2824	finally
    //   1308	1326	2824	finally
    //   1330	1339	2824	finally
    //   1343	1358	2824	finally
    //   1362	1371	2824	finally
    //   1375	1384	2824	finally
    //   1388	1396	2824	finally
    //   1400	1409	2824	finally
    //   1413	1420	2824	finally
    //   1424	1433	2824	finally
    //   1437	1445	2824	finally
    //   1449	1458	2824	finally
    //   1462	1470	2824	finally
    //   1474	1483	2824	finally
    //   1487	1495	2824	finally
    //   1499	1508	2824	finally
    //   1512	1526	2824	finally
    //   1530	1539	2824	finally
    //   1543	1557	2824	finally
    //   1561	1570	2824	finally
    //   1574	1587	2824	finally
    //   1591	1598	2824	finally
    //   1602	1613	2824	finally
    //   1617	1626	2824	finally
    //   1630	1641	2824	finally
    //   1645	1653	2824	finally
    //   1657	1668	2824	finally
    //   1672	1679	2824	finally
    //   1683	1705	2824	finally
    //   1709	1724	2824	finally
    //   1761	1772	2824	finally
    //   1784	1796	2824	finally
    //   1800	1809	2824	finally
    //   1813	1821	2824	finally
    //   1825	1834	2824	finally
    //   1838	1846	2824	finally
    //   1850	1859	2824	finally
    //   1863	1870	2824	finally
    //   1874	1883	2824	finally
    //   1887	1895	2824	finally
    //   1899	1908	2824	finally
    //   1912	1921	2824	finally
    //   1925	1934	2824	finally
    //   1938	1947	2824	finally
    //   1951	1964	2824	finally
    //   1968	1973	2824	finally
    //   2046	2052	2824	finally
    //   2056	2066	2824	finally
    //   1973	1978	2837	java/lang/Exception
    //   2074	2079	2841	java/lang/Exception
    //   2830	2835	2849	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor
 * JD-Core Version:    0.7.0.1
 */