package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/mini/appbrand/utils/ThreadPools$mainThreadExecutor$1", "Ljava/util/concurrent/Executor;", "execute", "", "command", "Ljava/lang/Runnable;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class ThreadPools$mainThreadExecutor$1
  implements Executor
{
  public void execute(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "command");
    ThreadPools.getMainThreadHandler().post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ThreadPools.mainThreadExecutor.1
 * JD-Core Version:    0.7.0.1
 */