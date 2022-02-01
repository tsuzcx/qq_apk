package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;
import io.flutter.plugin.common.MethodChannel.Result;

class FlutterWebView$1
  implements ValueCallback<String>
{
  FlutterWebView$1(FlutterWebView paramFlutterWebView, MethodChannel.Result paramResult) {}
  
  public void onReceiveValue(String paramString)
  {
    this.val$result.success(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.FlutterWebView.1
 * JD-Core Version:    0.7.0.1
 */