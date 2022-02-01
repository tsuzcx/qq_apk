package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$1
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$1(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("ret");
    if (QLog.isColorLevel()) {
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST] result=" + paramEIPCResult);
    }
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.1.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.1
 * JD-Core Version:    0.7.0.1
 */