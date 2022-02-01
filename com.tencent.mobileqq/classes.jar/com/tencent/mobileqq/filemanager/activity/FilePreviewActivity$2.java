package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FilePreviewActivity$2
  implements View.OnClickListener
{
  FilePreviewActivity$2(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, new Intent());
    this.a.finish();
    this.a.overridePendingTransition(2130771991, 2130771992);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */