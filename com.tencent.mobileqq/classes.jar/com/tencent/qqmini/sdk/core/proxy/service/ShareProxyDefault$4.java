package com.tencent.qqmini.sdk.core.proxy.service;

import android.app.Activity;
import android.os.Handler;
import beiw;
import berk;
import bers;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class ShareProxyDefault$4
  implements AsyncResult
{
  ShareProxyDefault$4(ShareProxyDefault paramShareProxyDefault, bers parambers, AsyncResult paramAsyncResult, Activity paramActivity) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      String str = paramJSONObject.optString("jump_url");
      if (!paramJSONObject.optBoolean("needShareCallBack")) {
        ((MiniAppProxy)localObject).callServer("MiniMsgIPCServer", "cmd_mini_share_suc", null);
      }
      localObject = new berk();
      ((berk)localObject).jdField_a_of_type_Int = this.val$shareData.jdField_b_of_type_Int;
      ((berk)localObject).jdField_b_of_type_JavaLangString = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((berk)localObject).c = this.val$shareData.jdField_a_of_type_JavaLangString;
      ((berk)localObject).jdField_a_of_type_JavaLangString = this.val$shareData.jdField_b_of_type_JavaLangString;
      ((berk)localObject).g = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl;
      ((berk)localObject).e = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
      ((berk)localObject).f = this.val$shareData.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name;
      ((berk)localObject).d = str;
      ((berk)localObject).jdField_a_of_type_Bert = new ShareProxyDefault.4.1(this, paramJSONObject);
      this.this$0.shareToOther(this.val$activity, (berk)localObject);
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
      beiw.c().post(new ShareProxyDefault.4.2(this, l, paramJSONObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ShareProxyDefault.4
 * JD-Core Version:    0.7.0.1
 */