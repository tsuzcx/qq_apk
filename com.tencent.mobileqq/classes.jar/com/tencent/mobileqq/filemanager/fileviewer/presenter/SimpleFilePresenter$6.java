package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class SimpleFilePresenter$6
  implements View.OnClickListener
{
  SimpleFilePresenter$6(SimpleFilePresenter paramSimpleFilePresenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    QVipUtils.a(this.a, BaseApplicationImpl.getApplication().getRuntime().getAccount(), this.b.d);
    KingCardProcessor.e().c.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.6
 * JD-Core Version:    0.7.0.1
 */