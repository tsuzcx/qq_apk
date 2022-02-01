package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItem;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$6
  implements View.OnClickListener
{
  SearchTemplatePresenter$6(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateSubItem paramNetSearchTemplateSubItem, NetSearchTemplateSubItemView paramNetSearchTemplateSubItemView) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.b.h());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.6
 * JD-Core Version:    0.7.0.1
 */