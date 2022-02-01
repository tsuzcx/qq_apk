package com.tencent.mobileqq.search.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MixSearchWebFragment$4
  implements View.OnClickListener
{
  MixSearchWebFragment$4(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(3);
    this.a.doOnBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment.4
 * JD-Core Version:    0.7.0.1
 */