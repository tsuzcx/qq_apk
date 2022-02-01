package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenCardContainer$1
  implements View.OnClickListener
{
  OpenCardContainer$1(OpenCardContainer paramOpenCardContainer) {}
  
  public void onClick(View paramView)
  {
    this.a.k.setMainAccountSelect(true);
    this.a.l.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.1
 * JD-Core Version:    0.7.0.1
 */