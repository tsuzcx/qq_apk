package com.tencent.mobileqq.mini.app;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PreCacheManager$2
  implements MiniAppCmdInterface
{
  PreCacheManager$2(PreCacheManager paramPreCacheManager, String paramString1, MiniAppConfig paramMiniAppConfig, PreCacheInfo paramPreCacheInfo, String paramString2, String paramString3, PreCacheManager.OnCacheListener paramOnCacheListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.val$logPrefix);
      ((StringBuilder)localObject).append("call API_LOGIN  code:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("miniapp-start_PreCacheManager", 1, ((StringBuilder)localObject).toString());
      paramJSONObject = paramJSONObject.optString("code");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        localObject = this.this$0;
        MiniAppConfig localMiniAppConfig = this.val$miniAppConfig;
        PreCacheInfo localPreCacheInfo = this.val$preCacheInfo;
        String str = this.val$cacheType;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.val$queryParam);
        localStringBuilder.append("&code=");
        localStringBuilder.append(paramJSONObject);
        PreCacheManager.access$100((PreCacheManager)localObject, localMiniAppConfig, localPreCacheInfo, str, localStringBuilder.toString(), this.val$listener);
      }
    }
    else
    {
      QLog.e("miniapp-start_PreCacheManager", 1, "call API_LOGIN failed ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.2
 * JD-Core Version:    0.7.0.1
 */