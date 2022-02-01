package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Handler;
import android.os.Looper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExpandPushChannel$2
  implements IExpandChannelCallback
{
  ExpandPushChannel$2(ExpandPushChannel paramExpandPushChannel, ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper) {}
  
  public void error(@NotNull String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    new Handler(Looper.myLooper()).post(new ExpandPushChannel.2.2(this, paramString1, paramString2, paramObject));
  }
  
  public void notImplemented()
  {
    new Handler(Looper.myLooper()).post(new ExpandPushChannel.2.3(this));
  }
  
  public void success(@Nullable Object paramObject)
  {
    new Handler(Looper.myLooper()).post(new ExpandPushChannel.2.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandPushChannel.2
 * JD-Core Version:    0.7.0.1
 */