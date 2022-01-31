package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bhei;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.widget.media.CoverPusherView;
import org.json.JSONObject;

class LivePusherJsPlugin$4
  implements Runnable
{
  LivePusherJsPlugin$4(LivePusherJsPlugin paramLivePusherJsPlugin, int paramInt, String paramString, bgok parambgok, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CoverView localCoverView = bhei.a(LivePusherJsPlugin.access$900(this.this$0)).a(this.val$livePusherId);
    if (!(localCoverView instanceof CoverPusherView)) {
      return;
    }
    ((CoverPusherView)localCoverView).a(this.val$type, this.val$req, this.val$jsonObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */