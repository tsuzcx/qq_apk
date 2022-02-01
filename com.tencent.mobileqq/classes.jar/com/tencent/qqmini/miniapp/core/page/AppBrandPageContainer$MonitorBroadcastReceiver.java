package com.tencent.qqmini.miniapp.core.page;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class AppBrandPageContainer$MonitorBroadcastReceiver
  extends BroadcastReceiver
{
  AppBrandPageContainer$MonitorBroadcastReceiver(AppBrandPageContainer paramAppBrandPageContainer) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
    {
      paramContext = "show";
      boolean bool = paramIntent.getBooleanExtra("show", true);
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive action action.qq.miniapp.show.monitorview, ");
      if (!bool) {
        paramContext = "hide";
      }
      paramIntent.append(paramContext);
      paramIntent.append(" monitor view!");
      QMLog.d("minisdk-start-AppBrandPageContainer", paramIntent.toString());
      if (AppBrandPageContainer.access$500(this.this$0) != bool) {
        this.this$0.toggleMonitorPanel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */