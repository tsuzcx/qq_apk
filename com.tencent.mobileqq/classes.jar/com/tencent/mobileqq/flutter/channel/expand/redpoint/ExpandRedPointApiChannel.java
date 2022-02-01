package com.tencent.mobileqq.flutter.channel.expand.redpoint;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApiChannel;", "Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApi;", "()V", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "onRedDotChangeEventChannel", "Lio/flutter/plugin/common/EventChannel;", "onRedDotChangeStreamHandler", "Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApiChannel$OnRedDotChangeStreamHandler;", "clearRedDotNums", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "getRedDotNums", "init", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "unInit", "Companion", "MethodCallHandler", "OnRedDotChangeStreamHandler", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel
  implements ExpandRedPointApi
{
  public static final ExpandRedPointApiChannel.Companion a;
  private static final MethodCodec jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  private static final MethodCodec b;
  private ExpandRedPointApiChannel.OnRedDotChangeStreamHandler jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
  private EventChannel jdField_a_of_type_IoFlutterPluginCommonEventChannel;
  private MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$Companion = new ExpandRedPointApiChannel.Companion(null);
    StandardMethodCodec localStandardMethodCodec = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localStandardMethodCodec, "StandardMethodCodec.INSTANCE");
    jdField_a_of_type_IoFlutterPluginCommonMethodCodec = (MethodCodec)localStandardMethodCodec;
    localStandardMethodCodec = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localStandardMethodCodec, "StandardMethodCodec.INSTANCE");
    b = (MethodCodec)localStandardMethodCodec;
  }
  
  public final void a()
  {
    ExpandRedPointApiChannel.OnRedDotChangeStreamHandler localOnRedDotChangeStreamHandler = this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
    if (localOnRedDotChangeStreamHandler == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeStreamHandler");
    }
    localOnRedDotChangeStreamHandler.b();
  }
  
  public final void a(@Nullable BinaryMessenger paramBinaryMessenger)
  {
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandRedPointApiChannel", 2, "init Method Channel com.tencent.qflutter/expand/method.expand_red_dot");
    }
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/method.expand_red_dot", jdField_a_of_type_IoFlutterPluginCommonMethodCodec);
    localObject = this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
    }
    ((MethodChannel)localObject).setMethodCallHandler((MethodChannel.MethodCallHandler)new ExpandRedPointApiChannel.MethodCallHandler((ExpandRedPointApi)this));
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler = new ExpandRedPointApiChannel.OnRedDotChangeStreamHandler();
    this.jdField_a_of_type_IoFlutterPluginCommonEventChannel = new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", b);
    paramBinaryMessenger = this.jdField_a_of_type_IoFlutterPluginCommonEventChannel;
    if (paramBinaryMessenger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeEventChannel");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeStreamHandler");
    }
    paramBinaryMessenger.setStreamHandler((EventChannel.StreamHandler)localObject);
    paramBinaryMessenger = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandRedPointApiChannel", 2, "init Event Channel com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange");
    }
  }
  
  public void a(@NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    try
    {
      i = ExpandFlutterIPCClient.a().a();
      paramResult.success(Integer.valueOf(i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtils localLogUtils = LogUtils.a;
        QLog.e("ExpandRedPointApiChannel", 1, "getRedDotNums error!", (Throwable)localException);
        int i = 0;
      }
    }
  }
  
  public void b(@NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    ExpandFlutterIPCClient.a().a();
    paramResult.success(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.redpoint.ExpandRedPointApiChannel
 * JD-Core Version:    0.7.0.1
 */