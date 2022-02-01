package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.camera.CameraCallBack;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class MediaJsPlugin$5$1
  implements CameraCallBack
{
  MediaJsPlugin$5$1(MediaJsPlugin.5 param5) {}
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$1.val$req.ok(this.this$1.val$result);
      return;
    }
    this.this$1.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.MediaJsPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */