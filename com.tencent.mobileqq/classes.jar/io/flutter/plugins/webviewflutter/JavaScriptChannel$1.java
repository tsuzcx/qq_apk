package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;

class JavaScriptChannel$1
  implements Runnable
{
  JavaScriptChannel$1(JavaScriptChannel paramJavaScriptChannel, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("channel", JavaScriptChannel.access$000(this.this$0));
    localHashMap.put("message", this.val$message);
    JavaScriptChannel.access$100(this.this$0).invokeMethod("javascriptChannelMessage", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.webviewflutter.JavaScriptChannel.1
 * JD-Core Version:    0.7.0.1
 */