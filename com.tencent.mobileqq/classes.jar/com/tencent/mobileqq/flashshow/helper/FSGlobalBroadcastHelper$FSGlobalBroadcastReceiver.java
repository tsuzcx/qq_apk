package com.tencent.mobileqq.flashshow.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

public class FSGlobalBroadcastHelper$FSGlobalBroadcastReceiver
  extends BroadcastReceiver
{
  public FSGlobalBroadcastHelper$FSGlobalBroadcastReceiver(FSGlobalBroadcastHelper paramFSGlobalBroadcastHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive action");
    localStringBuilder.append(paramContext);
    QLog.d("FSGlobalBroadcastHelper", 1, localStringBuilder.toString());
    int i;
    if ((paramContext.hashCode() == 332846332) && (paramContext.equals("action_update_native_user_follow_state"))) {
      i = 0;
    } else {
      i = -1;
    }
    if (i != 0) {
      return;
    }
    FSGlobalBroadcastHelper.a(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGlobalBroadcastHelper.FSGlobalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */