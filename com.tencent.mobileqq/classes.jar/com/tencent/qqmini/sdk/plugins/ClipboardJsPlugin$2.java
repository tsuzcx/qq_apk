package com.tencent.qqmini.sdk.plugins;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ClipboardJsPlugin$2
  implements Runnable
{
  ClipboardJsPlugin$2(ClipboardJsPlugin paramClipboardJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    try
    {
      localJSONObject1 = new JSONObject(this.val$req.jsonParams);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject1;
          ((ClipboardManager)ClipboardJsPlugin.access$100(this.this$0).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, localJSONObject1.optString("data")));
          this.val$req.ok();
          return;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject2;
          this.val$req.fail(localException.getMessage());
        }
        localThrowable = localThrowable;
        localThrowable.printStackTrace();
        localJSONObject2 = new JSONObject();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */