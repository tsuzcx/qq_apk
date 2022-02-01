package com.tencent.qapmsdk.common.thread;

import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/thread/ThreadManager$Companion;", "", "()V", "BATTERY_LOOPER", "Landroid/os/Looper;", "LOG_LOOPER", "MONITOR_LOOPER", "REPORTER_LOOPER", "STACK_LOOPER", "USER_BEHAVIOR_LOOPER", "getBatteryThreadLooper", "getLogThreadLooper", "getMonitorThreadLooper", "getReporterThreadLooper", "getStackThreadLooper", "getUserBehaviorLooper", "common_release"}, k=1, mv={1, 1, 15})
public final class ThreadManager$Companion
{
  @JvmStatic
  @Nullable
  public final Looper getBatteryThreadLooper()
  {
    if (ThreadManager.access$getBATTERY_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getBATTERY_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_Battery");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setBATTERY_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getBATTERY_LOOPER$cp();
    }
    finally {}
  }
  
  @JvmStatic
  @Nullable
  public final Looper getLogThreadLooper()
  {
    if (ThreadManager.access$getLOG_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getLOG_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_Log");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setLOG_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getLOG_LOOPER$cp();
    }
    finally {}
  }
  
  @JvmStatic
  @Nullable
  public final Looper getMonitorThreadLooper()
  {
    if (ThreadManager.access$getMONITOR_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getMONITOR_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_Monitor");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setMONITOR_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getMONITOR_LOOPER$cp();
    }
    finally {}
  }
  
  @JvmStatic
  @Nullable
  public final Looper getReporterThreadLooper()
  {
    if (ThreadManager.access$getREPORTER_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getREPORTER_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_Reporter");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setREPORTER_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getREPORTER_LOOPER$cp();
    }
    finally {}
  }
  
  @JvmStatic
  @Nullable
  public final Looper getStackThreadLooper()
  {
    if (ThreadManager.access$getSTACK_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getSTACK_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_Stack");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setSTACK_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getSTACK_LOOPER$cp();
    }
    finally {}
  }
  
  @JvmStatic
  @Nullable
  public final Looper getUserBehaviorLooper()
  {
    if (ThreadManager.access$getUSER_BEHAVIOR_LOOPER$cp() == null) {}
    try
    {
      if (ThreadManager.access$getUSER_BEHAVIOR_LOOPER$cp() == null)
      {
        localObject1 = new HandlerThread("QAPM_User_Behavior");
        ((HandlerThread)localObject1).start();
        ThreadManager.access$setUSER_BEHAVIOR_LOOPER$cp(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = Unit.INSTANCE;
      return ThreadManager.access$getUSER_BEHAVIOR_LOOPER$cp();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.thread.ThreadManager.Companion
 * JD-Core Version:    0.7.0.1
 */