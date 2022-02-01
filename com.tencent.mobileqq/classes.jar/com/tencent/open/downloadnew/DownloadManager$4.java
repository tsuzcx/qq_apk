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
    Object localObject = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    if (localObject != null) {
      localObject = ((SimpleAccount)localObject).getUin();
    } else {
      localObject = "";
    }
    if (!bool)
    {
      LogUtility.c("DownloadManager_", "getUpdateApp will do full report");
      AppReport.a(localContext, null, null, (String)localObject, true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localContext.getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("appcenter_app_report_storage_file.txt");
    if (new File(localStringBuilder.toString()).exists())
    {
      LogUtility.c("DownloadManager_", "getUpdateApp will do incremental report");
      AppReport.a(localContext, null, 0, null, null, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.4
 * JD-Core Version:    0.7.0.1
 */