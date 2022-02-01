package com.tencent.open.filedownload.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.appstore.report.ClickDataBuilder;
import com.tencent.open.appstore.report.ReportDataBuilder;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.filedownload.TaskInfo;

class ApkFileDownloadButton$5
  implements DialogInterface.OnClickListener
{
  ApkFileDownloadButton$5(ApkFileDownloadButton paramApkFileDownloadButton, DownloadInfo paramDownloadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.h();
    ApkFileDownloadButton.a(this.b, this.a);
    AppCenterReporter.b(ClickDataBuilder.a().a("400").l(this.b.c.a).k("5").m(this.b.c.c).n(this.b.c.d).b(this.b.c.i).c(this.b.c.f).h(this.b.c.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton.5
 * JD-Core Version:    0.7.0.1
 */