package com.tencent.mobileqq.upgrade;

import android.os.Handler;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class UpgradeTIMManager$DownloadTask
  implements AsyncBack, Runnable
{
  String a;
  String b;
  int c;
  boolean d;
  
  public UpgradeTIMManager$DownloadTask(UpgradeTIMManager paramUpgradeTIMManager, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private void a()
  {
    UpgradeTIMManager.d(this.this$0).postDelayed(new UpgradeTIMManager.DownloadTask.1(this), 3000L);
  }
  
  private void b()
  {
    if (!this.d)
    {
      ThreadManager.post(new UpgradeTIMManager.DownloadTask.2(this), 8, null, false);
      this.d = true;
    }
  }
  
  private void c()
  {
    if (this.d)
    {
      ThreadManager.post(this, 5, null, false);
      this.d = false;
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("UpgradeTIMManager", 2, new Object[] { "on download result, code=", Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      UpgradeTIMManager.e(this.this$0);
      return;
    }
    if (paramInt == 10)
    {
      paramInt = this.c;
      this.c = (paramInt + 1);
      if (paramInt < 3)
      {
        a();
        return;
      }
    }
    UpgradeTIMManager.a(this.this$0);
  }
  
  public void progress(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeTIMManager", 4, new Object[] { "downloading,  progress = ", Integer.valueOf(paramInt) });
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMManager", 2, "start download...");
    }
    if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeTIMManager", 2, "run download, wifi not connected...");
      }
      UpgradeTIMManager.a(this.this$0);
      return;
    }
    ReportController.b(UpgradeTIMManager.b(this.this$0), "CliOper", "", "", "0X8008A47", "0X8008A47", 0, 0, "", "", "", "");
    UpgradeTIMManager.c(this.this$0).a(BaseApplication.getContext(), this.a, this.b, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMManager.DownloadTask
 * JD-Core Version:    0.7.0.1
 */