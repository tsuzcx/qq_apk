package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$3
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$3(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = paramEIPCResult.data.getBoolean("sp_match_switch_type");
    if (QLog.isColorLevel()) {
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[METHOD_GET_STAY_MATCH_FLAG] result=" + bool);
    }
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.3.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.3
 * JD-Core Version:    0.7.0.1
 */