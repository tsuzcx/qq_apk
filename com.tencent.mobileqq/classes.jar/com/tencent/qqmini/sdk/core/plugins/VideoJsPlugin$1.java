package com.tencent.qqmini.sdk.core.plugins;

import bgho;
import bgkd;
import org.json.JSONObject;

class VideoJsPlugin$1
  implements Runnable
{
  VideoJsPlugin$1(VideoJsPlugin paramVideoJsPlugin, bgkd parambgkd, int paramInt, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    VideoJsPlugin.access$000(this.this$0, this.this$0.mMiniAppContext.a(), this.val$req.a, this.val$videoPlayerId, this.val$jsonObject);
    this.val$req.a(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VideoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */