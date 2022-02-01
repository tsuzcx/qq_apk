package com.tencent.mobileqq.mini.appbrand.page;

import android.content.SharedPreferences;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;

class PageWebview$5
  implements Runnable
{
  PageWebview$5(PageWebview paramPageWebview) {}
  
  public void run()
  {
    try
    {
      String str = StorageUtil.getPreference().getString("version", "1.19.0.00043");
      MiniAppRealTimeLogReporter.getInstance().flush(this.this$0.mRouteUrl, this.this$0.pageWebviewId, str, this.this$0.appBrandRuntime.appId);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(PageWebview.access$000(), 1, "MiniAppRealTimeLogReporter.flush failed,", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.PageWebview.5
 * JD-Core Version:    0.7.0.1
 */