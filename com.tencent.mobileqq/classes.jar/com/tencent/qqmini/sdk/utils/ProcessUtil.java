package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RecentTaskInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import bglv;
import bgud;
import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ProcessUtil
{
  public static void exitProcess(Activity paramActivity)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null);
    finishAndRemoveAllTasks(paramActivity);
    Process.killProcess(Process.myPid());
  }
  
  public static void exitProcess(bglv parambglv)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null);
    finishAndRemoveAllTasks(parambglv.a());
    Process.killProcess(Process.myPid());
  }
  
  private static boolean finishAndRemoveAllTasks(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    try
    {
      Object localObject = (ActivityManager)paramActivity.getSystemService("activity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ActivityManager)localObject).getAppTasks();
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.AppTask localAppTask = (ActivityManager.AppTask)((Iterator)localObject).next();
        if ((localAppTask != null) && (localAppTask.getTaskInfo() != null) && (localAppTask.getTaskInfo().baseIntent != null) && (localAppTask.getTaskInfo().baseIntent.getComponent() != null))
        {
          QMLog.e("miniapp", "will finish and remove task: id=" + localAppTask.getTaskInfo().id);
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
    }
    return false;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    int i = Process.myPid();
    Object localObject = "";
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    paramContext = (Context)localObject;
    if (localIterator.hasNext())
    {
      localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).pid != i) {
        break label64;
      }
      paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
    }
    label64:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
  
  private static bgud getCurrentProcessorInfo(Context paramContext)
  {
    paramContext = getCurrentProcessName(paramContext);
    if (paramContext != null) {
      return (bgud)AppBrandLaunchManager.subProcessorInfoMap.get(paramContext);
    }
    return null;
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    return paramContext.getPackageName().equals(getCurrentProcessName(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */