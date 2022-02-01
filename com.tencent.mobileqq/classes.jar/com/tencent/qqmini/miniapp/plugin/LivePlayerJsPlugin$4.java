package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONObject;

class LivePlayerJsPlugin$4
  implements Runnable
{
  LivePlayerJsPlugin$4(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CoverView localCoverView = CoverViewAction.obtain(LivePlayerJsPlugin.access$1100(this.this$0)).get(this.val$livePlayerId);
    if (!(localCoverView instanceof CoverLiveView)) {
      return;
    }
    ((CoverLiveView)localCoverView).operateLivePlayer(this.val$type, this.val$req, this.val$jsonObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */