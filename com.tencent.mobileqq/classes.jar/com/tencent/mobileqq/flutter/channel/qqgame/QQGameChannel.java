package com.tencent.mobileqq.flutter.channel.qqgame;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class QQGameChannel
  extends BaseMethodChannel
{
  public MethodChannel.MethodCallHandler a()
  {
    return new QQGameChannel.1(this);
  }
  
  public MethodCodec a()
  {
    return QQGameChannelHandler.a;
  }
  
  public String a()
  {
    return "com.tencent.qflutter/qqgame";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqgame.QQGameChannel
 * JD-Core Version:    0.7.0.1
 */