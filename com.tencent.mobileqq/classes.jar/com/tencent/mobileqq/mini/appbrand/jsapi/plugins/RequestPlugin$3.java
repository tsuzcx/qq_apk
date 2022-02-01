package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.JsPluginParam;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class RequestPlugin$3
  implements EIPCResultCallback
{
  RequestPlugin$3(RequestPlugin paramRequestPlugin, String paramString1, String paramString2, String paramString3, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getBoolean("hasCreateOrManageTroop")))
    {
      TroopApplicationListUtil.startTroopActivityAndAddTroopApplication(this.this$0.jsPluginEngine, this.val$appId, new TroopApplicationListUtil.JsPluginParam(this.val$event, this.val$jsonParams, this.val$jsRuntime, this.val$callbackId));
      return;
    }
    try
    {
      new JSONObject(this.val$jsonParams).put("errorCode", 41004);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null, "not group manager"), this.val$callbackId);
      TroopApplicationListUtil.showToast(41004);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "addGroupApp, exception: " + Log.getStackTraceString(paramEIPCResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.3
 * JD-Core Version:    0.7.0.1
 */