package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class SimpleFilePresenter$7
  implements View.OnClickListener
{
  SimpleFilePresenter$7(SimpleFilePresenter paramSimpleFilePresenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    QVipUtils.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerPresenterSimpleFilePresenter.a);
    KingCardProcessor.c().c.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.7
 * JD-Core Version:    0.7.0.1
 */