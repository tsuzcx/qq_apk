package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class GdtReporter
{
  public static final int REPORT_DEEP_LINK_SUCCESS = 137;
  public static final int REPORT_OPEN_MAIN_PAGE = 138;
  
  public static void doCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.executeOnNetworkIOThreadPool(new GdtCgiReportRunnable(paramString));
    QMLog.i("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.GdtReporter
 * JD-Core Version:    0.7.0.1
 */