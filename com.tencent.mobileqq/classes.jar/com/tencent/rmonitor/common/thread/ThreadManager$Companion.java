package com.tencent.rmonitor.common.thread;

import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/common/thread/ThreadManager$Companion;", "", "()V", "BATTERY_LOOPER", "Landroid/os/Looper;", "DUMP_LOOPER", "LOG_LOOPER", "MONITOR_LOOPER", "REPORTER_LOOPER", "STACK_LOOPER", "getBatteryThreadLooper", "getDumpThreadLooper", "getLogThreadLooper", "getMonitorThreadLooper", "getReporterThreadLooper", "getStackThreadLooper", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ThreadManager$Companion
{
  @JvmStatic
  @NotNull
  public final Looper a()
  {
    if (ThreadManager.a() == null) {
      try
      {
        if (ThreadManager.a() == null)
        {
          localObject1 = new HandlerThread("RMonitor_Monitor");
          ((HandlerThread)localObject1).start();
          ThreadManager.a(((HandlerThread)localObject1).getLooper());
        }
        Object localObject1 = Unit.INSTANCE;
      }
      finally {}
    }
    Looper localLooper = ThreadManager.a();
    if (localLooper == null) {
      Intrinsics.throwNpe();
    }
    return localLooper;
  }
  
  @JvmStatic
  @NotNull
  public final Looper b()
  {
    if (ThreadManager.b() == null) {
      try
      {
        if (ThreadManager.b() == null)
        {
          localObject1 = new HandlerThread("RMonitor_Log");
          ((HandlerThread)localObject1).start();
          ThreadManager.b(((HandlerThread)localObject1).getLooper());
        }
        Object localObject1 = Unit.INSTANCE;
      }
      finally {}
    }
    Looper localLooper = ThreadManager.b();
    if (localLooper == null) {
      Intrinsics.throwNpe();
    }
    return localLooper;
  }
  
  @JvmStatic
  @NotNull
  public final Looper c()
  {
    if (ThreadManager.c() == null) {
      try
      {
        if (ThreadManager.c() == null)
        {
          localObject1 = new HandlerThread("RMonitor_Reporter");
          ((HandlerThread)localObject1).start();
          ThreadManager.c(((HandlerThread)localObject1).getLooper());
        }
        Object localObject1 = Unit.INSTANCE;
      }
      finally {}
    }
    Looper localLooper = ThreadManager.c();
    if (localLooper == null) {
      Intrinsics.throwNpe();
    }
    return localLooper;
  }
  
  @JvmStatic
  @NotNull
  public final Looper d()
  {
    if (ThreadManager.d() == null) {
      try
      {
        if (ThreadManager.d() == null)
        {
          localObject1 = new HandlerThread("RMonitor_Dump");
          ((HandlerThread)localObject1).start();
          ThreadManager.d(((HandlerThread)localObject1).getLooper());
        }
        Object localObject1 = Unit.INSTANCE;
      }
      finally {}
    }
    Looper localLooper = ThreadManager.d();
    if (localLooper == null) {
      Intrinsics.throwNpe();
    }
    return localLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.thread.ThreadManager.Companion
 * JD-Core Version:    0.7.0.1
 */