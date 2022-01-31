package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;

class MediaJsPlugin$1
  implements Runnable
{
  MediaJsPlugin$1(MediaJsPlugin paramMediaJsPlugin, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    WebviewContainer localWebviewContainer = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
    if (localWebviewContainer != null)
    {
      localWebviewContainer.operateVideoPlayer(this.val$videoPlayerId, this.val$type, this.val$data);
      localWebviewContainer.callbackJsEventOK(this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */