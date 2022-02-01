package com.tencent.mobileqq.search.business.contact.presenter;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
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
    String str = this.a.c();
    if ((localObject instanceof QBaseActivity))
    {
      SearchUtils.a("all_result", "clk_result_join", new String[0]);
      localObject = (QBaseActivity)localObject;
      ContactSearchResultPresenter.a(this.b, (Activity)localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.2
 * JD-Core Version:    0.7.0.1
 */