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
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.qflutter/expand/");
    localStringBuilder.append(g());
    return localStringBuilder.toString();
  }
  
  protected abstract void a(@NonNull MethodCall paramMethodCall, @NonNull ExpandBaseChannel.MethodChannelResultWrapper paramMethodChannelResultWrapper);
  
  public MethodChannel.MethodCallHandler c()
  {
    return this;
  }
  
  protected abstract String g();
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    ExpandChannelReportUtil.a(a(), paramMethodCall.method, "method");
    a(paramMethodCall, new ExpandBaseChannel.MethodChannelResultWrapper(this, paramMethodCall.method, paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.ExpandBaseChannel
 * JD-Core Version:    0.7.0.1
 */