package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import arvo;
import bhhr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerInitialler;

public class OpenThreadCreateHook
  extends Step
{
  protected boolean doStep()
  {
    if (BaseApplicationImpl.sProcessId == 1)
    {
      com.tencent.mobileqq.app.ThreadManager.sThreadWrapContext = new ThreadManagerInitialler();
      arvo.a();
      if ((Build.VERSION.SDK_INT <= 27) || (System.currentTimeMillis() % 10000L < bhhr.z(BaseApplicationImpl.getApplication()))) {
        arvo.b();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OpenThreadCreateHook
 * JD-Core Version:    0.7.0.1
 */