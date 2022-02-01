package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchResultGroupTitlePresenter$1
  implements View.OnClickListener
{
  SearchResultGroupTitlePresenter$1(SearchResultGroupTitlePresenter paramSearchResultGroupTitlePresenter, ISearchResultGroupModel paramISearchResultGroupModel) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultGroupModel.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter.1
 * JD-Core Version:    0.7.0.1
 */