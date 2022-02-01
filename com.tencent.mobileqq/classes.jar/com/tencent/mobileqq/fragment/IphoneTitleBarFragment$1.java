package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IphoneTitleBarFragment$1
  implements View.OnClickListener
{
  IphoneTitleBarFragment$1(IphoneTitleBarFragment paramIphoneTitleBarFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.IphoneTitleBarFragment.1
 * JD-Core Version:    0.7.0.1
 */