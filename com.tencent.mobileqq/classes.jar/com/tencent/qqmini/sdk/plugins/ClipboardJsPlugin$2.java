package com.tencent.qqmini.sdk.plugins;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ClipboardJsPlugin$2
  implements Runnable
{
  ClipboardJsPlugin$2(ClipboardJsPlugin paramClipboardJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject;
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$req.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      localObject = new JSONObject();
    }
    try
    {
      ClipboardManager localClipboardManager = (ClipboardManager)ClipboardJsPlugin.access$200(this.this$0).getSystemService("clipboard");
      localObject = ClipData.newPlainText(null, ((JSONObject)localObject).optString("data"));
      ClipboardMonitor.setPrimaryClip(localClipboardManager, (ClipData)localObject);
      localClipboardManager.setPrimaryClip((ClipData)localObject);
      this.val$req.ok();
      return;
    }
    catch (Exception localException)
    {
      this.val$req.fail(localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */