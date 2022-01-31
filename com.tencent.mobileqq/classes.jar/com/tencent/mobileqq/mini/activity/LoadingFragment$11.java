package com.tencent.mobileqq.mini.activity;

import ajya;
import android.os.Handler;
import android.os.Message;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class LoadingFragment$11
  implements Runnable
{
  LoadingFragment$11(LoadingFragment paramLoadingFragment, Message paramMessage) {}
  
  public void run()
  {
    String str = null;
    try
    {
      MiniProgramLpReportDC04239.reportPageView(LoadingFragment.access$000(this.this$0), "0", null, "load_fail", "load_baselib_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "load_baselib_fail", null, LoadingFragment.access$000(this.this$0));
      if (this.val$msg.obj != null) {
        str = (String)this.val$msg.obj;
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (str != null) {}
      for (;;)
      {
        bcql.a(localBaseApplication, 1, str, 1).a();
        this.this$0.uiHandler.postDelayed(new LoadingFragment.11.1(this), 1000L);
        return;
        str = ajya.a(2131706244);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LoadingActivity", 1, "MSG_WHAT_BASELIB_LOAD_FAIL", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.LoadingFragment.11
 * JD-Core Version:    0.7.0.1
 */