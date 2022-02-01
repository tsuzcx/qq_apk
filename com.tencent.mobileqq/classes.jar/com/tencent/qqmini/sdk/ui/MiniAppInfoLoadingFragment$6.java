package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$6
  implements MiniAppInfoLoadingFragment.onGetMiniAppInfoListener
{
  MiniAppInfoLoadingFragment$6(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString, int paramInt) {}
  
  public void onGetMiniAppInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, MiniAppInfo paramMiniAppInfo, String paramString1, long paramLong, String paramString2)
  {
    MiniAppInfoLoadingFragment.access$400(this.this$0, paramJSONObject, paramArrayOfByte, paramString1, this.val$cacheProxy, this.val$link, this.val$linkType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.6
 * JD-Core Version:    0.7.0.1
 */