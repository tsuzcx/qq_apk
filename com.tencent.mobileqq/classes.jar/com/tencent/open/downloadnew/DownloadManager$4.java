package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.SharedPreferences;
import bcyb;
import bdii;
import bdjs;
import bdle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.File;

public class DownloadManager$4
  implements Runnable
{
  public DownloadManager$4(bdle parambdle) {}
  
  public void run()
  {
    Context localContext = bcyb.a().a();
    boolean bool = localContext.getSharedPreferences("appcenter_app_report", 0).getBoolean("is_app_last_fullReport_success", false);
    SimpleAccount localSimpleAccount = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
    String str = "";
    if (localSimpleAccount != null) {
      str = localSimpleAccount.getUin();
    }
    if (!bool)
    {
      bdii.c("DownloadManager_", "getUpdateApp will do full report");
      bdjs.a(localContext, null, null, str, true);
    }
    while (!new File(localContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists()) {
      return;
    }
    bdii.c("DownloadManager_", "getUpdateApp will do incremental report");
    bdjs.a(localContext, null, 0, null, null, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.4
 * JD-Core Version:    0.7.0.1
 */