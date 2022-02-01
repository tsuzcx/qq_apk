package com.tencent.qapmsdk.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ProcessUtil$Companion;", "", "()V", "TAG", "", "currProcessName", "getCurrentProcessName", "context", "Landroid/content/Context;", "isMainProcess", "", "common_release"}, k=1, mv={1, 1, 15})
public final class ProcessUtil$Companion
{
  @JvmStatic
  @NotNull
  public final String getCurrentProcessName(@Nullable Context paramContext)
  {
    if (((CharSequence)ProcessUtil.access$getCurrProcessName$cp()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return ProcessUtil.access$getCurrProcessName$cp();
    }
    int i = Process.myPid();
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = paramContext.getSystemService("activity");
        Object localObject = paramContext;
        if (!(paramContext instanceof ActivityManager)) {
          localObject = null;
        }
        paramContext = (ActivityManager)localObject;
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.iterator();
        if (!paramContext.hasNext()) {
          continue;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localObject == null) || (((ActivityManager.RunningAppProcessInfo)localObject).pid != i)) {
          continue;
        }
        paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
        Intrinsics.checkExpressionValueIsNotNull(paramContext, "appProcess.processName");
        ProcessUtil.access$setCurrProcessName$cp(paramContext);
      }
      catch (Exception paramContext)
      {
        continue;
      }
      Logger.INSTANCE.exception("QAPM_common_ProcessUtil", (Throwable)paramContext);
      return ProcessUtil.access$getCurrProcessName$cp();
      paramContext = null;
    }
  }
  
  @JvmStatic
  public final boolean isMainProcess(@Nullable Context paramContext)
  {
    return (paramContext != null) && (Intrinsics.areEqual(paramContext.getPackageName(), ((Companion)this).getCurrentProcessName(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ProcessUtil.Companion
 * JD-Core Version:    0.7.0.1
 */