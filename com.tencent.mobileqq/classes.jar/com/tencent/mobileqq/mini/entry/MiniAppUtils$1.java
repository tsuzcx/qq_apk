package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$1
  implements View.OnClickListener
{
  MiniAppUtils$1(int paramInt, MiniAppInfo paramMiniAppInfo) {}
  
  public void onClick(View paramView)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.scene = this.val$scene;
    try
    {
      MiniAppController.launchMiniAppByAppInfo((Activity)paramView.getContext(), this.val$info, localLaunchParam);
      if (this.val$scene == 3008) {
        MiniProgramLpReportDC04239.reportAsync("desktop", "featured", "click", null);
      }
      return;
    }
    catch (MiniAppException paramView)
    {
      for (;;)
      {
        QLog.e("MiniAppUtils", 1, "setJump failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.1
 * JD-Core Version:    0.7.0.1
 */