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
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import java.util.Iterator;
import java.util.List;

@MiniKeep
public class ProcessUtil
{
  public static String processName = "";
  
  public static void exitProcess(Activity paramActivity)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null, null);
    finishAndRemoveAllTasks(paramActivity);
    Process.killProcess(Process.myPid());
  }
  
  public static void exitProcess(IMiniAppContext paramIMiniAppContext)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(null, null);
    finishAndRemoveAllTasks(paramIMiniAppContext.getAttachedActivity());
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("will finish and remove task: id=");
          localStringBuilder.append(localAppTask.getTaskInfo().id);
          QMLog.e("miniapp", localStringBuilder.toString());
          if ((localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName())) || (localAppTask.getTaskInfo().baseIntent.getComponent().getClassName().equals(paramActivity.getClass().getName()))) {
            localAppTask.finishAndRemoveTask();
          }
        }
      }
      return true;
    }
    catch (Throwable paramActivity)
    {
      label194:
      break label194;
    }
    QMLog.e("miniapp", "finishAndRemoveAllTasks exception.");
    return false;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    if (TextUtils.isEmpty(processName))
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i) {
          processName = localRunningAppProcessInfo.processName;
        }
      }
    }
    return processName;
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    return paramContext.getPackageName().equals(getCurrentProcessName(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.ProcessUtil
 * JD-Core Version:    0.7.0.1
 */