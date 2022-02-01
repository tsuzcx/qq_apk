package com.tencent.rmonitor.common.thread;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/thread/ThreadManager;", "", "()V", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ThreadManager
{
  public static final ThreadManager.Companion a = new ThreadManager.Companion(null);
  private static volatile Looper b;
  private static volatile Looper c;
  private static volatile Looper d;
  private static volatile Looper e;
  
  @JvmStatic
  @NotNull
  public static final Looper e()
  {
    return a.a();
  }
  
  @JvmStatic
  @NotNull
  public static final Looper f()
  {
    return a.c();
  }
  
  @JvmStatic
  @NotNull
  public static final Looper g()
  {
    return a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */