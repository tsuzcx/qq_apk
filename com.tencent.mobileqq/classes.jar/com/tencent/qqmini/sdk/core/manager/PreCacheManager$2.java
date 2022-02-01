package com.tencent.qqmini.sdk.core.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import org.json.JSONObject;

class PreCacheManager$2
  implements AsyncResult
{
  PreCacheManager$2(PreCacheManager paramPreCacheManager, String paramString1, MiniAppInfo paramMiniAppInfo, PreCacheInfo paramPreCacheInfo, String paramString2, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$logPrefix);
      ((StringBuilder)localObject).append("call API_LOGIN  code:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QMLog.d("minisdk-start_PreCacheManager", ((StringBuilder)localObject).toString());
      paramJSONObject = paramJSONObject.optString("code");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        localObject = this.this$0;
        MiniAppInfo localMiniAppInfo = this.val$miniAppConfig;
        PreCacheInfo localPreCacheInfo = this.val$preCacheInfo;
        String str = this.val$cacheType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$queryParam);
        localStringBuilder.append("&code=");
        localStringBuilder.append(paramJSONObject);
        PreCacheManager.access$100((PreCacheManager)localObject, localMiniAppInfo, localPreCacheInfo, str, localStringBuilder.toString(), this.val$listener);
      }
    }
    else
    {
      QMLog.e("minisdk-start_PreCacheManager", "call API_LOGIN failed ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.PreCacheManager.2
 * JD-Core Version:    0.7.0.1
 */