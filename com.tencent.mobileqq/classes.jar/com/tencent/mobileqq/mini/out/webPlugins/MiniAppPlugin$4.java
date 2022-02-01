package com.tencent.mobileqq.mini.out.webPlugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class MiniAppPlugin$4
  implements View.OnClickListener
{
  MiniAppPlugin$4(MiniAppPlugin paramMiniAppPlugin, MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void onClick(View paramView)
  {
    MiniProgramLpReportDC04239.reportAsync(this.val$appConfig, "urlapp", "bottom", "cancel", this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin.4
 * JD-Core Version:    0.7.0.1
 */