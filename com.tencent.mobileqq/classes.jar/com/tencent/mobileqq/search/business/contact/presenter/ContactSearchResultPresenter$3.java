package com.tencent.mobileqq.search.business.contact.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactSearchResultPresenter$3
  implements View.OnClickListener
{
  ContactSearchResultPresenter$3(ContactSearchResultPresenter paramContactSearchResultPresenter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView.setTag(2021012801, this.jdField_a_of_type_JavaLangString);
    paramView.setTag(2021012802, this.b);
    ContactSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter).onAction(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.3
 * JD-Core Version:    0.7.0.1
 */