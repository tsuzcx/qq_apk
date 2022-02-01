package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$2
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$2(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[METHOD_SET_AB_TEST_PLAN] result=" + paramEIPCResult.isSuccess());
    }
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.2.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.2
 * JD-Core Version:    0.7.0.1
 */