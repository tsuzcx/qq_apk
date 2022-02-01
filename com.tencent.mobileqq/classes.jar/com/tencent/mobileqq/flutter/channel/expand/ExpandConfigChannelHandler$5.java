package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Handler;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$5
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$5(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.5.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.5
 * JD-Core Version:    0.7.0.1
 */