package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$6
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$6(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("security info : ");
      localStringBuilder.append(paramEIPCResult.getString("data"));
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, localStringBuilder.toString());
      this.a.success(paramEIPCResult.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.6
 * JD-Core Version:    0.7.0.1
 */