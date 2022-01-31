package com.tencent.mobileqq.startup.step;

import aznp;
import mqq.app.AppActivity;

public class LoadUi
  extends OnceIfSuccessStep
{
  protected boolean doStep()
  {
    AppActivity localAppActivity = this.mDirector.a;
    if (localAppActivity != null) {
      localAppActivity.preloadUi();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadUi
 * JD-Core Version:    0.7.0.1
 */