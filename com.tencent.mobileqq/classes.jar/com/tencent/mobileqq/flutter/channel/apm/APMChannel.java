package com.tencent.mobileqq.flutter.channel.apm;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class APMChannel
  extends BaseMethodChannel
{
  public String a()
  {
    return "com.tencent.qflutter/apm";
  }
  
  public MethodCodec b()
  {
    return APMChannelHandler.b;
  }
  
  public MethodChannel.MethodCallHandler c()
  {
    return new APMChannel.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.apm.APMChannel
 * JD-Core Version:    0.7.0.1
 */