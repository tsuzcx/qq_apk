package com.tencent.mobileqq.startup.step;

import ahon;
import axnx;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import xop;

public class LoadData
  extends Step
{
  protected boolean doStep()
  {
    boolean bool2 = true;
    AppActivity localAppActivity = this.mDirector.a;
    long l = System.currentTimeMillis();
    xop.a = l;
    if (localAppActivity != null)
    {
      if (xop.a(BaseApplicationImpl.sApplication)) {
        ahon.a(BaseApplicationImpl.sApplication, true);
      }
    }
    else {
      return false;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
    if (this.mId == 18)
    {
      bool1 = true;
      if ((!localAppActivity.preloadData(localAppRuntime, bool1)) || (System.currentTimeMillis() - l >= 550L)) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */