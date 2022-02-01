package com.tencent.mobileqq.qwallet.utils.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.qphone.base.util.QLog;

class ArkPubicEventWrapImpl$VolumeReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("--VolumeReceiver---");
      paramContext.append(paramIntent.getAction());
      QLog.i("ArkPubicEventWrap", 2, paramContext.toString());
    }
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).callbackMuteStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */