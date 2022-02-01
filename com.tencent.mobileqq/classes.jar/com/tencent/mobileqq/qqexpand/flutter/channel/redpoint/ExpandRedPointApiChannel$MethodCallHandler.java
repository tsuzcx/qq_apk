package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel$MethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "mApiImpl", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApi;", "(Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApi;)V", "onMethodCall", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel$MethodCallHandler
  implements MethodChannel.MethodCallHandler
{
  public static final ExpandRedPointApiChannel.MethodCallHandler.Companion a = new ExpandRedPointApiChannel.MethodCallHandler.Companion(null);
  private final ExpandRedPointApi b;
  
  public ExpandRedPointApiChannel$MethodCallHandler(@NotNull ExpandRedPointApi paramExpandRedPointApi)
  {
    this.b = paramExpandRedPointApi;
  }
  
  public void onMethodCall(@NotNull MethodCall paramMethodCall, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "methodCall");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    a.a(this.b, paramMethodCall, (IExpandChannelCallback)new ExpandRedPointApiChannel.MethodCallHandler.onMethodCall.1(paramResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.MethodCallHandler
 * JD-Core Version:    0.7.0.1
 */