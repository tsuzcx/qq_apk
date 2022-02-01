package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FilePreviewActivity$5
  implements View.OnClickListener
{
  FilePreviewActivity$5(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    FilePreviewActivity.a(this.a, TeamWorkConvertUtils.a(this.a.app, FilePreviewActivity.a(this.a), this.a, "<FileAssistant>FilePreviewActivity", this.a.getString(2131719819), false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.5
 * JD-Core Version:    0.7.0.1
 */