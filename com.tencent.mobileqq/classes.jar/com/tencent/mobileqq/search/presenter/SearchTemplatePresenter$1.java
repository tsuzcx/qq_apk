package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$1
  implements View.OnClickListener
{
  SearchTemplatePresenter$1(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    SearchReportUtil.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.1
 * JD-Core Version:    0.7.0.1
 */