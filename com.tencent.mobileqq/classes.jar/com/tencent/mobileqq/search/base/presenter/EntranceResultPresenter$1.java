package com.tencent.mobileqq.search.base.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EntranceResultPresenter$1
  implements View.OnClickListener
{
  EntranceResultPresenter$1(EntranceResultPresenter paramEntranceResultPresenter, SearchResultModelForEntrance paramSearchResultModelForEntrance) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    SearchReportUtil.a(this.a.ah, this.a.z(), this.a.g(), this.a.n());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.EntranceResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */