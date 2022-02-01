package com.tencent.open;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class OpenSdkQIPCClient$3
  extends BroadcastReceiver
{
  OpenSdkQIPCClient$3(OpenSdkQIPCClient paramOpenSdkQIPCClient) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      SSOLog.a("OpenSdkQIPCClient", new Object[] { "mPuzzleVerifyCodeReceiver onReceive null == oldIntent" });
      return;
    }
    SSOLog.a("OpenSdkQIPCClient", new Object[] { "mPuzzleVerifyCodeReceiver onReceive" });
    AuthorityUtil.a(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCClient.3
 * JD-Core Version:    0.7.0.1
 */