package com.tencent.mobileqq.flutter.channel.expand.redpoint;

import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.flutter.channel.expand.ExpandChannelReportUtil;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApiChannel$MethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "mApiImpl", "Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApi;", "(Lcom/tencent/mobileqq/flutter/channel/expand/redpoint/ExpandRedPointApi;)V", "onMethodCall", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel$MethodCallHandler
  implements MethodChannel.MethodCallHandler
{
  public static final ExpandRedPointApiChannel.MethodCallHandler.Companion a;
  private final ExpandRedPointApi a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApiChannel$MethodCallHandler$Companion = new ExpandRedPointApiChannel.MethodCallHandler.Companion(null);
  }
  
  public ExpandRedPointApiChannel$MethodCallHandler(@NotNull ExpandRedPointApi paramExpandRedPointApi)
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApi = paramExpandRedPointApi;
  }
  
  public void onMethodCall(@NotNull MethodCall paramMethodCall, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "methodCall");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    String str = paramMethodCall.method;
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandRedPointApiChannelHandler", 2, "[onMethodCall] method=" + str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExpandRedPointApiChannelHandler", 2, "[onMethodCall] method=" + str);
    }
    ExpandChannelReportUtil.a("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
    if (str == null) {}
    do
    {
      do
      {
        return;
        switch (str.hashCode())
        {
        default: 
          return;
        }
      } while (!str.equals("getRedDotNums"));
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApi.a(paramResult);
      ExpandChannelReportUtil.b("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
      return;
    } while (!str.equals("clearRedDotNums"));
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelExpandRedpointExpandRedPointApi.b(paramResult);
    ExpandChannelReportUtil.b("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.expand.redpoint.ExpandRedPointApiChannel.MethodCallHandler
 * JD-Core Version:    0.7.0.1
 */