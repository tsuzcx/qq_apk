package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwitchAccountActivity$2
  implements View.OnClickListener
{
  SwitchAccountActivity$2(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onClick(View paramView)
  {
    View localView = (View)paramView.getParent().getParent();
    if ((localView != null) && (localView.getTag() != null)) {
      SwitchAccountActivity.access$400(this.a, (String)localView.getTag());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */