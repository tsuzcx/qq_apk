package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import aoil;
import aryf;
import bhsi;
import com.tencent.common.app.BaseApplicationImpl;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new aoil();
      aryf.a();
      if ((Build.VERSION.SDK_INT <= 27) || (System.currentTimeMillis() % 10000L < bhsi.z(BaseApplicationImpl.getApplication()))) {
        aryf.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */