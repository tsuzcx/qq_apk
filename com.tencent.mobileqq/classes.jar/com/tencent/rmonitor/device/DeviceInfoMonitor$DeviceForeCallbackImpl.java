package com.tencent.rmonitor.device;

import android.app.Activity;
import android.os.Handler;
import com.tencent.rmonitor.common.lifecycle.IActivityStateCallback;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.thread.ThreadManager.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/DeviceInfoMonitor$DeviceForeCallbackImpl;", "Lcom/tencent/rmonitor/common/lifecycle/IActivityStateCallback;", "(Lcom/tencent/rmonitor/device/DeviceInfoMonitor;)V", "onBackground", "", "activity", "Landroid/app/Activity;", "onCreate", "onDestroy", "onForeground", "onResume", "onStop", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DeviceInfoMonitor$DeviceForeCallbackImpl
  implements IActivityStateCallback
{
  public void a(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void b(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void c(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void d(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    new Handler(ThreadManager.a.c()).post((Runnable)new DeviceInfoMonitor.DeviceForeCallbackImpl.onBackground.1(this));
  }
  
  public void e(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
  
  public void f(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.DeviceInfoMonitor.DeviceForeCallbackImpl
 * JD-Core Version:    0.7.0.1
 */