package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EntranceResultPresenter$1
  implements View.OnClickListener
{
  EntranceResultPresenter$1(EntranceResultPresenter paramEntranceResultPresenter, SearchResultModelForEntrance paramSearchResultModelForEntrance) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.EntranceResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */