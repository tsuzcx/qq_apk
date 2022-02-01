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
      SplashUIdata localSplashUIdata = (SplashUIdata)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      if (localSplashUIdata.a != 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
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
        if (this.jdField_a_of_type_JavaLangObject == null) {
          return;
        }
        SplashUIdata localSplashUIdata = (SplashUIdata)this.jdField_a_of_type_JavaLangObject;
        QLog.i("SplashMiniGameStarter", 1, "bindView");
        com.tencent.mobileqq.splashad.SplashADUtil.a = System.currentTimeMillis();
        if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
        {
          paramStartupDirector.a = 0L;
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131377782);
        if (localViewGroup == null)
        {
          QLog.i("SplashMiniGameStarter", 1, "bindView fail, root is null");
          paramStartupDirector.a = 0L;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.setNeedShow(false);
        localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
        if (localSplashUIdata.a == 2)
        {
          QLog.i("SplashMiniGameStarter", 1, "show video");
          this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
          if (this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.getCurrData() != null)
          {
            l = this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.getCurrData().videoDuration * 1000;
            paramStartupDirector.a = l;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqMiniApiISplashMiniGameStarterService.preloadMiniGame();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.1
 * JD-Core Version:    0.7.0.1
 */