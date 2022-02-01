package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PlayOperationViewModel$11
  implements View.OnClickListener
{
  PlayOperationViewModel$11(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onClick(View paramView)
  {
    this.a.h(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.11
 * JD-Core Version:    0.7.0.1
 */