package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$1
  implements MiniAppInfoLoadingFragment.onGetMiniAppInfoListener
{
  MiniAppInfoLoadingFragment$1(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, String paramString3) {}
  
  public void onGetMiniAppInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, MiniAppInfo paramMiniAppInfo, String paramString1, long paramLong, String paramString2)
  {
    MiniAppInfoLoadingFragment.access$000(this.this$0, paramJSONObject, paramArrayOfByte, this.val$finalEnvVersion, this.val$cacheProxy, this.val$appid, this.val$finalEntryPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.1
 * JD-Core Version:    0.7.0.1
 */