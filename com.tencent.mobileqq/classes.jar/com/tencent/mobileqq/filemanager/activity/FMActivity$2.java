package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FMActivity$2
  implements View.OnClickListener
{
  FMActivity$2(FMActivity paramFMActivity) {}
  
  public void onClick(View paramView)
  {
    FMActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.2
 * JD-Core Version:    0.7.0.1
 */