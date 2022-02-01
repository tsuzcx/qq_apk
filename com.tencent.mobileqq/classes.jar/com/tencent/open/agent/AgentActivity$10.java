package com.tencent.open.agent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class AgentActivity$10
  extends BroadcastReceiver
{
  AgentActivity$10(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("SDK_LOGIN.AgentActivity", 1, "mPuzzleVerifyCodeReceiver onReceive");
    AuthorityUtil.a(paramIntent, paramContext);
    this.a.unregisterReceiver(AgentActivity.a(this.a));
    AgentActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.10
 * JD-Core Version:    0.7.0.1
 */