package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$5
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$5(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    long l = paramEIPCResult.data.getLong("birthdate", 0L);
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("[METHOD_GET_BIRTH_DATE] result=");
      paramEIPCResult.append(l);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, paramEIPCResult.toString());
    }
    this.a.success(Long.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.5
 * JD-Core Version:    0.7.0.1
 */