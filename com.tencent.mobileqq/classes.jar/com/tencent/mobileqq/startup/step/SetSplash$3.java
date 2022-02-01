package com.tencent.mobileqq.startup.step;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class SetSplash$3
  implements View.OnClickListener
{
  SetSplash$3(StartupDirector paramStartupDirector) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a(15, 1, 0L);
      ISplashMiniGameStarterService localISplashMiniGameStarterService = (ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class);
      localISplashMiniGameStarterService.setNeedJump(false);
      localISplashMiniGameStarterService.setHasClickJumpBtn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.3
 * JD-Core Version:    0.7.0.1
 */