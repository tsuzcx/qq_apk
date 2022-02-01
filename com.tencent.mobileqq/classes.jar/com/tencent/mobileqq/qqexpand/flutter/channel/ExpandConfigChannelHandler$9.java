package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$9
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$9(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      int i = paramEIPCResult.data.getInt("data");
      if (QLog.isColorLevel())
      {
        paramEIPCResult = new StringBuilder();
        paramEIPCResult.append("get network status channel : ");
        paramEIPCResult.append(i);
        QLog.d("expand.flutter.expandConfigChannelHandler", 2, paramEIPCResult.toString());
      }
      this.a.success(Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.9
 * JD-Core Version:    0.7.0.1
 */