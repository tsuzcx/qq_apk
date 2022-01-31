package com.tencent.qqmini.sdk.runtime.plugin;

import bgkd;
import org.json.JSONObject;

class MediaJsPlugin$5
  implements Runnable
{
  MediaJsPlugin$5(MediaJsPlugin paramMediaJsPlugin, bgkd parambgkd, int paramInt1, int paramInt2, String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString2, boolean paramBoolean, String paramString3) {}
  
  public void run()
  {
    this.this$0.insertCamera(this.val$req, this.val$cameraId, this.val$parentId, this.val$devicePosition, this.val$postionObj.optInt("left"), this.val$postionObj.optInt("top"), this.val$postionObj.optInt("width"), this.val$postionObj.optInt("height"), new MediaJsPlugin.5.1(this), this.val$flashMode, this.val$fixed, this.val$mode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */