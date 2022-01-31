package com.tencent.mobileqq.statistics;

import aiks;
import aikt;
import aiku;
import aikv;
import aikw;
import aikx;
import aiky;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.anr.ANRReport;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class StatisticCollector
{
  private static Context jdField_a_of_type_AndroidContentContext;
  public static StatisticCollector.StatisticCallback a;
  private static StatisticCollector jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  private static final Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static boolean b;
  private static boolean c;
  private static boolean d;
  private int jdField_a_of_type_Int;
  aikx jdField_a_of_type_Aikx = new aikx();
  public String a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("DPC info:\n");
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Stack jdField_a_of_type_JavaUtilStack = new Stack();
  public boolean a;
  private aiky[] jdField_a_of_type_ArrayOfAiky = { new aiky("com.tencent.mtt", "qqBrowser"), new aiky("com.tencent.android.qqdownloader", "qqMarket"), new aiky("com.tencent.qqgame", "qqGame"), new aiky("com.tencent.qqmusic", "qqMusic"), new aiky("com.tencent.news", "qqNews"), new aiky("com.qq.reader", "qqReader"), new aiky("com.tencent.qqlive", "qqVideo"), new aiky("com.tencent.wblog", "qqMicroblog"), new aiky("com.tencent.qqphonebook", "qqPhonebook") };
  private String jdField_b_of_type_JavaLangString;
  private StringBuilder jdField_b_of_type_JavaLangStringBuilder = new StringBuilder("Thread info:\n");
  
  private StatisticCollector(Context paramContext, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = "999";
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_AndroidContentContext = paramContext;
    UserAction.setUserID("10000");
    UserAction.initUserAction(jdField_a_of_type_AndroidContentContext, false, paramLong);
    UserAction.setChannelID("70124");
  }
  
  public static int a()
  {
    return LocalMultiProcConfig.getInt("version_patchlib_load", 0);
  }
  
  public static StatisticCollector a(Context paramContext)
  {
    return a(paramContext, 3000L);
  }
  
  public static StatisticCollector a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector = new StatisticCollector(BaseApplicationImpl.getApplication(), paramLong);
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsStatisticCollector;
    }
    finally {}
  }
  
  private static Map a()
  {
    HashMap localHashMap = new HashMap(16);
    localHashMap.put("param_MODEL", DeviceInfoUtil.e());
    localHashMap.put("param_manu", DeviceInfoUtil.l());
    localHashMap.put("param_OS", DeviceInfoUtil.f());
    localHashMap.put("param_Resolution", MsfSdkUtils.getResolutionString(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_IMEI", DeviceInfoUtil.a());
    localHashMap.put("param_IMSI", DeviceInfoUtil.b());
    localHashMap.put("param_NetworkType", "" + NetworkUtil.b(jdField_a_of_type_AndroidContentContext));
    localHashMap.put("param_ProductVersion", "" + AppSetting.jdField_a_of_type_Int);
    localHashMap.put("param_CPU", DeviceInfoUtil.h());
    localHashMap.put("param_totalmemory", MsfSdkUtils.getTotalMemory());
    localHashMap.put("param_availmemory", String.valueOf(DeviceInfoUtil.f() / 1024L) + "kB");
    long[] arrayOfLong = DeviceInfoUtil.a();
    localHashMap.put("param_totalrom", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availrom", String.valueOf(arrayOfLong[1]) + "MB");
    arrayOfLong = DeviceInfoUtil.b();
    localHashMap.put("param_totalsd", String.valueOf(arrayOfLong[0]) + "MB");
    localHashMap.put("param_availsd", String.valueOf(arrayOfLong[1]) + "MB");
    localHashMap.put("param_Camera", "" + DeviceInfoUtil.c());
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    LocalMultiProcConfig.putInt("version_patchlib_load", paramInt);
    if (paramInt > 0) {
      QLog.i("PatchLibLoader", 1, "setQzonePatchTag" + paramInt);
    }
  }
  
  private void a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(200);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningServiceInfo localRunningServiceInfo = (ActivityManager.RunningServiceInfo)((Iterator)localObject).next();
          if (paramString.equals(localRunningServiceInfo.process))
          {
            Intent localIntent = new Intent();
            localIntent.setComponent(localRunningServiceInfo.service);
            QLog.d("StatisticCollector", 1, "Stop service: " + localRunningServiceInfo.service + ", clientCount: " + localRunningServiceInfo.clientCount + ", clientPackage: " + localRunningServiceInfo.clientPackage + ", crashCount: " + localRunningServiceInfo.crashCount);
            paramContext.stopService(localIntent);
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, StringBuilder paramStringBuilder)
  {
    Object localObject1 = ReflecterHelper.a("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)ReflecterHelper.a("android.app.LoadedApk", ((WeakReference)((Map)ReflecterHelper.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        paramStringBuilder.append(((BroadcastReceiver)localObject3).getClass().getName());
        paramStringBuilder.append(" in ");
        paramStringBuilder.append(localObject2.getClass().getName());
      }
    }
  }
  
  public static void a(Map paramMap, int paramInt)
  {
    paramMap.put("param_FailCode", String.valueOf(paramInt));
  }
  
  public static boolean a()
  {
    if ("7.6.8".startsWith("7.1.")) {}
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2;
    if (paramInt != 3)
    {
      bool2 = false;
      return bool2;
    }
    String[] arrayOfString2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SqlSampleCfg.name(), "250|5|5|1|50|5|5|25|25|25|5|10|10").split("\\|");
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2.length < 13) {
      arrayOfString1 = "250|5|5|1|50|5|5|25|25|25|5|10|10".split("\\|");
    }
    if (paramInt > arrayOfString1.length - 1) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(arrayOfString1[paramInt]).intValue();
        if (paramInt <= 0) {
          break label164;
        }
        if (jdField_a_of_type_JavaUtilRandom.nextInt(paramInt) == paramInt - 1)
        {
          bool1 = true;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("StatisticCollector", 2, new Object[] { "getSqliteSwitchBySample value: ", Integer.valueOf(paramInt), " switch: ", Boolean.valueOf(bool1) });
          return bool1;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StatisticCollector", 2, "getSqliteSwitchBySample error", localException);
        }
        return false;
      }
      boolean bool1 = false;
      continue;
      label164:
      bool1 = false;
    }
  }
  
  private boolean a(String paramString)
  {
    if ("actC2CPicUploadV1".equals(paramString)) {}
    while (("actC2CPicUploadV2".equals(paramString)) || ("actGroupPicUploadV2".equals(paramString)) || ("actDiscussPicUploadV2".equals(paramString)) || ("actC2CPicDownloadV1".equals(paramString)) || ("actC2CPicSmallDownV1".equals(paramString)) || ("actGroupPicUploadV1".equals(paramString)) || ("actGroupPicDownloadV1".equals(paramString)) || ("actGroupPicSmallDownV1".equals(paramString)) || ("actDiscussPicUpload".equals(paramString)) || ("actDiscussPicDown".equals(paramString)) || ("actDiscussPicSmallDown".equals(paramString)) || ("actGrpPttUp".equals(paramString)) || ("actGrpPttDown".equals(paramString)) || ("actDisscusPttUp".equals(paramString)) || ("actDisscusPttDown".equals(paramString)) || ("actC2CStreamPttUpload".equals(paramString)) || ("actC2CStreamPttDownload".equals(paramString)) || ("actC2CPttDownload".equals(paramString)) || ("actC2CPttUpload".equals(paramString)) || ("actFileDown".equals(paramString)) || ("actFileUp".equals(paramString)) || ("actFileOf2Of".equals(paramString)) || ("actFileOf2Wy".equals(paramString)) || ("actFileWy2Of".equals(paramString)) || ("actFileWyUp".equals(paramString)) || ("actFileWyDown".equals(paramString)) || ("actFileUpDetail".equals(paramString)) || ("actFileDownDetail".equals(paramString)) || ("actFAFileDown".equals(paramString)) || ("actFAFileUp".equals(paramString)) || ("actShortVideoUpload".equals(paramString)) || ("actShortVideoUploadBDH".equals(paramString)) || ("actShortVideoDiscussgroupUploadBDH".equals(paramString)) || ("actShortVideoForwardBDH".equals(paramString)) || ("actShortVideoDownloadVideo".equals(paramString)) || ("actShortVideoDownloadThumb".equals(paramString)) || ("actShortVideoDiscussgroupUpload".equals(paramString)) || ("actShortVideoDiscussgroupDownloadVideo".equals(paramString)) || ("actShortVideoDiscussgroupDownloadThumb".equals(paramString)) || ("PicStatisticsManagerUploadPic".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.e() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.f() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      localStringBuilder.append(l1).append("M,avaiable:").append(l2).append("M used:").append(((DecimalFormat)localObject).format(f1)).append("M freeMemory:").append(f2).append("M,appTotalMemory:").append(f3).append("M,maxMemory:").append(f4).append("M, ImgCache:").append(BaseApplicationImpl.sImageCache.size() / 1024 / 1024).append("M,SkinCache:").append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L).append("M,LeakMonitor=").append(MemoryReporter.a().jdField_a_of_type_Boolean);
      localObject = (ArrayList)MemoryReporter.jdField_a_of_type_JavaUtilArrayList.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      localStringBuilder.append("]");
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
    paramString2 = paramString2 + " time:" + System.currentTimeMillis() + "\n";
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.crash_control.name(), null);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      Object localObject = new JSONObject(str);
      this.jdField_a_of_type_Aikx.jdField_a_of_type_Boolean = ((JSONObject)localObject).getBoolean("control_switch");
      this.jdField_a_of_type_Aikx.jdField_a_of_type_Int = ((JSONObject)localObject).getInt("control_level");
      this.jdField_a_of_type_Aikx.b = ((JSONObject)localObject).getInt("control_window");
      this.jdField_a_of_type_Aikx.c = ((JSONObject)localObject).getInt("control_freq");
      localObject = this.jdField_a_of_type_JavaLangStringBuilder.append("initCrashControl");
      ((StringBuilder)localObject).append(",controlJson=").append(str);
      ((StringBuilder)localObject).append(",switch=").append(this.jdField_a_of_type_Aikx.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(",level=").append(this.jdField_a_of_type_Aikx.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",window=").append(this.jdField_a_of_type_Aikx.b);
      ((StringBuilder)localObject).append(",Freq=").append(this.jdField_a_of_type_Aikx.c);
      this.jdField_a_of_type_JavaLangStringBuilder.append("\n");
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.jdField_a_of_type_Aikx.a();
        QLog.d("StatisticCollector", 1, "initCrashControl parse json throws an exception, so reset.");
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.push(paramContext);
      b("onCreate", paramContext);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      UserAction.setUserID(paramString);
      CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new aikw(System.currentTimeMillis(), paramString1, paramString2);
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
      int i = this.jdField_a_of_type_Int;
      for (this.jdField_a_of_type_Int = (paramString1.jdField_a_of_type_Int + i); (this.jdField_a_of_type_Int > 15360L) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 1); this.jdField_a_of_type_Int -= paramString1.jdField_a_of_type_Int) {
        paramString1 = (aikw)this.jdField_a_of_type_JavaUtilLinkedList.removeLast();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3, boolean paramBoolean2)
  {
    if (paramString1 == null) {
      paramString1 = "10000";
    }
    for (;;)
    {
      paramString3 = paramString1;
      if (paramString1 != null)
      {
        paramString3 = paramString1;
        if (paramString1.length() < 1) {
          paramString3 = "10000";
        }
      }
      UserAction.setUserID(paramString3);
      if (paramHashMap == null)
      {
        paramString1 = new HashMap();
        if (paramString1 != null) {
          paramString1.put("param_ProductVersion", "" + AppSetting.jdField_a_of_type_Int);
        }
        if (QLog.isColorLevel()) {
          QLog.d("StatisticCollector", 2, "event report: " + paramString2 + " " + paramBoolean1 + " time:" + paramLong1 + " size:" + paramLong2);
        }
        if ((paramBoolean1) && ((!paramString1.containsKey("param_FailCode")) || ("".equals(paramString1.get("param_FailCode"))))) {
          paramString1.put("param_FailCode", String.valueOf(0));
        }
        paramHashMap = new RdmReq();
        paramHashMap.eventName = paramString2;
        paramHashMap.elapse = paramLong1;
        paramHashMap.size = paramLong2;
        paramHashMap.isSucceed = paramBoolean1;
        paramHashMap.isRealTime = paramBoolean2;
        if (a(paramString2))
        {
          paramHashMap.isMerge = false;
          paramHashMap.isRealTime = true;
        }
        paramHashMap.params = paramString1;
      }
      try
      {
        paramString1 = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramHashMap);
        paramString1.setAppId(AppSetting.jdField_a_of_type_Int);
        paramString1.setTimeout(30000L);
        ThreadManager.post(new aikv(this, paramString1), 5, null, true);
        return;
      }
      catch (Exception paramString1)
      {
        return;
      }
      paramString1 = new HashSet();
      paramString1.addAll(paramHashMap.keySet());
      paramString3 = paramString1.iterator();
      for (;;)
      {
        paramString1 = paramHashMap;
        if (!paramString3.hasNext()) {
          break;
        }
        paramString1 = (String)paramString3.next();
        if ((String)paramHashMap.get(paramString1) == null) {
          paramHashMap.put(paramString1, "");
        }
      }
    }
  }
  
  /* Error */
  public void a(StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 109	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 906
    //   10: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 635	android/os/Process:myPid	()I
    //   16: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   19: ldc_w 908
    //   22: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 9
    //   30: aload_1
    //   31: ldc_w 910
    //   34: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aconst_null
    //   39: astore 6
    //   41: aconst_null
    //   42: astore 8
    //   44: aconst_null
    //   45: astore 5
    //   47: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   50: lstore_3
    //   51: new 912	java/io/File
    //   54: dup
    //   55: aload 9
    //   57: invokespecial 913	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 917	java/io/File:list	()[Ljava/lang/String;
    //   63: astore 10
    //   65: iconst_0
    //   66: istore_2
    //   67: aload 5
    //   69: astore 6
    //   71: aload 5
    //   73: astore 8
    //   75: iload_2
    //   76: aload 10
    //   78: arraylength
    //   79: if_icmpge +120 -> 199
    //   82: aload 5
    //   84: astore 6
    //   86: aload 5
    //   88: astore 8
    //   90: new 912	java/io/File
    //   93: dup
    //   94: new 109	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   101: aload 9
    //   103: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 919
    //   109: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 10
    //   114: iload_2
    //   115: aaload
    //   116: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 921
    //   122: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 913	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: astore 7
    //   133: aload 5
    //   135: astore 6
    //   137: aload 5
    //   139: astore 8
    //   141: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   144: lload_3
    //   145: lsub
    //   146: ldc2_w 922
    //   149: lcmp
    //   150: ifle +192 -> 342
    //   153: aload 5
    //   155: astore 6
    //   157: aload 5
    //   159: astore 8
    //   161: invokestatic 504	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +35 -> 199
    //   167: aload 5
    //   169: astore 6
    //   171: aload 5
    //   173: astore 8
    //   175: ldc_w 366
    //   178: iconst_2
    //   179: iconst_2
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: ldc_w 925
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_1
    //   192: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   199: aload 5
    //   201: astore 6
    //   203: aload 5
    //   205: astore 8
    //   207: aload_1
    //   208: ldc_w 927
    //   211: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 10
    //   216: arraylength
    //   217: invokevirtual 236	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 5
    //   223: astore 6
    //   225: aload 5
    //   227: astore 8
    //   229: invokestatic 932	com/tencent/mobileqq/app/ThreadLog:needRecordJob	()Z
    //   232: ifeq +36 -> 268
    //   235: aload 5
    //   237: astore 6
    //   239: aload 5
    //   241: astore 8
    //   243: aload 10
    //   245: arraylength
    //   246: sipush 200
    //   249: if_icmple +19 -> 268
    //   252: aload 5
    //   254: astore 6
    //   256: aload 5
    //   258: astore 8
    //   260: aload_1
    //   261: invokestatic 935	com/tencent/mobileqq/app/ThreadManager:reportCurrentState	()Ljava/lang/String;
    //   264: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 5
    //   270: astore 6
    //   272: aload 5
    //   274: astore 8
    //   276: invokestatic 504	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +52 -> 331
    //   282: aload 5
    //   284: astore 6
    //   286: aload 5
    //   288: astore 8
    //   290: ldc_w 366
    //   293: iconst_2
    //   294: iconst_4
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: ldc_w 937
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: invokestatic 734	java/lang/System:currentTimeMillis	()J
    //   309: lload_3
    //   310: lsub
    //   311: invokestatic 942	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   314: aastore
    //   315: dup
    //   316: iconst_2
    //   317: ldc_w 944
    //   320: aastore
    //   321: dup
    //   322: iconst_3
    //   323: aload_1
    //   324: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aastore
    //   328: invokestatic 519	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   331: aload 5
    //   333: ifnull +8 -> 341
    //   336: aload 5
    //   338: invokevirtual 949	java/io/BufferedReader:close	()V
    //   341: return
    //   342: aload 5
    //   344: astore 6
    //   346: aload 5
    //   348: astore 8
    //   350: aload 7
    //   352: invokevirtual 952	java/io/File:exists	()Z
    //   355: ifeq +233 -> 588
    //   358: aload 5
    //   360: astore 6
    //   362: aload 5
    //   364: astore 8
    //   366: new 946	java/io/BufferedReader
    //   369: dup
    //   370: new 954	java/io/FileReader
    //   373: dup
    //   374: aload 7
    //   376: invokespecial 957	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   379: bipush 64
    //   381: invokespecial 960	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   384: astore 7
    //   386: aconst_null
    //   387: astore 6
    //   389: aload 7
    //   391: invokevirtual 963	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   394: astore 8
    //   396: aload 6
    //   398: astore 5
    //   400: aload 8
    //   402: ifnull +29 -> 431
    //   405: aload 8
    //   407: ldc_w 965
    //   410: invokevirtual 461	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   413: ifeq -24 -> 389
    //   416: aload 8
    //   418: ldc_w 967
    //   421: invokevirtual 489	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   424: iconst_1
    //   425: aaload
    //   426: invokevirtual 970	java/lang/String:trim	()Ljava/lang/String;
    //   429: astore 5
    //   431: aload_1
    //   432: aload 5
    //   434: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc_w 972
    //   440: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload 7
    //   446: astore 5
    //   448: aload 7
    //   450: ifnull +11 -> 461
    //   453: aload 7
    //   455: invokevirtual 949	java/io/BufferedReader:close	()V
    //   458: aconst_null
    //   459: astore 5
    //   461: iload_2
    //   462: iconst_1
    //   463: iadd
    //   464: istore_2
    //   465: goto -398 -> 67
    //   468: astore 5
    //   470: ldc_w 366
    //   473: iconst_2
    //   474: ldc_w 974
    //   477: aload 5
    //   479: invokestatic 524	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   482: aload 7
    //   484: astore 5
    //   486: goto -25 -> 461
    //   489: astore_1
    //   490: aload 7
    //   492: astore 8
    //   494: aload 8
    //   496: astore 6
    //   498: ldc_w 366
    //   501: iconst_2
    //   502: ldc_w 974
    //   505: aload_1
    //   506: invokestatic 524	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: aload 8
    //   511: ifnull -170 -> 341
    //   514: aload 8
    //   516: invokevirtual 949	java/io/BufferedReader:close	()V
    //   519: return
    //   520: astore_1
    //   521: ldc_w 366
    //   524: iconst_2
    //   525: ldc_w 974
    //   528: aload_1
    //   529: invokestatic 524	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   532: return
    //   533: astore_1
    //   534: ldc_w 366
    //   537: iconst_2
    //   538: ldc_w 974
    //   541: aload_1
    //   542: invokestatic 524	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   545: return
    //   546: astore_1
    //   547: aload 6
    //   549: ifnull +8 -> 557
    //   552: aload 6
    //   554: invokevirtual 949	java/io/BufferedReader:close	()V
    //   557: aload_1
    //   558: athrow
    //   559: astore 5
    //   561: ldc_w 366
    //   564: iconst_2
    //   565: ldc_w 974
    //   568: aload 5
    //   570: invokestatic 524	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   573: goto -16 -> 557
    //   576: astore_1
    //   577: aload 7
    //   579: astore 6
    //   581: goto -34 -> 547
    //   584: astore_1
    //   585: goto -91 -> 494
    //   588: goto -127 -> 461
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	591	0	this	StatisticCollector
    //   0	591	1	paramStringBuilder	StringBuilder
    //   66	399	2	i	int
    //   50	260	3	l	long
    //   45	415	5	localObject1	Object
    //   468	10	5	localIOException1	java.io.IOException
    //   484	1	5	localObject2	Object
    //   559	10	5	localIOException2	java.io.IOException
    //   39	541	6	localObject3	Object
    //   131	447	7	localObject4	Object
    //   42	473	8	localObject5	Object
    //   28	74	9	str	String
    //   63	181	10	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   453	458	468	java/io/IOException
    //   389	396	489	java/lang/Exception
    //   405	431	489	java/lang/Exception
    //   431	444	489	java/lang/Exception
    //   453	458	489	java/lang/Exception
    //   470	482	489	java/lang/Exception
    //   514	519	520	java/io/IOException
    //   336	341	533	java/io/IOException
    //   51	65	546	finally
    //   75	82	546	finally
    //   90	133	546	finally
    //   141	153	546	finally
    //   161	167	546	finally
    //   175	199	546	finally
    //   207	221	546	finally
    //   229	235	546	finally
    //   243	252	546	finally
    //   260	268	546	finally
    //   276	282	546	finally
    //   290	331	546	finally
    //   350	358	546	finally
    //   366	386	546	finally
    //   498	509	546	finally
    //   552	557	559	java/io/IOException
    //   389	396	576	finally
    //   405	431	576	finally
    //   431	444	576	finally
    //   453	458	576	finally
    //   470	482	576	finally
    //   51	65	584	java/lang/Exception
    //   75	82	584	java/lang/Exception
    //   90	133	584	java/lang/Exception
    //   141	153	584	java/lang/Exception
    //   161	167	584	java/lang/Exception
    //   175	199	584	java/lang/Exception
    //   207	221	584	java/lang/Exception
    //   229	235	584	java/lang/Exception
    //   243	252	584	java/lang/Exception
    //   260	268	584	java/lang/Exception
    //   276	282	584	java/lang/Exception
    //   290	331	584	java/lang/Exception
    //   350	358	584	java/lang/Exception
    //   366	386	584	java/lang/Exception
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (d) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return;
      } while ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()));
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
      l1 = ((SharedPreferences)localObject).getLong("next_reportTime_" + paramAppRuntime.getAccount(), 0L);
      l2 = (NetConnInfoCenter.getServerTimeMillis() + 28800000L) / 86400000L;
    } while (l2 < l1);
    d = true;
    ((SharedPreferences)localObject).edit().putLong("next_reportTime_" + paramAppRuntime.getAccount(), 1L + l2).commit();
    Object localObject = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    ((NewIntent)localObject).putExtra("sendType", 2);
    ((NewIntent)localObject).putExtra("tag", "mqq_dailyUse");
    ((NewIntent)localObject).putExtra("content", "");
    paramAppRuntime.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "Report Daily Use,Next Report Day:" + l2 + 1);
    }
    d = false;
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "MsgOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=MsgOper,content=" + paramString);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString == null)) {
      return;
    }
    a(paramAppRuntime, paramString, paramInt, "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {}
    do
    {
      return;
      paramString1 = paramString1 + "|" + paramString2 + "|" + paramString3 + "|" + paramInt + "|" + paramString4;
      paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", "appPlug");
      paramString2.putExtra("content", paramString1);
      paramAppRuntime.startServlet(paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("reportToAds", 2, paramString1);
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (paramString1 == null)) {
      return;
    }
    a(paramAppRuntime, paramString1, 1, "", "", paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    paramString1 = paramString2 + "|" + paramInt;
    paramString2 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString2.putExtra("sendType", 2);
    paramString2.putExtra("tag", "mqq_tab");
    paramString2.putExtra("content", paramString1);
    paramAppRuntime.startServlet(paramString2);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return;
    }
    String str = paramString4;
    if (paramString4 == null) {
      str = "0";
    }
    paramString4 = paramString5;
    if (paramString5 == null) {
      paramString4 = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramAppRuntime.getAccount()).append('|').append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(str).append('|').append(paramString4).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3);
      localStringBuilder.append('|').append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      localStringBuilder = new StringBuilder(128);
      localStringBuilder.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(paramInt4).append('|').append('|').append('|').append('|');
      paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
      paramString1.putExtra("sendType", 2);
      paramString1.putExtra("tag", "CliOper");
      paramString1.putExtra("content", localStringBuilder.toString());
      paramAppRuntime.startServlet(paramString1);
    } while (!QLog.isColorLevel());
    QLog.d("StatisticCollector", 2, "tag=CliOper,content=" + localStringBuilder.toString());
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if ((paramAppRuntime == null) || (paramString1 == null) || (paramString3 == null) || (paramString4 == null)) {
      return;
    }
    String str = paramString5;
    if (paramString5 == null) {
      str = "";
    }
    paramString5 = paramString6;
    if (paramString6 == null) {
      paramString5 = "";
    }
    paramString6 = paramString7;
    if (paramString7 == null) {
      paramString6 = "";
    }
    paramString7 = paramString8;
    if (paramString8 == null) {
      paramString7 = "";
    }
    paramString8 = new StringBuilder(128);
    paramString8.append(paramString1).append('|').append(paramString2).append('|').append(paramString3).append('|').append(paramString4).append('|').append(paramInt1).append('|').append(paramInt2).append('|').append(paramInt3).append('|').append(str).append('|').append(paramString5).append('|').append(paramString6).append('|').append(paramString7).append('|');
    paramString1 = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramString1.putExtra("sendType", 2);
    paramString1.putExtra("tag", "CliOper");
    paramString1.putExtra("content", paramString8.toString());
    paramAppRuntime.startServlet(paramString1);
  }
  
  @Deprecated
  public void a(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "custom_set");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Aikx.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updateLocalCrashData crash control is off..");
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().startComponentInfo;
      if ((this.jdField_a_of_type_Aikx.jdField_a_of_type_Int == 2) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("QQBroadcastReceiver"))))
      {
        QLog.d("StatisticCollector", 1, "updateLocalCrashData controllevel is 2 but not QQBroadcastReceiver start QQ.");
        return;
      }
      localObject = jdField_a_of_type_AndroidContentContext.getSharedPreferences("crashcontrol", 0);
    } while (localObject == null);
    long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
    int i = ((SharedPreferences)localObject).getInt("crashcount", 0);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",mCurUin=").append(this.jdField_a_of_type_JavaLangString).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Aikx.b * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Aikx.c) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updateLocalCrashData shouldStopMsf=").append(this.jdField_a_of_type_Boolean).append("\n");
      ((SharedPreferences)localObject).edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("shouldStopMsf", this.jdField_a_of_type_Boolean).commit();
      return;
      i += 1;
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null) {
      b("onResume", paramContext.toString());
    }
  }
  
  public void b(String paramString)
  {
    boolean bool1 = true;
    if (!this.jdField_a_of_type_Aikx.jdField_a_of_type_Boolean) {
      QLog.d("StatisticCollector", 1, "updatePreloadCrashData crash control is off..");
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      localSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("CrashControl_" + paramString, 4);
    } while (localSharedPreferences == null);
    long l1 = localSharedPreferences.getLong("starttime", 0L);
    int i = localSharedPreferences.getInt("crashcount", 0);
    boolean bool2 = localSharedPreferences.getBoolean("allowpreload", true);
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData process=").append(paramString).append(",startTime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l1))).append(",currenttime=").append(jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(l2))).append(",crashCount=").append(i).append(",allowPreload=").append(bool2).append(",mCurUin=").append(this.jdField_a_of_type_JavaLangString).append("\n");
    if ((l1 <= 0L) || (l2 <= l1) || (i < 0) || (l2 - l1 > this.jdField_a_of_type_Aikx.b * 1000))
    {
      i = 1;
      l1 = l2;
    }
    for (;;)
    {
      if (i > this.jdField_a_of_type_Aikx.c) {
        bool1 = false;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("updatePreloadCrashData update allowPreload=").append(bool1).append("\n");
      localSharedPreferences.edit().putLong("starttime", l1).putInt("crashcount", i).putBoolean("allowpreload", bool1).putInt("controlwindow", this.jdField_a_of_type_Aikx.b).commit();
      return;
      i += 1;
    }
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 2);
    localNewIntent.putExtra("tag", "P_CliOper");
    localNewIntent.putExtra("content", paramString);
    paramAppRuntime.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "tag=P_CliOper,content=" + paramString);
    }
  }
  
  public void b(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    a(paramAppRuntime, paramString2, paramInt);
  }
  
  @Deprecated
  public void b(AppRuntime paramAppRuntime, String paramString, Map paramMap)
  {
    if ((paramAppRuntime == null) || (paramString == null) || (paramMap == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Object localObject = paramMap.keySet();
    paramString = new ArrayList(paramMap.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder.append(str).append("|").append(paramMap.get(str)).append("|");
      paramString.add(localStringBuilder.toString());
      localStringBuilder.delete(0, localStringBuilder.length());
    }
    paramMap = new NewIntent(paramAppRuntime.getApplication(), ReportServlet.class);
    paramMap.putExtra("sendType", 6);
    paramMap.putExtra("tag", "on_off");
    paramMap.putExtra("content", paramString);
    paramAppRuntime.startServlet(paramMap);
  }
  
  public void c(Context paramContext)
  {
    if (paramContext != null) {
      b("onPause", paramContext.toString());
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("rqd_catcher_pref", 4);
    if (((SharedPreferences)localObject).getBoolean("disable_rqd_catcher", false)) {
      QLog.d("StatisticCollector", 1, "Not initCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
    }
    for (;;)
    {
      return;
      CrashReport.setLogAble(((SharedPreferences)localObject).getBoolean("enable_rqd_debug_log", false), false);
      localObject = new CrashStrategyBean();
      ((CrashStrategyBean)localObject).setUploadSpotCrash(false);
      ((CrashStrategyBean)localObject).setMaxStackFrame(6);
      QLog.d("StatisticCollector", 1, "initCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
      if (BaseApplicationImpl.processName.endsWith(":qzone")) {
        ThreadManager.executeOnSubThread(new aiks(this));
      }
      Context localContext = jdField_a_of_type_AndroidContentContext;
      aikt localaikt = new aikt(this);
      boolean bool;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        bool = true;
        CrashReport.initCrashReport(localContext, localaikt, null, bool, (CrashStrategyBean)localObject, 30000L);
        localObject = jdField_a_of_type_AndroidContentContext.getDir("tombs", 0).getAbsolutePath();
      }
      try
      {
        QLog.d("StatisticCollector", 1, "initNativeCrashReport process=" + BaseApplicationImpl.processName + ", pid=" + Process.myPid());
        CrashReport.initNativeCrashReport(jdField_a_of_type_AndroidContentContext, (String)localObject, false, null, null, 0L);
        CrashReport.filterSysLog(true, true);
        QLog.d("StatisticCollector", 1, "CrashReport init finished.");
        ANRReport.stopANRMonitor();
        CrashReport.setUserId(jdField_a_of_type_AndroidContentContext, paramString);
        CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "TbsSdkVersion", String.valueOf(WebView.getTbsSDKVersion(jdField_a_of_type_AndroidContentContext)));
        CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "X5CoreVersion", String.valueOf(QbSdk.getTbsVersion(jdField_a_of_type_AndroidContentContext)));
        CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "PatchInstallStatus", String.valueOf(DexPatchInstaller.jdField_a_of_type_Int));
        if (!TextUtils.isEmpty(DexPatchInstaller.jdField_a_of_type_JavaLangString)) {
          CrashReport.putUserData(jdField_a_of_type_AndroidContentContext, "PatchNameInstalled", DexPatchInstaller.jdField_a_of_type_JavaLangString);
        }
        this.jdField_b_of_type_JavaLangStringBuilder.append("Current process id=").append(Process.myPid()).append(", Name=").append(BaseApplicationImpl.processName).append("\n");
        if (!BaseApplicationImpl.processName.equals("com.tencent.mobileqq")) {
          continue;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new aiku(this, paramString), 3000L);
        return;
        bool = false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          QLog.e("StatisticCollector", 1, "initNativeCrashReport error", localUnsatisfiedLinkError);
        }
      }
    }
  }
  
  public void d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.toString();
      this.jdField_a_of_type_JavaUtilStack.remove(paramContext);
      b("onDestroy", paramContext);
    }
  }
  
  public void d(String paramString)
  {
    Map localMap = a();
    if ((paramString == null) || (localMap == null)) {
      return;
    }
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((String)localMap.get(str) == null) {
        localMap.put(str, "");
      }
    }
    UserAction.setUserID(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("StatisticCollector", 2, "report End_Info:" + localMap.toString());
    }
    paramString = new RdmReq();
    paramString.eventName = "End_Info";
    paramString.elapse = -1L;
    paramString.size = 0L;
    paramString.isSucceed = true;
    paramString.isRealTime = true;
    paramString.isMerge = false;
    paramString.params = localMap;
    try
    {
      paramString = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramString);
      paramString.setAppId(AppSetting.jdField_a_of_type_Int);
      paramString.setTimeout(30000L);
      MsfServiceSdk.get().sendMsg(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */