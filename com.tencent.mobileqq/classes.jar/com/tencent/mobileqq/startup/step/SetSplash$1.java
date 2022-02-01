package com.tencent.mobileqq.startup.step;

import android.view.ViewGroup;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.director.StartupDirector.SplashCallBack;
import com.tencent.mobileqq.vassplash.model.SplashUIdata;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

final class SetSplash$1
  extends StartupDirector.SplashCallBack
{
  SetSplash$1(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ISplashMiniGameStarterService paramISplashMiniGameStarterService)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      SplashUIdata localSplashUIdata = (SplashUIdata)this.b;
      this.a = true;
      this.c.l = false;
      if (localSplashUIdata.a != 2) {
        return;
      }
      this.c.d();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd end() error ", localException);
    }
  }
  
  protected void a(StartupDirector paramStartupDirector)
  {
    for (;;)
    {
      try
      {
        if (this.b == null) {
          return;
        }
        SplashUIdata localSplashUIdata = (SplashUIdata)this.b;
        QLog.i("SplashMiniGameStarter", 1, "bindView");
        com.tencent.mobileqq.splashad.SplashADUtil.a = System.currentTimeMillis();
        if (!this.c.k)
        {
          paramStartupDirector.g = 0L;
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)this.d.findViewById(2131446243);
        if (localViewGroup == null)
        {
          QLog.i("SplashMiniGameStarter", 1, "bindView fail, root is null");
          paramStartupDirector.g = 0L;
          return;
        }
        this.e.setNeedShow(false);
        localViewGroup.addView(this.c, 0);
        if (localSplashUIdata.a == 2)
        {
          QLog.i("SplashMiniGameStarter", 1, "show video");
          this.c.b();
          if (this.e.getCurrData() != null)
          {
            l = this.e.getCurrData().videoDuration * 1000;
            paramStartupDirector.g = l;
          }
        }
        else
        {
          this.e.preloadMiniGame();
          return;
        }
      }
      catch (Exception paramStartupDirector)
      {
        QLog.e("SplashMiniGameStarter", 1, "show SplashAd bindView error ", paramStartupDirector);
        return;
      }
      long l = 5000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.1
 * JD-Core Version:    0.7.0.1
 */