package com.tencent.mobileqq.mini.entry;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$1
  implements View.OnClickListener
{
  MiniAppUtils$1(Activity paramActivity, MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    try
    {
      MiniAppDesktopAdapter.startMiniApp(this.val$activity, this.val$info, this.val$scene);
      if (this.val$scene == 3008) {
        MiniProgramLpReportDC04239.reportAsync("desktop", "featured", "click", null);
      }
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e("MiniAppUtils", 1, "setJump failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.1
 * JD-Core Version:    0.7.0.1
 */