package com.tencent.mobileqq.flutter.channel.expand;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import io.flutter.plugin.common.MethodChannel.Result;

class ExpandConfigChannelHandler$5$1
  implements Runnable
{
  ExpandConfigChannelHandler$5$1(ExpandConfigChannelHandler.5 param5, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_EipcEIPCResult != null) && (this.jdField_a_of_type_EipcEIPCResult.isSuccess()))
    {
      Bundle localBundle = this.jdField_a_of_type_EipcEIPCResult.data;
      QLog.d("expand.flutter.expandConfigChannelHandler", 2, "security info : " + localBundle.getString("data"));
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandExpandConfigChannelHandler$5.a.success(localBundle.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannelHandler.5.1
 * JD-Core Version:    0.7.0.1
 */