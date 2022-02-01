package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$7
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$7(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set quiet mode : ");
    localStringBuilder.append(paramEIPCResult);
    QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("set quiet mode : ");
      localStringBuilder.append(paramEIPCResult.getString("data"));
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
      this.a.success(Boolean.valueOf(paramEIPCResult.getBoolean("data")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.7
 * JD-Core Version:    0.7.0.1
 */