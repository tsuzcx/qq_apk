package com.tencent.qqmini.sdk.core.plugins;

import bekr;

class VideoJsPlugin$3
  implements Runnable
{
  VideoJsPlugin$3(VideoJsPlugin paramVideoJsPlugin, int paramInt, String paramString, bekr parambekr) {}
  
  public void run()
  {
    if (this.this$0.operateVideoPlayer(this.val$videoPlayerId, this.val$type, this.val$req.b))
    {
      this.val$req.a();
      return;
    }
    this.val$req.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.VideoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */