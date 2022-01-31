package com.tencent.mobileqq.mini.appbrand.page;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class AppBrandPage$MonitorBroadcastReceiver
  extends BroadcastReceiver
{
  AppBrandPage$MonitorBroadcastReceiver(AppBrandPage paramAppBrandPage) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
    {
      bool = paramIntent.getBooleanExtra("show", true);
      paramIntent = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (paramContext = "show";; paramContext = "hide")
    {
      QLog.d("AppBrandPage", 1, paramContext + " monitor view!");
      if (AppBrandPage.access$000(this.this$0) != bool) {
        AppBrandPage.access$002(this.this$0, this.this$0.clickMonitorPanel());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPage.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */