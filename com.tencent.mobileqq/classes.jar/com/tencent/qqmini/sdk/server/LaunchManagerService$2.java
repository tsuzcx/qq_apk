package com.tencent.qqmini.sdk.server;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LaunchManagerService$2
  extends MiniCmdCallback.Stub
{
  LaunchManagerService$2(LaunchManagerService paramLaunchManagerService, ResultReceiver paramResultReceiver) {}
  
  public void onCmdResult(boolean paramBoolean, @NonNull Bundle paramBundle)
  {
    if (paramBoolean)
    {
      int i = paramBundle.getInt("retCode");
      ResultReceiver localResultReceiver = this.val$resultReceiver;
      if (localResultReceiver != null) {
        localResultReceiver.send(i, paramBundle);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("[preDownloadPkg] retCode=");
      paramBundle.append(i);
      QMLog.i("minisdk-start_LaunchManagerService", paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.LaunchManagerService.2
 * JD-Core Version:    0.7.0.1
 */