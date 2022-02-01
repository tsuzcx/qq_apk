package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class TextViewJsPlugin$3
  implements Runnable
{
  TextViewJsPlugin$3(TextViewJsPlugin paramTextViewJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (CoverViewAction.obtain(TextViewJsPlugin.access$200(this.this$0)).del(this.val$jsonObject.optInt("viewId")))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */