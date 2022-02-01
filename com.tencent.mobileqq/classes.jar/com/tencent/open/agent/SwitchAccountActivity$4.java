package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwitchAccountActivity$4
  implements View.OnClickListener
{
  SwitchAccountActivity$4(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onClick(View paramView)
  {
    SwitchAccountActivity.access$300(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.4
 * JD-Core Version:    0.7.0.1
 */