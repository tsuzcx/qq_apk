package com.tencent.mobileqq.qqexpand.flutter.channel;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodCodec;

public class ExpandConfigChannel
  extends ExpandBaseChannel
{
  public String a()
  {
    return "com.tencent.qflutter/expand/method.config";
  }
  
  protected void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    new ExpandConfigChannelHandler().onMethodCall(paramMethodCall, paramMethodChannelResultWrapper);
  }
  
  public MethodCodec b()
  {
    return ExpandConfigChannelHandler.a;
  }
  
  public void f()
  {
    super.f();
  }
  
  protected String g()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandConfigChannel
 * JD-Core Version:    0.7.0.1
 */