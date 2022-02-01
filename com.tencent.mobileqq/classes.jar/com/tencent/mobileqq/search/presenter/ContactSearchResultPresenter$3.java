package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.ContactSearchActivity.GroupFileSearchListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactSearchResultPresenter$3
  implements View.OnClickListener
{
  ContactSearchResultPresenter$3(ContactSearchResultPresenter paramContactSearchResultPresenter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ContactSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter).a(paramView);
    if ((ContactSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter) instanceof ContactSearchActivity.GroupFileSearchListener)) {
      ((ContactSearchActivity.GroupFileSearchListener)ContactSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter)).a(this.jdField_a_of_type_JavaLangString, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.3
 * JD-Core Version:    0.7.0.1
 */