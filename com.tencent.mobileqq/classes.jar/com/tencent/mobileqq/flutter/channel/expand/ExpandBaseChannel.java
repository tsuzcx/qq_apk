package com.tencent.mobileqq.flutter.channel.expand;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public abstract class ExpandBaseChannel
  extends BaseMethodChannel
  implements MethodChannel.MethodCallHandler
{
  public MethodChannel.MethodCallHandler a()
  {
    return this;
  }
  
  public String a()
  {
    return "com.tencent.qflutter/expand/" + c();
  }
  
  protected abstract void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper);
  
  protected abstract String c();
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    ExpandChannelReportUtil.a(a(), paramMethodCall.method, "method");
    a(paramMethodCall, new ExpandBaseChannel.MethodChannelResultWrapper(this, paramMethodCall.method, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.ExpandBaseChannel
 * JD-Core Version:    0.7.0.1
 */