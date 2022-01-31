package com.tencent.mobileqq.startup.step;

import amdq;
import android.os.Build.VERSION;
import apfv;
import bdne;
import com.tencent.common.app.BaseApplicationImpl;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new amdq();
      apfv.a();
      if ((Build.VERSION.SDK_INT <= 27) || (System.currentTimeMillis() % 10000L < bdne.A(BaseApplicationImpl.getApplication()))) {
        apfv.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */