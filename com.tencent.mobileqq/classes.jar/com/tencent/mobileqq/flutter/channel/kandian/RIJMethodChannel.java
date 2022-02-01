package com.tencent.mobileqq.flutter.channel.kandian;

import com.tencent.mobileqq.flutter.channel.BaseMethodChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/kandian/RIJMethodChannel;", "Lcom/tencent/mobileqq/flutter/channel/BaseMethodChannel;", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "METHOD_CHANNEL_CODEC", "Lio/flutter/plugin/common/MethodCodec;", "getMETHOD_CHANNEL_CODEC", "()Lio/flutter/plugin/common/MethodCodec;", "METHOD_CHANNEL_NAME", "", "getMETHOD_CHANNEL_NAME", "()Ljava/lang/String;", "getMethodCallHandler", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "getMethodCodec", "getName", "onDestroy", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJMethodChannel
  extends BaseMethodChannel
{
  @NotNull
  private final MethodCodec d;
  @NotNull
  private final String e;
  
  public RIJMethodChannel(@Nullable BinaryMessenger paramBinaryMessenger)
  {
    paramBinaryMessenger = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(paramBinaryMessenger, "StandardMethodCodec.INSTANCE");
    this.d = ((MethodCodec)paramBinaryMessenger);
    this.e = "com.tencent.qflutter/RIJMethodChannel";
  }
  
  @Nullable
  public String a()
  {
    return this.e;
  }
  
  @Nullable
  public MethodCodec b()
  {
    return this.d;
  }
  
  @Nullable
  public MethodChannel.MethodCallHandler c()
  {
    return (MethodChannel.MethodCallHandler)new RIJChannelHandler();
  }
  
  public void f()
  {
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.kandian.RIJMethodChannel
 * JD-Core Version:    0.7.0.1
 */