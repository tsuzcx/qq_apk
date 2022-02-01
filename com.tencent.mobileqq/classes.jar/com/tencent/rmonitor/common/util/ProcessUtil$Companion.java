package com.tencent.rmonitor.common.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/ProcessUtil$Companion;", "", "()V", "TAG", "", "currProcessName", "getCurrentProcessName", "context", "Landroid/content/Context;", "getCurrentProcessNameByActivityManager", "getCurrentProcessNameByActivityThread", "getCurrentProcessNameByApplication", "isMainProcess", "", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ProcessUtil$Companion
{
  @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
  private final String a()
  {
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Class.forName(\"android.a…rayOfNulls<Class<*>?>(0))");
      ((Method)localObject1).setAccessible(true);
      Object localObject2 = ((Method)localObject1).invoke(null, new Object[0]);
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = null;
      }
      localObject1 = (String)localObject1;
      if (localObject1 != null) {
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("RMonitor_common_ProcessUtil", localThrowable);
    }
    return "";
  }
  
  private final String b()
  {
    if (AndroidVersion.a.h())
    {
      String str = Application.getProcessName();
      Intrinsics.checkExpressionValueIsNotNull(str, "Application.getProcessName()");
      return str;
    }
    return "";
  }
  
  private final String c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        int i = Process.myPid();
        if (paramContext == null) {
          break label114;
        }
        paramContext = paramContext.getSystemService("activity");
        Object localObject = paramContext;
        if (!(paramContext instanceof ActivityManager)) {
          localObject = null;
        }
        paramContext = (ActivityManager)localObject;
        if (paramContext != null)
        {
          paramContext = paramContext.getRunningAppProcesses();
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            if (paramContext.hasNext())
            {
              localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
              if ((localObject == null) || (((ActivityManager.RunningAppProcessInfo)localObject).pid != i)) {
                continue;
              }
              paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
              Intrinsics.checkExpressionValueIsNotNull(paramContext, "appProcess.processName");
              return paramContext;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        Logger.b.a("RMonitor_common_ProcessUtil", (Throwable)paramContext);
      }
      return "";
      label114:
      paramContext = null;
    }
  }
  
  @JvmStatic
  @NotNull
  public final String a(@Nullable Context paramContext)
  {
    if (!TextUtils.isEmpty((CharSequence)ProcessUtil.a())) {
      return ProcessUtil.a();
    }
    Companion localCompanion = (Companion)this;
    ProcessUtil.a(localCompanion.b());
    if (!TextUtils.isEmpty((CharSequence)ProcessUtil.a())) {
      return ProcessUtil.a();
    }
    ProcessUtil.a(localCompanion.a());
    if (!TextUtils.isEmpty((CharSequence)ProcessUtil.a())) {
      return ProcessUtil.a();
    }
    ProcessUtil.a(localCompanion.c(paramContext));
    return ProcessUtil.a();
  }
  
  @JvmStatic
  public final boolean b(@Nullable Context paramContext)
  {
    return (paramContext != null) && (Intrinsics.areEqual(paramContext.getPackageName(), ((Companion)this).a(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.ProcessUtil.Companion
 * JD-Core Version:    0.7.0.1
 */