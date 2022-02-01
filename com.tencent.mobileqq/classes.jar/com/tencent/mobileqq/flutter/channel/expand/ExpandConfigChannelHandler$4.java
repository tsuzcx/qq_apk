package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$4
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$4(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    long l = paramEIPCResult.data.getLong("birthdate", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "[METHOD_GET_BIRTH_DATE] result=" + l);
    }
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.4.1(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.4
 * JD-Core Version:    0.7.0.1
 */