package com.tencent.mobileqq.startup.step;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.mobileqq.vassplash.model.SplashUIdata;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.ad.TianshuReportUtils;
import cooperation.vip.common.VipHandler;
import cooperation.vip.tianshu.TianShuManager;

final class SetSplash$5
  implements View.OnClickListener
{
  SetSplash$5(SplashItem paramSplashItem, StartupDirector paramStartupDirector, SplashADView paramSplashADView, SplashUIdata paramSplashUIdata, Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131436701)
    {
      if ((i == 2131444944) || (i == 2131446248))
      {
        this.c.setOnClickListener(null);
        VasSplashUtil.c = true;
        localObject = this.d;
        int j = 0;
        i = j;
        if (localObject != null) {
          if (((SplashUIdata)localObject).i != 2)
          {
            i = j;
            if (this.d.i != 3) {}
          }
          else
          {
            VasSplashUtil.c = false;
            i = 2000;
            if ((this.c.k) && (this.c.l) && (this.d.a == 2)) {
              this.c.d();
            }
            if (!TextUtils.isEmpty(this.d.d)) {
              TianShuManager.setLastClickAdTraceInfo(this.a.b, this.a.n);
            }
            localObject = this.a;
            if (localObject != null) {
              if (((SplashItem)localObject).c()) {
                TianshuReportUtils.b(this.a.b, 102, this.a.n);
              } else {
                TianshuReportUtils.c(this.a.b, 102, this.a.n);
              }
            }
            VipHandler.b(this.e, this.d.j);
          }
        }
        localObject = this.a;
        if ((localObject != null) && (((SplashItem)localObject).c()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append("");
          VasSplashUtil.b(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cover_layer =");
        ((StringBuilder)localObject).append(i);
        QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
        this.b.a(15, 1, i);
      }
    }
    else
    {
      localObject = this.a;
      if (localObject != null) {
        if (((SplashItem)localObject).c()) {
          TianshuReportUtils.b(this.a.b, 122, this.a.n);
        } else {
          TianshuReportUtils.c(this.a.b, 122, this.a.n);
        }
      }
      this.b.a(15, 1, 0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.5
 * JD-Core Version:    0.7.0.1
 */