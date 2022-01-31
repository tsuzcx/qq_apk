package com.tencent.mobileqq.startup.step;

import alzb;
import android.os.Build.VERSION;
import apbm;
import bdiv;
import com.tencent.common.app.BaseApplicationImpl;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new alzb();
      apbm.a();
      if ((Build.VERSION.SDK_INT <= 27) || (System.currentTimeMillis() % 10000L < bdiv.A(BaseApplicationImpl.getApplication()))) {
        apbm.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */