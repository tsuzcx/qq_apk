package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MostUsedResultPresenter$1
  implements View.OnClickListener
{
  MostUsedResultPresenter$1(MostUsedResultPresenter paramMostUsedResultPresenter) {}
  
  public void onClick(View paramView)
  {
    MostUsedResultPresenter.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.MostUsedResultPresenter.1
 * JD-Core Version:    0.7.0.1
 */