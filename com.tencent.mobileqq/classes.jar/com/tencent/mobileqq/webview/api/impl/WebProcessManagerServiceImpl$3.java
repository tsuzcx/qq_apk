package com.tencent.mobileqq.webview.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class WebProcessManagerServiceImpl$3
  extends BroadcastReceiver
{
  WebProcessManagerServiceImpl$3(WebProcessManagerServiceImpl paramWebProcessManagerServiceImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessStartServiceImpl", 2, "action=" + paramContext);
        }
        if (!paramContext.equals("com.tencent.mobileqq.webprocess.restart_web_process")) {
          break;
        }
        WebProcessManagerServiceImpl.access$100(this.a);
      } while (!paramIntent.getBooleanExtra("isPreloadWebProcess", false));
      WebProcessManagerServiceImpl.access$200(this.a);
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.webprocess.report"));
    WebProcessManagerServiceImpl.access$200(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */