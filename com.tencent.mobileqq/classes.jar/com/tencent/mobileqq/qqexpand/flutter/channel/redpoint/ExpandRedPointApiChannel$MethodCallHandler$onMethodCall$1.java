package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel$MethodCallHandler$onMethodCall$1", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "error", "", "errorCode", "", "errorMsg", "errorDetails", "", "notImplemented", "success", "ret", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel$MethodCallHandler$onMethodCall$1
  implements IExpandChannelCallback
{
  ExpandRedPointApiChannel$MethodCallHandler$onMethodCall$1(MethodChannel.Result paramResult) {}
  
  public void error(@NotNull String paramString1, @Nullable String paramString2, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorCode");
    this.a.error(paramString1, paramString2, paramObject);
  }
  
  public void notImplemented()
  {
    this.a.notImplemented();
  }
  
  public void success(@Nullable Object paramObject)
  {
    this.a.success(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.MethodCallHandler.onMethodCall.1
 * JD-Core Version:    0.7.0.1
 */