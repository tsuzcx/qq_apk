package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BindGroupFragment$1
  implements View.OnClickListener
{
  BindGroupFragment$1(BindGroupFragment paramBindGroupFragment) {}
  
  public void onClick(View paramView)
  {
    BindGroupFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupFragment.1
 * JD-Core Version:    0.7.0.1
 */