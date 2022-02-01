package com.tencent.rmonitor.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.util.SparseArray;
import com.tencent.rmonitor.common.logger.Logger;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/util/AppInfo$Companion;", "", "()V", "PSS_INFO_VALIDATE_IN_MILLIS", "", "TAG", "", "pid", "", "getPid", "()I", "pid$delegate", "Lkotlin/Lazy;", "processMap", "Landroid/util/SparseArray;", "pssInfo", "Lcom/tencent/rmonitor/common/util/AppInfo$PssInfo;", "getPssMemory", "hasPermissions", "", "ctx", "Landroid/content/Context;", "permissionList", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isApkInDebug", "context", "obtainProcessName", "obtainProcessNameByCmdline", "obtainProcessNameBySysService", "obtainProcessPackageName", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AppInfo$Companion
{
  private final String a(int paramInt)
  {
    Object localObject1 = FileUtil.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("/proc/");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("/cmdline");
    localObject1 = ((FileUtil.Companion)localObject1).b(((StringBuilder)localObject2).toString());
    if (((CharSequence)StringUtil.a((String)localObject1)).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    localObject1 = StringUtil.a((String)localObject1).subSequence(0, StringsKt.getLastIndex((CharSequence)localObject1));
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
    AppInfo.b().put(paramInt, localObject1.toString());
    return localObject1.toString();
  }
  
  private final String a(int paramInt, Context paramContext)
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
          AppInfo.b().put(paramInt, paramContext);
          return paramContext;
        }
      }
    }
    return str;
  }
  
  public final int a()
  {
    Lazy localLazy = AppInfo.a();
    Object localObject = AppInfo.a;
    localObject = a[0];
    return ((Number)localLazy.getValue()).intValue();
  }
  
  @JvmStatic
  @NotNull
  public final String a(@Nullable Context paramContext)
  {
    Object localObject = AppInfo.b();
    Companion localCompanion = (Companion)this;
    localObject = (String)((SparseArray)localObject).get(localCompanion.a());
    if (localObject == null) {
      localObject = localCompanion.a(localCompanion.a());
    }
    if (localObject == null) {
      localObject = localCompanion.a(localCompanion.a(), paramContext);
    }
    if (localObject != null) {
      return localObject;
    }
    return "";
  }
  
  @JvmStatic
  public final boolean a(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
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
          break label136;
        }
        String str = paramArrayOfString[i];
        try
        {
          int m = paramContext.checkPermission(str, (String)localObject);
          if (m != 0) {
            break label118;
          }
        }
        catch (Throwable localThrowable)
        {
          Logger.b.a("RMonitor_common_AppInfo", localThrowable);
          break label118;
        }
        paramContext = Unit.INSTANCE;
        return bool;
      }
      finally {}
      return false;
      label118:
      int j = 0;
      if (j != 0)
      {
        i += 1;
        continue;
        label136:
        bool = true;
      }
    }
  }
  
  @JvmStatic
  public final long b()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (l - AppInfo.d().b() < AppInfo.c()) {
        return AppInfo.d().a() * 1024;
      }
      AppInfo.d().b(l);
      AppInfo.d().a(Debug.getPss());
      l = AppInfo.d().a();
      return l * 1024;
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_common_AppInfo", (Throwable)localException);
    }
    return 0L;
  }
  
  @JvmStatic
  @NotNull
  public final String b(@Nullable Context paramContext)
  {
    return (String)StringsKt.split$default((CharSequence)StringsKt.split$default((CharSequence)((Companion)this).a(paramContext), new String[] { "&" }, false, 0, 6, null).get(0), new String[] { ":" }, false, 0, 6, null).get(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.AppInfo.Companion
 * JD-Core Version:    0.7.0.1
 */