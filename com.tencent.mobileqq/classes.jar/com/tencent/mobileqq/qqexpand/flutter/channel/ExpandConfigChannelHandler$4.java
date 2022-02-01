package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandConfigChannelHandler$4
  implements EIPCResultCallback
{
  ExpandConfigChannelHandler$4(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = paramEIPCResult.data.getBoolean("sp_match_switch_type");
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("[METHOD_GET_STAY_MATCH_FLAG] result=");
      paramEIPCResult.append(bool);
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, paramEIPCResult.toString());
    }
    this.a.success(Boolean.valueOf(bool ^ true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.4
 * JD-Core Version:    0.7.0.1
 */