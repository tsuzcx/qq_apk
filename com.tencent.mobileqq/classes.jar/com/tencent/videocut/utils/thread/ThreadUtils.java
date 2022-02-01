package com.tencent.videocut.utils.thread;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/ThreadUtils;", "", "()V", "isMainThread", "", "()Z", "mainHandler", "Landroid/os/Handler;", "sMainThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "post", "", "r", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeCallbacks", "runInBackground", "runnable", "runInBackgroundForIO", "runInMainThread", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class ThreadUtils
{
  @NotNull
  public static final ThreadUtils a = new ThreadUtils();
  private static final Thread b;
  private static final Handler c = new Handler(Looper.getMainLooper());
  
  static
  {
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkNotNullExpressionValue(localLooper, "Looper.getMainLooper()");
    b = localLooper.getThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */