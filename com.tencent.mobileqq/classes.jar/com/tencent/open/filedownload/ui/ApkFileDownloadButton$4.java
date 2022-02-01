package com.tencent.open.filedownload.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.open.filedownload.TaskInfo;

class ApkFileDownloadButton$4
  implements DialogInterface.OnClickListener
{
  ApkFileDownloadButton$4(ApkFileDownloadButton paramApkFileDownloadButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.b(false, true);
    paramDialogInterface.dismiss();
    AppCenterReporter.b(ClickDataBuilder.a().a("203").k(this.a.a.a).j("5").l(this.a.a.c).m(this.a.a.d).a(this.a.a.h).b(this.a.a.f).g(this.a.a.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton.4
 * JD-Core Version:    0.7.0.1
 */