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
    boolean bool;
    if ((paramIntent != null) && (paramIntent.getAction() != null) && (paramIntent.getAction().equals("action.qq.miniapp.show.monitorview")))
    {
      bool = paramIntent.getBooleanExtra("show", true);
      paramIntent = new StringBuilder().append("onReceive action action.qq.miniapp.show.monitorview, ");
      if (!bool) {
        break label89;
      }
    }
    label89:
    for (paramContext = "show";; paramContext = "hide")
    {
      QMLog.d("minisdk-start-AppBrandPageContainer", paramContext + " monitor view!");
      if (AppBrandPageContainer.access$400(this.this$0) != bool) {
        this.this$0.toggleMonitorPanel();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */