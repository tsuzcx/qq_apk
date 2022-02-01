package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwitchAccountActivity$3
  implements View.OnClickListener
{
  SwitchAccountActivity$3(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if (!SwitchAccountActivity.access$500(this.a))
    {
      SwitchAccountActivity.access$602(this.a, (String)paramView.getTag());
      SwitchAccountActivity.access$700(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.3
 * JD-Core Version:    0.7.0.1
 */