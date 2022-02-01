package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener;

class AppUIProxy$4$1
  implements MiniLoadingAdLayout.OnDismissListener
{
  AppUIProxy$4$1(AppUIProxy.4 param4) {}
  
  public void onDismiss(boolean paramBoolean)
  {
    DisplayUtil.setSystemUIVisible(this.this$1.val$activity, true);
    if (paramBoolean) {
      MiniProgramLpReportDC04239.reportMiniAppEvent(this.this$1.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.this$1.val$miniAppConfig), null, "ad", "ad_loading", "skip", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AppUIProxy.4.1
 * JD-Core Version:    0.7.0.1
 */