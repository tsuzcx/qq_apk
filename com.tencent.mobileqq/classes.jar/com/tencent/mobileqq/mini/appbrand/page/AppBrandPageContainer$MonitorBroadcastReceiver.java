package com.tencent.mobileqq.mini.appbrand.page;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.qphone.base.util.QLog;

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
        break label120;
      }
    }
    label120:
    for (paramContext = "show";; paramContext = "hide")
    {
      QLog.d("AppBrandPageContainer", 1, paramContext + " monitor view!");
      if (AppBrandPageContainer.access$000(this.this$0) != bool)
      {
        AppBrandPageContainer.access$002(this.this$0, this.this$0.clickMonitorPanel());
        this.this$0.getCurrentPage().getNavBar().getCapsuleButton().setIsOpenMonitorPanel(AppBrandPageContainer.access$000(this.this$0));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer.MonitorBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */