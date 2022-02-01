package com.tencent.mobileqq.flutter.channel.apm;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class APMChannel
  extends BaseMethodChannel
{
  public MethodChannel.MethodCallHandler a()
  {
    return new APMChannel.1(this);
  }
  
  public MethodCodec a()
  {
    return APMChannelHandler.a;
  }
  
  public String a()
  {
    return "com.tencent.qflutter/apm";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.apm.APMChannel
 * JD-Core Version:    0.7.0.1
 */