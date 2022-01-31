package com.tencent.mobileqq.startup.step;

import ajtc;
import amts;
import android.os.Build.VERSION;
import baig;
import com.tencent.common.app.BaseApplicationImpl;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new ajtc();
      amts.a();
      if ((Build.VERSION.SDK_INT <= 27) || (System.currentTimeMillis() % 10000L < baig.A(BaseApplicationImpl.getApplication()))) {
        amts.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */