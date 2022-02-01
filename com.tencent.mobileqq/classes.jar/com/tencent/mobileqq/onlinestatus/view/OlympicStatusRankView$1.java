package com.tencent.mobileqq.onlinestatus.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OlympicStatusRankView$1
  implements View.OnClickListener
{
  OlympicStatusRankView$1(OlympicStatusRankView paramOlympicStatusRankView) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OlympicStatusRankView.1
 * JD-Core Version:    0.7.0.1
 */