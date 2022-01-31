package com.tencent.tmediacodec.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/util/ThreadManager;", "", "()V", "mHandler", "Landroid/os/Handler;", "mThreadPool", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "execute", "", "runnable", "Ljava/lang/Runnable;", "runOnSubThread", "Lkotlin/Function0;", "runOnUiThread", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class ThreadManager
{
  public static final ThreadManager INSTANCE = new ThreadManager();
  private static final Handler mHandler = new Handler(Looper.getMainLooper());
  private static final ExecutorService mThreadPool = Executors.newCachedThreadPool();
  
  public final void execute(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    mThreadPool.execute(paramRunnable);
  }
  
  public final void runOnSubThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      mThreadPool.execute(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  public final void runOnSubThread(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    runOnSubThread((Runnable)new ThreadManager.runOnSubThread.1(paramFunction0));
  }
  
  public final void runOnUiThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    runOnUiThread((Function0)new ThreadManager.runOnUiThread.1(paramRunnable));
  }
  
  public final void runOnUiThread(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      paramFunction0.invoke();
      return;
    }
    mHandler.post((Runnable)new ThreadManager.sam.java_lang_Runnable.0(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ThreadManager
 * JD-Core Version:    0.7.0.1
 */