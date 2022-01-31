package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bhei;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverLiveView;
import org.json.JSONObject;

class LivePlayerJsPlugin$4
  implements Runnable
{
  LivePlayerJsPlugin$4(LivePlayerJsPlugin paramLivePlayerJsPlugin, int paramInt, String paramString, bgok parambgok, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CoverView localCoverView = bhei.a(LivePlayerJsPlugin.access$1000(this.this$0)).a(this.val$livePlayerId);
    if (!(localCoverView instanceof CoverLiveView)) {
      return;
    }
    ((CoverLiveView)localCoverView).a(this.val$type, this.val$req, this.val$jsonObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */