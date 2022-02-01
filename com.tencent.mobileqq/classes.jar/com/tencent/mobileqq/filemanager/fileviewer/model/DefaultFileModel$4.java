package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DefaultFileModel$4
  implements View.OnClickListener
{
  DefaultFileModel$4(DefaultFileModel paramDefaultFileModel) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.a, this.a.d());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.4
 * JD-Core Version:    0.7.0.1
 */