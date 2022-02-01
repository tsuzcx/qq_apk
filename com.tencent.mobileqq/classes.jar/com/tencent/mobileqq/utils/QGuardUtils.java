package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.ThreadSetting;
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
  private static String[] a = { "1253336001", "328659992", "262330293" };
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    int i;
    if (paramBoolean)
    {
      i = localTime.minute - 1;
      localStringBuilder.append(i);
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      i = localTime.minute;
      break;
    }
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
          break;
        }
        AppRuntime localAppRuntime = MobileQQ.getMobileQQ().peekAppRuntime();
        l2 = JobReporter.sThreadJobReportTotalCount.getAndSet(0L);
        if ((l2 == 0L) || (localAppRuntime == null) || (!a())) {
          break;
        }
        String str1 = Long.toString(JobReporter.sThreadJobReportCountLevelOne.getAndSet(0L));
        String str2 = Long.toString(JobReporter.sThreadJobReportCountLevelTwo.getAndSet(0L));
        String str3 = Long.toString(JobReporter.sThreadJobReportCountLevelThree.getAndSet(0L));
        if (l2 > 2147483647L)
        {
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
        return;
      }
      int i = (int)l2;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager == null) {}
    do
    {
      return;
      PreloadProcHitMgr.b(paramString);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      Intent localIntent = new Intent("com.tencent.process.exit");
      localIntent.putExtra("exit_type", 101);
      localIntent.putExtra("qq_mode_foreground", paramBoolean);
      localIntent.putStringArrayListExtra("procNameList", localArrayList);
      localIntent.putExtra("verify", a(localArrayList, false));
      localGuardManager.a().sendBroadcast(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(MobileQQ.getContext()) + ", toExitTargetProcess=" + paramString + " isForeground=" + paramBoolean);
  }
  
  public static void a(boolean paramBoolean, String... paramVarArgs)
  {
    GuardManager localGuardManager = GuardManager.a;
    if (localGuardManager == null) {}
    ArrayList localArrayList1;
    label308:
    label315:
    label326:
    do
    {
      return;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Object localObject1 = (ActivityManager)localGuardManager.a().getSystemService("activity");
      try
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label326;
            }
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            str1 = localRunningAppProcessInfo.processName;
            i = localRunningAppProcessInfo.pid;
            if ((str1.startsWith("com.tencent.mobileqq")) && (str1.indexOf(':') != -1) && (!str1.endsWith(":MSF"))) {
              if (paramVarArgs != null)
              {
                int k = paramVarArgs.length;
                j = 0;
                i = 0;
                if (j < k)
                {
                  String str2 = paramVarArgs[j];
                  if ((TextUtils.isEmpty(str2)) || (!str1.endsWith(str2))) {
                    break;
                  }
                  i = 1;
                  if (i == 0) {
                    break label308;
                  }
                  localArrayList3.add(str1);
                }
                if (i != 0) {}
              }
              else
              {
                if ((localRunningAppProcessInfo.importance == 100) || ((localRunningAppProcessInfo.importance == 200) && ((localRunningAppProcessInfo.importance != 200) || (localRunningAppProcessInfo.importanceReasonCode == 0)))) {
                  break label315;
                }
                localArrayList1.add(str1);
                PreloadProcHitMgr.b(str1);
                if (str1.endsWith(":qzone")) {
                  StatisticHitRateCollector.a().d(StatisticHitRateCollector.a());
                }
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          String str1;
          int j;
          if (QLog.isColorLevel()) {
            QLog.e("GuardManager", 2, "exitProcess: Failed.  exception: ", localThrowable);
          }
          Object localObject2 = null;
          continue;
          int i = 0;
          continue;
          j += 1;
          continue;
          localArrayList2.add(str1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("GuardManager", 2, "GmVersion= 20140619, app versioncode = " + ApkUtils.a(MobileQQ.getContext()) + ", toExitProcess=" + localArrayList1 + ", forgroundProcess=" + localArrayList2 + ", exceptions:" + localArrayList3);
        }
      }
    } while (localArrayList1.size() <= 0);
    paramVarArgs = new Intent("com.tencent.process.exit");
    paramVarArgs.putExtra("exit_type", 101);
    paramVarArgs.putExtra("qq_mode_foreground", paramBoolean);
    paramVarArgs.putStringArrayListExtra("procNameList", localArrayList1);
    paramVarArgs.putExtra("verify", a(localArrayList1, false));
    localGuardManager.a().sendBroadcast(paramVarArgs);
  }
  
  public static void a(String... paramVarArgs) {}
  
  public static boolean a()
  {
    if (!ThreadSetting.isPublicVersion) {}
    while (ThreadSetting.isGrayVersion) {
      return true;
    }
    return JobReporter.ramdomReport(10000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QGuardUtils
 * JD-Core Version:    0.7.0.1
 */