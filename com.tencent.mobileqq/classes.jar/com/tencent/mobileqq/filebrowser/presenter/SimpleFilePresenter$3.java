package com.tencent.mobileqq.filebrowser.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SimpleFilePresenter$3
  implements View.OnClickListener
{
  SimpleFilePresenter$3(SimpleFilePresenter paramSimpleFilePresenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(this.jdField_a_of_type_JavaLangString, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterSimpleFilePresenter.a);
    KingCardProcessor.c().c.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter.3
 * JD-Core Version:    0.7.0.1
 */