package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;

class PageWebview$2
  implements Runnable
{
  PageWebview$2(PageWebview paramPageWebview, String paramString) {}
  
  public void run()
  {
    try
    {
      String str1 = PageWebview.access$000(this.this$0).getBaseLibVersion();
      String str2 = PageWebview.access$000(this.this$0).getMiniAppInfo().appId;
      ((MiniAppRealTimeLogReporter)PageWebview.access$000(this.this$0).getManager(MiniAppRealTimeLogReporter.class)).flush(this.val$routeUrl, this.this$0.mPageWebviewId, str1, str2);
      return;
    }
    catch (Exception localException)
    {
      QMLog.d("PageWebview", "MiniAppRealTimeLogReporter flush failed,", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebview.2
 * JD-Core Version:    0.7.0.1
 */