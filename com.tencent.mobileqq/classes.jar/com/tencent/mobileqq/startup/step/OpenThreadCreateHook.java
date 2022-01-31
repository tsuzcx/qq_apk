package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean a()
  {
    NativeMonitorConfigHelper.b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */