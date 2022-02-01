package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import io.flutter.plugin.common.MethodChannel;

class JavaScriptChannel
{
  private final String javaScriptChannelName;
  private final MethodChannel methodChannel;
  private final Handler platformThreadHandler;
  
  JavaScriptChannel(MethodChannel paramMethodChannel, String paramString, Handler paramHandler)
  {
    this.methodChannel = paramMethodChannel;
    this.javaScriptChannelName = paramString;
    this.platformThreadHandler = paramHandler;
  }
  
  @JavascriptInterface
  public void postMessage(String paramString)
  {
    JavaScriptChannel.1 local1 = new JavaScriptChannel.1(this, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channel:");
    localStringBuilder.append(this.javaScriptChannelName);
    localStringBuilder.append(",message:");
    localStringBuilder.append(paramString);
    Log.v("FlutterWebView", localStringBuilder.toString());
    if (this.platformThreadHandler.getLooper() == Looper.myLooper())
    {
      local1.run();
      return;
    }
    this.platformThreadHandler.post(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.JavaScriptChannel
 * JD-Core Version:    0.7.0.1
 */