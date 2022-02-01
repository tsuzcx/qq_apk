package com.tencent.mobileqq.emosm.web;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class MessengerService$IncomingHandler$5
  extends BroadcastReceiver
{
  MessengerService$IncomingHandler$5(MessengerService.IncomingHandler paramIncomingHandler, MessengerService paramMessengerService, Bundle paramBundle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (!TextUtils.isEmpty(paramContext))
    {
      if (!TextUtils.equals(paramContext, "mqq.intent.action.DEVLOCK_ROAM")) {
        return;
      }
      paramContext = this.a.getApplicationContext();
      if (paramContext != null) {
        paramContext.unregisterReceiver(this);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openDevLock unregisterReceiver context: ");
        localStringBuilder.append(paramContext);
        QLog.d("Q.emoji.web.MessengerService", 2, localStringBuilder.toString());
      }
      paramContext = new Bundle(paramIntent.getExtras());
      this.b.putBundle("response", paramContext);
      this.a.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.5
 * JD-Core Version:    0.7.0.1
 */