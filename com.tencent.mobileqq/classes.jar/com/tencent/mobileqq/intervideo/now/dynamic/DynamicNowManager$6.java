package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.qphone.base.util.QLog;

class DynamicNowManager$6
  extends BroadcastReceiver
{
  DynamicNowManager$6(DynamicNowManager paramDynamicNowManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("mqq.intent.action.ACCOUNT_EXPIRED".equals(paramContext))
    {
      QLog.i("XProxy|NowProxy", 1, "accountReceiver, expired");
      NowLive.killPluginProcess();
      return;
    }
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      QLog.i("XProxy|NowProxy", 1, "accountReceiver, kicked");
      NowLive.killPluginProcess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.6
 * JD-Core Version:    0.7.0.1
 */