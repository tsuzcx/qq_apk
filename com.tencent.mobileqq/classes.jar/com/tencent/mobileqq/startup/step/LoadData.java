package com.tencent.mobileqq.startup.step;

import aauu;
import alht;
import bdgy;
import bhii;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class LoadData
  extends Step
{
  protected boolean doStep()
  {
    AppActivity localAppActivity = this.mDirector.a;
    long l = System.currentTimeMillis();
    aauu.a = l;
    if (localAppActivity != null)
    {
      if (aauu.a(BaseApplicationImpl.sApplication))
      {
        alht.a(BaseApplicationImpl.sApplication, true);
        bhii.a(BaseApplicationImpl.sApplication, true, null, null);
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.waitAppRuntime(null);
      if (this.mId == 19) {}
      for (boolean bool = true; (localAppActivity.preloadData(localAppRuntime, bool)) && (System.currentTimeMillis() - l < 550L); bool = false) {
        return true;
      }
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadData
 * JD-Core Version:    0.7.0.1
 */