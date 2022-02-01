package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class LivePusherJsPlugin$3
  implements Runnable
{
  LivePusherJsPlugin$3(LivePusherJsPlugin paramLivePusherJsPlugin, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    CoverViewAction.obtain(LivePusherJsPlugin.access$900(this.this$0)).del(this.val$livePusherId);
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */