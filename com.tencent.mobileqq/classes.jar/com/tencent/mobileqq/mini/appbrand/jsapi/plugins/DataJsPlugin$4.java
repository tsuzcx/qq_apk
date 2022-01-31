package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import Wallet.IsUinFocusMpIdRsp;
import android.os.Bundle;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class DataJsPlugin$4
  implements BusinessObserver
{
  DataJsPlugin$4(DataJsPlugin paramDataJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = (IsUinFocusMpIdRsp)paramBundle.getSerializable("rsp");
    if (localObject == null)
    {
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("[mini] DataJsPlugin", 2, "is_subscribed: " + ((IsUinFocusMpIdRsp)localObject).is_focus_link_mp_id);
    }
    try
    {
      paramBundle = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("nick_name", ((IsUinFocusMpIdRsp)localObject).account_name);
      localJSONObject2.put("is_subscribed", ((IsUinFocusMpIdRsp)localObject).is_focus_link_mp_id);
      localJSONObject2.put("head_img", ((IsUinFocusMpIdRsp)localObject).icon_url);
      localJSONObject2.put("desc", ((IsUinFocusMpIdRsp)localObject).describe_content);
      localJSONObject2.put("uin", ((IsUinFocusMpIdRsp)localObject).link_mp_id_admin_uin);
      localJSONObject2.put("mpid", ((IsUinFocusMpIdRsp)localObject).link_mp_id);
      localJSONObject1.put("biz_info", localJSONObject2);
      localJSONObject1.put("status", ((IsUinFocusMpIdRsp)localObject).status_code);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", localJSONObject1.toString());
      paramBundle.put("data", ((JSONObject)localObject).toString());
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, paramBundle, this.val$callbackId);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */