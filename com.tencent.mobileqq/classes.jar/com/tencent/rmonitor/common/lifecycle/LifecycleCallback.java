package com.tencent.rmonitor.common.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/lifecycle/LifecycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "activityName", "", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "callbackList", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/rmonitor/common/lifecycle/IActivityStateCallback;", "foregroundCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "weakActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getWeakActivity", "()Ljava/lang/ref/WeakReference;", "setWeakActivity", "(Ljava/lang/ref/WeakReference;)V", "clear", "", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "register", "foreBack", "unRegister", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class LifecycleCallback
  implements Application.ActivityLifecycleCallbacks
{
  public static final LifecycleCallback a = new LifecycleCallback();
  private static final ConcurrentLinkedQueue<IActivityStateCallback> b = new ConcurrentLinkedQueue();
  private static AtomicInteger c = new AtomicInteger(1);
  @Nullable
  private static WeakReference<Activity> d;
  @NotNull
  private static String e = "";
  
  @JvmStatic
  public static final void a(@NotNull IActivityStateCallback paramIActivityStateCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIActivityStateCallback, "foreBack");
    b.add(paramIActivityStateCallback);
  }
  
  @JvmStatic
  public static final void b(@NotNull IActivityStateCallback paramIActivityStateCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIActivityStateCallback, "foreBack");
    b.remove(paramIActivityStateCallback);
  }
  
  @Nullable
  public final WeakReference<Activity> a()
  {
    return d;
  }
  
  @NotNull
  public final String b()
  {
    return e;
  }
  
  public void onActivityCreated(@NotNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    paramBundle = b.iterator();
    while (paramBundle.hasNext()) {
      ((IActivityStateCallback)paramBundle.next()).a(paramActivity);
    }
  }
  
  public void onActivityDestroyed(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IActivityStateCallback)localIterator.next()).b(paramActivity);
    }
  }
  
  public void onActivityPaused(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void onActivityResumed(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IActivityStateCallback)localIterator.next()).e(paramActivity);
    }
    d = new WeakReference(paramActivity);
    paramActivity = d;
    if (paramActivity != null)
    {
      paramActivity = (Activity)paramActivity.get();
      if (paramActivity != null)
      {
        paramActivity = paramActivity.getClass();
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getSimpleName();
          if (paramActivity != null) {
            break label95;
          }
        }
      }
    }
    paramActivity = "";
    label95:
    e = paramActivity;
  }
  
  public void onActivitySaveInstanceState(@NotNull Activity paramActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void onActivityStarted(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    c.incrementAndGet();
    if ((c.get() == 1) || (c.get() == 2))
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((IActivityStateCallback)localIterator.next()).c(paramActivity);
      }
    }
    if (c.get() <= 0) {
      c.set(1);
    }
  }
  
  public void onActivityStopped(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IActivityStateCallback)localIterator.next()).f(paramActivity);
    }
    c.decrementAndGet();
    if (c.get() <= 0)
    {
      c.set(0);
      localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((IActivityStateCallback)localIterator.next()).d(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.lifecycle.LifecycleCallback
 * JD-Core Version:    0.7.0.1
 */