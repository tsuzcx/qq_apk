package com.tencent.qqmini.sdk.plugins;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ClipboardJsPlugin$1
  implements Runnable
{
  ClipboardJsPlugin$1(ClipboardJsPlugin paramClipboardJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject = (ClipboardManager)ClipboardJsPlugin.access$000(this.this$0).getSystemService("clipboard");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ClipboardMonitor.hasPrimaryClip((ClipboardManager)localObject);
      boolean bool = ((ClipboardManager)localObject).hasPrimaryClip();
      if (bool)
      {
        ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
        if (localObject != null)
        {
          localObject = ((ClipData)localObject).getItemAt(0);
          if (localObject != null) {
            localJSONObject.put("data", ((ClipData.Item)localObject).getText());
          } else {
            localJSONObject.put("data", "");
          }
        }
        else
        {
          localJSONObject.put("data", "");
        }
      }
      else
      {
        localJSONObject.put("data", "");
      }
      this.val$req.ok(localJSONObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.val$req.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ClipboardJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */