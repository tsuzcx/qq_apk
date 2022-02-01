package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;

class MediaJsPlugin$1
  implements Runnable
{
  MediaJsPlugin$1(MediaJsPlugin paramMediaJsPlugin, int paramInt, RequestEvent paramRequestEvent, String paramString1, String paramString2) {}
  
  public void run()
  {
    CoverView localCoverView = CoverViewAction.obtain(MediaJsPlugin.access$000(this.this$0)).get(this.val$videoPlayerId);
    if (!(localCoverView instanceof CoverVideoView))
    {
      this.val$req.fail();
      return;
    }
    if ("play".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).playWithUi();
    } else if ("pause".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).pauseWithUi();
    } else if ("stop".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).stop();
    } else if ("seek".equals(this.val$type))
    {
      if (!MediaJsPlugin.access$100(this.this$0, (CoverVideoView)localCoverView, this.val$data)) {
        this.this$0.callbackJsEventFail(this.val$req, this.val$type, null, this.val$videoPlayerId);
      }
    }
    else if (("playbackRate".equals(this.val$type)) && (!TextUtils.isEmpty(this.val$data))) {
      QMLog.e("MediaJsPlugin", "playbackRate is not support.");
    } else if ("requestFullScreen".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).fullScreen();
    } else if ("exitFullScreen".equals(this.val$type)) {
      ((CoverVideoView)localCoverView).smallScreen();
    } else if ("sendDanmu".equals(this.val$type)) {
      MediaJsPlugin.access$200(this.this$0, (CoverVideoView)localCoverView, this.val$data, this.val$req, this.val$type, this.val$videoPlayerId);
    }
    this.this$0.callbackJsEventOK(this.val$req, this.val$type, null, this.val$videoPlayerId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */