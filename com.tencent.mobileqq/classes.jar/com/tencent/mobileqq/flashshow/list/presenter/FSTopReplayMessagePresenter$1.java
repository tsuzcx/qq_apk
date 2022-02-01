package com.tencent.mobileqq.flashshow.list.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSTopReplayMessagePresenter$1
  implements View.OnClickListener
{
  FSTopReplayMessagePresenter$1(FSTopReplayMessagePresenter paramFSTopReplayMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSTopReplayMessagePresenter.1
 * JD-Core Version:    0.7.0.1
 */