package com.tencent.mobileqq.conditionsearch;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationSelectActivity$1
  implements View.OnClickListener
{
  LocationSelectActivity$1(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.1
 * JD-Core Version:    0.7.0.1
 */