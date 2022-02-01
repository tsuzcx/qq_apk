package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import org.json.JSONObject;

class MediaJsPlugin$2
  implements Runnable
{
  MediaJsPlugin$2(MediaJsPlugin paramMediaJsPlugin, int paramInt, RequestEvent paramRequestEvent, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    Object localObject2 = CoverViewAction.obtain(MediaJsPlugin.access$300(this.this$0)).get(this.val$videoPlayerId);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = MediaJsPlugin.access$400(this.this$0).getAttachedActivity();
      if (localObject1 == null)
      {
        this.val$req.fail();
        return;
      }
      localObject1 = new CoverVideoView((Activity)localObject1);
      localObject2 = (CoverVideoView)localObject1;
      ((CoverVideoView)localObject2).setData(this.val$jsonObject.optString("data"));
      ((CoverVideoView)localObject2).setPageWebView(this.val$req.jsService);
      ((CoverVideoView)localObject2).setPageWebViewId(PageAction.obtain(MediaJsPlugin.access$500(this.this$0)).getPageId());
      ((CoverVideoView)localObject2).setVideoPlayerId(this.val$videoPlayerId);
      CoverViewAction.obtain(MediaJsPlugin.access$600(this.this$0)).add(0, this.val$videoPlayerId, (CoverView)localObject1);
      ((ObserverManager)MediaJsPlugin.access$700(this.this$0).getManager(ObserverManager.class)).addObserver(((CoverVideoView)localObject2).getVideoPlayerStatusObserver());
    }
    if ((localObject1 instanceof CoverVideoView))
    {
      localObject1 = (CoverVideoView)localObject1;
      ((CoverVideoView)localObject1).setMiniAppContext(MediaJsPlugin.access$800(this.this$0));
      ((CoverVideoView)localObject1).initVideoPlayerSettings(this.val$jsonObject);
    }
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */