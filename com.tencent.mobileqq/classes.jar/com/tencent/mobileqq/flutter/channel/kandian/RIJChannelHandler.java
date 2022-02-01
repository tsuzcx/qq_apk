package com.tencent.mobileqq.flutter.channel.kandian;

import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/flutter/channel/kandian/RIJChannelHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "methodCall", "", "methodName", "arguments", "", "onMethodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelHandler
  implements MethodChannel.MethodCallHandler
{
  @NotNull
  private final String a = "RIJChannelHandler";
  
  private final void a(String paramString, Object paramObject)
  {
    Object localObject = (Function1)RIJChannelFlutterUtils.a.a().get(paramString);
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(paramObject);
    }
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("methodCall,methodName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", arguments=");
    localStringBuilder.append(paramObject);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void onMethodCall(@NotNull MethodCall paramMethodCall, @NotNull MethodChannel.Result paramResult)
  {
    Intrinsics.checkParameterIsNotNull(paramMethodCall, "methodCall");
    Intrinsics.checkParameterIsNotNull(paramResult, "result");
    paramResult = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    if (paramResult != null) {
      a(paramResult, paramMethodCall);
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMethodCall,methodName=");
    localStringBuilder.append(paramResult);
    localStringBuilder.append(", arguments=");
    localStringBuilder.append(paramMethodCall);
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.kandian.RIJChannelHandler
 * JD-Core Version:    0.7.0.1
 */