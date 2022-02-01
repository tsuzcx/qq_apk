package com.tencent.mobileqq.qqexpand.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/ProcessUtils;", "", "()V", "PLUGINS_PROCESS_NAME", "", "isProcessExits", "", "pid", "", "processName", "processId", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ProcessUtils
{
  public static final ProcessUtils a = new ProcessUtils();
  
  @JvmStatic
  public static final int a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int j = 0;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return 0;
    }
    localObject = MobileQQ.getContext().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        localObject = CollectionsKt.emptyList();
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (Intrinsics.areEqual(paramString, ((ActivityManager.RunningAppProcessInfo)localObject).processName))
        {
          paramString = (String)localObject;
          break label118;
        }
      }
      paramString = null;
      label118:
      paramString = (ActivityManager.RunningAppProcessInfo)paramString;
      i = j;
      if (paramString != null) {
        i = paramString.pid;
      }
      return i;
    }
    paramString = new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    for (;;)
    {
      throw paramString;
    }
  }
  
  @JvmStatic
  public static final boolean a(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    Object localObject = MobileQQ.getContext().getSystemService("activity");
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject != null)
      {
        if (((List)localObject).size() <= 0) {
          return false;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).pid) {
            return true;
          }
        }
      }
      return false;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  @JvmStatic
  public static final boolean a(@Nullable String paramString)
  {
    return a(paramString) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ProcessUtils
 * JD-Core Version:    0.7.0.1
 */