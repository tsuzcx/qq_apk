package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$2
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$2(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("ret");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST] result=");
      localStringBuilder.append(paramEIPCResult);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
    }
    this.a.success(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.2
 * JD-Core Version:    0.7.0.1
 */