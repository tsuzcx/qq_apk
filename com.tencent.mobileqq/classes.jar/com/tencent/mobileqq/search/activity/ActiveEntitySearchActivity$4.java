package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActiveEntitySearchActivity$4
  implements View.OnClickListener
{
  ActiveEntitySearchActivity$4(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.4
 * JD-Core Version:    0.7.0.1
 */