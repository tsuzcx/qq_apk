package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class VideoJsPlugin$3
  implements Runnable
{
  VideoJsPlugin$3(VideoJsPlugin paramVideoJsPlugin, int paramInt, String paramString, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (this.this$0.operateVideoPlayer(this.val$videoPlayerId, this.val$type, this.val$req.jsonParams))
    {
      this.val$req.ok();
      return;
    }
    this.val$req.fail(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.VideoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */