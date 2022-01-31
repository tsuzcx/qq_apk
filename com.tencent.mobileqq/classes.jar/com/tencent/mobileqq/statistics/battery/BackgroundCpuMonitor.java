package com.tencent.mobileqq.statistics.battery;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import mqq.app.MainService;

public class BackgroundCpuMonitor
  implements Handler.Callback
{
  private static BackgroundCpuMonitor jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBackgroundCpuMonitor;
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", File.separator) + File.separator;
  private static final String jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "temp.trace";
  private static final String jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + File.separator + "bg_cpu_" + "baseInfo.txt";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 15;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  
  public static BackgroundCpuMonitor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBackgroundCpuMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBackgroundCpuMonitor == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBackgroundCpuMonitor = new BackgroundCpuMonitor();
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsBatteryBackgroundCpuMonitor;
    }
    finally {}
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString).append("bg_cpu_").append(System.currentTimeMillis()).append(".trace.zip");
    return localStringBuilder.toString();
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, Map paramMap)
  {
    Object[] arrayOfObject = ProcessStats.a("-2");
    long l2 = -1L;
    long l1 = -1L;
    long l3 = -1L;
    if (arrayOfObject != null)
    {
      l2 = ((Long)arrayOfObject[1]).longValue() + ((Long)arrayOfObject[2]).longValue();
      l1 = ((Long)arrayOfObject[1]).longValue();
    }
    long l4 = ProcessStats.a("-1");
    if (BaseApplicationImpl.sProcessId != 4) {
      l3 = ProcessStats.a(String.valueOf(MainService.sNativeTidOfReceiver));
    }
    if (QLog.isColorLevel()) {
      QLog.d("BatteryStats.BgCpu", 2, new Object[] { "cpuInfo: ", Long.valueOf(l2), ", ", Long.valueOf(l1), ", ", Long.valueOf(l4), ", ", Long.valueOf(l3), "[", Integer.valueOf(MainService.sNativeTidOfReceiver), "]" });
    }
    if ((l2 <= 0L) || (l1 <= 0L) || (l4 <= 0L) || ((BaseApplicationImpl.sProcessId != 4) && (l3 <= 0L)))
    {
      QLog.e("BatteryStats.BgCpu", 2, "bad cpu value");
      return false;
    }
    int i;
    int k;
    if (paramBoolean2)
    {
      i = -1;
      long l5 = l2 - this.jdField_a_of_type_Long;
      if ((l5 <= 0L) || (l1 <= this.jdField_b_of_type_Long) || (l4 <= this.jdField_c_of_type_Long))
      {
        paramMap = new StringBuilder(256);
        paramMap.append("bad cpu value2.").append(l2).append(",").append(this.jdField_a_of_type_Long).append(",").append(l1).append(",").append(this.jdField_b_of_type_Long).append(",").append(l4).append(",").append(this.jdField_c_of_type_Long);
        QLog.d("BatteryStats.BgCpu", 1, paramMap.toString());
        return false;
      }
      long l6 = l4 - this.jdField_c_of_type_Long;
      k = (int)(100L * l6 / l5);
      if (paramMap != null)
      {
        paramMap.put("elapse", Long.valueOf(l5));
        paramMap.put("qqConsume", Long.valueOf(l6));
        paramMap.put("qqRatio", Long.valueOf(k));
      }
      if (BaseApplicationImpl.sProcessId == 4) {
        break label628;
      }
      if (l3 < this.jdField_d_of_type_Long)
      {
        QLog.e("BatteryStats.BgCpu", 1, new Object[] { "bad msf-receiver cpu.", Long.valueOf(l3), ", ", Long.valueOf(this.jdField_d_of_type_Long) });
        return false;
      }
      l6 = l3 - this.jdField_d_of_type_Long;
      int j = (int)(100L * l6 / l5);
      i = j;
      if (paramMap != null)
      {
        paramMap.put("msfConsume", Long.valueOf(l6));
        paramMap.put("msfRatio", Long.valueOf(j));
        i = j;
      }
    }
    for (;;)
    {
      QLog.d("BatteryStats.BgCpu", 1, new Object[] { "qqCpuRatio = ", Integer.valueOf(k), ", msf-receiver cpuRatio = ", Integer.valueOf(i), ", remainRptCount = ", Integer.valueOf(this.jdField_a_of_type_Int) });
      if (paramBoolean1)
      {
        this.jdField_a_of_type_Long = l2;
        this.jdField_b_of_type_Long = l1;
        this.jdField_c_of_type_Long = l4;
        this.jdField_d_of_type_Long = l3;
      }
      return true;
      label628:
      paramMap.put("msfConsume", Long.valueOf(0L));
      paramMap.put("msfRatio", Long.valueOf(0L));
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
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
    } while ((!this.jdField_a_of_type_Boolean) || (Looper.myLooper() != ThreadManager.getFileThreadLooper()) || (!a(true, false, null)));
    QLog.d("BatteryStats.BgCpu", 1, "start trace bg cpu");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
  }
  
  void a(String paramString)
  {
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4)) {
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
          this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
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
            break label445;
          }
          bool1 = true;
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("rand_time", System.currentTimeMillis()).putBoolean("rand_rs", bool1).putInt("times", 0).commit();
        }
        boolean bool2 = bool1;
        if (bool1)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            break label451;
          }
          i = 1;
          break label469;
          this.jdField_b_of_type_Int = Integer.valueOf(paramString[j]).intValue();
          if (i == 0) {
            break label463;
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
        QQLiveImage.setUSRLogEnable(this.jdField_a_of_type_Boolean);
        if ((this.jdField_a_of_type_Boolean) && (BaseApplicationImpl.sProcessId == 4) && (this.jdField_a_of_type_AndroidOsHandler == null)) {
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
      label445:
      boolean bool1 = false;
      continue;
      label451:
      int i = 0;
      label463:
      label469:
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
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("bgCpu", 4);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("enable_nor_sensor", true);
  }
  
  void b()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (this.e > 0L) {
        QLog.d("BatteryStats.BgCpu", 1, "stop trace bg cpu");
      }
      try
      {
        Debug.stopMethodTracing();
        this.e = 0L;
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
    //   1: getfield 417	android/os/Message:what	I
    //   4: iconst_2
    //   5: if_icmpne +9 -> 14
    //   8: aload_0
    //   9: invokevirtual 419	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	()V
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_1
    //   15: getfield 417	android/os/Message:what	I
    //   18: ifne +623 -> 641
    //   21: new 421	java/util/HashMap
    //   24: dup
    //   25: iconst_5
    //   26: invokespecial 422	java/util/HashMap:<init>	(I)V
    //   29: astore 17
    //   31: aload_0
    //   32: iconst_1
    //   33: iconst_1
    //   34: aload 17
    //   36: invokespecial 262	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   39: ifeq -27 -> 12
    //   42: aload 17
    //   44: ldc 187
    //   46: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   49: ifeq -37 -> 12
    //   52: aload 17
    //   54: ldc 197
    //   56: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   59: ifeq -47 -> 12
    //   62: aload 17
    //   64: ldc 187
    //   66: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 104	java/lang/Long
    //   72: invokevirtual 107	java/lang/Long:longValue	()J
    //   75: lstore 4
    //   77: aload 17
    //   79: ldc 197
    //   81: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   84: ifeq +552 -> 636
    //   87: aload 17
    //   89: ldc 197
    //   91: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: checkcast 104	java/lang/Long
    //   97: invokevirtual 107	java/lang/Long:longValue	()J
    //   100: lstore_2
    //   101: ldc 134
    //   103: iconst_1
    //   104: bipush 6
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: ldc_w 431
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: lload 4
    //   119: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: ldc 171
    //   127: aastore
    //   128: dup
    //   129: iconst_3
    //   130: lload_2
    //   131: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: aastore
    //   135: dup
    //   136: iconst_4
    //   137: ldc 141
    //   139: aastore
    //   140: dup
    //   141: iconst_5
    //   142: iconst_0
    //   143: invokestatic 436	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   146: aastore
    //   147: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   150: lload 4
    //   152: lload_2
    //   153: lsub
    //   154: aload_0
    //   155: getfield 75	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   158: i2l
    //   159: lcmp
    //   160: ifgt +13 -> 173
    //   163: lload_2
    //   164: aload_0
    //   165: getfield 77	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   168: i2l
    //   169: lcmp
    //   170: ifle -158 -> 12
    //   173: new 421	java/util/HashMap
    //   176: dup
    //   177: iconst_2
    //   178: invokespecial 422	java/util/HashMap:<init>	(I)V
    //   181: astore_1
    //   182: aload_1
    //   183: new 22	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   190: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   193: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc_w 441
    //   199: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: new 22	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   212: aload 17
    //   214: ldc 187
    //   216: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   219: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc_w 383
    //   225: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   234: pop
    //   235: aload_1
    //   236: new 22	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   243: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   246: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 447
    //   252: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: new 22	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   265: aload 17
    //   267: ldc 197
    //   269: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: ldc_w 383
    //   278: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   287: pop
    //   288: aload_1
    //   289: new 22	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   296: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   299: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   302: ldc_w 449
    //   305: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: new 22	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   318: aload 17
    //   320: ldc 177
    //   322: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   325: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   328: ldc_w 383
    //   331: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   340: pop
    //   341: aload_1
    //   342: new 22	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   349: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   352: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: ldc_w 451
    //   358: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: new 22	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   371: aload 17
    //   373: ldc 185
    //   375: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   378: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   381: ldc_w 383
    //   384: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   393: pop
    //   394: aload_1
    //   395: new 22	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   402: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   405: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc_w 453
    //   411: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: new 22	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   424: aload 17
    //   426: ldc 195
    //   428: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   431: invokevirtual 444	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: ldc_w 383
    //   437: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   446: pop
    //   447: aload_1
    //   448: ldc_w 455
    //   451: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   454: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   457: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload_1
    //   462: ldc_w 457
    //   465: getstatic 284	android/os/Build$VERSION:SDK_INT	I
    //   468: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   471: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   474: pop
    //   475: invokestatic 292	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   478: invokestatic 462	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   481: aconst_null
    //   482: ldc_w 464
    //   485: iconst_1
    //   486: lconst_0
    //   487: lconst_0
    //   488: aload_1
    //   489: aconst_null
    //   490: invokevirtual 467	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   493: new 33	java/io/File
    //   496: dup
    //   497: getstatic 67	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   500: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   503: astore 17
    //   505: aload 17
    //   507: invokevirtual 470	java/io/File:getParentFile	()Ljava/io/File;
    //   510: ifnull +23 -> 533
    //   513: aload 17
    //   515: invokevirtual 470	java/io/File:getParentFile	()Ljava/io/File;
    //   518: invokevirtual 211	java/io/File:exists	()Z
    //   521: ifeq +12 -> 533
    //   524: aload 17
    //   526: invokevirtual 470	java/io/File:getParentFile	()Ljava/io/File;
    //   529: invokevirtual 473	java/io/File:mkdirs	()Z
    //   532: pop
    //   533: aload 17
    //   535: invokevirtual 211	java/io/File:exists	()Z
    //   538: ifeq +9 -> 547
    //   541: aload 17
    //   543: invokevirtual 245	java/io/File:delete	()Z
    //   546: pop
    //   547: aload_0
    //   548: getfield 373	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_Boolean	Z
    //   551: ifeq +7 -> 558
    //   554: iconst_2
    //   555: invokestatic 476	com/tencent/qphone/base/util/QLog:setUIN_REPORTLOG_LEVEL	(I)V
    //   558: getstatic 67	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   561: ldc_w 477
    //   564: sipush 1000
    //   567: invokestatic 481	android/os/Debug:startMethodTracingSampling	(Ljava/lang/String;II)V
    //   570: aload_0
    //   571: invokestatic 486	android/os/SystemClock:uptimeMillis	()J
    //   574: putfield 393	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:e	J
    //   577: aload_0
    //   578: getfield 266	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   581: aload_0
    //   582: getfield 266	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   585: iconst_1
    //   586: aload_1
    //   587: invokestatic 490	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   590: ldc2_w 272
    //   593: invokevirtual 494	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   596: pop
    //   597: goto -585 -> 12
    //   600: astore_1
    //   601: aload_0
    //   602: iconst_0
    //   603: putfield 249	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_Boolean	Z
    //   606: ldc 134
    //   608: iconst_1
    //   609: ldc_w 496
    //   612: aload_1
    //   613: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   616: invokestatic 400	android/os/Debug:stopMethodTracing	()V
    //   619: goto -607 -> 12
    //   622: astore_1
    //   623: ldc 134
    //   625: iconst_1
    //   626: ldc_w 383
    //   629: aload_1
    //   630: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   633: goto -621 -> 12
    //   636: lconst_0
    //   637: lstore_2
    //   638: goto -537 -> 101
    //   641: aload_1
    //   642: getfield 417	android/os/Message:what	I
    //   645: iconst_1
    //   646: if_icmpne -634 -> 12
    //   649: invokestatic 400	android/os/Debug:stopMethodTracing	()V
    //   652: aload_0
    //   653: lconst_0
    //   654: putfield 393	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:e	J
    //   657: new 421	java/util/HashMap
    //   660: dup
    //   661: iconst_5
    //   662: invokespecial 422	java/util/HashMap:<init>	(I)V
    //   665: astore_1
    //   666: aload_0
    //   667: iconst_1
    //   668: iconst_1
    //   669: aload_1
    //   670: invokespecial 262	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	(ZZLjava/util/Map;)Z
    //   673: ifeq -661 -> 12
    //   676: aload_1
    //   677: ldc 187
    //   679: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   682: ifeq -670 -> 12
    //   685: aload_1
    //   686: ldc 197
    //   688: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   691: ifeq -679 -> 12
    //   694: aload_1
    //   695: ldc 187
    //   697: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   700: checkcast 104	java/lang/Long
    //   703: invokevirtual 107	java/lang/Long:longValue	()J
    //   706: lstore 8
    //   708: aload_1
    //   709: ldc 197
    //   711: invokevirtual 425	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   714: ifeq +1274 -> 1988
    //   717: aload_1
    //   718: ldc 197
    //   720: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   723: checkcast 104	java/lang/Long
    //   726: invokevirtual 107	java/lang/Long:longValue	()J
    //   729: lstore_2
    //   730: ldc 134
    //   732: iconst_1
    //   733: bipush 6
    //   735: anewarray 4	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: ldc_w 500
    //   743: aastore
    //   744: dup
    //   745: iconst_1
    //   746: lload 8
    //   748: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   751: aastore
    //   752: dup
    //   753: iconst_2
    //   754: ldc 171
    //   756: aastore
    //   757: dup
    //   758: iconst_3
    //   759: lload_2
    //   760: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   763: aastore
    //   764: dup
    //   765: iconst_4
    //   766: ldc 171
    //   768: aastore
    //   769: dup
    //   770: iconst_5
    //   771: iconst_0
    //   772: invokestatic 436	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   775: aastore
    //   776: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   779: lload 8
    //   781: lload_2
    //   782: lsub
    //   783: aload_0
    //   784: getfield 75	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_Int	I
    //   787: i2l
    //   788: lcmp
    //   789: ifgt +13 -> 802
    //   792: lload_2
    //   793: aload_0
    //   794: getfield 77	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_c_of_type_Int	I
    //   797: i2l
    //   798: lcmp
    //   799: ifle +1286 -> 2085
    //   802: aload_1
    //   803: ldc 177
    //   805: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   808: checkcast 104	java/lang/Long
    //   811: invokevirtual 107	java/lang/Long:longValue	()J
    //   814: lstore 10
    //   816: aload_1
    //   817: ldc 185
    //   819: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   822: checkcast 104	java/lang/Long
    //   825: invokevirtual 107	java/lang/Long:longValue	()J
    //   828: lstore 12
    //   830: aload_1
    //   831: ldc 195
    //   833: invokevirtual 429	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   836: checkcast 104	java/lang/Long
    //   839: invokevirtual 107	java/lang/Long:longValue	()J
    //   842: lstore 14
    //   844: new 33	java/io/File
    //   847: dup
    //   848: getstatic 67	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   851: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   854: astore_1
    //   855: new 502	java/util/ArrayList
    //   858: dup
    //   859: iconst_4
    //   860: invokespecial 503	java/util/ArrayList:<init>	(I)V
    //   863: astore 22
    //   865: aload 22
    //   867: aload_1
    //   868: invokevirtual 506	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   871: invokeinterface 511 2 0
    //   876: pop
    //   877: new 33	java/io/File
    //   880: dup
    //   881: getstatic 71	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   884: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   887: astore 17
    //   889: aload 17
    //   891: invokevirtual 211	java/io/File:exists	()Z
    //   894: ifeq +9 -> 903
    //   897: aload 17
    //   899: invokevirtual 245	java/io/File:delete	()Z
    //   902: pop
    //   903: aload 22
    //   905: aload 17
    //   907: invokevirtual 506	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   910: invokeinterface 511 2 0
    //   915: pop
    //   916: aconst_null
    //   917: astore_1
    //   918: new 513	java/io/BufferedOutputStream
    //   921: dup
    //   922: new 515	java/io/FileOutputStream
    //   925: dup
    //   926: aload 17
    //   928: invokespecial 518	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   931: invokespecial 521	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   934: astore 19
    //   936: aload 19
    //   938: ldc_w 523
    //   941: invokevirtual 527	java/lang/String:getBytes	()[B
    //   944: invokevirtual 531	java/io/BufferedOutputStream:write	([B)V
    //   947: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   950: iconst_1
    //   951: if_icmpne +1042 -> 1993
    //   954: ldc_w 533
    //   957: astore_1
    //   958: aload 19
    //   960: aload_1
    //   961: invokevirtual 527	java/lang/String:getBytes	()[B
    //   964: invokevirtual 531	java/io/BufferedOutputStream:write	([B)V
    //   967: new 22	java/lang/StringBuilder
    //   970: dup
    //   971: sipush 200
    //   974: invokespecial 167	java/lang/StringBuilder:<init>	(I)V
    //   977: astore 23
    //   979: aload 23
    //   981: ldc_w 535
    //   984: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   990: ldc2_w 536
    //   993: lsub
    //   994: ldc_w 539
    //   997: invokestatic 544	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1000: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: ldc_w 546
    //   1006: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   1012: ldc_w 539
    //   1015: invokestatic 544	com/tencent/mobileqq/utils/TimeFormatterUtils:a	(JLjava/lang/String;)Ljava/lang/String;
    //   1018: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 548
    //   1024: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: ldc_w 550
    //   1030: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: lload 8
    //   1035: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1038: ldc_w 552
    //   1041: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: lload_2
    //   1045: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1048: ldc_w 554
    //   1051: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: lload 10
    //   1056: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1059: ldc_w 556
    //   1062: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: lload 12
    //   1067: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1070: ldc_w 558
    //   1073: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1076: lload 14
    //   1078: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1081: ldc_w 548
    //   1084: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: aload 19
    //   1090: aload 23
    //   1092: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokevirtual 527	java/lang/String:getBytes	()[B
    //   1098: invokevirtual 531	java/io/BufferedOutputStream:write	([B)V
    //   1101: aconst_null
    //   1102: astore 21
    //   1104: aconst_null
    //   1105: astore_1
    //   1106: aconst_null
    //   1107: astore 20
    //   1109: lconst_0
    //   1110: lstore 4
    //   1112: aload 20
    //   1114: astore 18
    //   1116: aload 21
    //   1118: astore 17
    //   1120: invokestatic 292	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1123: invokevirtual 562	com/tencent/common/app/BaseApplicationImpl:getPackageManager	()Landroid/content/pm/PackageManager;
    //   1126: astore 24
    //   1128: iconst_0
    //   1129: ifne +60 -> 1189
    //   1132: aload 20
    //   1134: astore 18
    //   1136: aload 21
    //   1138: astore 17
    //   1140: aload 24
    //   1142: ldc 45
    //   1144: sipush 128
    //   1147: invokevirtual 568	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   1150: astore_1
    //   1151: aload 20
    //   1153: astore 18
    //   1155: aload 21
    //   1157: astore 17
    //   1159: new 22	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1166: aload_1
    //   1167: getfield 573	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   1170: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: ldc 47
    //   1175: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload_1
    //   1179: getfield 576	android/content/pm/PackageInfo:versionCode	I
    //   1182: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1185: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1188: astore_1
    //   1189: aload 20
    //   1191: astore 18
    //   1193: aload_1
    //   1194: astore 17
    //   1196: aload 24
    //   1198: ldc 45
    //   1200: sipush 128
    //   1203: invokevirtual 580	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   1206: getfield 586	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   1209: ldc_w 588
    //   1212: invokevirtual 593	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1215: invokevirtual 594	java/lang/Object:toString	()Ljava/lang/String;
    //   1218: astore 20
    //   1220: aload 20
    //   1222: astore 18
    //   1224: aload_1
    //   1225: astore 17
    //   1227: invokestatic 292	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1230: aconst_null
    //   1231: invokevirtual 598	com/tencent/common/app/BaseApplicationImpl:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   1234: checkcast 600	com/tencent/mobileqq/app/QQAppInterface
    //   1237: invokevirtual 603	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1240: invokestatic 606	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1243: lstore 6
    //   1245: ldc_w 608
    //   1248: astore 21
    //   1250: aload_1
    //   1251: astore 17
    //   1253: lload 6
    //   1255: lstore 4
    //   1257: aload 20
    //   1259: astore 18
    //   1261: aload 21
    //   1263: astore_1
    //   1264: aload 23
    //   1266: iconst_0
    //   1267: aload 23
    //   1269: invokevirtual 611	java/lang/StringBuilder:length	()I
    //   1272: invokevirtual 614	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 23
    //   1278: ldc_w 616
    //   1281: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: lload 4
    //   1286: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1289: ldc_w 618
    //   1292: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload 17
    //   1297: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: ldc_w 620
    //   1303: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload 18
    //   1308: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: ldc_w 622
    //   1314: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: aload_1
    //   1318: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1321: ldc_w 624
    //   1324: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   1330: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1333: ldc_w 626
    //   1336: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1342: invokevirtual 629	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 19
    //   1348: aload 23
    //   1350: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1353: invokevirtual 527	java/lang/String:getBytes	()[B
    //   1356: invokevirtual 531	java/io/BufferedOutputStream:write	([B)V
    //   1359: aload 19
    //   1361: invokevirtual 632	java/io/BufferedOutputStream:flush	()V
    //   1364: aload 19
    //   1366: ifnull +8 -> 1374
    //   1369: aload 19
    //   1371: invokevirtual 635	java/io/BufferedOutputStream:close	()V
    //   1374: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   1377: invokestatic 640	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:a	(J)Ljava/lang/String;
    //   1380: astore_1
    //   1381: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   1384: ldc2_w 641
    //   1387: lsub
    //   1388: invokestatic 640	com/tencent/mfsdk/LeakInspector/DumpMemInfoHandler:a	(J)Ljava/lang/String;
    //   1391: astore 17
    //   1393: aload 22
    //   1395: aload_1
    //   1396: invokeinterface 511 2 0
    //   1401: pop
    //   1402: aload_1
    //   1403: aload 17
    //   1405: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1408: ifne +13 -> 1421
    //   1411: aload 22
    //   1413: aload 17
    //   1415: invokeinterface 511 2 0
    //   1420: pop
    //   1421: invokestatic 644	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:a	()Ljava/lang/String;
    //   1424: astore 18
    //   1426: iconst_0
    //   1427: istore 16
    //   1429: aload 22
    //   1431: aload 18
    //   1433: invokestatic 649	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/util/List;Ljava/lang/String;)Z
    //   1436: ifeq +165 -> 1601
    //   1439: aload_0
    //   1440: aload_0
    //   1441: getfield 205	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_Int	I
    //   1444: iconst_1
    //   1445: isub
    //   1446: putfield 205	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_Int	I
    //   1449: aload_0
    //   1450: getfield 288	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1453: invokeinterface 342 1 0
    //   1458: ldc_w 354
    //   1461: aload_0
    //   1462: getfield 288	com/tencent/mobileqq/statistics/battery/BackgroundCpuMonitor:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   1465: ldc_w 354
    //   1468: iconst_0
    //   1469: invokeinterface 365 3 0
    //   1474: iconst_1
    //   1475: iadd
    //   1476: invokeinterface 358 3 0
    //   1481: invokeinterface 361 1 0
    //   1486: pop
    //   1487: new 651	org/json/JSONObject
    //   1490: dup
    //   1491: invokespecial 652	org/json/JSONObject:<init>	()V
    //   1494: astore_1
    //   1495: new 651	org/json/JSONObject
    //   1498: dup
    //   1499: invokespecial 652	org/json/JSONObject:<init>	()V
    //   1502: astore 17
    //   1504: aload 17
    //   1506: ldc_w 654
    //   1509: aload 18
    //   1511: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1514: pop
    //   1515: new 651	org/json/JSONObject
    //   1518: dup
    //   1519: invokespecial 652	org/json/JSONObject:<init>	()V
    //   1522: astore 18
    //   1524: aload 18
    //   1526: ldc_w 659
    //   1529: ldc_w 367
    //   1532: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1535: pop
    //   1536: aload_1
    //   1537: ldc_w 661
    //   1540: aload 17
    //   1542: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1545: pop
    //   1546: aload_1
    //   1547: ldc_w 663
    //   1550: aload 18
    //   1552: invokevirtual 657	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1555: pop
    //   1556: aload_1
    //   1557: ldc_w 665
    //   1560: bipush 126
    //   1562: invokevirtual 668	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1565: pop
    //   1566: new 670	com/tencent/mfsdk/collector/ResultObject
    //   1569: dup
    //   1570: iconst_0
    //   1571: ldc_w 672
    //   1574: iconst_1
    //   1575: lconst_1
    //   1576: lconst_1
    //   1577: aload_1
    //   1578: iconst_1
    //   1579: iconst_1
    //   1580: getstatic 675	com/tencent/mfsdk/MagnifierSDK:jdField_a_of_type_Long	J
    //   1583: invokespecial 678	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   1586: invokestatic 683	com/tencent/mfsdk/reporter/ReporterMachine:a	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   1589: ldc 134
    //   1591: iconst_2
    //   1592: ldc_w 685
    //   1595: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1598: iconst_1
    //   1599: istore 16
    //   1601: new 421	java/util/HashMap
    //   1604: dup
    //   1605: iconst_2
    //   1606: invokespecial 422	java/util/HashMap:<init>	(I)V
    //   1609: astore_1
    //   1610: aload_1
    //   1611: new 22	java/lang/StringBuilder
    //   1614: dup
    //   1615: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1618: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1621: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1624: ldc_w 441
    //   1627: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1633: new 22	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1640: lload 8
    //   1642: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1645: ldc_w 383
    //   1648: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1654: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1657: pop
    //   1658: aload_1
    //   1659: new 22	java/lang/StringBuilder
    //   1662: dup
    //   1663: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1666: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1669: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1672: ldc_w 447
    //   1675: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1681: new 22	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1688: lload_2
    //   1689: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1692: ldc_w 383
    //   1695: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1698: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1704: pop
    //   1705: aload_1
    //   1706: new 22	java/lang/StringBuilder
    //   1709: dup
    //   1710: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1713: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1716: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1719: ldc_w 449
    //   1722: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1728: new 22	java/lang/StringBuilder
    //   1731: dup
    //   1732: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1735: lload 10
    //   1737: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1740: ldc_w 383
    //   1743: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1749: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1752: pop
    //   1753: aload_1
    //   1754: new 22	java/lang/StringBuilder
    //   1757: dup
    //   1758: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1761: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1764: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1767: ldc_w 451
    //   1770: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1776: new 22	java/lang/StringBuilder
    //   1779: dup
    //   1780: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1783: lload 12
    //   1785: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1788: ldc_w 383
    //   1791: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1797: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1800: pop
    //   1801: aload_1
    //   1802: new 22	java/lang/StringBuilder
    //   1805: dup
    //   1806: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1809: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1812: invokevirtual 439	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1815: ldc_w 453
    //   1818: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1824: new 22	java/lang/StringBuilder
    //   1827: dup
    //   1828: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   1831: lload 14
    //   1833: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: ldc_w 383
    //   1839: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1845: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1848: pop
    //   1849: aload_1
    //   1850: ldc_w 455
    //   1853: getstatic 117	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   1856: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1859: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1862: pop
    //   1863: aload_1
    //   1864: ldc_w 457
    //   1867: getstatic 284	android/os/Build$VERSION:SDK_INT	I
    //   1870: invokestatic 126	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1873: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1876: pop
    //   1877: invokestatic 292	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1880: invokestatic 462	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1883: aconst_null
    //   1884: ldc_w 687
    //   1887: iload 16
    //   1889: lconst_0
    //   1890: lconst_0
    //   1891: aload_1
    //   1892: aconst_null
    //   1893: invokevirtual 467	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1896: aload 22
    //   1898: invokeinterface 691 1 0
    //   1903: astore_1
    //   1904: aload_1
    //   1905: invokeinterface 696 1 0
    //   1910: ifeq -1898 -> 12
    //   1913: aload_1
    //   1914: invokeinterface 700 1 0
    //   1919: checkcast 52	java/lang/String
    //   1922: astore 17
    //   1924: aload 17
    //   1926: ldc_w 702
    //   1929: invokevirtual 705	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1932: ifne -28 -> 1904
    //   1935: aload 17
    //   1937: ldc_w 707
    //   1940: invokevirtual 705	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1943: ifne -39 -> 1904
    //   1946: new 33	java/io/File
    //   1949: dup
    //   1950: aload 17
    //   1952: invokespecial 208	java/io/File:<init>	(Ljava/lang/String;)V
    //   1955: astore 17
    //   1957: aload 17
    //   1959: invokevirtual 211	java/io/File:exists	()Z
    //   1962: ifeq -58 -> 1904
    //   1965: aload 17
    //   1967: invokevirtual 245	java/io/File:delete	()Z
    //   1970: pop
    //   1971: goto -67 -> 1904
    //   1974: astore_1
    //   1975: ldc 134
    //   1977: iconst_1
    //   1978: ldc_w 383
    //   1981: aload_1
    //   1982: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1985: goto -1333 -> 652
    //   1988: lconst_0
    //   1989: lstore_2
    //   1990: goto -1260 -> 730
    //   1993: ldc_w 709
    //   1996: astore_1
    //   1997: goto -1039 -> 958
    //   2000: astore_1
    //   2001: ldc 134
    //   2003: iconst_1
    //   2004: ldc_w 383
    //   2007: aload_1
    //   2008: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2011: ldc_w 711
    //   2014: astore_1
    //   2015: goto -751 -> 1264
    //   2018: astore 17
    //   2020: invokestatic 132	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2023: ifeq +14 -> 2037
    //   2026: ldc 134
    //   2028: iconst_2
    //   2029: ldc_w 383
    //   2032: aload 17
    //   2034: invokestatic 386	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2037: aload_1
    //   2038: ifnull -664 -> 1374
    //   2041: aload_1
    //   2042: invokevirtual 635	java/io/BufferedOutputStream:close	()V
    //   2045: goto -671 -> 1374
    //   2048: astore_1
    //   2049: goto -675 -> 1374
    //   2052: astore_1
    //   2053: aconst_null
    //   2054: astore 17
    //   2056: aload 17
    //   2058: ifnull +8 -> 2066
    //   2061: aload 17
    //   2063: invokevirtual 635	java/io/BufferedOutputStream:close	()V
    //   2066: aload_1
    //   2067: athrow
    //   2068: astore_1
    //   2069: ldc 134
    //   2071: iconst_1
    //   2072: ldc_w 713
    //   2075: aload_1
    //   2076: invokestatic 498	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2079: iconst_1
    //   2080: istore 16
    //   2082: goto -481 -> 1601
    //   2085: ldc 134
    //   2087: iconst_1
    //   2088: iconst_4
    //   2089: anewarray 4	java/lang/Object
    //   2092: dup
    //   2093: iconst_0
    //   2094: ldc_w 715
    //   2097: aastore
    //   2098: dup
    //   2099: iconst_1
    //   2100: lload 8
    //   2102: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2105: aastore
    //   2106: dup
    //   2107: iconst_2
    //   2108: ldc_w 383
    //   2111: aastore
    //   2112: dup
    //   2113: iconst_3
    //   2114: lload_2
    //   2115: invokestatic 139	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2118: aastore
    //   2119: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2122: goto -2110 -> 12
    //   2125: astore_1
    //   2126: goto -752 -> 1374
    //   2129: astore 17
    //   2131: goto -65 -> 2066
    //   2134: astore_1
    //   2135: aload 19
    //   2137: astore 17
    //   2139: goto -83 -> 2056
    //   2142: astore 18
    //   2144: aload_1
    //   2145: astore 17
    //   2147: aload 18
    //   2149: astore_1
    //   2150: goto -94 -> 2056
    //   2153: astore 17
    //   2155: aload 19
    //   2157: astore_1
    //   2158: goto -138 -> 2020
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2161	0	this	BackgroundCpuMonitor
    //   0	2161	1	paramMessage	android.os.Message
    //   100	2015	2	l1	long
    //   75	1210	4	l2	long
    //   1243	11	6	l3	long
    //   706	1395	8	l4	long
    //   814	922	10	l5	long
    //   828	956	12	l6	long
    //   842	990	14	l7	long
    //   1427	654	16	bool	boolean
    //   29	1937	17	localObject1	Object
    //   2018	15	17	localException1	Exception
    //   2054	8	17	localObject2	Object
    //   2129	1	17	localException2	Exception
    //   2137	9	17	localObject3	Object
    //   2153	1	17	localException3	Exception
    //   1114	437	18	localObject4	Object
    //   2142	6	18	localObject5	Object
    //   934	1222	19	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1107	151	20	str1	String
    //   1102	160	21	str2	String
    //   863	1034	22	localArrayList	java.util.ArrayList
    //   977	372	23	localStringBuilder	StringBuilder
    //   1126	71	24	localPackageManager	android.content.pm.PackageManager
    // Exception table:
    //   from	to	target	type
    //   558	597	600	java/lang/Throwable
    //   616	619	622	java/lang/Throwable
    //   649	652	1974	java/lang/Throwable
    //   1120	1128	2000	java/lang/Exception
    //   1140	1151	2000	java/lang/Exception
    //   1159	1189	2000	java/lang/Exception
    //   1196	1220	2000	java/lang/Exception
    //   1227	1245	2000	java/lang/Exception
    //   918	936	2018	java/lang/Exception
    //   2041	2045	2048	java/lang/Exception
    //   918	936	2052	finally
    //   1487	1598	2068	java/lang/Exception
    //   1369	1374	2125	java/lang/Exception
    //   2061	2066	2129	java/lang/Exception
    //   936	954	2134	finally
    //   958	1101	2134	finally
    //   1120	1128	2134	finally
    //   1140	1151	2134	finally
    //   1159	1189	2134	finally
    //   1196	1220	2134	finally
    //   1227	1245	2134	finally
    //   1264	1364	2134	finally
    //   2001	2011	2134	finally
    //   2020	2037	2142	finally
    //   936	954	2153	java/lang/Exception
    //   958	1101	2153	java/lang/Exception
    //   1264	1364	2153	java/lang/Exception
    //   2001	2011	2153	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.battery.BackgroundCpuMonitor
 * JD-Core Version:    0.7.0.1
 */