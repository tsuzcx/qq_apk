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
      QLog.d("miniapp-start_PreCacheManager", 1, this.val$logPrefix + "call API_LOGIN  code:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.optString("code");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        PreCacheManager.access$100(this.this$0, this.val$miniAppConfig, this.val$preCacheInfo, this.val$cacheType, this.val$queryParam + "&code=" + paramJSONObject, this.val$listener);
      }
      return;
    }
    QLog.e("miniapp-start_PreCacheManager", 1, "call API_LOGIN failed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.PreCacheManager.2
 * JD-Core Version:    0.7.0.1
 */