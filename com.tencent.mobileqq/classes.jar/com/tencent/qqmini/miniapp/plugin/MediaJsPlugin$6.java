package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;

class MediaJsPlugin$6
  implements Runnable
{
  MediaJsPlugin$6(MediaJsPlugin paramMediaJsPlugin, CoverView paramCoverView, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    int i = ((CoverCameraView)this.val$cameraView).getParentId();
    if (i == 0) {
      CoverViewAction.obtain(MediaJsPlugin.access$1300(this.this$0)).del(this.val$cameraId);
    } else {
      CoverViewAction.obtain(MediaJsPlugin.access$1400(this.this$0)).del(i);
    }
    this.val$req.ok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */