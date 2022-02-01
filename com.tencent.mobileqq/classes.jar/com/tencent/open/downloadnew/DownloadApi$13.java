package com.tencent.open.downloadnew;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.appcircle.st.AppCircleReportManager;

final class DownloadApi$13
  implements DialogInterface.OnClickListener
{
  DownloadApi$13(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DownloadApi.a(this.a, this.b, this.c);
    ReportController.b(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append(this.a.getString(DownloadConstants.f));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.a.getString(DownloadConstants.c));
    paramDialogInterface.append("_");
    paramDialogInterface.append(this.a.getString(DownloadConstants.d));
    paramDialogInterface = paramDialogInterface.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis() / 1000L);
    localStringBuilder.append("|");
    localStringBuilder.append(101);
    localStringBuilder.append("|");
    localStringBuilder.append(paramDialogInterface);
    paramDialogInterface = localStringBuilder.toString();
    AppCircleReportManager.a().a(25, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.13
 * JD-Core Version:    0.7.0.1
 */