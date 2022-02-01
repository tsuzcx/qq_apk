package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper;
import eipc.EIPCResult;

class ExpandChatApiChannel$6$1
  implements Runnable
{
  ExpandChatApiChannel$6$1(ExpandChatApiChannel.6 param6, EIPCResult paramEIPCResult) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_EipcEIPCResult != null) && (this.jdField_a_of_type_EipcEIPCResult.data != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatApiChannel$6.a.success(this.jdField_a_of_type_EipcEIPCResult.data.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel.6.1
 * JD-Core Version:    0.7.0.1
 */