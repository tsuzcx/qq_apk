package com.tencent.qapmsdk.common.thread;

import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/thread/ThreadManager;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ThreadManager
{
  private static volatile Looper BATTERY_LOOPER;
  public static final ThreadManager.Companion Companion = new ThreadManager.Companion(null);
  private static volatile Looper LOG_LOOPER;
  private static volatile Looper MONITOR_LOOPER;
  private static volatile Looper REPORTER_LOOPER;
  private static volatile Looper STACK_LOOPER;
  private static volatile Looper USER_BEHAVIOR_LOOPER;
  
  @JvmStatic
  @Nullable
  public static final Looper getBatteryThreadLooper()
  {
    return Companion.getBatteryThreadLooper();
  }
  
  @JvmStatic
  @Nullable
  public static final Looper getLogThreadLooper()
  {
    return Companion.getLogThreadLooper();
  }
  
  @JvmStatic
  @Nullable
  public static final Looper getMonitorThreadLooper()
  {
    return Companion.getMonitorThreadLooper();
  }
  
  @JvmStatic
  @Nullable
  public static final Looper getReporterThreadLooper()
  {
    return Companion.getReporterThreadLooper();
  }
  
  @JvmStatic
  @Nullable
  public static final Looper getStackThreadLooper()
  {
    return Companion.getStackThreadLooper();
  }
  
  @JvmStatic
  @Nullable
  public static final Looper getUserBehaviorLooper()
  {
    return Companion.getUserBehaviorLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */