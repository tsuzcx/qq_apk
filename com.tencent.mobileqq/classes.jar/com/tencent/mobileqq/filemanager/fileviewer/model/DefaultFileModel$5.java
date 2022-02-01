package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DefaultFileModel$5
  implements View.OnClickListener
{
  DefaultFileModel$5(DefaultFileModel paramDefaultFileModel) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.a, this.a.d());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel.5
 * JD-Core Version:    0.7.0.1
 */