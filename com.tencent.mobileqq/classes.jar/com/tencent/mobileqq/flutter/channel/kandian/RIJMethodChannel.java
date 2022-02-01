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
  private final MethodCodec jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  public RIJMethodChannel(@Nullable BinaryMessenger paramBinaryMessenger)
  {
    paramBinaryMessenger = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(paramBinaryMessenger, "StandardMethodCodec.INSTANCE");
    this.jdField_a_of_type_IoFlutterPluginCommonMethodCodec = ((MethodCodec)paramBinaryMessenger);
    this.jdField_a_of_type_JavaLangString = "com.tencent.qflutter/RIJMethodChannel";
  }
  
  @Nullable
  public MethodChannel.MethodCallHandler a()
  {
    return (MethodChannel.MethodCallHandler)new RIJChannelHandler();
  }
  
  @Nullable
  public MethodCodec a()
  {
    return this.jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.kandian.RIJMethodChannel
 * JD-Core Version:    0.7.0.1
 */