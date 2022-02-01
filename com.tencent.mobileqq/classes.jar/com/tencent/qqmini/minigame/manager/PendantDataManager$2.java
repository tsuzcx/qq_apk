package com.tencent.qqmini.minigame.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.minigame.action.OperatePendantAd;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

final class PendantDataManager$2
  implements AsyncResult
{
  PendantDataManager$2(String paramString, int paramInt, Context paramContext, IMiniAppContext paramIMiniAppContext, ChannelProxy paramChannelProxy, MiniAppProxy paramMiniAppProxy) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = PendantDataManager.access$100(this.val$appId, this.val$scene, paramJSONObject);
    }
    else
    {
      QMLog.e("PendantDataManager", "TianShuResponse response fail");
      PendantDataManager.access$200(paramJSONObject);
      paramJSONObject = null;
    }
    if (PendantDataManager.access$300(paramJSONObject))
    {
      PendantDataManager.access$400(this.val$context, paramJSONObject);
      PendantDataManager.wirteTianshuCache(paramJSONObject);
      PendantDataManager.access$500(this.val$context, this.val$iMiniAppContext, this.val$appId, this.val$scene, this.val$channelProxy, this.val$proxy, paramJSONObject);
      return;
    }
    if (PendantDataManager.requestTianshuCache(this.val$appId, this.val$context, this.val$iMiniAppContext, this.val$scene, this.val$channelProxy, this.val$proxy))
    {
      QMLog.i("PendantDataManager", "restoring pendantAd from disk");
      return;
    }
    QMLog.d("PendantDataManager", "没有挂件活动(包含天枢配置出错) 或者 已经领完奖励，红包挂件消失");
    if (PendantDataManager.getSp().contains("curDay"))
    {
      PendantDataManager.entranceStrategy = 2;
      OperatePendantAd.obtain(this.val$iMiniAppContext).remove();
      PendantDataManager.getSp().edit().clear().commit();
      return;
    }
    PendantDataManager.requestTianshuAgain(paramJSONObject, this.val$context, this.val$iMiniAppContext, this.val$appId, this.val$scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.PendantDataManager.2
 * JD-Core Version:    0.7.0.1
 */