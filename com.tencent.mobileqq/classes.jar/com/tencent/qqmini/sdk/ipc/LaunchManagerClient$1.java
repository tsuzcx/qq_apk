package com.tencent.qqmini.sdk.ipc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class LaunchManagerClient$1
  implements Handler.Callback
{
  LaunchManagerClient$1(LaunchManagerClient paramLaunchManagerClient) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage.getData().setClassLoader(LaunchManagerClient.access$000(this.this$0).getClassLoader());
    MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramMessage.getData().getParcelable("KEY_APPINFO");
    ResultReceiver localResultReceiver = (ResultReceiver)paramMessage.getData().getParcelable("receiver");
    LaunchManagerClient.access$100(this.this$0, i, paramMessage.getData(), localMiniAppInfo, localResultReceiver);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ipc.LaunchManagerClient.1
 * JD-Core Version:    0.7.0.1
 */