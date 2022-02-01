package com.tencent.qqmini.sdk.ui;

import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$4
  implements AsyncResult
{
  MiniAppInfoLoadingFragment$4(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, MiniAppInfoLoadingFragment.onGetMiniAppInfoListener paramonGetMiniAppInfoListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      this.val$listener.onGetMiniAppInfo(null, null, null, null, -1L, "result is null");
    }
    long l = paramJSONObject.optLong("retCode");
    String str = paramJSONObject.optString("errMsg");
    QMLog.i("MiniAppInfoLoadingFragment", "getAppInfoById, retCode = " + l + ",errMsg = " + str);
    if (paramBoolean)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("mini_app_info_data_json");
      paramJSONObject = (byte[])paramJSONObject.opt("mini_app_info_data_pb");
      this.val$listener.onGetMiniAppInfo(localJSONObject, paramJSONObject, localMiniAppInfo, null, l, str);
      return;
    }
    this.val$listener.onGetMiniAppInfo(null, null, null, null, l, str);
    ThreadManager.getUIHandler().post(new MiniAppInfoLoadingFragment.4.1(this, l, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.4
 * JD-Core Version:    0.7.0.1
 */