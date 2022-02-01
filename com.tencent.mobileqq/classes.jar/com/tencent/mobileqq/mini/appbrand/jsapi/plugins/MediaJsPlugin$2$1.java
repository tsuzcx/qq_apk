package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.media.CameraSurfaceView.CameraSurfaceViewCallBack;

class MediaJsPlugin$2$1
  implements CameraSurfaceView.CameraSurfaceViewCallBack
{
  MediaJsPlugin$2$1(MediaJsPlugin.2 param2) {}
  
  public void onStartPreview(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, this.this$1.val$result, this.this$1.val$callbackId);
      return;
    }
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$event, null, this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */