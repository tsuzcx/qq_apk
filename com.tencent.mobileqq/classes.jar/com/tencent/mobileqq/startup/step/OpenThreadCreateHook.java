package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean a()
  {
    com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new ThreadManagerInitialler();
    NativeMonitorConfigHelper.a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */