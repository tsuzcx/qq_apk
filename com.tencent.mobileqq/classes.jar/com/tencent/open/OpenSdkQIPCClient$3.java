package com.tencent.open;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;

class OpenSdkQIPCClient$3
  extends BroadcastReceiver
{
  OpenSdkQIPCClient$3(OpenSdkQIPCClient paramOpenSdkQIPCClient) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "mPuzzleVerifyCodeReceiver onReceive null == oldIntent");
      return;
    }
    QLog.d("Q.quicklogin.OpenSdkQIPCClient", 1, "mPuzzleVerifyCodeReceiver onReceive");
    AuthorityUtil.a(paramIntent, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCClient.3
 * JD-Core Version:    0.7.0.1
 */