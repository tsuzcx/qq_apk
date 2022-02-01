package com.tencent.mobileqq.flutter.channel.expand.chat;

import android.os.Handler;
import com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel.MethodChannelResultWrapper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ExpandChatApiChannel$6
  implements EIPCResultCallback
{
  ExpandChatApiChannel$6(ExpandChatApiChannel paramExpandChatApiChannel, ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ExpandChatApiChannel.a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandChatExpandChatApiChannel).post(new ExpandChatApiChannel.6.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatApiChannel.6
 * JD-Core Version:    0.7.0.1
 */