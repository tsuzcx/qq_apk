package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileAssistantActivity$4
  implements View.OnClickListener
{
  FileAssistantActivity$4(FileAssistantActivity paramFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    FileAssistantActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.4
 * JD-Core Version:    0.7.0.1
 */