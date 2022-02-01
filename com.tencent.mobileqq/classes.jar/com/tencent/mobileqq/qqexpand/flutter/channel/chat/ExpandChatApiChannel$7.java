package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Bundle;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ExpandChatApiChannel$7
  implements EIPCResultCallback
{
  ExpandChatApiChannel$7(IExpandChannelCallback paramIExpandChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      this.a.success(paramEIPCResult.data.getString("data"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel.7
 * JD-Core Version:    0.7.0.1
 */