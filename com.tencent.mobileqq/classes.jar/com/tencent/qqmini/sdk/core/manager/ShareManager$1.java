package com.tencent.qqmini.sdk.core.manager;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import org.json.JSONObject;

class ShareManager$1
  implements AsyncResult
{
  ShareManager$1(ShareManager paramShareManager, InnerShareData paramInnerShareData) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    String str;
    Object localObject;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      str = paramJSONObject.optString("jump_url");
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack");
      localObject = this.val$shareData;
      ((InnerShareData)localObject).needShareCallback = paramBoolean;
      ((InnerShareData)localObject).targetUrl = str;
      ((InnerShareData)localObject).jsonObject = paramJSONObject;
      if (!paramBoolean) {
        ((InnerShareData)localObject).notifyShareResult(((InnerShareData)localObject).fromActivity, 0, true);
      }
      if (((ShareProxy)ProxyManager.get(ShareProxy.class)).isShareTargetAvailable(this.val$shareData.fromActivity, this.val$shareData.shareTarget))
      {
        if (this.val$shareData.shareInMiniProcess)
        {
          ((ShareProxy)ProxyManager.get(ShareProxy.class)).share(this.val$shareData.fromActivity, this.val$shareData);
          return;
        }
        ShareManager.access$000(this.val$shareData);
      }
    }
    else
    {
      long l = -1L;
      str = null;
      if (paramJSONObject != null)
      {
        paramBoolean = paramJSONObject.optBoolean("needShareCallBack");
        l = paramJSONObject.optLong("retCode");
        str = paramJSONObject.optString("errMsg");
      }
      else
      {
        paramBoolean = false;
      }
      localObject = this.val$shareData;
      ((InnerShareData)localObject).needShareCallback = paramBoolean;
      if (!paramBoolean) {
        ((InnerShareData)localObject).notifyShareResult(((InnerShareData)localObject).fromActivity, 0, true);
      } else {
        ((InnerShareData)localObject).notifyShareResult(((InnerShareData)localObject).fromActivity, 1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to getShareInfo, result: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QMLog.e("ShareManager", ((StringBuilder)localObject).toString());
      ThreadManager.getUIHandler().post(new ShareManager.1.1(this, l, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.ShareManager.1
 * JD-Core Version:    0.7.0.1
 */