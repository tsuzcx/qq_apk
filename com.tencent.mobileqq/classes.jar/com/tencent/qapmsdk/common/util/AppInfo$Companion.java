package com.tencent.qapmsdk.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Debug.MemoryInfo;
import android.util.SparseArray;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AppInfo$Companion;", "", "()V", "TAG", "", "pid", "", "getPid", "()I", "pid$delegate", "Lkotlin/Lazy;", "processMap", "Landroid/util/SparseArray;", "getAppVersion", "context", "Landroid/content/Context;", "getPssMemory", "", "app", "Landroid/app/Application;", "pId", "hasPermissions", "", "ctx", "permissionList", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isApkInDebug", "obtainProcessName", "obtainProcessNameByCmdline", "obtainProcessNameBySysService", "obtainProcessPackageName", "common_release"}, k=1, mv={1, 1, 15})
public final class AppInfo$Companion
{
  private final String obtainProcessNameByCmdline(int paramInt)
  {
    Object localObject1 = FileUtil.Companion;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("/proc/");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("/cmdline");
    localObject1 = ((FileUtil.Companion)localObject1).readOutputFromFile(((StringBuilder)localObject2).toString());
    if (((CharSequence)StringUtil.Companion.replaceBlank((String)localObject1)).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    localObject1 = StringUtil.Companion.replaceBlank((String)localObject1).subSequence(0, StringsKt.getLastIndex((CharSequence)localObject1));
    localObject2 = (Appendable)new StringBuilder();
    int k = ((CharSequence)localObject1).length();
    int i = 0;
    while (i < k)
    {
      char c = ((CharSequence)localObject1).charAt(i);
      int j;
      if (c > 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        ((Appendable)localObject2).append(c);
      }
      i += 1;
    }
    localObject1 = (CharSequence)localObject2;
    AppInfo.access$getProcessMap$cp().put(paramInt, localObject1.toString());
    return localObject1.toString();
  }
  
  private final String obtainProcessNameBySysService(int paramInt, Context paramContext)
  {
    String str = null;
    Object localObject1 = null;
    if (paramContext != null)
    {
      str = (String)null;
      Object localObject2 = paramContext.getSystemService("activity");
      paramContext = (Context)localObject2;
      if (!(localObject2 instanceof ActivityManager)) {
        paramContext = null;
      }
      paramContext = (ActivityManager)paramContext;
      if (paramContext != null) {
        paramContext = paramContext.getRunningAppProcesses();
      } else {
        paramContext = null;
      }
      if (paramContext != null)
      {
        localObject2 = ((Iterable)paramContext).iterator();
        int i;
        do
        {
          paramContext = localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramContext = ((Iterator)localObject2).next();
          if (((ActivityManager.RunningAppProcessInfo)paramContext).pid == paramInt) {
            i = 1;
          } else {
            i = 0;
          }
        } while (i == 0);
        paramContext = (ActivityManager.RunningAppProcessInfo)paramContext;
        if (paramContext != null)
        {
          paramContext = paramContext.processName;
          AppInfo.access$getProcessMap$cp().put(paramInt, paramContext);
          return paramContext;
        }
      }
    }
    return str;
  }
  
  @NotNull
  public final String getAppVersion(@Nullable Context paramContext)
  {
    if (paramContext != null)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      }
      catch (Exception paramContext)
      {
        Logger.INSTANCE.exception("QAPM_common_AppInfo", (Throwable)paramContext);
        paramContext = "";
      }
      if (paramContext != null) {
        return paramContext;
      }
    }
    return "";
  }
  
  public final int getPid()
  {
    Lazy localLazy = AppInfo.access$getPid$cp();
    Object localObject = AppInfo.Companion;
    localObject = $$delegatedProperties[0];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  @JvmStatic
  public final long getPssMemory(@Nullable Application paramApplication, int paramInt)
  {
    if (paramApplication != null) {}
    for (;;)
    {
      try
      {
        paramApplication = paramApplication.getApplicationContext();
        if (paramApplication == null) {
          break label117;
        }
        paramApplication = paramApplication.getSystemService("activity");
        Application localApplication = paramApplication;
        if (!(paramApplication instanceof ActivityManager)) {
          localApplication = null;
        }
        paramApplication = (ActivityManager)localApplication;
        if (paramApplication == null) {
          continue;
        }
        paramApplication = paramApplication.getProcessMemoryInfo(new int[] { paramInt });
        if (paramApplication == null) {
          continue;
        }
        if (paramApplication.length != 0) {
          break label122;
        }
        paramInt = 1;
        if ((paramInt ^ 0x1) == 0) {
          continue;
        }
        paramApplication = paramApplication[0];
        Intrinsics.checkExpressionValueIsNotNull(paramApplication, "myMemoryInfo[0]");
        paramInt = paramApplication.getTotalPss();
        return paramInt * 1024;
      }
      catch (Exception paramApplication)
      {
        continue;
      }
      Logger.INSTANCE.exception("QAPM_common_AppInfo", (Throwable)paramApplication);
      return 0L;
      label117:
      paramApplication = null;
      continue;
      label122:
      paramInt = 0;
    }
  }
  
  @JvmStatic
  public final boolean hasPermissions(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "permissionList");
    boolean bool = false;
    Object localObject;
    if (paramContext != null)
    {
      localObject = paramContext.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appContext");
      paramContext = ((Context)localObject).getPackageManager();
      if (paramContext != null) {
        localObject = ((Context)localObject).getPackageName();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        int k = paramArrayOfString.length;
        i = 0;
        j = 1;
        if (i >= k) {
          break label137;
        }
        String str = paramArrayOfString[i];
        try
        {
          int m = paramContext.checkPermission(str, (String)localObject);
          if (m != 0) {
            break label119;
          }
        }
        catch (Throwable localThrowable)
        {
          Logger.INSTANCE.exception("QAPM_common_AppInfo", localThrowable);
          break label119;
        }
        paramContext = Unit.INSTANCE;
        return bool;
      }
      finally {}
      return false;
      label119:
      int j = 0;
      if (j != 0)
      {
        i += 1;
        continue;
        label137:
        bool = true;
      }
    }
  }
  
  @JvmStatic
  public final boolean isApkInDebug(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      int i = paramContext.getApplicationInfo().flags;
      if ((i & 0x2) != 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      Logger.INSTANCE.exception("QAPM_common_AppInfo", paramContext);
    }
    return false;
  }
  
  @JvmStatic
  @NotNull
  public final String obtainProcessName(@Nullable Context paramContext)
  {
    Object localObject = AppInfo.access$getProcessMap$cp();
    Companion localCompanion = (Companion)this;
    localObject = (String)((SparseArray)localObject).get(localCompanion.getPid());
    if (localObject == null) {
      localObject = localCompanion.obtainProcessNameByCmdline(localCompanion.getPid());
    }
    if (localObject == null) {
      localObject = localCompanion.obtainProcessNameBySysService(localCompanion.getPid(), paramContext);
    }
    if (localObject != null) {
      return localObject;
    }
    return "";
  }
  
  @JvmStatic
  @NotNull
  public final String obtainProcessPackageName(@Nullable Context paramContext)
  {
    return (String)StringsKt.split$default((CharSequence)StringsKt.split$default((CharSequence)((Companion)this).obtainProcessName(paramContext), new String[] { "&" }, false, 0, 6, null).get(0), new String[] { ":" }, false, 0, 6, null).get(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AppInfo.Companion
 * JD-Core Version:    0.7.0.1
 */