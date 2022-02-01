package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.appreport.AppReport;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.File;

class DownloadManager$4
  implements Runnable
{
  DownloadManager$4(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    Context localContext = CommonDataAdapter.a().a();
    boolean bool = localContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false);
    SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    String str = "";
    if (localSimpleAccount != null) {
      str = localSimpleAccount.getUin();
    }
    if (!bool)
    {
      LogUtility.c("DownloadManager_", "getUpdateApp will do full report");
      AppReport.a(localContext, null, null, str, true);
    }
    while (!new File(localContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists()) {
      return;
    }
    LogUtility.c("DownloadManager_", "getUpdateApp will do incremental report");
    AppReport.a(localContext, null, 0, null, null, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.4
 * JD-Core Version:    0.7.0.1
 */