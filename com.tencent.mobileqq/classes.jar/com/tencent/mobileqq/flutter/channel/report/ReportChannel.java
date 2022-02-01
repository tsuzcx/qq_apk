package com.tencent.mobileqq.flutter.channel.report;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;

public class ReportChannel
  extends BaseMethodChannel
{
  public String a()
  {
    return "com.tencent.qflutter/reporter";
  }
  
  public MethodCodec b()
  {
    return ReporterChannelHandler.b;
  }
  
  public MethodChannel.MethodCallHandler c()
  {
    return new ReportChannel.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.report.ReportChannel
 * JD-Core Version:    0.7.0.1
 */