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
    this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.h();
    ApkFileDownloadButton.a(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton, this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    AppCenterReporter.b(ClickDataBuilder.a().a("400").k(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.a).j("5").l(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.c).m(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.d).a(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.h).b(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.f).g(this.jdField_a_of_type_ComTencentOpenFiledownloadUiApkFileDownloadButton.a.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton.5
 * JD-Core Version:    0.7.0.1
 */