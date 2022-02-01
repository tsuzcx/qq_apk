package com.tencent.mobileqq.qqexpand.flutter.channel;

import android.os.Handler;
import io.flutter.plugin.common.MethodChannel.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ExpandConfigChannelHandler$1
  implements IExpandChannelCallback
{
  ExpandConfigChannelHandler$1(ExpandConfigChannelHandler paramExpandConfigChannelHandler, MethodChannel.Result paramResult) {}
  
  public void error(@NotNull String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.1.2(this, paramString1, paramString2, paramObject));
  }
  
  public void notImplemented()
  {
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.1.1(this));
  }
  
  public void success(@Nullable Object paramObject)
  {
    ExpandConfigChannelHandler.a().post(new ExpandConfigChannelHandler.1.3(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannelHandler.1
 * JD-Core Version:    0.7.0.1
 */