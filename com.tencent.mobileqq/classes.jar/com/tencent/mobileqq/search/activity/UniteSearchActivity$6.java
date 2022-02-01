package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UniteSearchActivity$6
  implements View.OnClickListener
{
  UniteSearchActivity$6(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.p();
    this.a.q();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.6
 * JD-Core Version:    0.7.0.1
 */