package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel;", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApi;", "()V", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "onRedDotChangeEventChannel", "Lio/flutter/plugin/common/EventChannel;", "onRedDotChangeStreamHandler", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel$OnRedDotChangeStreamHandler;", "clearRedDotNums", "", "result", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "getRedDotNums", "init", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "unInit", "Companion", "MethodCallHandler", "OnRedDotChangeStreamHandler", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel
  implements ExpandRedPointApi
{
  public static final ExpandRedPointApiChannel.Companion a;
  private static final MethodCodec jdField_a_of_type_IoFlutterPluginCommonMethodCodec;
  private static final MethodCodec b;
  private ExpandRedPointApiChannel.OnRedDotChangeStreamHandler jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
  private EventChannel jdField_a_of_type_IoFlutterPluginCommonEventChannel;
  private MethodChannel jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelRedpointExpandRedPointApiChannel$Companion = new ExpandRedPointApiChannel.Companion(null);
    StandardMethodCodec localStandardMethodCodec = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localStandardMethodCodec, "StandardMethodCodec.INSTANCE");
    jdField_a_of_type_IoFlutterPluginCommonMethodCodec = (MethodCodec)localStandardMethodCodec;
    localStandardMethodCodec = StandardMethodCodec.INSTANCE;
    Intrinsics.checkExpressionValueIsNotNull(localStandardMethodCodec, "StandardMethodCodec.INSTANCE");
    b = (MethodCodec)localStandardMethodCodec;
  }
  
  public final void a()
  {
    ExpandRedPointApiChannel.OnRedDotChangeStreamHandler localOnRedDotChangeStreamHandler = this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
    if (localOnRedDotChangeStreamHandler == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeStreamHandler");
    }
    localOnRedDotChangeStreamHandler.b();
  }
  
  public void a(@NotNull IExpandChannelCallback paramIExpandChannelCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandChannelCallback, "result");
    int i;
    try
    {
      i = ExpandFlutterIPCClient.a().a();
    }
    catch (Exception localException)
    {
      LogUtils.a.a().a("ExpandRedPointApiChannel", 1, "getRedDotNums error!", (Throwable)localException);
      i = 0;
    }
    paramIExpandChannelCallback.success(Integer.valueOf(i));
  }
  
  public final void a(@Nullable BinaryMessenger paramBinaryMessenger)
  {
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      ((LogUtils)localObject).a().a("ExpandRedPointApiChannel", 2, "init Method Channel com.tencent.qflutter/expand/method.expand_red_dot");
    }
    this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel = new MethodChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/method.expand_red_dot", jdField_a_of_type_IoFlutterPluginCommonMethodCodec);
    localObject = this.jdField_a_of_type_IoFlutterPluginCommonMethodChannel;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("methodChannel");
    }
    ((MethodChannel)localObject).setMethodCallHandler((MethodChannel.MethodCallHandler)new ExpandRedPointApiChannel.MethodCallHandler((ExpandRedPointApi)this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler = new ExpandRedPointApiChannel.OnRedDotChangeStreamHandler();
    this.jdField_a_of_type_IoFlutterPluginCommonEventChannel = new EventChannel(paramBinaryMessenger, "com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange", b);
    paramBinaryMessenger = this.jdField_a_of_type_IoFlutterPluginCommonEventChannel;
    if (paramBinaryMessenger == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeEventChannel");
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterChannelRedpointExpandRedPointApiChannel$OnRedDotChangeStreamHandler;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onRedDotChangeStreamHandler");
    }
    paramBinaryMessenger.setStreamHandler((EventChannel.StreamHandler)localObject);
    paramBinaryMessenger = LogUtils.a;
    if (QLog.isColorLevel()) {
      paramBinaryMessenger.a().a("ExpandRedPointApiChannel", 2, "init Event Channel com.tencent.qflutter/expand/event.expand_red_dot.onRedDotChange");
    }
  }
  
  public void b(@NotNull IExpandChannelCallback paramIExpandChannelCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIExpandChannelCallback, "result");
    ExpandFlutterIPCClient.a().a();
    paramIExpandChannelCallback.success(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel
 * JD-Core Version:    0.7.0.1
 */