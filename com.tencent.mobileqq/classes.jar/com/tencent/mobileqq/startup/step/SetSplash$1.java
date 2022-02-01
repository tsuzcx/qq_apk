package com.tencent.mobileqq.startup.step;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.qbosssplash.common.QbossSplashUtil;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.director.StartupDirector.SplashCallBack;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.ad.TianshuSplashUtils;
import mqq.app.AppActivity;

final class SetSplash$1
  extends StartupDirector.SplashCallBack
{
  SetSplash$1(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  public void a()
  {
    try
    {
      SplashItem localSplashItem = (SplashItem)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localSplashItem.a)
      {
      case 2: 
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd end() error ", localException);
      return;
    }
  }
  
  public void a(StartupDirector paramStartupDirector)
  {
    SplashItem localSplashItem;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localSplashItem = (SplashItem)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      SplashADUtil.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramStartupDirector.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception paramStartupDirector)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", paramStartupDirector);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131378373);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      paramStartupDirector.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localSplashItem.a)
    {
    }
    for (;;)
    {
      if (TianshuSplashUtils.a(localSplashItem.l))
      {
        QLog.d("QSplash@QbossSplashUtil", 1, "show UnionBannerSplash ");
        SetSplash.a(this.jdField_a_of_type_MqqAppAppActivity);
        TianshuSplashUtils.a(this.jdField_a_of_type_Long + "", 101, localSplashItem.b, localSplashItem.j);
        TianshuSplashUtils.a(localSplashItem.b, this.jdField_a_of_type_Long + "");
        QbossSplashUtil.a(localSplashItem.b, this.jdField_a_of_type_Long, false, "tianshu_splash_ad_ids_with_showdate_with_priority_");
        return;
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.b.setVisibility(8);
        }
        paramStartupDirector.jdField_a_of_type_Long = 3000L;
        continue;
        QLog.i("QSplash@QbossSplashUtil", 1, "show video");
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
        paramStartupDirector.jdField_a_of_type_Long = 10000L;
      }
      else
      {
        QbossSplashUtil.a(localSplashItem.j, null, 1);
        QbossSplashUtil.a(localSplashItem.b, this.jdField_a_of_type_Long, false, "qboss_splash_ad_ids_with_showdate_with_priority_");
        SplashADUtil.a(localSplashItem.c, localSplashItem.g);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.1
 * JD-Core Version:    0.7.0.1
 */