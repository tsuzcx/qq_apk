package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RichSearchResultPresenter$1
  implements View.OnClickListener
{
  RichSearchResultPresenter$1(RichSearchResultPresenter paramRichSearchResultPresenter) {}
  
  public void onClick(View paramView)
  {
    RichSearchResultPresenter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.RichSearchResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */