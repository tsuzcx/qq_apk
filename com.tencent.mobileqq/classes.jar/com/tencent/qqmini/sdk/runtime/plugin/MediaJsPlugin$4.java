package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bhei;
import com.tencent.qqmini.sdk.core.widget.media.CoverVideoView;

class MediaJsPlugin$4
  implements Runnable
{
  MediaJsPlugin$4(MediaJsPlugin paramMediaJsPlugin, int paramInt, bgok parambgok) {}
  
  public void run()
  {
    if ((bhei.a(MediaJsPlugin.access$800(this.this$0)).a(this.val$videoPlayerId) instanceof CoverVideoView))
    {
      bhei.a(MediaJsPlugin.access$900(this.this$0)).a(this.val$videoPlayerId);
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */