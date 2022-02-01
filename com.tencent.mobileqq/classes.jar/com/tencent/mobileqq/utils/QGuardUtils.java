package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitMgr;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticHitRateCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QGuardUtils
{
  private static String[] a = { "1253336001", "328659992", "262330293", "563224709" };
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    int i;
    if (paramBoolean) {
      i = ((Time)localObject).minute - 1;
    } else {
      i = ((Time)localObject).minute;
    }
    localStringBuilder.append(i);
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      long l2;
      try
      {
        if (MobileQQ.sProcessId != 1) {
          return;
        }
        long l1 = SystemClock.uptimeMillis();
        if ((!paramBoolean) && (l1 - JobReporter.sThreadJobReportLastReportTs.get() < 600000L)) {
          return;
        }
        AppRuntime localAppRuntime = MobileQQ.getMobileQQ().peekAppRuntime();
        l2 = JobReporter.sThreadJobReportTotalCount.getAndSet(0L);
        if (l2 != 0L)
        {
          if (localAppRuntime == null) {
            return;
          }
          if (!a()) {
            return;
          }
          String str1 = Long.toString(JobReporter.sThreadJobReportCountLevelOne.getAndSet(0L));
          String str2 = Long.toString(JobReporter.sThreadJobReportCountLevelTwo.getAndSet(0L));
          String str3 = Long.toString(JobReporter.sThreadJobReportCountLevelThree.getAndSet(0L));
          if (l2 <= 2147483647L) {
            break label205;
          }
          i = 2147483647;
          JobReporter.sThreadJobReportLastReportTs.set(l1);
          HashMap localHashMap = new HashMap();
          localHashMap.put("countLevel_1", str1);
          localHashMap.put("countLevel_2", str2);
          localHashMap.put("countLevel_3", str3);
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(localAppRuntime.getAccount(), "maxThreadManagerJobWait", true, i, 1L, localHashMap, "", false);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GuardManager", 1, "reportThreadJobWaitTime", localThrowable);
      }
      return;
      label205:
      int i = (int)l2;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    Object localObject = GuardManager.sInstance;
    if (localObject == null) {
      return;
    }
    PreloadProcHitMgr.b(paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    Intent localIntent = new Intent("com.tencent.process.exit");
    localIntent.putExtra("exit_type", 101);
    localIntent.putExtra("qq_mode_foreground", paramBoolean);
    localIntent.putStringArrayListExtra("procNameList", localArrayList);
    localIntent.putExtra("verify", a(localArrayList, false));
    ((GuardManager)localObject).getContext().sendBroadcast(localIntent);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GmVersion= 20140619, app versioncode = ");
      ((StringBuilder)localObject).append(ApkUtils.a(MobileQQ.getContext()));
      ((StringBuilder)localObject).append(", toExitTargetProcess=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isForeground=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GuardManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(boolean paramBoolean, String... paramVarArgs)
  {
    GuardManager localGuardManager = GuardManager.sInstance;
    if (localGuardManager == null) {
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject = (ActivityManager)localGuardManager.getContext().getSystemService("activity");
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = null;
    try
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    }
    catch (Throwable localThrowable)
    {
      localObject = localRunningAppProcessInfo;
      if (QLog.isColorLevel())
      {
        QLog.e("GuardManager", 2, "exitProcess: Failed.  exception: ", localThrowable);
        localObject = localRunningAppProcessInfo;
      }
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        String str1 = localRunningAppProcessInfo.processName;
        int i = localRunningAppProcessInfo.pid;
        if ((str1.startsWith("com.tencent.mobileqq")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF"))) {
          if (paramVarArgs != null)
          {
            int k = paramVarArgs.length;
            int j = 0;
            i = 0;
            while (j < k)
            {
              String str2 = paramVarArgs[j];
              if ((!TextUtils.isEmpty(str2)) && (str1.endsWith(str2))) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                localArrayList3.add(str1);
                break;
              }
              j += 1;
            }
            if (i != 0) {}
          }
          else if ((localRunningAppProcessInfo.importance != 100) && ((localRunningAppProcessInfo.importance != 200) || ((localRunningAppProcessInfo.importance == 200) && (localRunningAppProcessInfo.importanceReasonCode != 0))))
          {
            localArrayList1.add(str1);
            PreloadProcHitMgr.b(str1);
            if (str1.endsWith(":qzone")) {
              StatisticHitRateCollector.a().d(StatisticHitRateCollector.b());
            }
          }
          else
          {
            localArrayList2.add(str1);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("GmVersion= 20140619, app versioncode = ");
      paramVarArgs.append(ApkUtils.a(MobileQQ.getContext()));
      paramVarArgs.append(", toExitProcess=");
      paramVarArgs.append(localArrayList1);
      paramVarArgs.append(", forgroundProcess=");
      paramVarArgs.append(localArrayList2);
      paramVarArgs.append(", exceptions:");
      paramVarArgs.append(localArrayList3);
      QLog.d("GuardManager", 2, paramVarArgs.toString());
    }
    if (localArrayList1.size() > 0)
    {
      paramVarArgs = new Intent("com.tencent.process.exit");
      paramVarArgs.putExtra("exit_type", 101);
      paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
      paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
      paramVarArgs.putExtra("verify", a(localArrayList1, false));
      localGuardManager.getContext().sendBroadcast(paramVarArgs);
    }
  }
  
  public static void a(String... paramVarArgs) {}
  
  public static boolean a()
  {
    if (!ThreadSetting.isPublicVersion) {
      return true;
    }
    if (ThreadSetting.isGrayVersion) {
      return true;
    }
    return JobReporter.ramdomReport(10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QGuardUtils
 * JD-Core Version:    0.7.0.1
 */