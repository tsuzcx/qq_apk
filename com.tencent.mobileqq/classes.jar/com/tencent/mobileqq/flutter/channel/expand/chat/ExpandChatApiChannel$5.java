package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ExpandChatApiChannel$5
  implements EIPCResultCallback
{
  ExpandChatApiChannel$5(ExpandChatApiChannel paramExpandChatApiChannel, ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data;
      ExpandChatApiChannel.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatApiChannel, this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandExpandBaseChannel$MethodChannelResultWrapper, paramEIPCResult.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel.5
 * JD-Core Version:    0.7.0.1
 */