package com.tencent.mobileqq.search.base.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseSearchActivity$3
  implements View.OnClickListener
{
  BaseSearchActivity$3(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.activity.BaseSearchActivity.3
 * JD-Core Version:    0.7.0.1
 */