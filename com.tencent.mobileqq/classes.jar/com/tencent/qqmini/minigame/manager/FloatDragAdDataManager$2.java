package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.action.OperateFloatDragAd;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

final class FloatDragAdDataManager$2
  implements AsyncResult
{
  FloatDragAdDataManager$2(String paramString, int paramInt, IMiniAppContext paramIMiniAppContext) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = FloatDragAdDataManager.access$100(this.val$appId, this.val$scene, paramJSONObject);
    }
    else
    {
      QMLog.e("FloatDragAdDataManager", "TianShuResponse response fail");
      paramJSONObject = null;
    }
    if (paramJSONObject != null)
    {
      OperateFloatDragAd.obtain(this.val$iMiniAppContext).show(paramJSONObject);
      return;
    }
    OperateFloatDragAd.obtain(this.val$iMiniAppContext).remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.FloatDragAdDataManager.2
 * JD-Core Version:    0.7.0.1
 */