package com.tencent.mobileqq.search.business.contact.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactSearchResultMobilePresenter$1
  implements View.OnClickListener
{
  ContactSearchResultMobilePresenter$1(ContactSearchResultMobilePresenter paramContactSearchResultMobilePresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultMobilePresenter.1
 * JD-Core Version:    0.7.0.1
 */