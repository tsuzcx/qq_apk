package com.tencent.mobileqq.qqexpand.flutter.channel;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/");
    localStringBuilder.append(c());
    return localStringBuilder.toString();
  }
  
  protected abstract void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper);
  
  protected abstract String c();
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    ExpandChannelReportUtil.a(a(), paramMethodCall.method, "method");
    a(paramMethodCall, new ExpandBaseChannel.MethodChannelResultWrapper(this, paramMethodCall.method, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel
 * JD-Core Version:    0.7.0.1
 */