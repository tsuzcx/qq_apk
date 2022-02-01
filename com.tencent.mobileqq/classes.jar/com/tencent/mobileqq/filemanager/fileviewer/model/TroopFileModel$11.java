package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileModel$11
  implements View.OnClickListener
{
  TroopFileModel$11(TroopFileModel paramTroopFileModel) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.i, this.a.y());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.11
 * JD-Core Version:    0.7.0.1
 */