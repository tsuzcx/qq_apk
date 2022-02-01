package com.tencent.qqconnect.wtlogin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class OpenSDKAppInterface$2
  extends BroadcastReceiver
{
  OpenSDKAppInterface$2(OpenSDKAppInterface paramOpenSDKAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("OpenSDKAppInterface", 2, "onReceive: invoked.  intent: " + paramIntent + " action: " + paramContext);
    }
    if ((paramContext != null) && (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED"))) {
      OpenSDKAppInterface.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.OpenSDKAppInterface.2
 * JD-Core Version:    0.7.0.1
 */