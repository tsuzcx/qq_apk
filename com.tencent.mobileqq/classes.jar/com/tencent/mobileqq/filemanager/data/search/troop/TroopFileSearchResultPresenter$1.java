package com.tencent.mobileqq.filemanager.data.search.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileSearchResultPresenter$1
  implements View.OnClickListener
{
  TroopFileSearchResultPresenter$1(TroopFileSearchResultPresenter paramTroopFileSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */