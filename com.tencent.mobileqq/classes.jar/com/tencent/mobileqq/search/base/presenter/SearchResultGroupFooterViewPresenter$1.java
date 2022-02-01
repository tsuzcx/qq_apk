package com.tencent.mobileqq.search.base.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchResultGroupFooterViewPresenter$1
  implements View.OnClickListener
{
  SearchResultGroupFooterViewPresenter$1(SearchResultGroupFooterViewPresenter paramSearchResultGroupFooterViewPresenter, GroupSearchModelFooter paramGroupSearchModelFooter) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchBusinessGroupModelGroupSearchModelFooter.b(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.presenter.SearchResultGroupFooterViewPresenter.1
 * JD-Core Version:    0.7.0.1
 */