package com.tencent.mobileqq.qqexpand.flutter.channel;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$3
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$3(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[METHOD_SET_AB_TEST_PLAN] result=");
      localStringBuilder.append(paramEIPCResult.isSuccess());
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
    }
    this.a.success(Boolean.valueOf(paramEIPCResult.isSuccess()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.3
 * JD-Core Version:    0.7.0.1
 */