package com.tencent.qqmini.sdk.core.plugins;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import bgok;
import org.json.JSONObject;

class ClipboardJsPlugin$1
  implements Runnable
{
  ClipboardJsPlugin$1(ClipboardJsPlugin paramClipboardJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    Object localObject = (ClipboardManager)this.this$0.mContext.getSystemService("clipboard");
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (!((ClipboardManager)localObject).hasPrimaryClip()) {
          break label109;
        }
        localObject = ((ClipboardManager)localObject).getPrimaryClip();
        if (localObject != null)
        {
          localObject = ((ClipData)localObject).getItemAt(0);
          if (localObject != null)
          {
            localJSONObject.put("data", ((ClipData.Item)localObject).getText());
            this.val$req.a(localJSONObject);
            return;
          }
          localJSONObject.put("data", "");
          continue;
        }
        localThrowable.put("data", "");
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        this.val$req.b();
        return;
      }
      continue;
      label109:
      localThrowable.put("data", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ClipboardJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */