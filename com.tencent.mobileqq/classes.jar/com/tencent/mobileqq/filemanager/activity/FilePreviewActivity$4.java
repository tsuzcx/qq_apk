package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FilePreviewActivity$4
  implements View.OnClickListener
{
  FilePreviewActivity$4(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "dc00898", "", "", "0X8009065", "0X8009065", 0, 0, "", "", "", "");
    FilePreviewActivity localFilePreviewActivity1 = this.a;
    QQAppInterface localQQAppInterface = localFilePreviewActivity1.app;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = FilePreviewActivity.a(this.a);
    FilePreviewActivity localFilePreviewActivity2 = this.a;
    FilePreviewActivity.a(localFilePreviewActivity1, TeamWorkConvertUtils.a(localQQAppInterface, localTeamWorkFileImportInfo, localFilePreviewActivity2, "<FileAssistant>FilePreviewActivity", localFilePreviewActivity2.getString(2131719542), true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */