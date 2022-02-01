package com.tencent.qqmini.miniapp.plugin;

import android.content.Context;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class MediaJsPlugin$2
  implements Runnable
{
  MediaJsPlugin$2(MediaJsPlugin paramMediaJsPlugin, int paramInt, RequestEvent paramRequestEvent, JSONObject paramJSONObject1, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    CoverView localCoverView = CoverViewAction.obtain(MediaJsPlugin.access$300(this.this$0)).get(this.val$videoPlayerId);
    Object localObject = localCoverView;
    if (localCoverView == null)
    {
      localObject = MediaJsPlugin.access$400(this.this$0).getAttachedActivity();
      if (localObject == null)
      {
        this.val$req.fail();
        return;
      }
      localObject = new CoverVideoView((Context)localObject);
      ((CoverVideoView)localObject).setAtyRef(new WeakReference(MediaJsPlugin.access$500(this.this$0).getAttachedActivity()));
      ((CoverVideoView)localObject).setData(this.val$jsonObject.optString("data"));
      ((CoverVideoView)localObject).setPageWebview(this.val$req.jsService);
      ((CoverVideoView)localObject).setPageWebviewId(PageAction.obtain(MediaJsPlugin.access$600(this.this$0)).getPageId());
      ((CoverVideoView)localObject).setVideoPlayerId(this.val$videoPlayerId);
      CoverViewAction.obtain(MediaJsPlugin.access$700(this.this$0)).add(0, this.val$videoPlayerId, (CoverView)localObject);
      ((ObserverManager)MediaJsPlugin.access$800(this.this$0).getManager(ObserverManager.class)).addObserver(((CoverVideoView)localObject).getVideoPlayerStatusObserver());
    }
    if ((localObject instanceof CoverVideoView))
    {
      ((CoverVideoView)localObject).setMiniAppContext(MediaJsPlugin.access$900(this.this$0));
      ((CoverVideoView)localObject).initVideoPlayerSettings(this.val$jsonObject);
    }
    this.val$req.ok(this.val$result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */