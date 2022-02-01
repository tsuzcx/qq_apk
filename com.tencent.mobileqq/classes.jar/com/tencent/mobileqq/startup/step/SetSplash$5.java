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
    if (i != 2131369593)
    {
      if (i == 2131377787)
      {
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
        VasSplashUtil.a = true;
        localObject = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata;
        int j = 0;
        i = j;
        if (localObject != null) {
          if (((SplashUIdata)localObject).jdField_d_of_type_Int != 2)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_d_of_type_Int != 3) {}
          }
          else
          {
            VasSplashUtil.a = false;
            i = 2000;
            if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.a == 2)) {
              this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.b)) {
              TianShuManager.setLastClickAdTraceInfo(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.b, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.j);
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem;
            if (localObject != null) {
              if (((SplashItem)localObject).c()) {
                TianshuReportUtils.b(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.b, 102, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.j);
              } else {
                TianshuReportUtils.c(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.b, 102, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.j);
              }
            }
            VipHandler.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashUIdata.jdField_d_of_type_JavaLangString);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem;
        if ((localObject != null) && (((SplashItem)localObject).c()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append("");
          VasSplashUtil.a(((StringBuilder)localObject).toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cover_layer =");
        ((StringBuilder)localObject).append(i);
        QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
        this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(15, 1, i);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem;
      if (localObject != null) {
        if (((SplashItem)localObject).c()) {
          TianshuReportUtils.b(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.b, 122, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.j);
        } else {
          TianshuReportUtils.c(this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.b, 122, this.jdField_a_of_type_ComTencentMobileqqVassplashModelSplashItem.j);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(15, 1, 0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash.5
 * JD-Core Version:    0.7.0.1
 */