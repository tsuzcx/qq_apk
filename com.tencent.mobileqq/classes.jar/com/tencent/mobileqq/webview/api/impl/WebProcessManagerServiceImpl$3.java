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
    if (paramContext == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action=");
      localStringBuilder.append(paramContext);
      QLog.d("WebProcessStartServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramContext.equals("com.tencent.mobileqq.webprocess.restart_web_process"))
    {
      WebProcessManagerServiceImpl.access$100(this.a);
      if (paramIntent.getBooleanExtra("isPreloadWebProcess", false)) {
        WebProcessManagerServiceImpl.access$200(this.a);
      }
    }
    else if (paramContext.equals("com.tencent.mobileqq.webprocess.report"))
    {
      WebProcessManagerServiceImpl.access$200(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.WebProcessManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */