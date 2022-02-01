package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Bundle;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandChatApiChannel$6
  implements EIPCResultCallback
{
  ExpandChatApiChannel$6(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      paramEIPCResult = paramEIPCResult.data;
      this.a.success(paramEIPCResult.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel.6
 * JD-Core Version:    0.7.0.1
 */