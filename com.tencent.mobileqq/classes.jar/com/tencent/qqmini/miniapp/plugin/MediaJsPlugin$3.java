package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import org.json.JSONObject;

class MediaJsPlugin$3
  implements Runnable
{
  MediaJsPlugin$3(MediaJsPlugin paramMediaJsPlugin, int paramInt, JSONObject paramJSONObject, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    Object localObject = CoverViewAction.obtain(MediaJsPlugin.access$900(this.this$0)).get(this.val$videoPlayerId);
    if ((localObject instanceof CoverVideoView))
    {
      localObject = (CoverVideoView)localObject;
      ((CoverVideoView)localObject).updateVideoPlayerSettings(this.val$jsonObject);
      String str = this.val$jsonObject.optString("filePath");
      if (!StringUtil.isEmpty(str)) {
        ((CoverVideoView)localObject).setVideoPath(str);
      }
      this.val$req.ok();
      return;
    }
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */