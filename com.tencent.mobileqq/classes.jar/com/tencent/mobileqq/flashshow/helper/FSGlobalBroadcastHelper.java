package com.tencent.mobileqq.flashshow.helper;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.qphone.base.util.QLog;

public class FSGlobalBroadcastHelper
{
  private static volatile FSGlobalBroadcastHelper a;
  private final FSGlobalBroadcastHelper.FSGlobalBroadcastReceiver b = new FSGlobalBroadcastHelper.FSGlobalBroadcastReceiver(this);
  
  public static FSGlobalBroadcastHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSGlobalBroadcastHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    int i = paramIntent.getIntExtra("followState", -1);
    if (i == -1)
    {
      QLog.i("FSGlobalBroadcastHelper", 1, "updateNativeUserFollowState followState is null");
      return;
    }
    FSDataCenter.a().a(str, i);
  }
  
  public void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_update_native_user_follow_state");
      FSApplication.APP.registerReceiver(this.b, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGlobalBroadcastHelper
 * JD-Core Version:    0.7.0.1
 */