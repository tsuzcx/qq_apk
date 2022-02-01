package com.tencent.mobileqq.flashshow.list.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FSDefaultMessagePresenter$2
  implements View.OnClickListener
{
  FSDefaultMessagePresenter$2(FSDefaultMessagePresenter paramFSDefaultMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSDefaultMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */