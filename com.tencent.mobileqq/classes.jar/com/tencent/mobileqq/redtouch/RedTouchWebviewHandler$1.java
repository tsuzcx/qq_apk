package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;

class RedTouchWebviewHandler$1
  implements Runnable
{
  RedTouchWebviewHandler$1(RedTouchWebviewHandler paramRedTouchWebviewHandler, long paramLong, String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = RedTouchWebviewHandler.parseGetAppInfoList(RedTouchWebviewHandler.access$000(this.this$0), this.a, this.b);
    if (this.this$0.mRuntime != null)
    {
      Activity localActivity = this.this$0.mRuntime.d();
      if (localActivity != null) {
        localActivity.runOnUiThread(new RedTouchWebviewHandler.1.1(this, localHashMap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1
 * JD-Core Version:    0.7.0.1
 */