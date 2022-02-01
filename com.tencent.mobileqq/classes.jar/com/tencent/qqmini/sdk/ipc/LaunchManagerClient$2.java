package com.tencent.qqmini.sdk.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerClient$2
  implements ServiceConnection
{
  LaunchManagerClient$2(LaunchManagerClient paramLaunchManagerClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LaunchManagerClient.access$202(this.this$0, ILaunchManager.Stub.asInterface(paramIBinder));
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceConnected:" + LaunchManagerClient.access$200(this.this$0));
    LaunchManagerClient.access$302(this.this$0, false);
    LaunchManagerClient.access$400(this.this$0);
    LaunchManagerClient.access$500(this.this$0);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    LaunchManagerClient.access$202(this.this$0, null);
    QMLog.w("minisdk-start_AppBrandProxy", "onServiceDisconnected.");
    LaunchManagerClient.access$302(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.2
 * JD-Core Version:    0.7.0.1
 */