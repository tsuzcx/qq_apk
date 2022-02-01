package com.tencent.mobileqq.qqexpand.flutter.channel.redpoint;

import com.tencent.mobileqq.qqexpand.flutter.channel.ExpandChannelReportUtil;
import com.tencent.mobileqq.qqexpand.flutter.channel.IExpandChannelCallback;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApiChannel$MethodCallHandler$Companion;", "", "()V", "METHOD_CLEAR_RED_DOT_NUMS", "", "METHOD_GET_RED_DOT_NUMS", "TAG", "doCallMethod", "", "mApiImpl", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/redpoint/ExpandRedPointApi;", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "callback", "Lcom/tencent/mobileqq/qqexpand/flutter/channel/IExpandChannelCallback;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandRedPointApiChannel$MethodCallHandler$Companion
{
  @JvmStatic
  public final void a(@NotNull ExpandRedPointApi paramExpandRedPointApi, @NotNull MethodCall paramMethodCall, @NotNull IExpandChannelCallback paramIExpandChannelCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandRedPointApi, "mApiImpl");
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "methodCall");
    Intrinsics.checkParameterIsNotNull(paramIExpandChannelCallback, "callback");
    String str = paramMethodCall.method;
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onMethodCall] method=");
      localStringBuilder.append(str);
      ((ILog)localObject).a("ExpandRedPointApiChannelHandler", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onMethodCall] method=");
      ((StringBuilder)localObject).append(str);
      QLog.d("ExpandRedPointApiChannelHandler", 2, ((StringBuilder)localObject).toString());
    }
    ExpandChannelReportUtil.a("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
    if (str == null) {
      return;
    }
    int i = str.hashCode();
    if (i != -1694239557)
    {
      if (i != 2128155378) {
        return;
      }
      if (str.equals("clearRedDotNums"))
      {
        paramExpandRedPointApi.b(paramIExpandChannelCallback);
        ExpandChannelReportUtil.b("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
      }
    }
    else if (str.equals("getRedDotNums"))
    {
      paramExpandRedPointApi.a(paramIExpandChannelCallback);
      ExpandChannelReportUtil.b("com.tencent.qflutter/expand/method.expand_red_dot", paramMethodCall.method, "method");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.channel.redpoint.ExpandRedPointApiChannel.MethodCallHandler.Companion
 * JD-Core Version:    0.7.0.1
 */