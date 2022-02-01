package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$1
  implements View.OnClickListener
{
  SearchTemplatePresenter$1(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateBaseItem paramNetSearchTemplateBaseItem) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.1
 * JD-Core Version:    0.7.0.1
 */