package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;

class BannerAdPlugin$7
  implements AdProxy.IBannerAdListener
{
  BannerAdPlugin$7(BannerAdPlugin paramBannerAdPlugin, RequestEvent paramRequestEvent, BannerAdPosInfo paramBannerAdPosInfo) {}
  
  public void onADClicked()
  {
    QMLog.i("BannerAdPlugin", "onADClicked");
  }
  
  public void onADCloseOverlay()
  {
    QMLog.i("BannerAdPlugin", "onADCloseOverlay");
  }
  
  public void onADClosed()
  {
    QMLog.i("BannerAdPlugin", "onADClosed");
  }
  
  public void onADExposure()
  {
    QMLog.i("BannerAdPlugin", "onADExposure");
  }
  
  public void onADLeftApplication()
  {
    QMLog.i("BannerAdPlugin", "onADLeftApplication");
  }
  
  public void onADOpenOverlay()
  {
    QMLog.i("BannerAdPlugin", "onADOpenOverlay");
  }
  
  public void onADReceive()
  {
    QMLog.i("BannerAdPlugin", "onADReceive");
    if (this.val$adPosInfo == null) {
      return;
    }
    BannerAdPlugin.access$702(this.this$0, true);
    AppBrandTask.runTaskOnUiThread(new BannerAdPlugin.7.1(this));
  }
  
  public void onNoAD(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNoAD, errCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QMLog.i("BannerAdPlugin", localStringBuilder.toString());
    BannerAdPlugin.access$300(this.this$0, this.val$req, paramInt, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BannerAdPlugin.7
 * JD-Core Version:    0.7.0.1
 */