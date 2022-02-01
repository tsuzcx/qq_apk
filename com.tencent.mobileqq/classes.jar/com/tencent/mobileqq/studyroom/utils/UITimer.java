package com.tencent.mobileqq.studyroom.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studyroom/utils/UITimer;", "", "()V", "isStart", "", "mUIHandler", "Landroid/os/Handler;", "start", "", "runnable", "Ljava/lang/Runnable;", "loopMillis", "", "stop", "qqstudyroom_impl_release"}, k=1, mv={1, 1, 16})
final class UITimer
{
  private final Handler a = new Handler(Looper.getMainLooper());
  private volatile boolean b;
  
  public final void a()
  {
    this.b = false;
    this.a.removeCallbacksAndMessages(null);
  }
  
  public final void a(@NotNull Runnable paramRunnable, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    this.b = true;
    this.a.removeCallbacksAndMessages(null);
    this.a.postDelayed((Runnable)new UITimer.start.1(this, paramRunnable, paramLong), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.UITimer
 * JD-Core Version:    0.7.0.1
 */