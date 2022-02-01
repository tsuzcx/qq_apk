package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class NativeAppBrandRuntime$3
  implements MethodChannel.MethodCallHandler
{
  NativeAppBrandRuntime$3(NativeAppBrandRuntime paramNativeAppBrandRuntime) {}
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    paramResult.success(null);
    QMLog.d("miniapp-start-TISSUE-flutter_method_channel", paramMethodCall.method);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.3
 * JD-Core Version:    0.7.0.1
 */