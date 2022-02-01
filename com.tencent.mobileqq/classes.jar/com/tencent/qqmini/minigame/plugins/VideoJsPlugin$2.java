package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONObject;

class VideoJsPlugin$2
  implements Runnable
{
  VideoJsPlugin$2(VideoJsPlugin paramVideoJsPlugin, int paramInt, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    VideoJsPlugin.access$200(this.this$0, this.val$videoPlayerId, this.val$jsonObject);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.VideoJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */