package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class SCFChannel
  extends BaseMethodChannel
{
  public String a()
  {
    return "com.tencent.qflutter/scfsetting";
  }
  
  public MethodCodec b()
  {
    return SCFSettingChannelHandler.b;
  }
  
  public MethodChannel.MethodCallHandler c()
  {
    return new SCFChannel.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel
 * JD-Core Version:    0.7.0.1
 */