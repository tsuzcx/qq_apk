package com.tencent.qqmini.miniapp.proxy;

import android.app.Activity;
import android.content.Intent;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import java.io.File;

class VideoJsProxyDefault$2
  implements IActivityResultListener
{
  VideoJsProxyDefault$2(VideoJsProxyDefault paramVideoJsProxyDefault, VideoJsProxyDefault.BridgeInfo paramBridgeInfo, Activity paramActivity, boolean paramBoolean) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 2) {
      return false;
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 0) {
        VideoJsProxyDefault.access$200(this.this$0).responseCancel(this.val$bridgeInfo.callbackId, this.val$bridgeInfo.eventName, null);
      }
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    paramIntent = paramIntent.getData();
    paramIntent = this.this$0.getPath(this.val$context, paramIntent);
    if (paramIntent != null) {
      VideoJsProxyDefault.access$300(this.this$0, new File(paramIntent), this.val$compress, this.val$bridgeInfo);
    }
    ActivityResultManager.g().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault.2
 * JD-Core Version:    0.7.0.1
 */