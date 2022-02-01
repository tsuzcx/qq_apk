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
  public static int a = -1000;
  public static long a;
  private static BackgroundCpuMonitor jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor;
  private static final String jdField_a_of_type_JavaLangString;
  private static final String jdField_b_of_type_JavaLangString;
  private static final String jdField_c_of_type_JavaLangString;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  BackgroundCpuMonitor.BgCpuTotalCost jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost = new BackgroundCpuMonitor.BgCpuTotalCost();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 10;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 15;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/tencent/msflogs/");
    localStringBuilder.append("com.tencent.mobileqq".replace(".", File.separator));
    localStringBuilder.append(File.separator);
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append("temp.trace");
    jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append("baseInfo.txt");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static BackgroundCpuMonitor a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor == null) {
          jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor = new BackgroundCpuMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor;
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("bg_cpu_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".trace.zip");
    return localStringBuilder.toString();
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
    Object[] arrayOfObject = ProcessStats.a("-2");
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
    long l6 = jdField_a_of_type_Long;
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "cpuInfo: ", Long.valueOf(l1), ", ", Long.valueOf(l2), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", Long.valueOf(l5), ", ", Long.valueOf(l6) });
    if ((l1 > 0L) && (l2 > 0L) && (l4 > 0L) && ((MobileQQ.sProcessId == 4) || (l3 > 0L)))
    {
      if (paramBoolean2)
      {
        long l7 = l1 - this.jdField_b_of_type_Long;
        if ((l7 > 0L) && (l2 > this.jdField_c_of_type_Long))
        {
          long l8 = this.jdField_d_of_type_Long;
          if (l4 > l8)
          {
            l8 = l4 - l8;
            int k = (int)(l8 * 100L / l7);
            if (paramMap != null)
            {
              paramMap.put("elapse", Long.valueOf(l7));
              paramMap.put("qqConsume", Long.valueOf(l8));
              paramMap.put("qqRatio", Long.valueOf(k));
            }
            int i;
            if (MobileQQ.sProcessId != 4)
            {
              l8 = this.e;
              if (l3 < l8)
              {
                QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.e) });
                return false;
              }
              l8 = l3 - l8;
              int j = (int)(100L * l8 / l7);
              i = j;
              if (paramMap != null)
              {
                paramMap.put("msfConsume", Long.valueOf(l8));
                paramMap.put("msfRatio", Long.valueOf(j));
                i = j;
              }
            }
            else
            {
              paramMap.put("msfConsume", Long.valueOf(0L));
              paramMap.put("msfRatio", Long.valueOf(0L));
              i = -1;
            }
            paramMap.put("msfTime", Long.valueOf(l5 - this.f));
            paramMap.put("ftsTime", Long.valueOf(l6 - this.g));
            QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(k), ", msf-receiver cpuRatio = ", Integer.valueOf(i), ", remainRptCount = ", Integer.valueOf(this.jdField_b_of_type_Int) });
            break label738;
          }
        }
        paramMap = new StringBuilder(256);
        paramMap.append("bad cpu value2.");
        paramMap.append(l1);
        paramMap.append(",");
        paramMap.append(this.jdField_b_of_type_Long);
        paramMap.append(",");
        paramMap.append(l2);
        paramMap.append(",");
        paramMap.append(this.jdField_c_of_type_Long);
        paramMap.append(",");
        paramMap.append(l4);
        paramMap.append(",");
        paramMap.append(this.jdField_d_of_type_Long);
        QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
        return false;
      }
      label738:
      if (paramBoolean1)
      {
        this.jdField_b_of_type_Long = l1;
        this.jdField_c_of_type_Long = l2;
        this.jdField_d_of_type_Long = l4;
        this.e = l3;
        this.f = l5;
        this.g = l6;
      }
      return true;
    }
    QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
    return false;
  }
  
  private static void c()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int k = localObject1.length;
        int i = 0;
        while (i < k)
        {
          Object localObject2 = localObject1[i];
          int j;
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("bg_cpu_"))) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
            localObject2.delete();
          }
          i += 1;
        }
      }
    }
  }
  
  void a()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground,sCountActivity = ", Integer.valueOf(Foreground.getActivityCount()) });
    if (this.jdField_d_of_type_Boolean)
    {
      QLog.d("BatteryStats.BgCpu", 1, "BackgroundCpuMonitor onAppBackground");
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean)
    {
      if (Looper.myLooper() != ThreadManager.getFileThreadLooper()) {
        return;
      }
      if (!a(true, false, null)) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
    }
  }
  
  void a(String paramString)
  {
    int j = MobileQQ.sProcessId;
    int i = 1;
    if ((j != 1) && (MobileQQ.sProcessId != 4)) {
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
        if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
          this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.getContext().getSharedPreferences("bgCpu", 4);
        }
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("rand_time", 0L);
        bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("rand_rs", false);
        paramString = paramString.split(";");
        l = Math.abs(System.currentTimeMillis() - l);
        if (l > 86400000L)
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
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label469;
          }
          break label472;
          this.jdField_c_of_type_Int = Integer.valueOf(paramString[j]).intValue();
          if (i == 0) {
            break label489;
          }
          i = 3;
          this.jdField_d_of_type_Int = Integer.valueOf(paramString[i]).intValue();
          this.jdField_b_of_type_Int = (Integer.valueOf(paramString[6]).intValue() - this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("times", 0));
          if (this.jdField_b_of_type_Int <= 0) {
            bool1 = false;
          }
          this.jdField_b_of_type_Boolean = "1".equals(paramString[7]);
          bool2 = bool1;
        }
        this.jdField_a_of_type_Boolean = bool2;
        if ((this.jdField_a_of_type_Boolean) && (MobileQQ.sProcessId == 4) && (this.jdField_a_of_type_AndroidOsHandler == null)) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        }
        if (paramString.length >= 10)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("enable_nor_sensor", "1".equals(paramString[9])).commit();
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
      i = 0;
      label472:
      if (i != 0)
      {
        j = 2;
      }
      else
      {
        j = 4;
        continue;
        label489:
        i = 5;
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.getContext().getSharedPreferences("bgCpu", 4);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("enable_nor_sensor", true);
  }
  
  void b()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppForeground,sCountActivity = ", Integer.valueOf(Foreground.getActivityCount()) });
    this.jdField_d_of_type_Boolean = false;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(11);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (this.h > 0L)
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
      this.h = 0L;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      c();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(21)
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 502	android/os/Message:what	I
    //   4: istore_2
    //   5: iconst_0
    //   6: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   9: astore 16
    //   11: iload_2
    //   12: bipush 10
    //   14: if_icmpne +25 -> 39
    //   17: aload_0
    //   18: getfield 111	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   21: invokevirtual 509	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:a	()V
    //   24: aload_0
    //   25: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   28: bipush 10
    //   30: ldc2_w 367
    //   33: invokevirtual 372	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   36: pop
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 502	android/os/Message:what	I
    //   43: bipush 11
    //   45: if_icmpne +13 -> 58
    //   48: aload_0
    //   49: getfield 111	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   52: invokevirtual 511	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:b	()V
    //   55: goto -18 -> 37
    //   58: aload_1
    //   59: getfield 502	android/os/Message:what	I
    //   62: iconst_2
    //   63: if_icmpne +10 -> 73
    //   66: aload_0
    //   67: invokevirtual 512	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	()V
    //   70: goto -33 -> 37
    //   73: aload_1
    //   74: getfield 502	android/os/Message:what	I
    //   77: ifne +743 -> 820
    //   80: new 514	java/util/HashMap
    //   83: dup
    //   84: iconst_5
    //   85: invokespecial 515	java/util/HashMap:<init>	(I)V
    //   88: astore_1
    //   89: aload_0
    //   90: iconst_1
    //   91: iconst_1
    //   92: aload_1
    //   93: invokespecial 366	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   96: ifeq -59 -> 37
    //   99: aload_1
    //   100: ldc_w 261
    //   103: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   106: ifeq -69 -> 37
    //   109: aload_1
    //   110: ldc_w 269
    //   113: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   116: ifeq -79 -> 37
    //   119: aload_1
    //   120: ldc_w 261
    //   123: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast 201	java/lang/Long
    //   129: invokevirtual 204	java/lang/Long:longValue	()J
    //   132: lstore 5
    //   134: aload_1
    //   135: ldc_w 269
    //   138: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   141: ifeq +20 -> 161
    //   144: aload_1
    //   145: ldc_w 269
    //   148: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: checkcast 201	java/lang/Long
    //   154: invokevirtual 204	java/lang/Long:longValue	()J
    //   157: lstore_3
    //   158: goto +5 -> 163
    //   161: lconst_0
    //   162: lstore_3
    //   163: ldc 228
    //   165: iconst_1
    //   166: bipush 6
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 524
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: lload 5
    //   181: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: ldc_w 286
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: lload_3
    //   194: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: dup
    //   199: iconst_4
    //   200: ldc 235
    //   202: aastore
    //   203: dup
    //   204: iconst_5
    //   205: aload 16
    //   207: aastore
    //   208: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   211: lload 5
    //   213: lload_3
    //   214: lsub
    //   215: aload_0
    //   216: getfield 90	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   219: i2l
    //   220: lcmp
    //   221: ifgt +13 -> 234
    //   224: lload_3
    //   225: aload_0
    //   226: getfield 92	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_d_of_type_Int	I
    //   229: i2l
    //   230: lcmp
    //   231: ifle -194 -> 37
    //   234: new 514	java/util/HashMap
    //   237: dup
    //   238: iconst_2
    //   239: invokespecial 515	java/util/HashMap:<init>	(I)V
    //   242: astore 16
    //   244: new 27	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   251: astore 17
    //   253: aload 17
    //   255: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   258: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 17
    //   264: ldc_w 529
    //   267: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 17
    //   273: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: astore 17
    //   278: new 27	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   285: astore 18
    //   287: aload 18
    //   289: aload_1
    //   290: ldc_w 261
    //   293: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   296: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 18
    //   302: ldc_w 470
    //   305: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 16
    //   311: aload 17
    //   313: aload 18
    //   315: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   321: pop
    //   322: new 27	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   329: astore 17
    //   331: aload 17
    //   333: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   336: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 17
    //   342: ldc_w 535
    //   345: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 17
    //   351: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: astore 17
    //   356: new 27	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   363: astore 18
    //   365: aload 18
    //   367: aload_1
    //   368: ldc_w 269
    //   371: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   374: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 18
    //   380: ldc_w 470
    //   383: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 16
    //   389: aload 17
    //   391: aload 18
    //   393: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: new 27	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   407: astore 17
    //   409: aload 17
    //   411: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   414: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 17
    //   420: ldc_w 537
    //   423: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 17
    //   429: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: astore 17
    //   434: new 27	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   441: astore 18
    //   443: aload 18
    //   445: aload_1
    //   446: ldc 251
    //   448: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 18
    //   457: ldc_w 470
    //   460: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 16
    //   466: aload 17
    //   468: aload 18
    //   470: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: new 27	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   484: astore 17
    //   486: aload 17
    //   488: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   491: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 17
    //   497: ldc_w 539
    //   500: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 17
    //   506: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: astore 17
    //   511: new 27	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   518: astore 18
    //   520: aload 18
    //   522: aload_1
    //   523: ldc_w 259
    //   526: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   529: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 18
    //   535: ldc_w 470
    //   538: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 16
    //   544: aload 17
    //   546: aload 18
    //   548: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   554: pop
    //   555: new 27	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   562: astore 17
    //   564: aload 17
    //   566: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   569: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 17
    //   575: ldc_w 541
    //   578: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 17
    //   584: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: astore 17
    //   589: new 27	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   596: astore 18
    //   598: aload 18
    //   600: aload_1
    //   601: ldc_w 267
    //   604: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   607: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 18
    //   613: ldc_w 470
    //   616: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 16
    //   622: aload 17
    //   624: aload 18
    //   626: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   632: pop
    //   633: aload 16
    //   635: ldc_w 543
    //   638: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   641: invokestatic 221	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   644: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   647: pop
    //   648: aload 16
    //   650: ldc_w 545
    //   653: getstatic 379	android/os/Build$VERSION:SDK_INT	I
    //   656: invokestatic 221	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   659: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   662: pop
    //   663: invokestatic 164	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   666: invokestatic 550	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   669: aconst_null
    //   670: ldc_w 552
    //   673: iconst_1
    //   674: lconst_0
    //   675: lconst_0
    //   676: aload 16
    //   678: aconst_null
    //   679: invokevirtual 556	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   682: new 38	java/io/File
    //   685: dup
    //   686: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   689: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: astore_1
    //   693: aload_1
    //   694: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   697: ifnull +21 -> 718
    //   700: aload_1
    //   701: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   704: invokevirtual 300	java/io/File:exists	()Z
    //   707: ifeq +11 -> 718
    //   710: aload_1
    //   711: invokevirtual 559	java/io/File:getParentFile	()Ljava/io/File;
    //   714: invokevirtual 562	java/io/File:mkdirs	()Z
    //   717: pop
    //   718: aload_1
    //   719: invokevirtual 300	java/io/File:exists	()Z
    //   722: ifeq +8 -> 730
    //   725: aload_1
    //   726: invokevirtual 334	java/io/File:delete	()Z
    //   729: pop
    //   730: aload_0
    //   731: getfield 94	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Boolean	Z
    //   734: ifeq +7 -> 741
    //   737: iconst_2
    //   738: invokestatic 565	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   741: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   744: ldc_w 566
    //   747: sipush 1000
    //   750: invokestatic 570	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   753: aload_0
    //   754: invokestatic 575	android/os/SystemClock:uptimeMillis	()J
    //   757: putfield 113	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:h	J
    //   760: aload_0
    //   761: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   764: aload_0
    //   765: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   768: iconst_1
    //   769: aload 16
    //   771: invokestatic 579	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   774: ldc2_w 367
    //   777: invokevirtual 583	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   780: pop
    //   781: goto -744 -> 37
    //   784: astore_1
    //   785: aload_0
    //   786: iconst_0
    //   787: putfield 86	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_Boolean	Z
    //   790: ldc 228
    //   792: iconst_1
    //   793: ldc_w 585
    //   796: aload_1
    //   797: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: invokestatic 487	android/os/Debug:stopMethodTracing	()V
    //   803: goto -766 -> 37
    //   806: astore_1
    //   807: ldc 228
    //   809: iconst_1
    //   810: ldc_w 470
    //   813: aload_1
    //   814: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   817: goto -780 -> 37
    //   820: aload_1
    //   821: getfield 502	android/os/Message:what	I
    //   824: iconst_3
    //   825: if_icmpne +13 -> 838
    //   828: aload_1
    //   829: getfield 590	android/os/Message:arg1	I
    //   832: invokestatic 565	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   835: goto -798 -> 37
    //   838: aload_1
    //   839: getfield 502	android/os/Message:what	I
    //   842: iconst_1
    //   843: if_icmpne -806 -> 37
    //   846: invokestatic 487	android/os/Debug:stopMethodTracing	()V
    //   849: goto +17 -> 866
    //   852: astore_1
    //   853: ldc 228
    //   855: iconst_1
    //   856: ldc_w 470
    //   859: aload_1
    //   860: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   863: goto -14 -> 849
    //   866: aload_0
    //   867: lconst_0
    //   868: putfield 113	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:h	J
    //   871: new 514	java/util/HashMap
    //   874: dup
    //   875: iconst_5
    //   876: invokespecial 515	java/util/HashMap:<init>	(I)V
    //   879: astore 17
    //   881: aload_0
    //   882: iconst_1
    //   883: iconst_1
    //   884: aload 17
    //   886: invokespecial 366	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   889: ifeq -852 -> 37
    //   892: aload 17
    //   894: ldc_w 261
    //   897: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   900: ifeq -863 -> 37
    //   903: aload 17
    //   905: ldc_w 269
    //   908: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   911: ifeq -874 -> 37
    //   914: aload 17
    //   916: ldc_w 261
    //   919: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   922: checkcast 201	java/lang/Long
    //   925: invokevirtual 204	java/lang/Long:longValue	()J
    //   928: lstore 7
    //   930: aload 17
    //   932: ldc_w 269
    //   935: invokevirtual 518	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   938: ifeq +21 -> 959
    //   941: aload 17
    //   943: ldc_w 269
    //   946: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   949: checkcast 201	java/lang/Long
    //   952: invokevirtual 204	java/lang/Long:longValue	()J
    //   955: lstore_3
    //   956: goto +5 -> 961
    //   959: lconst_0
    //   960: lstore_3
    //   961: ldc 228
    //   963: iconst_1
    //   964: bipush 6
    //   966: anewarray 4	java/lang/Object
    //   969: dup
    //   970: iconst_0
    //   971: ldc_w 592
    //   974: aastore
    //   975: dup
    //   976: iconst_1
    //   977: lload 7
    //   979: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   982: aastore
    //   983: dup
    //   984: iconst_2
    //   985: ldc_w 286
    //   988: aastore
    //   989: dup
    //   990: iconst_3
    //   991: lload_3
    //   992: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   995: aastore
    //   996: dup
    //   997: iconst_4
    //   998: ldc_w 286
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_5
    //   1004: aload 16
    //   1006: aastore
    //   1007: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1010: lload 7
    //   1012: lload_3
    //   1013: lsub
    //   1014: aload_0
    //   1015: getfield 90	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   1018: i2l
    //   1019: lcmp
    //   1020: ifgt +56 -> 1076
    //   1023: lload_3
    //   1024: aload_0
    //   1025: getfield 92	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_d_of_type_Int	I
    //   1028: i2l
    //   1029: lcmp
    //   1030: ifle +6 -> 1036
    //   1033: goto +43 -> 1076
    //   1036: ldc 228
    //   1038: iconst_1
    //   1039: iconst_4
    //   1040: anewarray 4	java/lang/Object
    //   1043: dup
    //   1044: iconst_0
    //   1045: ldc_w 594
    //   1048: aastore
    //   1049: dup
    //   1050: iconst_1
    //   1051: lload 7
    //   1053: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1056: aastore
    //   1057: dup
    //   1058: iconst_2
    //   1059: ldc_w 470
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_3
    //   1065: lload_3
    //   1066: invokestatic 233	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1069: aastore
    //   1070: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1073: goto -1036 -> 37
    //   1076: aload 17
    //   1078: ldc 251
    //   1080: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1083: checkcast 201	java/lang/Long
    //   1086: invokevirtual 204	java/lang/Long:longValue	()J
    //   1089: lstore 9
    //   1091: aload 17
    //   1093: ldc_w 259
    //   1096: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1099: checkcast 201	java/lang/Long
    //   1102: invokevirtual 204	java/lang/Long:longValue	()J
    //   1105: lstore 11
    //   1107: aload 17
    //   1109: ldc_w 267
    //   1112: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1115: checkcast 201	java/lang/Long
    //   1118: invokevirtual 204	java/lang/Long:longValue	()J
    //   1121: lstore 13
    //   1123: new 38	java/io/File
    //   1126: dup
    //   1127: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1130: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   1133: astore_1
    //   1134: new 596	java/util/ArrayList
    //   1137: dup
    //   1138: iconst_4
    //   1139: invokespecial 597	java/util/ArrayList:<init>	(I)V
    //   1142: astore 20
    //   1144: aload 20
    //   1146: aload_1
    //   1147: invokevirtual 600	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1150: invokeinterface 605 2 0
    //   1155: pop
    //   1156: new 38	java/io/File
    //   1159: dup
    //   1160: getstatic 82	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1163: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   1166: astore_1
    //   1167: aload_1
    //   1168: invokevirtual 300	java/io/File:exists	()Z
    //   1171: ifeq +8 -> 1179
    //   1174: aload_1
    //   1175: invokevirtual 334	java/io/File:delete	()Z
    //   1178: pop
    //   1179: aload 20
    //   1181: aload_1
    //   1182: invokevirtual 600	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1185: invokeinterface 605 2 0
    //   1190: pop
    //   1191: new 607	java/io/BufferedOutputStream
    //   1194: dup
    //   1195: new 609	java/io/FileOutputStream
    //   1198: dup
    //   1199: aload_1
    //   1200: invokespecial 612	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1203: invokespecial 615	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1206: astore 19
    //   1208: aload 19
    //   1210: astore 16
    //   1212: aload 19
    //   1214: ldc_w 617
    //   1217: invokevirtual 621	java/lang/String:getBytes	()[B
    //   1220: invokevirtual 625	java/io/BufferedOutputStream:write	([B)V
    //   1223: aload 19
    //   1225: astore 16
    //   1227: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   1230: istore_2
    //   1231: iload_2
    //   1232: iconst_1
    //   1233: if_icmpne +10 -> 1243
    //   1236: ldc_w 627
    //   1239: astore_1
    //   1240: goto +7 -> 1247
    //   1243: ldc_w 629
    //   1246: astore_1
    //   1247: aload 19
    //   1249: astore 16
    //   1251: aload 19
    //   1253: aload_1
    //   1254: invokevirtual 621	java/lang/String:getBytes	()[B
    //   1257: invokevirtual 625	java/io/BufferedOutputStream:write	([B)V
    //   1260: aload 19
    //   1262: astore 16
    //   1264: new 27	java/lang/StringBuilder
    //   1267: dup
    //   1268: sipush 200
    //   1271: invokespecial 282	java/lang/StringBuilder:<init>	(I)V
    //   1274: astore 22
    //   1276: aload 19
    //   1278: astore 16
    //   1280: aload 22
    //   1282: ldc_w 631
    //   1285: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload 19
    //   1291: astore 16
    //   1293: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   1296: lstore 5
    //   1298: ldc 228
    //   1300: astore 21
    //   1302: aload 19
    //   1304: astore 16
    //   1306: aload 22
    //   1308: lload 5
    //   1310: ldc2_w 632
    //   1313: lsub
    //   1314: ldc_w 635
    //   1317: invokestatic 158	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1320: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 19
    //   1326: astore 16
    //   1328: aload 22
    //   1330: ldc_w 637
    //   1333: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload 19
    //   1339: astore 16
    //   1341: aload 22
    //   1343: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   1346: ldc_w 635
    //   1349: invokestatic 158	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1352: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload 19
    //   1358: astore 16
    //   1360: aload 22
    //   1362: ldc_w 639
    //   1365: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload 19
    //   1371: astore 16
    //   1373: aload 22
    //   1375: ldc_w 641
    //   1378: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload 19
    //   1384: astore 16
    //   1386: aload 22
    //   1388: lload 7
    //   1390: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload 19
    //   1396: astore 16
    //   1398: aload 22
    //   1400: ldc_w 643
    //   1403: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: aload 19
    //   1409: astore 16
    //   1411: aload 22
    //   1413: lload_3
    //   1414: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: aload 19
    //   1420: astore 16
    //   1422: aload 22
    //   1424: ldc_w 645
    //   1427: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 19
    //   1433: astore 16
    //   1435: aload 22
    //   1437: lload 9
    //   1439: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1442: pop
    //   1443: aload 19
    //   1445: astore 16
    //   1447: aload 22
    //   1449: ldc_w 647
    //   1452: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload 19
    //   1458: astore 16
    //   1460: aload 22
    //   1462: lload 11
    //   1464: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: aload 19
    //   1470: astore 16
    //   1472: aload 22
    //   1474: ldc_w 649
    //   1477: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: pop
    //   1481: aload 19
    //   1483: astore 16
    //   1485: aload 22
    //   1487: lload 13
    //   1489: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1492: pop
    //   1493: aload 19
    //   1495: astore 16
    //   1497: aload 22
    //   1499: ldc_w 651
    //   1502: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: pop
    //   1506: aload 19
    //   1508: astore 16
    //   1510: aload 22
    //   1512: aload 17
    //   1514: ldc_w 271
    //   1517: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1520: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1523: pop
    //   1524: aload 19
    //   1526: astore 16
    //   1528: aload 22
    //   1530: ldc_w 653
    //   1533: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: pop
    //   1537: aload 19
    //   1539: astore 16
    //   1541: aload 22
    //   1543: aload 17
    //   1545: ldc_w 273
    //   1548: invokevirtual 522	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1551: invokevirtual 532	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1554: pop
    //   1555: aload 19
    //   1557: astore 16
    //   1559: aload 22
    //   1561: ldc_w 639
    //   1564: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: pop
    //   1568: aload 19
    //   1570: astore 16
    //   1572: aload 19
    //   1574: aload 22
    //   1576: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1579: invokevirtual 621	java/lang/String:getBytes	()[B
    //   1582: invokevirtual 625	java/io/BufferedOutputStream:write	([B)V
    //   1585: aload 19
    //   1587: astore 16
    //   1589: invokestatic 164	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1592: invokevirtual 657	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1595: astore_1
    //   1596: aload 19
    //   1598: astore 16
    //   1600: aload_1
    //   1601: ldc 50
    //   1603: sipush 128
    //   1606: invokevirtual 663	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1609: astore 17
    //   1611: aload 19
    //   1613: astore 16
    //   1615: new 27	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1622: astore 18
    //   1624: aload 19
    //   1626: astore 16
    //   1628: aload 18
    //   1630: aload 17
    //   1632: getfield 668	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1635: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload 19
    //   1641: astore 16
    //   1643: aload 18
    //   1645: ldc 52
    //   1647: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: pop
    //   1651: aload 19
    //   1653: astore 16
    //   1655: aload 18
    //   1657: aload 17
    //   1659: getfield 671	android/content/pm/PackageInfo:versionCode	I
    //   1662: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1665: pop
    //   1666: aload 19
    //   1668: astore 16
    //   1670: aload 18
    //   1672: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: astore 18
    //   1677: aload 19
    //   1679: astore 16
    //   1681: aload_1
    //   1682: ldc 50
    //   1684: sipush 128
    //   1687: invokevirtual 675	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1690: getfield 681	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1693: ldc_w 683
    //   1696: invokevirtual 688	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1699: invokevirtual 689	java/lang/Object:toString	()Ljava/lang/String;
    //   1702: astore_1
    //   1703: aload 19
    //   1705: astore 16
    //   1707: getstatic 693	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   1710: aconst_null
    //   1711: invokevirtual 697	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1714: invokevirtual 702	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1717: invokestatic 705	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1720: lstore 5
    //   1722: ldc_w 707
    //   1725: astore 17
    //   1727: goto +51 -> 1778
    //   1730: astore 17
    //   1732: goto +23 -> 1755
    //   1735: astore 17
    //   1737: aconst_null
    //   1738: astore_1
    //   1739: goto +16 -> 1755
    //   1742: astore 17
    //   1744: goto +5 -> 1749
    //   1747: astore 17
    //   1749: aconst_null
    //   1750: astore 18
    //   1752: aload 18
    //   1754: astore_1
    //   1755: aload 19
    //   1757: astore 16
    //   1759: aload 21
    //   1761: iconst_1
    //   1762: ldc_w 470
    //   1765: aload 17
    //   1767: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1770: lconst_0
    //   1771: lstore 5
    //   1773: ldc_w 709
    //   1776: astore 17
    //   1778: aload 19
    //   1780: astore 16
    //   1782: aload 22
    //   1784: iconst_0
    //   1785: aload 22
    //   1787: invokevirtual 712	java/lang/StringBuilder:length	()I
    //   1790: invokevirtual 715	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1793: pop
    //   1794: aload 19
    //   1796: astore 16
    //   1798: aload 22
    //   1800: ldc_w 717
    //   1803: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: pop
    //   1807: aload 19
    //   1809: astore 16
    //   1811: aload 22
    //   1813: lload 5
    //   1815: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1818: pop
    //   1819: aload 19
    //   1821: astore 16
    //   1823: aload 22
    //   1825: ldc_w 719
    //   1828: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1831: pop
    //   1832: aload 19
    //   1834: astore 16
    //   1836: aload 22
    //   1838: aload 18
    //   1840: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: pop
    //   1844: aload 19
    //   1846: astore 16
    //   1848: aload 22
    //   1850: ldc_w 721
    //   1853: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: pop
    //   1857: aload 19
    //   1859: astore 16
    //   1861: aload 22
    //   1863: aload_1
    //   1864: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1867: pop
    //   1868: aload 19
    //   1870: astore 16
    //   1872: aload 22
    //   1874: ldc_w 723
    //   1877: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: pop
    //   1881: aload 19
    //   1883: astore 16
    //   1885: aload 22
    //   1887: aload 17
    //   1889: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: pop
    //   1893: aload 19
    //   1895: astore 16
    //   1897: aload 22
    //   1899: ldc_w 725
    //   1902: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: pop
    //   1906: aload 19
    //   1908: astore 16
    //   1910: aload 22
    //   1912: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   1915: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1918: pop
    //   1919: aload 19
    //   1921: astore 16
    //   1923: aload 22
    //   1925: ldc_w 727
    //   1928: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 19
    //   1934: astore 16
    //   1936: aload 22
    //   1938: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1941: invokevirtual 730	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1944: pop
    //   1945: aload 19
    //   1947: astore 16
    //   1949: aload 19
    //   1951: aload 22
    //   1953: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1956: invokevirtual 621	java/lang/String:getBytes	()[B
    //   1959: invokevirtual 625	java/io/BufferedOutputStream:write	([B)V
    //   1962: aload 19
    //   1964: astore 16
    //   1966: aload 19
    //   1968: invokevirtual 733	java/io/BufferedOutputStream:flush	()V
    //   1971: aload 19
    //   1973: invokevirtual 736	java/io/BufferedOutputStream:close	()V
    //   1976: ldc 228
    //   1978: astore 16
    //   1980: goto +103 -> 2083
    //   1983: astore_1
    //   1984: goto +20 -> 2004
    //   1987: astore 17
    //   1989: aload 21
    //   1991: astore_1
    //   1992: aload 19
    //   1994: astore 18
    //   1996: goto +44 -> 2040
    //   1999: astore_1
    //   2000: goto +4 -> 2004
    //   2003: astore_1
    //   2004: ldc 228
    //   2006: astore 16
    //   2008: aload_1
    //   2009: astore 17
    //   2011: aload 16
    //   2013: astore_1
    //   2014: aload 19
    //   2016: astore 18
    //   2018: goto +22 -> 2040
    //   2021: astore 17
    //   2023: goto +11 -> 2034
    //   2026: astore_1
    //   2027: aconst_null
    //   2028: astore 16
    //   2030: goto +793 -> 2823
    //   2033: astore_1
    //   2034: ldc 228
    //   2036: astore_1
    //   2037: aconst_null
    //   2038: astore 18
    //   2040: aload 18
    //   2042: astore 16
    //   2044: invokestatic 423	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2047: ifeq +17 -> 2064
    //   2050: aload 18
    //   2052: astore 16
    //   2054: aload_1
    //   2055: iconst_2
    //   2056: ldc_w 470
    //   2059: aload 17
    //   2061: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2064: aload_1
    //   2065: astore 16
    //   2067: aload 18
    //   2069: ifnull +14 -> 2083
    //   2072: aload 18
    //   2074: invokevirtual 736	java/io/BufferedOutputStream:close	()V
    //   2077: aload_1
    //   2078: astore 16
    //   2080: goto +3 -> 2083
    //   2083: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   2086: invokestatic 738	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   2089: astore_1
    //   2090: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   2093: ldc2_w 739
    //   2096: lsub
    //   2097: invokestatic 738	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   2100: astore 17
    //   2102: aload 20
    //   2104: aload_1
    //   2105: invokeinterface 605 2 0
    //   2110: pop
    //   2111: aload_1
    //   2112: aload 17
    //   2114: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2117: ifne +13 -> 2130
    //   2120: aload 20
    //   2122: aload 17
    //   2124: invokeinterface 605 2 0
    //   2129: pop
    //   2130: invokestatic 742	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	()Ljava/lang/String;
    //   2133: astore 18
    //   2135: aload 20
    //   2137: aload 18
    //   2139: invokestatic 748	com/tencent/mobileqq/utils/FileUtils:zipFiles	(Ljava/util/List;Ljava/lang/String;)Z
    //   2142: ifeq +182 -> 2324
    //   2145: aload_0
    //   2146: aload_0
    //   2147: getfield 88	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   2150: iconst_1
    //   2151: isub
    //   2152: putfield 88	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   2155: aload_0
    //   2156: getfield 383	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   2159: invokeinterface 437 1 0
    //   2164: ldc_w 449
    //   2167: aload_0
    //   2168: getfield 383	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   2171: ldc_w 449
    //   2174: iconst_0
    //   2175: invokeinterface 460 3 0
    //   2180: iconst_1
    //   2181: iadd
    //   2182: invokeinterface 453 3 0
    //   2187: invokeinterface 456 1 0
    //   2192: pop
    //   2193: new 750	org/json/JSONObject
    //   2196: dup
    //   2197: invokespecial 751	org/json/JSONObject:<init>	()V
    //   2200: astore_1
    //   2201: new 750	org/json/JSONObject
    //   2204: dup
    //   2205: invokespecial 751	org/json/JSONObject:<init>	()V
    //   2208: astore 17
    //   2210: aload 17
    //   2212: ldc_w 753
    //   2215: aload 18
    //   2217: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2220: pop
    //   2221: new 750	org/json/JSONObject
    //   2224: dup
    //   2225: invokespecial 751	org/json/JSONObject:<init>	()V
    //   2228: astore 18
    //   2230: aload 18
    //   2232: ldc_w 758
    //   2235: ldc_w 462
    //   2238: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2241: pop
    //   2242: aload_1
    //   2243: ldc_w 760
    //   2246: aload 17
    //   2248: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2251: pop
    //   2252: aload_1
    //   2253: ldc_w 762
    //   2256: aload 18
    //   2258: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2261: pop
    //   2262: aload_1
    //   2263: ldc_w 764
    //   2266: bipush 126
    //   2268: invokevirtual 767	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2271: pop
    //   2272: new 769	com/tencent/qqperf/repoter/ResultObject
    //   2275: dup
    //   2276: iconst_0
    //   2277: ldc_w 771
    //   2280: iconst_1
    //   2281: lconst_1
    //   2282: lconst_1
    //   2283: aload_1
    //   2284: iconst_1
    //   2285: iconst_1
    //   2286: getstatic 774	com/tencent/qqperf/MagnifierSDK:jdField_a_of_type_Long	J
    //   2289: invokespecial 777	com/tencent/qqperf/repoter/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   2292: invokestatic 782	com/tencent/qqperf/repoter/ReporterMachine:a	(Lcom/tencent/qqperf/repoter/ResultObject;)V
    //   2295: aload 16
    //   2297: iconst_2
    //   2298: ldc_w 784
    //   2301: invokestatic 289	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2304: goto +14 -> 2318
    //   2307: astore_1
    //   2308: aload 16
    //   2310: iconst_1
    //   2311: ldc_w 786
    //   2314: aload_1
    //   2315: invokestatic 587	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2318: iconst_1
    //   2319: istore 15
    //   2321: goto +6 -> 2327
    //   2324: iconst_0
    //   2325: istore 15
    //   2327: new 514	java/util/HashMap
    //   2330: dup
    //   2331: iconst_2
    //   2332: invokespecial 515	java/util/HashMap:<init>	(I)V
    //   2335: astore_1
    //   2336: new 27	java/lang/StringBuilder
    //   2339: dup
    //   2340: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2343: astore 16
    //   2345: aload 16
    //   2347: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2350: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2353: pop
    //   2354: aload 16
    //   2356: ldc_w 529
    //   2359: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: pop
    //   2363: aload 16
    //   2365: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2368: astore 16
    //   2370: new 27	java/lang/StringBuilder
    //   2373: dup
    //   2374: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2377: astore 17
    //   2379: aload 17
    //   2381: lload 7
    //   2383: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2386: pop
    //   2387: aload 17
    //   2389: ldc_w 470
    //   2392: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: pop
    //   2396: aload_1
    //   2397: aload 16
    //   2399: aload 17
    //   2401: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2404: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2407: pop
    //   2408: new 27	java/lang/StringBuilder
    //   2411: dup
    //   2412: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2415: astore 16
    //   2417: aload 16
    //   2419: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2422: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2425: pop
    //   2426: aload 16
    //   2428: ldc_w 535
    //   2431: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2434: pop
    //   2435: aload 16
    //   2437: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2440: astore 16
    //   2442: new 27	java/lang/StringBuilder
    //   2445: dup
    //   2446: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2449: astore 17
    //   2451: aload 17
    //   2453: lload_3
    //   2454: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2457: pop
    //   2458: aload 17
    //   2460: ldc_w 470
    //   2463: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: pop
    //   2467: aload_1
    //   2468: aload 16
    //   2470: aload 17
    //   2472: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2475: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2478: pop
    //   2479: new 27	java/lang/StringBuilder
    //   2482: dup
    //   2483: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2486: astore 16
    //   2488: aload 16
    //   2490: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2493: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2496: pop
    //   2497: aload 16
    //   2499: ldc_w 537
    //   2502: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: pop
    //   2506: aload 16
    //   2508: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2511: astore 16
    //   2513: new 27	java/lang/StringBuilder
    //   2516: dup
    //   2517: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2520: astore 17
    //   2522: aload 17
    //   2524: lload 9
    //   2526: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2529: pop
    //   2530: aload 17
    //   2532: ldc_w 470
    //   2535: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: pop
    //   2539: aload_1
    //   2540: aload 16
    //   2542: aload 17
    //   2544: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2547: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2550: pop
    //   2551: new 27	java/lang/StringBuilder
    //   2554: dup
    //   2555: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2558: astore 16
    //   2560: aload 16
    //   2562: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2565: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2568: pop
    //   2569: aload 16
    //   2571: ldc_w 539
    //   2574: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: pop
    //   2578: aload 16
    //   2580: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2583: astore 16
    //   2585: new 27	java/lang/StringBuilder
    //   2588: dup
    //   2589: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2592: astore 17
    //   2594: aload 17
    //   2596: lload 11
    //   2598: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2601: pop
    //   2602: aload 17
    //   2604: ldc_w 470
    //   2607: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2610: pop
    //   2611: aload_1
    //   2612: aload 16
    //   2614: aload 17
    //   2616: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2619: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2622: pop
    //   2623: new 27	java/lang/StringBuilder
    //   2626: dup
    //   2627: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2630: astore 16
    //   2632: aload 16
    //   2634: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2637: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2640: pop
    //   2641: aload 16
    //   2643: ldc_w 541
    //   2646: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: pop
    //   2650: aload 16
    //   2652: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2655: astore 16
    //   2657: new 27	java/lang/StringBuilder
    //   2660: dup
    //   2661: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   2664: astore 17
    //   2666: aload 17
    //   2668: lload 13
    //   2670: invokevirtual 132	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2673: pop
    //   2674: aload 17
    //   2676: ldc_w 470
    //   2679: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2682: pop
    //   2683: aload_1
    //   2684: aload 16
    //   2686: aload 17
    //   2688: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2691: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2694: pop
    //   2695: aload_1
    //   2696: ldc_w 543
    //   2699: getstatic 212	mqq/app/MobileQQ:sProcessId	I
    //   2702: invokestatic 221	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2705: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2708: pop
    //   2709: aload_1
    //   2710: ldc_w 545
    //   2713: getstatic 379	android/os/Build$VERSION:SDK_INT	I
    //   2716: invokestatic 221	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2719: invokevirtual 533	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2722: pop
    //   2723: invokestatic 164	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2726: invokestatic 550	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2729: aconst_null
    //   2730: ldc_w 788
    //   2733: iload 15
    //   2735: lconst_0
    //   2736: lconst_0
    //   2737: aload_1
    //   2738: aconst_null
    //   2739: invokevirtual 556	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2742: aload 20
    //   2744: invokeinterface 792 1 0
    //   2749: astore_1
    //   2750: aload_1
    //   2751: invokeinterface 797 1 0
    //   2756: ifeq -2719 -> 37
    //   2759: aload_1
    //   2760: invokeinterface 801 1 0
    //   2765: checkcast 57	java/lang/String
    //   2768: astore 16
    //   2770: aload 16
    //   2772: ldc 176
    //   2774: invokevirtual 804	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2777: ifne -27 -> 2750
    //   2780: aload 16
    //   2782: ldc_w 806
    //   2785: invokevirtual 804	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2788: ifeq +6 -> 2794
    //   2791: goto -41 -> 2750
    //   2794: new 38	java/io/File
    //   2797: dup
    //   2798: aload 16
    //   2800: invokespecial 296	java/io/File:<init>	(Ljava/lang/String;)V
    //   2803: astore 16
    //   2805: aload 16
    //   2807: invokevirtual 300	java/io/File:exists	()Z
    //   2810: ifeq -60 -> 2750
    //   2813: aload 16
    //   2815: invokevirtual 334	java/io/File:delete	()Z
    //   2818: pop
    //   2819: goto -69 -> 2750
    //   2822: astore_1
    //   2823: aload 16
    //   2825: ifnull +8 -> 2833
    //   2828: aload 16
    //   2830: invokevirtual 736	java/io/BufferedOutputStream:close	()V
    //   2833: aload_1
    //   2834: athrow
    //   2835: astore_1
    //   2836: goto -860 -> 1976
    //   2839: astore 16
    //   2841: aload_1
    //   2842: astore 16
    //   2844: goto -761 -> 2083
    //   2847: astore 16
    //   2849: goto -16 -> 2833
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2852	0	this	BackgroundCpuMonitor
    //   0	2852	1	paramMessage	android.os.Message
    //   4	1230	2	i	int
    //   157	1257	3	l1	long
    //   132	1682	5	l2	long
    //   928	461	7	l3	long
    //   1089	349	9	l4	long
    //   1105	358	11	l5	long
    //   1121	367	13	l6	long
    //   9	2020	16	localObject1	Object
    //   251	1475	17	localObject2	Object
    //   1730	1	17	localException1	Exception
    //   1735	1	17	localException2	Exception
    //   1742	1	17	localException3	Exception
    //   1747	19	17	localException4	Exception
    //   1776	112	17	str1	String
    //   1987	1	17	localException5	Exception
    //   2009	1	17	localMessage	android.os.Message
    //   2021	1	17	localException6	Exception
    //   285	1732	18	localObject3	Object
    //   1206	809	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1142	38	20	localArrayList	java.util.ArrayList
    //   1300	690	21	str2	String
    //   1274	678	22	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   741	781	784	java/lang/Throwable
    //   800	803	806	java/lang/Throwable
    //   846	849	852	java/lang/Throwable
    //   1707	1722	1730	java/lang/Exception
    //   1681	1703	1735	java/lang/Exception
    //   1628	1639	1742	java/lang/Exception
    //   1643	1651	1742	java/lang/Exception
    //   1655	1666	1742	java/lang/Exception
    //   1670	1677	1742	java/lang/Exception
    //   1589	1596	1747	java/lang/Exception
    //   1600	1611	1747	java/lang/Exception
    //   1615	1624	1747	java/lang/Exception
    //   1782	1794	1983	java/lang/Exception
    //   1798	1807	1983	java/lang/Exception
    //   1811	1819	1983	java/lang/Exception
    //   1823	1832	1983	java/lang/Exception
    //   1836	1844	1983	java/lang/Exception
    //   1848	1857	1983	java/lang/Exception
    //   1861	1868	1983	java/lang/Exception
    //   1872	1881	1983	java/lang/Exception
    //   1885	1893	1983	java/lang/Exception
    //   1897	1906	1983	java/lang/Exception
    //   1910	1919	1983	java/lang/Exception
    //   1923	1932	1983	java/lang/Exception
    //   1936	1945	1983	java/lang/Exception
    //   1949	1962	1983	java/lang/Exception
    //   1966	1971	1983	java/lang/Exception
    //   1759	1770	1987	java/lang/Exception
    //   1306	1324	1999	java/lang/Exception
    //   1328	1337	1999	java/lang/Exception
    //   1341	1356	1999	java/lang/Exception
    //   1360	1369	1999	java/lang/Exception
    //   1373	1382	1999	java/lang/Exception
    //   1386	1394	1999	java/lang/Exception
    //   1398	1407	1999	java/lang/Exception
    //   1411	1418	1999	java/lang/Exception
    //   1422	1431	1999	java/lang/Exception
    //   1435	1443	1999	java/lang/Exception
    //   1447	1456	1999	java/lang/Exception
    //   1460	1468	1999	java/lang/Exception
    //   1472	1481	1999	java/lang/Exception
    //   1485	1493	1999	java/lang/Exception
    //   1497	1506	1999	java/lang/Exception
    //   1510	1524	1999	java/lang/Exception
    //   1528	1537	1999	java/lang/Exception
    //   1541	1555	1999	java/lang/Exception
    //   1559	1568	1999	java/lang/Exception
    //   1572	1585	1999	java/lang/Exception
    //   1212	1223	2003	java/lang/Exception
    //   1227	1231	2003	java/lang/Exception
    //   1251	1260	2003	java/lang/Exception
    //   1264	1276	2003	java/lang/Exception
    //   1280	1289	2003	java/lang/Exception
    //   1293	1298	2003	java/lang/Exception
    //   1191	1208	2021	java/lang/Exception
    //   1191	1208	2026	finally
    //   2193	2304	2307	java/lang/Exception
    //   1212	1223	2822	finally
    //   1227	1231	2822	finally
    //   1251	1260	2822	finally
    //   1264	1276	2822	finally
    //   1280	1289	2822	finally
    //   1293	1298	2822	finally
    //   1306	1324	2822	finally
    //   1328	1337	2822	finally
    //   1341	1356	2822	finally
    //   1360	1369	2822	finally
    //   1373	1382	2822	finally
    //   1386	1394	2822	finally
    //   1398	1407	2822	finally
    //   1411	1418	2822	finally
    //   1422	1431	2822	finally
    //   1435	1443	2822	finally
    //   1447	1456	2822	finally
    //   1460	1468	2822	finally
    //   1472	1481	2822	finally
    //   1485	1493	2822	finally
    //   1497	1506	2822	finally
    //   1510	1524	2822	finally
    //   1528	1537	2822	finally
    //   1541	1555	2822	finally
    //   1559	1568	2822	finally
    //   1572	1585	2822	finally
    //   1589	1596	2822	finally
    //   1600	1611	2822	finally
    //   1615	1624	2822	finally
    //   1628	1639	2822	finally
    //   1643	1651	2822	finally
    //   1655	1666	2822	finally
    //   1670	1677	2822	finally
    //   1681	1703	2822	finally
    //   1707	1722	2822	finally
    //   1759	1770	2822	finally
    //   1782	1794	2822	finally
    //   1798	1807	2822	finally
    //   1811	1819	2822	finally
    //   1823	1832	2822	finally
    //   1836	1844	2822	finally
    //   1848	1857	2822	finally
    //   1861	1868	2822	finally
    //   1872	1881	2822	finally
    //   1885	1893	2822	finally
    //   1897	1906	2822	finally
    //   1910	1919	2822	finally
    //   1923	1932	2822	finally
    //   1936	1945	2822	finally
    //   1949	1962	2822	finally
    //   1966	1971	2822	finally
    //   2044	2050	2822	finally
    //   2054	2064	2822	finally
    //   1971	1976	2835	java/lang/Exception
    //   2072	2077	2839	java/lang/Exception
    //   2828	2833	2847	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor
 * JD-Core Version:    0.7.0.1
 */