package com.tencent.qqmini.sdk.runtime.plugin;

import bglv;
import bgml;
import bgok;
import bhei;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.core.widget.media.CoverVideoView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class MediaJsPlugin$2
  implements Runnable
{
  MediaJsPlugin$2(MediaJsPlugin paramMediaJsPlugin, int paramInt, JSONObject paramJSONObject1, bgok parambgok, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    CoverView localCoverView = bhei.a(MediaJsPlugin.access$100(this.this$0)).a(this.val$videoPlayerId);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = new CoverVideoView(MediaJsPlugin.access$200(this.this$0).a());
      ((CoverVideoView)localObject).setAtyRef(new WeakReference(MediaJsPlugin.access$300(this.this$0).a()));
      ((CoverVideoView)localObject).setData(this.val$jsonObject.optString("data"));
      ((CoverVideoView)localObject).setServiceWebview(this.val$req.a);
      ((CoverVideoView)localObject).setPageWebviewId(bgml.a(MediaJsPlugin.access$400(this.this$0)).a());
      ((CoverVideoView)localObject).setVideoPlayerId(this.val$videoPlayerId);
      bhei.a(MediaJsPlugin.access$500(this.this$0)).a(0, this.val$videoPlayerId, (CoverView)localObject);
    }
    if ((localObject instanceof CoverVideoView))
    {
      ((CoverVideoView)localObject).setMiniAppContext(MediaJsPlugin.access$600(this.this$0));
      ((CoverVideoView)localObject).a(this.val$jsonObject);
    }
    this.val$req.a(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */