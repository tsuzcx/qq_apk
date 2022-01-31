package com.tencent.qqmini.sdk.core.plugins;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import beka;
import org.json.JSONObject;

class ClipboardJsPlugin$2
  implements Runnable
{
  ClipboardJsPlugin$2(ClipboardJsPlugin paramClipboardJsPlugin, beka parambeka) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.val$req.b);
      ((ClipboardManager)this.this$0.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, localJSONObject1.optString("data")));
      this.val$req.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        JSONObject localJSONObject2 = new JSONObject();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ClipboardJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */