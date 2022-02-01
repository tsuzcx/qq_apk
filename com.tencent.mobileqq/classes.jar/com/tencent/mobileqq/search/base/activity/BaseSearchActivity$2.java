package com.tencent.mobileqq.search.base.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseSearchActivity$2
  implements View.OnClickListener
{
  BaseSearchActivity$2(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    BaseSearchActivity.l = 1;
    this.a.d.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.activity.BaseSearchActivity.2
 * JD-Core Version:    0.7.0.1
 */