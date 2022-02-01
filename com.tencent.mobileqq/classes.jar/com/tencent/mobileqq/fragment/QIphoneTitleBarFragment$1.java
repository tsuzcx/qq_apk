package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QIphoneTitleBarFragment$1
  implements View.OnClickListener
{
  QIphoneTitleBarFragment$1(QIphoneTitleBarFragment paramQIphoneTitleBarFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QIphoneTitleBarFragment.1
 * JD-Core Version:    0.7.0.1
 */