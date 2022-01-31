package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import bgqv;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.util.WeakReference;

class MiniGameAdBannerPopup$GetAdCallback
  implements bgqv
{
  private final WeakReference<Context> context;
  private final MiniAppConfig miniAppConfig;
  
  MiniGameAdBannerPopup$GetAdCallback(Context paramContext, MiniAppConfig paramMiniAppConfig)
  {
    this.context = new WeakReference(paramContext);
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    QLog.d("MiniGameAdBannerPopup", 1, "onGetAdvs() called with: result = [" + paramBoolean + "], getAdsRsp = [" + paramGetAdsRsp + "]");
    if ((this.context != null) && (this.context.get() != null)) {
      MiniGameAdBannerPopup.access$100((Context)this.context.get(), this.miniAppConfig, paramBoolean, paramGetAdsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.GetAdCallback
 * JD-Core Version:    0.7.0.1
 */