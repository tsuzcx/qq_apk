package com.tencent.qqmini.minigame.plugins;

import android.os.Bundle;
import com.tencent.qqmini.minigame.model.BlockAdInfo;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;

class BlockAdPlugin$1
  implements Runnable
{
  BlockAdPlugin$1(BlockAdPlugin paramBlockAdPlugin, BlockAdInfo paramBlockAdInfo, String paramString, RequestEvent paramRequestEvent, Bundle paramBundle) {}
  
  public void run()
  {
    if (((AdProxy)ProxyManager.get(AdProxy.class) == null) || (this.val$adInfo == null)) {
      QMLog.i("BlockAdPlugin", "start create, null");
    }
    AdProxy.AbsBlockAdView localAbsBlockAdView;
    do
    {
      return;
      localAbsBlockAdView = ((AdProxy)ProxyManager.get(AdProxy.class)).createBlockAdView(BlockAdPlugin.access$000(this.this$0).getAttachedActivity(), this.val$appid, this.val$adInfo.getAdUnitId(), this.val$adInfo.getLeft(), this.val$adInfo.getTop(), this.val$adInfo.getSize(), this.val$adInfo.getOri(), this.val$adInfo.getCompId(), new BlockAdPlugin.1.1(this), this.val$ext);
    } while (localAbsBlockAdView == null);
    try
    {
      localAbsBlockAdView.loadAD();
      BlockAdPlugin.access$300(this.this$0).put(Integer.valueOf(this.val$adInfo.getCompId()), localAbsBlockAdView);
      BlockAdPlugin.access$400(this.this$0).put(Integer.valueOf(this.val$adInfo.getCompId()), this.val$adInfo);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.i("BlockAdPlugin", "loadAd error", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.BlockAdPlugin.1
 * JD-Core Version:    0.7.0.1
 */