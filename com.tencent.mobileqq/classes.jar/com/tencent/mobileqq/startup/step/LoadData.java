package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class LoadData
  extends Step
{
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    long l = System.currentTimeMillis();
    if (localAppActivity != null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
      if (this.c == 17) {}
      for (boolean bool = true; (localAppActivity.preloadData(localAppRuntime, bool)) && (System.currentTimeMillis() - l < 550L); bool = false) {
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */