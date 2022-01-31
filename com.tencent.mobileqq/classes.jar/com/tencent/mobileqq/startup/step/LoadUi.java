package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;
import mqq.app.AppActivity;

public class LoadUi
  extends Step
{
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    if (localAppActivity != null) {
      localAppActivity.preloadUi();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadUi
 * JD-Core Version:    0.7.0.1
 */