package com.tencent.mobileqq.werewolves;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HalfScreenBrowserActivity$1
  implements View.OnClickListener
{
  HalfScreenBrowserActivity$1(HalfScreenBrowserActivity paramHalfScreenBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */