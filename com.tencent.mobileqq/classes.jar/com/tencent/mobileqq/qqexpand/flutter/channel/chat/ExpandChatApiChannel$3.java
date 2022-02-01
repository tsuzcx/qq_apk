package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Handler;
import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel.MethodChannelResultWrapper;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExpandChatApiChannel$3
  implements IExpandChannelCallback
{
  ExpandChatApiChannel$3(ExpandChatApiChannel paramExpandChatApiChannel, ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper) {}
  
  public void error(@NotNull String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    ExpandChatApiChannel.a(this.b).post(new ExpandChatApiChannel.3.2(this, paramString1, paramString2, paramObject));
  }
  
  public void notImplemented()
  {
    ExpandChatApiChannel.a(this.b).post(new ExpandChatApiChannel.3.1(this));
  }
  
  public void success(@Nullable Object paramObject)
  {
    ExpandChatApiChannel.a(this.b, this.a, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatApiChannel.3
 * JD-Core Version:    0.7.0.1
 */