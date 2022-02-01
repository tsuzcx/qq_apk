package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerInitialler;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new ThreadManagerInitialler();
      NativeMonitorConfigHelper.a();
      int i = Build.VERSION.SDK_INT;
      if (System.currentTimeMillis() % 10000L < SharedPreUtils.A(BaseApplicationImpl.getApplication())) {
        NativeMonitorConfigHelper.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */