package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class TextViewJsPlugin$2
  implements Runnable
{
  TextViewJsPlugin$2(TextViewJsPlugin paramTextViewJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (TextViewJsPlugin.access$100(this.this$0, this.val$jsonObject))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */