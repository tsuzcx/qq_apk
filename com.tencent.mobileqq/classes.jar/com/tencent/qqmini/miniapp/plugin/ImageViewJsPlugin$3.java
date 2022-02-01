package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class ImageViewJsPlugin$3
  implements Runnable
{
  ImageViewJsPlugin$3(ImageViewJsPlugin paramImageViewJsPlugin, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (CoverViewAction.obtain(ImageViewJsPlugin.access$100(this.this$0)).del(this.val$jsonObject.optInt("viewId")))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */