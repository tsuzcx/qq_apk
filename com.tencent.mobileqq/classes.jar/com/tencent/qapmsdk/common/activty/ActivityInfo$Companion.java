package com.tencent.qapmsdk.common.activty;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/activty/ActivityInfo$Companion;", "", "()V", "TAG", "", "getActiveComponent", "Landroid/content/ComponentName;", "ctx", "Landroid/content/Context;", "getCurrentActivity", "app", "Landroid/app/Application;", "getCurrentActivityName", "common_release"}, k=1, mv={1, 1, 15})
public final class ActivityInfo$Companion
{
  private final ComponentName getActiveComponent(Context paramContext)
  {
    try
    {
      Object localObject2 = paramContext.getSystemService("activity");
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ActivityManager)) {
        localObject1 = null;
      }
      localObject1 = (ActivityManager)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            if (((ActivityManager.RunningAppProcessInfo)localObject2).importance == 100)
            {
              String[] arrayOfString = ((ActivityManager.RunningAppProcessInfo)localObject2).pkgList;
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                if ((Intrinsics.areEqual(arrayOfString[i], paramContext.getPackageName())) && (((ActivityManager.RunningAppProcessInfo)localObject2).importanceReasonComponent != null)) {
                  return ((ActivityManager.RunningAppProcessInfo)localObject2).importanceReasonComponent;
                }
                i += 1;
              }
            }
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      Logger.INSTANCE.exception("QAPM_common_ActivityInfo", (Throwable)paramContext);
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public final Object getCurrentActivity(@Nullable Application paramApplication)
  {
    WeakReference localWeakReference = LifecycleCallback.INSTANCE.getWeakActivity();
    Object localObject2 = null;
    if (localWeakReference != null) {
      localObject1 = (Activity)localWeakReference.get();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      return localWeakReference.get();
    }
    Object localObject1 = localObject2;
    if (paramApplication != null)
    {
      localObject1 = (Companion)this;
      paramApplication = paramApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(paramApplication, "app.applicationContext");
      localObject1 = ((Companion)localObject1).getActiveComponent(paramApplication);
    }
    return localObject1;
  }
  
  @JvmStatic
  @NotNull
  public final String getCurrentActivityName()
  {
    if (TextUtils.isEmpty((CharSequence)LifecycleCallback.INSTANCE.getActivityName())) {
      return "";
    }
    return LifecycleCallback.INSTANCE.getActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.activty.ActivityInfo.Companion
 * JD-Core Version:    0.7.0.1
 */