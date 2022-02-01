package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandChatApiChannel$5
  implements EIPCResultCallback
{
  ExpandChatApiChannel$5(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    this.a.success(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel.5
 * JD-Core Version:    0.7.0.1
 */