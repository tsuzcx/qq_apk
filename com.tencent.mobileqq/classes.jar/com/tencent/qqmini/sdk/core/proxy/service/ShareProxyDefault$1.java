package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.Handler;
import bejn;
import besf;
import besj;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class ShareProxyDefault$1
  implements AsyncResult
{
  ShareProxyDefault$1(ShareProxyDefault paramShareProxyDefault, besj parambesj, AsyncResult paramAsyncResult, Activity paramActivity) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (!paramJSONObject.optBoolean("needShareCallBack")) {
        ((MiniAppProxy)localObject).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      localObject = new besf();
      ((besf)localObject).b = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((besf)localObject).c = this.val$shareData.jdField_a_of_type_JavaLangString;
      ((besf)localObject).jdField_a_of_type_JavaLangString = this.val$shareData.b;
      ((besf)localObject).g = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl;
      ((besf)localObject).e = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
      ((besf)localObject).f = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((besf)localObject).d = str;
      ((besf)localObject).jdField_a_of_type_Besk = new ShareProxyDefault.1.1(this, paramJSONObject);
      this.this$0.shareToQQ(this.val$activity, (besf)localObject);
      return;
    }
    long l = -1L;
    paramBoolean = false;
    if (paramJSONObject != null)
    {
      paramBoolean = paramJSONObject.optBoolean("needShareCallBack");
      l = paramJSONObject.optLong("retCode");
    }
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = null)
    {
      if (!paramBoolean) {
        ((MiniAppProxy)localObject).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      bejn.c().post(new ShareProxyDefault.1.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */