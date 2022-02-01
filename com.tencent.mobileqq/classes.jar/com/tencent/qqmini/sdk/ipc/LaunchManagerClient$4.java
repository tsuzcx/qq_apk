package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class LaunchManagerClient$4
  implements Runnable
{
  LaunchManagerClient$4(LaunchManagerClient paramLaunchManagerClient, Activity paramActivity, MiniAppInfo paramMiniAppInfo, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    LaunchManagerClient.access$600(this.this$0, this.val$activity, this.val$appConfig, this.val$bundle, this.val$resultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.4
 * JD-Core Version:    0.7.0.1
 */