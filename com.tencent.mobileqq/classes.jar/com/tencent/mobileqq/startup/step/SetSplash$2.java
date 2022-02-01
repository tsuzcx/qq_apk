package com.tencent.mobileqq.startup.step;

import android.view.ViewGroup;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.qbosssplash.model.SplashUIdata;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.director.StartupDirector.SplashCallBack;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

final class SetSplash$2
  extends StartupDirector.SplashCallBack
{
  SetSplash$2(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ISplashMiniGameStarterService paramISplashMiniGameStarterService)
  {
    super(paramObject);
  }
  
  public void a()
  {
    try
    {
      SplashUIdata localSplashUIdata = (SplashUIdata)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localSplashUIdata.a)
      {
      case 2: 
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd end() error ", localException);
      return;
    }
  }
  
  public void a(StartupDirector paramStartupDirector)
  {
    SplashUIdata localSplashUIdata;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localSplashUIdata = (SplashUIdata)this.jdField_a_of_type_JavaLangObject;
      QLog.i("SplashMiniGameStarter", 1, "bindView");
      com.tencent.mobileqq.splashad.SplashADUtil.a = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramStartupDirector.a = 0L;
        return;
      }
    }
    catch (Exception paramStartupDirector)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd bindView error ", paramStartupDirector);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131378373);
    if (localViewGroup == null)
    {
      QLog.i("SplashMiniGameStarter", 1, "bindView fail, root is null");
      paramStartupDirector.a = 0L;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.setNeedShow(false);
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localSplashUIdata.a)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.preloadMiniGame();
      return;
      QLog.i("SplashMiniGameStarter", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      if (this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.getCurrData() != null) {}
      for (long l = this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.getCurrData().videoDuration * 1000;; l = 5000L)
      {
        paramStartupDirector.a = l;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.2
 * JD-Core Version:    0.7.0.1
 */