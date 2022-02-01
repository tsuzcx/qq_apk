package com.tencent.qapmsdk.common.activty;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/activty/LifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "activityName", "", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "bufferCount", "", "callbackList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/qapmsdk/common/activty/IForeBackInterface;", "foregroundCount", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getWeakActivity", "()Ljava/lang/ref/WeakReference;", "setWeakActivity", "(Ljava/lang/ref/WeakReference;)V", "onActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "register", "foreBack", "unRegister", "common_release"}, k=1, mv={1, 1, 15})
public final class LifecycleCallback
  implements Application.ActivityLifecycleCallbacks
{
  public static final LifecycleCallback INSTANCE = new LifecycleCallback();
  @NotNull
  private static String activityName = "";
  private static int bufferCount;
  private static final ConcurrentLinkedQueue<IForeBackInterface> callbackList = new ConcurrentLinkedQueue();
  private static int foregroundCount;
  @Nullable
  private static WeakReference<Activity> weakActivity;
  
  @NotNull
  public final String getActivityName()
  {
    return activityName;
  }
  
  @Nullable
  public final WeakReference<Activity> getWeakActivity()
  {
    return weakActivity;
  }
  
  public void onActivityCreated(@NotNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    paramBundle = callbackList.iterator();
    while (paramBundle.hasNext()) {
      ((IForeBackInterface)paramBundle.next()).onCreate(paramActivity);
    }
  }
  
  public void onActivityDestroyed(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = callbackList.iterator();
    while (localIterator.hasNext()) {
      ((IForeBackInterface)localIterator.next()).onDestroy(paramActivity);
    }
  }
  
  public void onActivityPaused(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void onActivityResumed(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = callbackList.iterator();
    while (localIterator.hasNext()) {
      ((IForeBackInterface)localIterator.next()).onResume(paramActivity);
    }
    weakActivity = new WeakReference(paramActivity);
    paramActivity = weakActivity;
    if (paramActivity != null)
    {
      paramActivity = (Activity)paramActivity.get();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getClass();
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getSimpleName();
          if (paramActivity == null) {}
        }
      }
    }
    for (;;)
    {
      activityName = paramActivity;
      return;
      paramActivity = "";
    }
  }
  
  public void onActivitySaveInstanceState(@NotNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void onActivityStarted(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (foregroundCount <= 0)
    {
      Iterator localIterator = callbackList.iterator();
      while (localIterator.hasNext()) {
        ((IForeBackInterface)localIterator.next()).onForeground(paramActivity);
      }
    }
    if (bufferCount < 0)
    {
      bufferCount += 1;
      return;
    }
    foregroundCount += 1;
  }
  
  public void onActivityStopped(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = callbackList.iterator();
    while (localIterator.hasNext()) {
      ((IForeBackInterface)localIterator.next()).onStop(paramActivity);
    }
    if (paramActivity.isChangingConfigurations()) {
      bufferCount -= 1;
    }
    for (;;)
    {
      return;
      foregroundCount -= 1;
      if (foregroundCount <= 0)
      {
        localIterator = callbackList.iterator();
        while (localIterator.hasNext()) {
          ((IForeBackInterface)localIterator.next()).onBackground(paramActivity);
        }
      }
    }
  }
  
  public final void register(@NotNull IForeBackInterface paramIForeBackInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramIForeBackInterface, "foreBack");
    callbackList.add(paramIForeBackInterface);
  }
  
  public final void setActivityName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    activityName = paramString;
  }
  
  public final void setWeakActivity(@Nullable WeakReference<Activity> paramWeakReference)
  {
    weakActivity = paramWeakReference;
  }
  
  public final void unRegister(@NotNull IForeBackInterface paramIForeBackInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramIForeBackInterface, "foreBack");
    callbackList.remove(paramIForeBackInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.activty.LifecycleCallback
 * JD-Core Version:    0.7.0.1
 */