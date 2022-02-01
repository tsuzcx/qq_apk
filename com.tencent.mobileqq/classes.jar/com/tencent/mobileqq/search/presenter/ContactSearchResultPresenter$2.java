package com.tencent.mobileqq.search.presenter;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ContactSearchResultPresenter$2
  implements View.OnClickListener
{
  ContactSearchResultPresenter$2(ContactSearchResultPresenter paramContactSearchResultPresenter, ISearchResultModel paramISearchResultModel) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    String str = this.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel.b();
    if ((localObject instanceof BaseActivity))
    {
      SearchUtils.a("all_result", "clk_result_join", new String[0]);
      localObject = (BaseActivity)localObject;
      ContactSearchResultPresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter, (Activity)localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.2
 * JD-Core Version:    0.7.0.1
 */