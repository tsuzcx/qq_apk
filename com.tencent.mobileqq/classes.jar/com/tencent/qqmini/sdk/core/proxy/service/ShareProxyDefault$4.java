package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.Handler;
import bejn;
import besb;
import besj;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class ShareProxyDefault$4
  implements AsyncResult
{
  ShareProxyDefault$4(ShareProxyDefault paramShareProxyDefault, besj parambesj, AsyncResult paramAsyncResult, Activity paramActivity) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (!paramJSONObject.optBoolean("needShareCallBack")) {
        ((MiniAppProxy)localObject).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      localObject = new besb();
      ((besb)localObject).jdField_a_of_type_Int = this.val$shareData.jdField_b_of_type_Int;
      ((besb)localObject).jdField_b_of_type_JavaLangString = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((besb)localObject).c = this.val$shareData.jdField_a_of_type_JavaLangString;
      ((besb)localObject).jdField_a_of_type_JavaLangString = this.val$shareData.jdField_b_of_type_JavaLangString;
      ((besb)localObject).g = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl;
      ((besb)localObject).e = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
      ((besb)localObject).f = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((besb)localObject).d = str;
      ((besb)localObject).jdField_a_of_type_Besk = new ShareProxyDefault.4.1(this, paramJSONObject);
      this.this$0.shareToOther(this.val$activity, (besb)localObject);
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
      bejn.c().post(new ShareProxyDefault.4.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */