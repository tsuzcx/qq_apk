package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.annotation.NonNull;

class ActivityWatcher$MonitorInstrumentation
  extends Instrumentation
{
  public void callActivityOnDestroy(@NonNull Activity paramActivity)
  {
    ActivityWatcher.access$200().callActivityOnDestroy(paramActivity);
    ActivityWatcher.access$000(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher.MonitorInstrumentation
 * JD-Core Version:    0.7.0.1
 */