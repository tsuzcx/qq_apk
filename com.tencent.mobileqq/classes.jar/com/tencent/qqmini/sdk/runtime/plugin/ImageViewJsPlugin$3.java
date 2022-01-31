package com.tencent.qqmini.sdk.runtime.plugin;

import org.json.JSONObject;

class ImageViewJsPlugin$3
  implements Runnable
{
  ImageViewJsPlugin$3(ImageViewJsPlugin paramImageViewJsPlugin, JSONObject paramJSONObject) {}
  
  public void run()
  {
    this.this$0.removeImageView(this.val$jsonObject.optInt("viewId"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.ImageViewJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */