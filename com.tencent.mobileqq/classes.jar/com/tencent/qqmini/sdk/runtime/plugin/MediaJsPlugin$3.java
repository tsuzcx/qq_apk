package com.tencent.qqmini.sdk.runtime.plugin;

import bgok;
import bgpv;
import bhei;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.core.widget.media.CoverVideoView;
import org.json.JSONObject;

class MediaJsPlugin$3
  implements Runnable
{
  MediaJsPlugin$3(MediaJsPlugin paramMediaJsPlugin, int paramInt, JSONObject paramJSONObject, bgok parambgok) {}
  
  public void run()
  {
    CoverView localCoverView = bhei.a(MediaJsPlugin.access$700(this.this$0)).a(this.val$videoPlayerId);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((CoverVideoView)localCoverView).b(this.val$jsonObject);
      String str = this.val$jsonObject.optString("filePath");
      if (!bgpv.a(str)) {
        ((CoverVideoView)localCoverView).setVideoPath(str);
      }
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */