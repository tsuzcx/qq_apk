package com.tencent.mobileqq.flutter.channel;

import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public abstract class BaseMethodChannel
  extends BaseChannel
{
  public abstract MethodCodec b();
  
  public abstract MethodChannel.MethodCallHandler c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.BaseMethodChannel
 * JD-Core Version:    0.7.0.1
 */