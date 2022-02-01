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
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static BackgroundCpuMonitor jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor = null;
  private static final String jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", File.separator) + File.separator);
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "temp.trace";
  private static final String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "baseInfo.txt";
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  BackgroundCpuMonitor.BgCpuTotalCost jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost = new BackgroundCpuMonitor.BgCpuTotalCost();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 15;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  
  public static BackgroundCpuMonitor a()
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor == null) {
        jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor = new BackgroundCpuMonitor();
      }
      return jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor;
    }
    finally {}
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("bg_cpu_").append(System.currentTimeMillis()).append(".trace.zip");
    return localStringBuilder.toString();
  }
  
  public static String a(long paramLong)
  {
    String str1 = QLog.getLogPath();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(MobileQQ.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
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
    long l2;
    long l4;
    long l1;
    if (arrayOfObject != null)
    {
      l2 = ((Long)arrayOfObject[1]).longValue();
      l4 = ((Long)arrayOfObject[2]).longValue();
      l1 = ((Long)arrayOfObject[1]).longValue();
      l2 += l4;
    }
    for (;;)
    {
      l4 = ProcessStats.a("-1");
      if (MobileQQ.sProcessId != 4) {
        l3 = ProcessStats.a(String.valueOf(MainService.sNativeTidOfReceiver));
      }
      long l5 = MainService.sReceiverCpuTime;
      long l6 = ((IPerfApi)QRoute.api(IPerfApi.class)).getFTSSyncHandlerThreadTime();
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "cpuInfo: ", Long.valueOf(l2), ", ", Long.valueOf(l1), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "], ", Long.valueOf(l5), ", ", Long.valueOf(l6) });
      if ((l2 <= 0L) || (l1 <= 0L) || (l4 <= 0L) || ((MobileQQ.sProcessId != 4) && (l3 <= 0L)))
      {
        QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
        return false;
      }
      int i;
      int k;
      if (paramBoolean2)
      {
        i = -1;
        long l7 = l2 - this.jdField_a_of_type_Long;
        if ((l7 <= 0L) || (l1 <= this.jdField_b_of_type_Long) || (l4 <= this.jdField_c_of_type_Long))
        {
          paramMap = new StringBuilder(256);
          paramMap.append("bad cpu value2.").append(l2).append(",").append(this.jdField_a_of_type_Long).append(",").append(l1).append(",").append(this.jdField_b_of_type_Long).append(",").append(l4).append(",").append(this.jdField_c_of_type_Long);
          QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
          return false;
        }
        long l8 = l4 - this.jdField_c_of_type_Long;
        k = (int)(100L * l8 / l7);
        if (paramMap != null)
        {
          paramMap.put("elapse", Long.valueOf(l7));
          paramMap.put("qqConsume", Long.valueOf(l8));
          paramMap.put("qqRatio", Long.valueOf(k));
        }
        if (MobileQQ.sProcessId == 4) {
          break label732;
        }
        if (l3 < this.jdField_d_of_type_Long)
        {
          QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.jdField_d_of_type_Long) });
          return false;
        }
        l8 = l3 - this.jdField_d_of_type_Long;
        int j = (int)(100L * l8 / l7);
        i = j;
        if (paramMap != null)
        {
          paramMap.put("msfConsume", Long.valueOf(l8));
          paramMap.put("msfRatio", Long.valueOf(j));
          i = j;
        }
      }
      for (;;)
      {
        paramMap.put("msfTime", Long.valueOf(l5 - this.e));
        paramMap.put("ftsTime", Long.valueOf(l6 - this.f));
        QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(k), ", msf-receiver cpuRatio = ", Integer.valueOf(i), ", remainRptCount = ", Integer.valueOf(this.jdField_a_of_type_Int) });
        if (paramBoolean1)
        {
          this.jdField_a_of_type_Long = l2;
          this.jdField_b_of_type_Long = l1;
          this.jdField_c_of_type_Long = l4;
          this.jdField_d_of_type_Long = l3;
          this.e = l5;
          this.f = l6;
        }
        return true;
        label732:
        paramMap.put("msfConsume", Long.valueOf(0L));
        paramMap.put("msfRatio", Long.valueOf(0L));
      }
      l2 = -1L;
      l1 = -1L;
    }
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
        if (i < k)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2.isFile()) && (!TextUtils.isEmpty(localObject2.getName())) && (localObject2.getName().startsWith("bg_cpu_"))) {}
          for (int j = 1;; j = 0)
          {
            if ((j != 0) && (Math.abs(localObject2.lastModified() - System.currentTimeMillis()) > 86400000L)) {
              localObject2.delete();
            }
            i += 1;
            break;
          }
        }
      }
    }
  }
  
  void a()
  {
    QLog.d("BatteryStats.BgCpu", 1, new Object[] { "BackgroundCpuMonitor onAppBackground,sCountActivity = ", Integer.valueOf(Foreground.getActivityCount()) });
    if (this.jdField_d_of_type_Boolean) {
      QLog.d("BatteryStats.BgCpu", 1, "BackgroundCpuMonitor onAppBackground");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      this.jdField_d_of_type_Boolean = true;
    } while ((!this.jdField_a_of_type_Boolean) || (Looper.myLooper() != ThreadManager.getFileThreadLooper()) || (!a(true, false, null)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
  }
  
  void a(String paramString)
  {
    if ((MobileQQ.sProcessId != 1) && (MobileQQ.sProcessId != 4)) {
      break label14;
    }
    label14:
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    QLog.d("BatteryStats.BgCpu", 2, "config = " + paramString);
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
        if (Math.abs(System.currentTimeMillis() - l) > 86400000L)
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
            break label438;
          }
          bool1 = true;
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label444;
          }
          i = 1;
          break label462;
          this.jdField_b_of_type_Int = Integer.valueOf(paramString[j]).intValue();
          if (i == 0) {
            break label456;
          }
          i = 3;
          label267:
          this.jdField_c_of_type_Int = Integer.valueOf(paramString[i]).intValue();
          this.jdField_a_of_type_Int = (Integer.valueOf(paramString[6]).intValue() - this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("times", 0));
          if (this.jdField_a_of_type_Int <= 0) {
            bool1 = false;
          }
          this.jdField_b_of_type_Boolean = "1".equals(paramString[7]);
          bool2 = bool1;
        }
        this.jdField_a_of_type_Boolean = bool2;
        if ((this.jdField_a_of_type_Boolean) && (MobileQQ.sProcessId == 4) && (this.jdField_a_of_type_AndroidOsHandler == null)) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
        }
        if (paramString.length < 10) {
          break label14;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("enable_nor_sensor", "1".equals(paramString[9])).commit();
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BatteryStats.BgCpu", 2, "", paramString);
      return;
      label438:
      boolean bool1 = false;
      continue;
      label444:
      int i = 0;
      label456:
      label462:
      while (i == 0)
      {
        j = 4;
        break;
        i = 5;
        break label267;
      }
      int j = 2;
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
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.g > 0L) {
        QLog.d("BatteryStats.BgCpu", 1, "stop trace bg cpu");
      }
      try
      {
        Debug.stopMethodTracing();
        this.g = 0L;
        if (this.jdField_c_of_type_Boolean) {
          continue;
        }
        c();
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("BatteryStats.BgCpu", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  @android.annotation.TargetApi(21)
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 509	android/os/Message:what	I
    //   4: bipush 10
    //   6: if_icmpne +25 -> 31
    //   9: aload_0
    //   10: getfield 111	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   13: invokevirtual 511	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:a	()V
    //   16: aload_0
    //   17: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   20: bipush 10
    //   22: ldc2_w 374
    //   25: invokevirtual 379	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   28: pop
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_1
    //   32: getfield 509	android/os/Message:what	I
    //   35: bipush 11
    //   37: if_icmpne +13 -> 50
    //   40: aload_0
    //   41: getfield 111	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_ComTencentQqperfMonitorBackgroundcpuBackgroundCpuMonitor$BgCpuTotalCost	Lcom/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost;
    //   44: invokevirtual 513	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor$BgCpuTotalCost:b	()V
    //   47: goto -18 -> 29
    //   50: aload_1
    //   51: getfield 509	android/os/Message:what	I
    //   54: iconst_2
    //   55: if_icmpne +10 -> 65
    //   58: aload_0
    //   59: invokevirtual 514	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	()V
    //   62: goto -33 -> 29
    //   65: aload_1
    //   66: getfield 509	android/os/Message:what	I
    //   69: ifne +634 -> 703
    //   72: new 516	java/util/HashMap
    //   75: dup
    //   76: iconst_5
    //   77: invokespecial 517	java/util/HashMap:<init>	(I)V
    //   80: astore 17
    //   82: aload_0
    //   83: iconst_1
    //   84: iconst_1
    //   85: aload 17
    //   87: invokespecial 373	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   90: ifeq -61 -> 29
    //   93: aload 17
    //   95: ldc_w 282
    //   98: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   101: ifeq -72 -> 29
    //   104: aload 17
    //   106: ldc_w 290
    //   109: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   112: ifeq -83 -> 29
    //   115: aload 17
    //   117: ldc_w 282
    //   120: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 199	java/lang/Long
    //   126: invokevirtual 202	java/lang/Long:longValue	()J
    //   129: lstore 4
    //   131: aload 17
    //   133: ldc_w 290
    //   136: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   139: ifeq +559 -> 698
    //   142: aload 17
    //   144: ldc_w 290
    //   147: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 199	java/lang/Long
    //   153: invokevirtual 202	java/lang/Long:longValue	()J
    //   156: lstore_2
    //   157: ldc 235
    //   159: iconst_1
    //   160: bipush 6
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: ldc_w 526
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: lload 4
    //   175: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: ldc_w 266
    //   184: aastore
    //   185: dup
    //   186: iconst_3
    //   187: lload_2
    //   188: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: dup
    //   193: iconst_4
    //   194: ldc 242
    //   196: aastore
    //   197: dup
    //   198: iconst_5
    //   199: iconst_0
    //   200: invokestatic 531	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   203: aastore
    //   204: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   207: lload 4
    //   209: lload_2
    //   210: lsub
    //   211: aload_0
    //   212: getfield 90	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   215: i2l
    //   216: lcmp
    //   217: ifgt +13 -> 230
    //   220: lload_2
    //   221: aload_0
    //   222: getfield 92	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   225: i2l
    //   226: lcmp
    //   227: ifle -198 -> 29
    //   230: new 516	java/util/HashMap
    //   233: dup
    //   234: iconst_2
    //   235: invokespecial 517	java/util/HashMap:<init>	(I)V
    //   238: astore_1
    //   239: aload_1
    //   240: new 27	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   247: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   250: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: ldc_w 536
    //   256: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: new 27	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   269: aload 17
    //   271: ldc_w 282
    //   274: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   277: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: ldc_w 477
    //   283: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: aload_1
    //   294: new 27	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   301: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   304: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc_w 542
    //   310: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: new 27	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   323: aload 17
    //   325: ldc_w 290
    //   328: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   334: ldc_w 477
    //   337: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: aload_1
    //   348: new 27	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   355: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   358: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 544
    //   364: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: new 27	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   377: aload 17
    //   379: ldc_w 272
    //   382: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   385: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: ldc_w 477
    //   391: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   400: pop
    //   401: aload_1
    //   402: new 27	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   409: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   412: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: ldc_w 546
    //   418: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: new 27	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   431: aload 17
    //   433: ldc_w 280
    //   436: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   439: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   442: ldc_w 477
    //   445: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: pop
    //   455: aload_1
    //   456: new 27	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   463: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   466: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: ldc_w 548
    //   472: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: new 27	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   485: aload 17
    //   487: ldc_w 288
    //   490: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   493: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   496: ldc_w 477
    //   499: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: aload_1
    //   510: ldc_w 550
    //   513: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   516: invokestatic 219	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   519: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   522: pop
    //   523: aload_1
    //   524: ldc_w 552
    //   527: getstatic 386	android/os/Build$VERSION:SDK_INT	I
    //   530: invokestatic 219	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   533: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: invokestatic 162	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   540: invokestatic 557	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   543: aconst_null
    //   544: ldc_w 559
    //   547: iconst_1
    //   548: lconst_0
    //   549: lconst_0
    //   550: aload_1
    //   551: aconst_null
    //   552: invokevirtual 563	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   555: new 38	java/io/File
    //   558: dup
    //   559: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   562: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   565: astore 17
    //   567: aload 17
    //   569: invokevirtual 566	java/io/File:getParentFile	()Ljava/io/File;
    //   572: ifnull +23 -> 595
    //   575: aload 17
    //   577: invokevirtual 566	java/io/File:getParentFile	()Ljava/io/File;
    //   580: invokevirtual 307	java/io/File:exists	()Z
    //   583: ifeq +12 -> 595
    //   586: aload 17
    //   588: invokevirtual 566	java/io/File:getParentFile	()Ljava/io/File;
    //   591: invokevirtual 569	java/io/File:mkdirs	()Z
    //   594: pop
    //   595: aload 17
    //   597: invokevirtual 307	java/io/File:exists	()Z
    //   600: ifeq +9 -> 609
    //   603: aload 17
    //   605: invokevirtual 341	java/io/File:delete	()Z
    //   608: pop
    //   609: aload_0
    //   610: getfield 94	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Boolean	Z
    //   613: ifeq +7 -> 620
    //   616: iconst_2
    //   617: invokestatic 572	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   620: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   623: ldc_w 573
    //   626: sipush 1000
    //   629: invokestatic 577	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   632: aload_0
    //   633: invokestatic 582	android/os/SystemClock:uptimeMillis	()J
    //   636: putfield 113	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:g	J
    //   639: aload_0
    //   640: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   643: aload_0
    //   644: getfield 119	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   647: iconst_1
    //   648: aload_1
    //   649: invokestatic 586	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   652: ldc2_w 374
    //   655: invokevirtual 590	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   658: pop
    //   659: goto -630 -> 29
    //   662: astore_1
    //   663: aload_0
    //   664: iconst_0
    //   665: putfield 86	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_Boolean	Z
    //   668: ldc 235
    //   670: iconst_1
    //   671: ldc_w 592
    //   674: aload_1
    //   675: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   678: invokestatic 494	android/os/Debug:stopMethodTracing	()V
    //   681: goto -652 -> 29
    //   684: astore_1
    //   685: ldc 235
    //   687: iconst_1
    //   688: ldc_w 477
    //   691: aload_1
    //   692: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: goto -666 -> 29
    //   698: lconst_0
    //   699: lstore_2
    //   700: goto -543 -> 157
    //   703: aload_1
    //   704: getfield 509	android/os/Message:what	I
    //   707: iconst_3
    //   708: if_icmpne +13 -> 721
    //   711: aload_1
    //   712: getfield 597	android/os/Message:arg1	I
    //   715: invokestatic 572	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   718: goto -689 -> 29
    //   721: aload_1
    //   722: getfield 509	android/os/Message:what	I
    //   725: iconst_1
    //   726: if_icmpne -697 -> 29
    //   729: invokestatic 494	android/os/Debug:stopMethodTracing	()V
    //   732: aload_0
    //   733: lconst_0
    //   734: putfield 113	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:g	J
    //   737: new 516	java/util/HashMap
    //   740: dup
    //   741: iconst_5
    //   742: invokespecial 517	java/util/HashMap:<init>	(I)V
    //   745: astore 17
    //   747: aload_0
    //   748: iconst_1
    //   749: iconst_1
    //   750: aload 17
    //   752: invokespecial 373	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   755: ifeq -726 -> 29
    //   758: aload 17
    //   760: ldc_w 282
    //   763: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   766: ifeq -737 -> 29
    //   769: aload 17
    //   771: ldc_w 290
    //   774: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   777: ifeq -748 -> 29
    //   780: aload 17
    //   782: ldc_w 282
    //   785: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   788: checkcast 199	java/lang/Long
    //   791: invokevirtual 202	java/lang/Long:longValue	()J
    //   794: lstore 8
    //   796: aload 17
    //   798: ldc_w 290
    //   801: invokevirtual 520	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   804: ifeq +1314 -> 2118
    //   807: aload 17
    //   809: ldc_w 290
    //   812: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   815: checkcast 199	java/lang/Long
    //   818: invokevirtual 202	java/lang/Long:longValue	()J
    //   821: lstore_2
    //   822: ldc 235
    //   824: iconst_1
    //   825: bipush 6
    //   827: anewarray 4	java/lang/Object
    //   830: dup
    //   831: iconst_0
    //   832: ldc_w 599
    //   835: aastore
    //   836: dup
    //   837: iconst_1
    //   838: lload 8
    //   840: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: ldc_w 266
    //   849: aastore
    //   850: dup
    //   851: iconst_3
    //   852: lload_2
    //   853: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   856: aastore
    //   857: dup
    //   858: iconst_4
    //   859: ldc_w 266
    //   862: aastore
    //   863: dup
    //   864: iconst_5
    //   865: iconst_0
    //   866: invokestatic 531	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   869: aastore
    //   870: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   873: lload 8
    //   875: lload_2
    //   876: lsub
    //   877: aload_0
    //   878: getfield 90	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   881: i2l
    //   882: lcmp
    //   883: ifgt +13 -> 896
    //   886: lload_2
    //   887: aload_0
    //   888: getfield 92	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   891: i2l
    //   892: lcmp
    //   893: ifle +1322 -> 2215
    //   896: aload 17
    //   898: ldc_w 272
    //   901: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   904: checkcast 199	java/lang/Long
    //   907: invokevirtual 202	java/lang/Long:longValue	()J
    //   910: lstore 10
    //   912: aload 17
    //   914: ldc_w 280
    //   917: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   920: checkcast 199	java/lang/Long
    //   923: invokevirtual 202	java/lang/Long:longValue	()J
    //   926: lstore 12
    //   928: aload 17
    //   930: ldc_w 288
    //   933: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   936: checkcast 199	java/lang/Long
    //   939: invokevirtual 202	java/lang/Long:longValue	()J
    //   942: lstore 14
    //   944: new 38	java/io/File
    //   947: dup
    //   948: getstatic 78	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   951: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   954: astore_1
    //   955: new 601	java/util/ArrayList
    //   958: dup
    //   959: iconst_4
    //   960: invokespecial 602	java/util/ArrayList:<init>	(I)V
    //   963: astore 22
    //   965: aload 22
    //   967: aload_1
    //   968: invokevirtual 605	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   971: invokeinterface 610 2 0
    //   976: pop
    //   977: new 38	java/io/File
    //   980: dup
    //   981: getstatic 82	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   984: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   987: astore 18
    //   989: aload 18
    //   991: invokevirtual 307	java/io/File:exists	()Z
    //   994: ifeq +9 -> 1003
    //   997: aload 18
    //   999: invokevirtual 341	java/io/File:delete	()Z
    //   1002: pop
    //   1003: aload 22
    //   1005: aload 18
    //   1007: invokevirtual 605	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1010: invokeinterface 610 2 0
    //   1015: pop
    //   1016: aconst_null
    //   1017: astore_1
    //   1018: new 612	java/io/BufferedOutputStream
    //   1021: dup
    //   1022: new 614	java/io/FileOutputStream
    //   1025: dup
    //   1026: aload 18
    //   1028: invokespecial 617	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1031: invokespecial 620	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1034: astore 19
    //   1036: aload 19
    //   1038: ldc_w 622
    //   1041: invokevirtual 626	java/lang/String:getBytes	()[B
    //   1044: invokevirtual 630	java/io/BufferedOutputStream:write	([B)V
    //   1047: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1050: iconst_1
    //   1051: if_icmpne +1072 -> 2123
    //   1054: ldc_w 632
    //   1057: astore_1
    //   1058: aload 19
    //   1060: aload_1
    //   1061: invokevirtual 626	java/lang/String:getBytes	()[B
    //   1064: invokevirtual 630	java/io/BufferedOutputStream:write	([B)V
    //   1067: new 27	java/lang/StringBuilder
    //   1070: dup
    //   1071: sipush 200
    //   1074: invokespecial 262	java/lang/StringBuilder:<init>	(I)V
    //   1077: astore 23
    //   1079: aload 23
    //   1081: ldc_w 634
    //   1084: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   1090: ldc2_w 635
    //   1093: lsub
    //   1094: ldc_w 638
    //   1097: invokestatic 156	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1100: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: ldc_w 640
    //   1106: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   1112: ldc_w 638
    //   1115: invokestatic 156	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1118: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 642
    //   1124: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: ldc_w 644
    //   1130: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1133: lload 8
    //   1135: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1138: ldc_w 646
    //   1141: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: lload_2
    //   1145: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1148: ldc_w 648
    //   1151: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: lload 10
    //   1156: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1159: ldc_w 650
    //   1162: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: lload 12
    //   1167: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1170: ldc_w 652
    //   1173: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: lload 14
    //   1178: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1181: ldc_w 654
    //   1184: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: aload 17
    //   1189: ldc_w 292
    //   1192: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1195: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1198: ldc_w 656
    //   1201: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload 17
    //   1206: ldc_w 294
    //   1209: invokevirtual 524	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1212: invokevirtual 539	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1215: ldc_w 642
    //   1218: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload 19
    //   1224: aload 23
    //   1226: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokevirtual 626	java/lang/String:getBytes	()[B
    //   1232: invokevirtual 630	java/io/BufferedOutputStream:write	([B)V
    //   1235: aconst_null
    //   1236: astore 21
    //   1238: aconst_null
    //   1239: astore_1
    //   1240: aconst_null
    //   1241: astore 20
    //   1243: lconst_0
    //   1244: lstore 4
    //   1246: aload 20
    //   1248: astore 18
    //   1250: aload 21
    //   1252: astore 17
    //   1254: invokestatic 162	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1257: invokevirtual 660	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1260: astore 24
    //   1262: iconst_0
    //   1263: ifne +60 -> 1323
    //   1266: aload 20
    //   1268: astore 18
    //   1270: aload 21
    //   1272: astore 17
    //   1274: aload 24
    //   1276: ldc 50
    //   1278: sipush 128
    //   1281: invokevirtual 666	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1284: astore_1
    //   1285: aload 20
    //   1287: astore 18
    //   1289: aload 21
    //   1291: astore 17
    //   1293: new 27	java/lang/StringBuilder
    //   1296: dup
    //   1297: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1300: aload_1
    //   1301: getfield 671	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1304: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc 52
    //   1309: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload_1
    //   1313: getfield 674	android/content/pm/PackageInfo:versionCode	I
    //   1316: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1319: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1322: astore_1
    //   1323: aload 20
    //   1325: astore 18
    //   1327: aload_1
    //   1328: astore 17
    //   1330: aload 24
    //   1332: ldc 50
    //   1334: sipush 128
    //   1337: invokevirtual 678	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1340: getfield 684	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1343: ldc_w 686
    //   1346: invokevirtual 691	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1349: invokevirtual 692	java/lang/Object:toString	()Ljava/lang/String;
    //   1352: astore 20
    //   1354: aload 20
    //   1356: astore 18
    //   1358: aload_1
    //   1359: astore 17
    //   1361: getstatic 696	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   1364: aconst_null
    //   1365: invokevirtual 700	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1368: invokevirtual 705	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   1371: invokestatic 708	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1374: lstore 6
    //   1376: ldc_w 710
    //   1379: astore 21
    //   1381: aload_1
    //   1382: astore 17
    //   1384: lload 6
    //   1386: lstore 4
    //   1388: aload 20
    //   1390: astore 18
    //   1392: aload 21
    //   1394: astore_1
    //   1395: aload 23
    //   1397: iconst_0
    //   1398: aload 23
    //   1400: invokevirtual 713	java/lang/StringBuilder:length	()I
    //   1403: invokevirtual 716	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: aload 23
    //   1409: ldc_w 718
    //   1412: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: lload 4
    //   1417: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1420: ldc_w 720
    //   1423: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: aload 17
    //   1428: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 722
    //   1434: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload 18
    //   1439: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc_w 724
    //   1445: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: aload_1
    //   1449: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: ldc_w 726
    //   1455: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   1461: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1464: ldc_w 728
    //   1467: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1473: invokevirtual 731	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1476: pop
    //   1477: aload 19
    //   1479: aload 23
    //   1481: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1484: invokevirtual 626	java/lang/String:getBytes	()[B
    //   1487: invokevirtual 630	java/io/BufferedOutputStream:write	([B)V
    //   1490: aload 19
    //   1492: invokevirtual 734	java/io/BufferedOutputStream:flush	()V
    //   1495: aload 19
    //   1497: ifnull +8 -> 1505
    //   1500: aload 19
    //   1502: invokevirtual 737	java/io/BufferedOutputStream:close	()V
    //   1505: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   1508: invokestatic 739	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   1511: astore_1
    //   1512: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   1515: ldc2_w 740
    //   1518: lsub
    //   1519: invokestatic 739	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	(J)Ljava/lang/String;
    //   1522: astore 17
    //   1524: aload 22
    //   1526: aload_1
    //   1527: invokeinterface 610 2 0
    //   1532: pop
    //   1533: aload_1
    //   1534: aload 17
    //   1536: invokevirtual 473	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1539: ifne +13 -> 1552
    //   1542: aload 22
    //   1544: aload 17
    //   1546: invokeinterface 610 2 0
    //   1551: pop
    //   1552: invokestatic 743	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:a	()Ljava/lang/String;
    //   1555: astore 18
    //   1557: iconst_0
    //   1558: istore 16
    //   1560: aload 22
    //   1562: aload 18
    //   1564: invokestatic 748	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/util/List;Ljava/lang/String;)Z
    //   1567: ifeq +165 -> 1732
    //   1570: aload_0
    //   1571: aload_0
    //   1572: getfield 88	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_Int	I
    //   1575: iconst_1
    //   1576: isub
    //   1577: putfield 88	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_Int	I
    //   1580: aload_0
    //   1581: getfield 390	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1584: invokeinterface 444 1 0
    //   1589: ldc_w 456
    //   1592: aload_0
    //   1593: getfield 390	com/tencent/qqperf/monitor/backgroundcpu/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1596: ldc_w 456
    //   1599: iconst_0
    //   1600: invokeinterface 467 3 0
    //   1605: iconst_1
    //   1606: iadd
    //   1607: invokeinterface 460 3 0
    //   1612: invokeinterface 463 1 0
    //   1617: pop
    //   1618: new 750	org/json/JSONObject
    //   1621: dup
    //   1622: invokespecial 751	org/json/JSONObject:<init>	()V
    //   1625: astore_1
    //   1626: new 750	org/json/JSONObject
    //   1629: dup
    //   1630: invokespecial 751	org/json/JSONObject:<init>	()V
    //   1633: astore 17
    //   1635: aload 17
    //   1637: ldc_w 753
    //   1640: aload 18
    //   1642: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1645: pop
    //   1646: new 750	org/json/JSONObject
    //   1649: dup
    //   1650: invokespecial 751	org/json/JSONObject:<init>	()V
    //   1653: astore 18
    //   1655: aload 18
    //   1657: ldc_w 758
    //   1660: ldc_w 469
    //   1663: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1666: pop
    //   1667: aload_1
    //   1668: ldc_w 760
    //   1671: aload 17
    //   1673: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1676: pop
    //   1677: aload_1
    //   1678: ldc_w 762
    //   1681: aload 18
    //   1683: invokevirtual 756	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1686: pop
    //   1687: aload_1
    //   1688: ldc_w 764
    //   1691: bipush 126
    //   1693: invokevirtual 767	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1696: pop
    //   1697: new 769	com/tencent/qqperf/repoter/ResultObject
    //   1700: dup
    //   1701: iconst_0
    //   1702: ldc_w 771
    //   1705: iconst_1
    //   1706: lconst_1
    //   1707: lconst_1
    //   1708: aload_1
    //   1709: iconst_1
    //   1710: iconst_1
    //   1711: getstatic 774	com/tencent/qqperf/MagnifierSDK:jdField_a_of_type_Long	J
    //   1714: invokespecial 777	com/tencent/qqperf/repoter/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   1717: invokestatic 782	com/tencent/qqperf/repoter/ReporterMachine:a	(Lcom/tencent/qqperf/repoter/ResultObject;)V
    //   1720: ldc 235
    //   1722: iconst_2
    //   1723: ldc_w 784
    //   1726: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1729: iconst_1
    //   1730: istore 16
    //   1732: new 516	java/util/HashMap
    //   1735: dup
    //   1736: iconst_2
    //   1737: invokespecial 517	java/util/HashMap:<init>	(I)V
    //   1740: astore_1
    //   1741: aload_1
    //   1742: new 27	java/lang/StringBuilder
    //   1745: dup
    //   1746: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1749: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1752: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1755: ldc_w 536
    //   1758: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1764: new 27	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1771: lload 8
    //   1773: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1776: ldc_w 477
    //   1779: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1785: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1788: pop
    //   1789: aload_1
    //   1790: new 27	java/lang/StringBuilder
    //   1793: dup
    //   1794: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1797: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1800: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1803: ldc_w 542
    //   1806: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1809: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1812: new 27	java/lang/StringBuilder
    //   1815: dup
    //   1816: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1819: lload_2
    //   1820: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1823: ldc_w 477
    //   1826: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1832: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1835: pop
    //   1836: aload_1
    //   1837: new 27	java/lang/StringBuilder
    //   1840: dup
    //   1841: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1844: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1847: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1850: ldc_w 544
    //   1853: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1856: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1859: new 27	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1866: lload 10
    //   1868: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1871: ldc_w 477
    //   1874: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1880: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1883: pop
    //   1884: aload_1
    //   1885: new 27	java/lang/StringBuilder
    //   1888: dup
    //   1889: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1892: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1895: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1898: ldc_w 546
    //   1901: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1907: new 27	java/lang/StringBuilder
    //   1910: dup
    //   1911: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1914: lload 12
    //   1916: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1919: ldc_w 477
    //   1922: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1925: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1928: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1931: pop
    //   1932: aload_1
    //   1933: new 27	java/lang/StringBuilder
    //   1936: dup
    //   1937: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1940: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1943: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1946: ldc_w 548
    //   1949: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1955: new 27	java/lang/StringBuilder
    //   1958: dup
    //   1959: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   1962: lload 14
    //   1964: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1967: ldc_w 477
    //   1970: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1973: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1976: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1979: pop
    //   1980: aload_1
    //   1981: ldc_w 550
    //   1984: getstatic 210	mqq/app/MobileQQ:sProcessId	I
    //   1987: invokestatic 219	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1990: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1993: pop
    //   1994: aload_1
    //   1995: ldc_w 552
    //   1998: getstatic 386	android/os/Build$VERSION:SDK_INT	I
    //   2001: invokestatic 219	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2004: invokevirtual 540	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2007: pop
    //   2008: invokestatic 162	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2011: invokestatic 557	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2014: aconst_null
    //   2015: ldc_w 786
    //   2018: iload 16
    //   2020: lconst_0
    //   2021: lconst_0
    //   2022: aload_1
    //   2023: aconst_null
    //   2024: invokevirtual 563	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   2027: aload 22
    //   2029: invokeinterface 790 1 0
    //   2034: astore_1
    //   2035: aload_1
    //   2036: invokeinterface 795 1 0
    //   2041: ifeq -2012 -> 29
    //   2044: aload_1
    //   2045: invokeinterface 799 1 0
    //   2050: checkcast 57	java/lang/String
    //   2053: astore 17
    //   2055: aload 17
    //   2057: ldc 174
    //   2059: invokevirtual 802	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2062: ifne -27 -> 2035
    //   2065: aload 17
    //   2067: ldc_w 804
    //   2070: invokevirtual 802	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2073: ifne -38 -> 2035
    //   2076: new 38	java/io/File
    //   2079: dup
    //   2080: aload 17
    //   2082: invokespecial 303	java/io/File:<init>	(Ljava/lang/String;)V
    //   2085: astore 17
    //   2087: aload 17
    //   2089: invokevirtual 307	java/io/File:exists	()Z
    //   2092: ifeq -57 -> 2035
    //   2095: aload 17
    //   2097: invokevirtual 341	java/io/File:delete	()Z
    //   2100: pop
    //   2101: goto -66 -> 2035
    //   2104: astore_1
    //   2105: ldc 235
    //   2107: iconst_1
    //   2108: ldc_w 477
    //   2111: aload_1
    //   2112: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2115: goto -1383 -> 732
    //   2118: lconst_0
    //   2119: lstore_2
    //   2120: goto -1298 -> 822
    //   2123: ldc_w 806
    //   2126: astore_1
    //   2127: goto -1069 -> 1058
    //   2130: astore_1
    //   2131: ldc 235
    //   2133: iconst_1
    //   2134: ldc_w 477
    //   2137: aload_1
    //   2138: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2141: ldc_w 808
    //   2144: astore_1
    //   2145: goto -750 -> 1395
    //   2148: astore 17
    //   2150: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2153: ifeq +14 -> 2167
    //   2156: ldc 235
    //   2158: iconst_2
    //   2159: ldc_w 477
    //   2162: aload 17
    //   2164: invokestatic 480	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2167: aload_1
    //   2168: ifnull -663 -> 1505
    //   2171: aload_1
    //   2172: invokevirtual 737	java/io/BufferedOutputStream:close	()V
    //   2175: goto -670 -> 1505
    //   2178: astore_1
    //   2179: goto -674 -> 1505
    //   2182: astore_1
    //   2183: aconst_null
    //   2184: astore 17
    //   2186: aload 17
    //   2188: ifnull +8 -> 2196
    //   2191: aload 17
    //   2193: invokevirtual 737	java/io/BufferedOutputStream:close	()V
    //   2196: aload_1
    //   2197: athrow
    //   2198: astore_1
    //   2199: ldc 235
    //   2201: iconst_1
    //   2202: ldc_w 810
    //   2205: aload_1
    //   2206: invokestatic 594	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2209: iconst_1
    //   2210: istore 16
    //   2212: goto -480 -> 1732
    //   2215: ldc 235
    //   2217: iconst_1
    //   2218: iconst_4
    //   2219: anewarray 4	java/lang/Object
    //   2222: dup
    //   2223: iconst_0
    //   2224: ldc_w 812
    //   2227: aastore
    //   2228: dup
    //   2229: iconst_1
    //   2230: lload 8
    //   2232: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2235: aastore
    //   2236: dup
    //   2237: iconst_2
    //   2238: ldc_w 477
    //   2241: aastore
    //   2242: dup
    //   2243: iconst_3
    //   2244: lload_2
    //   2245: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2248: aastore
    //   2249: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2252: goto -2223 -> 29
    //   2255: astore_1
    //   2256: goto -751 -> 1505
    //   2259: astore 17
    //   2261: goto -65 -> 2196
    //   2264: astore_1
    //   2265: aload 19
    //   2267: astore 17
    //   2269: goto -83 -> 2186
    //   2272: astore 18
    //   2274: aload_1
    //   2275: astore 17
    //   2277: aload 18
    //   2279: astore_1
    //   2280: goto -94 -> 2186
    //   2283: astore 17
    //   2285: aload 19
    //   2287: astore_1
    //   2288: goto -138 -> 2150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2291	0	this	BackgroundCpuMonitor
    //   0	2291	1	paramMessage	android.os.Message
    //   156	2089	2	l1	long
    //   129	1287	4	l2	long
    //   1374	11	6	l3	long
    //   794	1437	8	l4	long
    //   910	957	10	l5	long
    //   926	989	12	l6	long
    //   942	1021	14	l7	long
    //   1558	653	16	bool	boolean
    //   80	2016	17	localObject1	Object
    //   2148	15	17	localException1	Exception
    //   2184	8	17	localObject2	Object
    //   2259	1	17	localException2	Exception
    //   2267	9	17	localObject3	Object
    //   2283	1	17	localException3	Exception
    //   987	695	18	localObject4	Object
    //   2272	6	18	localObject5	Object
    //   1034	1252	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1241	148	20	str1	String
    //   1236	157	21	str2	String
    //   963	1065	22	localArrayList	java.util.ArrayList
    //   1077	403	23	localStringBuilder	StringBuilder
    //   1260	71	24	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   620	659	662	java/lang/Throwable
    //   678	681	684	java/lang/Throwable
    //   729	732	2104	java/lang/Throwable
    //   1254	1262	2130	java/lang/Exception
    //   1274	1285	2130	java/lang/Exception
    //   1293	1323	2130	java/lang/Exception
    //   1330	1354	2130	java/lang/Exception
    //   1361	1376	2130	java/lang/Exception
    //   1018	1036	2148	java/lang/Exception
    //   2171	2175	2178	java/lang/Exception
    //   1018	1036	2182	finally
    //   1618	1729	2198	java/lang/Exception
    //   1500	1505	2255	java/lang/Exception
    //   2191	2196	2259	java/lang/Exception
    //   1036	1054	2264	finally
    //   1058	1235	2264	finally
    //   1254	1262	2264	finally
    //   1274	1285	2264	finally
    //   1293	1323	2264	finally
    //   1330	1354	2264	finally
    //   1361	1376	2264	finally
    //   1395	1495	2264	finally
    //   2131	2141	2264	finally
    //   2150	2167	2272	finally
    //   1036	1054	2283	java/lang/Exception
    //   1058	1235	2283	java/lang/Exception
    //   1395	1495	2283	java/lang/Exception
    //   2131	2141	2283	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor
 * JD-Core Version:    0.7.0.1
 */