package com.tencent.mobileqq.startup.step;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.director.StartupDirector.SplashCallBack;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.ad.TianshuReportUtils;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;

class SetSplash$VasSplashCallBack
  extends StartupDirector.SplashCallBack
{
  WeakReference<SplashADView> c;
  WeakReference<ImageView> d;
  WeakReference<ImageView> e;
  WeakReference<AppActivity> f;
  
  protected SetSplash$VasSplashCallBack(Object paramObject, SplashADView paramSplashADView, ImageView paramImageView1, ImageView paramImageView2, AppActivity paramAppActivity)
  {
    super(paramObject);
    this.c = new WeakReference(paramSplashADView);
    this.d = new WeakReference(paramImageView1);
    this.e = new WeakReference(paramImageView2);
    this.f = new WeakReference(paramAppActivity);
  }
  
  protected void a()
  {
    try
    {
      SplashItem localSplashItem = (SplashItem)this.b;
      this.a = true;
      SplashADView localSplashADView = (SplashADView)this.c.get();
      if (localSplashADView != null) {
        localSplashADView.l = false;
      }
      if (localSplashItem.e != 2) {
        return;
      }
      localSplashADView.d();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QSplash@VasSplashUtil", 1, "show SplashAd end() error ", localException);
    }
  }
  
  protected void a(StartupDirector paramStartupDirector)
  {
    try
    {
      if (this.b == null) {
        return;
      }
      Object localObject = (SplashADView)this.c.get();
      ImageView localImageView1 = (ImageView)this.d.get();
      ImageView localImageView2 = (ImageView)this.e.get();
      AppActivity localAppActivity = (AppActivity)this.f.get();
      if (localObject != null)
      {
        if (localAppActivity == null) {
          return;
        }
        SplashItem localSplashItem = (SplashItem)this.b;
        QLog.i("QSplash@VasSplashUtil", 1, "bindView");
        SplashADUtil.a = System.currentTimeMillis();
        if (!((SplashADView)localObject).k)
        {
          paramStartupDirector.g = 0L;
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)localAppActivity.findViewById(2131446243);
        if (localViewGroup == null)
        {
          QLog.i("QSplash@VasSplashUtil", 1, "bindView fail, root is null");
          paramStartupDirector.g = 0L;
          return;
        }
        localViewGroup.addView((View)localObject, 0);
        int i = localSplashItem.e;
        if (i != 0)
        {
          if (i == 2)
          {
            QLog.i("QSplash@VasSplashUtil", 1, "show video");
            ((SplashADView)localObject).b();
            paramStartupDirector.g = 10000L;
          }
        }
        else
        {
          if ((localImageView1 != null) && (localImageView2 != null))
          {
            localImageView1.setVisibility(8);
            localImageView2.setVisibility(8);
          }
          paramStartupDirector.g = 3000L;
        }
        long l = SplashADUtil.a(BaseApplicationImpl.getApplication());
        ImmersiveUtils.clearCoverForStatus(localAppActivity.getWindow(), true);
        if (localSplashItem.c())
        {
          QLog.d("QSplash@VasSplashUtil", 1, "show UnionBannerSplash ");
          SetSplash.a(localAppActivity);
          paramStartupDirector = localSplashItem.b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("");
          VasSplashUtil.a(paramStartupDirector, ((StringBuilder)localObject).toString());
          TianshuReportUtils.b(localSplashItem.b, 101, localSplashItem.n);
        }
        else
        {
          TianshuReportUtils.c(localSplashItem.b, 101, localSplashItem.n);
        }
        VasSplashUtil.a(localSplashItem.b, l, false);
        return;
      }
      return;
    }
    catch (Exception paramStartupDirector)
    {
      QLog.e("QSplash@VasSplashUtil", 1, "show SplashAd bindView error ", paramStartupDirector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.VasSplashCallBack
 * JD-Core Version:    0.7.0.1
 */