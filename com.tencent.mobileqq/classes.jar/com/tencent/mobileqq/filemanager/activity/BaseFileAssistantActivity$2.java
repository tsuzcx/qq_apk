package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseFileAssistantActivity$2
  implements View.OnClickListener
{
  BaseFileAssistantActivity$2(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.i();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity.2
 * JD-Core Version:    0.7.0.1
 */