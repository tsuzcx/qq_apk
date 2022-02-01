package com.tencent.qqmini.sdk.task;

import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class MiniAppInfoLoadTask$7
  implements Runnable
{
  MiniAppInfoLoadTask$7(MiniAppInfoLoadTask paramMiniAppInfoLoadTask, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    SpecialProxy localSpecialProxy = (SpecialProxy)ProxyManager.get(SpecialProxy.class);
    if (localSpecialProxy != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("mini_appinfo", this.val$miniAppInfo);
      localSpecialProxy.sendEventToHost(1, localBundle, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask.7
 * JD-Core Version:    0.7.0.1
 */