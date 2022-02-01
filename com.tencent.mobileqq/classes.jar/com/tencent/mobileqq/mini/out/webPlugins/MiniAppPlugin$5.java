package com.tencent.mobileqq.mini.out.webPlugins;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.MiniAppController;

class MiniAppPlugin$5
  implements View.OnClickListener
{
  MiniAppPlugin$5(MiniAppPlugin paramMiniAppPlugin, Activity paramActivity, MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void onClick(View paramView)
  {
    MiniAppController.startApp(this.val$activity, this.val$appConfig, new MiniAppPlugin.5.1(this, new Handler()));
    MiniProgramLpReportDC04239.reportAsync(this.val$appConfig, "urlapp", "bottom", "confirm", this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.5
 * JD-Core Version:    0.7.0.1
 */