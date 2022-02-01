package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Bundle;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ExpandChatApiChannel$3
  implements EIPCResultCallback
{
  ExpandChatApiChannel$3(ExpandChatApiChannel paramExpandChatApiChannel, ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data.getString("response");
      ExpandChatApiChannel.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatApiChannel, this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandExpandBaseChannel$MethodChannelResultWrapper, paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel.3
 * JD-Core Version:    0.7.0.1
 */