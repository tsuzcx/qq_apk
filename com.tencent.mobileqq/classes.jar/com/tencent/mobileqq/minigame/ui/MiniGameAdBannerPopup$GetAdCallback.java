package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.util.WeakReference;

class MiniGameAdBannerPopup$GetAdCallback
  implements TianShuGetAdvCallback
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetAdvs() called with: result = [");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("], getAdsRsp = [");
    ((StringBuilder)localObject).append(paramGetAdsRsp);
    ((StringBuilder)localObject).append("]");
    QLog.d("MiniGameAdBannerPopup", 1, ((StringBuilder)localObject).toString());
    localObject = this.context;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      MiniGameAdBannerPopup.access$100((Context)this.context.get(), this.miniAppConfig, paramBoolean, paramGetAdsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGameAdBannerPopup.GetAdCallback
 * JD-Core Version:    0.7.0.1
 */