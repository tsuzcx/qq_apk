package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ScrollViewJsPlugin$2
  implements Runnable
{
  ScrollViewJsPlugin$2(ScrollViewJsPlugin paramScrollViewJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (ScrollViewJsPlugin.access$100(this.this$0, this.val$jsonObject))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */