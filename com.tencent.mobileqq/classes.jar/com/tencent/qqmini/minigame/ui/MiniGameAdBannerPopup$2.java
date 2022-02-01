package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class MiniGameAdBannerPopup$2
  implements AsyncResult
{
  MiniGameAdBannerPopup$2(WeakReference paramWeakReference, String paramString, int paramInt) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      TianShuAccess.GetAdsRsp localGetAdsRsp = (TianShuAccess.GetAdsRsp)paramJSONObject.get("response");
      QMLog.d("MiniGameAdBannerPopup", "onGetAdvs() called with: result = [" + paramJSONObject + "], getAdsRsp = [" + localGetAdsRsp + "]");
      if ((this.val$weakContext == null) || (this.val$weakContext.get() == null)) {
        return;
      }
      MiniGameAdBannerPopup.access$100((Context)this.val$weakContext.get(), this.val$appid, this.val$scene, paramBoolean, localGetAdsRsp);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QMLog.e("MiniGameAdBannerPopup", "tianshuRequestAdv onReceiveResult", paramJSONObject);
    }
    if ((this.val$weakContext != null) && (this.val$weakContext.get() != null))
    {
      MiniGameAdBannerPopup.access$100((Context)this.val$weakContext.get(), this.val$appid, this.val$scene, paramBoolean, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.2
 * JD-Core Version:    0.7.0.1
 */