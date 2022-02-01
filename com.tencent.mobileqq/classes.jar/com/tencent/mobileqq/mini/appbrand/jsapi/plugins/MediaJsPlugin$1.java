package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import java.util.concurrent.ConcurrentHashMap;

class MediaJsPlugin$1
  implements Runnable
{
  MediaJsPlugin$1(MediaJsPlugin paramMediaJsPlugin, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    if ((MediaJsPlugin.access$000(this.this$0) != null) && (MediaJsPlugin.access$000(this.this$0).containsKey(Integer.valueOf(this.val$videoPlayerId)))) {}
    for (WebviewContainer localWebviewContainer = (WebviewContainer)MediaJsPlugin.access$000(this.this$0).get(Integer.valueOf(this.val$videoPlayerId));; localWebviewContainer = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer())
    {
      if (localWebviewContainer != null)
      {
        localWebviewContainer.operateVideoPlayer(this.val$videoPlayerId, this.val$type, this.val$data);
        localWebviewContainer.callbackJsEventOK(this.val$event, null, this.val$callbackId);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.MediaJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */