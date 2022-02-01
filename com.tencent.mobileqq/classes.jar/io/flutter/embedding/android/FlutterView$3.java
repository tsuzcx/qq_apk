package io.flutter.embedding.android;

import android.app.Activity;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

class FlutterView$3
  implements MethodChannel.MethodCallHandler
{
  FlutterView$3(FlutterView paramFlutterView) {}
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    if ("closePage".equals(paramMethodCall.method))
    {
      paramMethodCall = this.this$0.getContext();
      if ((paramMethodCall instanceof Activity)) {
        ((Activity)paramMethodCall).finish();
      }
      paramResult.success(Boolean.valueOf(true));
      return;
    }
    paramResult.notImplemented();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.3
 * JD-Core Version:    0.7.0.1
 */