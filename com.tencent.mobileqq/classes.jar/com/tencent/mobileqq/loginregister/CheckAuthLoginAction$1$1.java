package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.AuthCodeWriter;
import com.tencent.open.appcenter.OpenWriteCodeQQBrowserActivity;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.qphone.base.util.BaseApplication;

class CheckAuthLoginAction$1$1
  implements Runnable
{
  CheckAuthLoginAction$1$1(CheckAuthLoginAction.1 param1) {}
  
  public void run()
  {
    int k = ApkUtils.a(BaseApplication.getContext(), "com.tencent.android.qqdownloader");
    int j = 0;
    int i = 0;
    Intent localIntent;
    if (k > 0)
    {
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.a.b));
      i = j;
    }
    try
    {
      this.a.a.startActivity(localIntent);
      i = 1;
      j = 1;
      ReportController.a(this.a.a.getAppRuntime(), "dc00898", "", "", "0X8006798", "0X8006798", 0, 0, "", "", "", "");
      i = j;
    }
    catch (Exception localException)
    {
      label100:
      break label100;
    }
    if (i == 0)
    {
      ReportController.a(this.a.a.getAppRuntime(), "dc00898", "", "", "0X8006799", "0X8006799", 0, 0, "", "", "", "");
      localIntent = new Intent(this.a.a, OpenWriteCodeQQBrowserActivity.class);
      localIntent.putExtra("url", this.a.c);
      DownloadApi.a(new AuthCodeWriter(this.a.d, null));
      this.a.a.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.CheckAuthLoginAction.1.1
 * JD-Core Version:    0.7.0.1
 */