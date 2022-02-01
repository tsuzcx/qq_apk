package com.tencent.mobileqq.flutter.channel.expand;

import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodCodec;

public class ExpandConfigChannel
  extends ExpandBaseChannel
{
  public MethodCodec a()
  {
    return ExpandConfigChannelHandler.a;
  }
  
  public String a()
  {
    return "com.tencent.qflutter/expand/method.config";
  }
  
  public void a()
  {
    super.a();
  }
  
  protected void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper)
  {
    new ExpandConfigChannelHandler().onMethodCall(paramMethodCall, paramMethodChannelResultWrapper);
  }
  
  protected String c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandConfigChannel
 * JD-Core Version:    0.7.0.1
 */