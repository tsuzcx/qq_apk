package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class DataJsPlugin$13
  implements MiniAppCmdInterface
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, AuthorizeCenter paramAuthorizeCenter, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    INTERFACE.StGetAuthListRsp localStGetAuthListRsp;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      QLog.d("[mini] DataJsPlugin", 1, "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.opt("authList");
      if ((paramJSONObject instanceof byte[])) {
        localStGetAuthListRsp = new INTERFACE.StGetAuthListRsp();
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          localStGetAuthListRsp.mergeFrom((byte[])paramJSONObject);
          paramJSONObject = localStGetAuthListRsp.settings.get();
          this.val$authorizeCenter.updateAuthList(null, paramJSONObject);
          this.val$authorizeCenter.setAuthorizeSynchronized();
          int j = this.val$authorizeCenter.getAuthFlagFromAuthorize(this.val$finalScopeName);
          i = j;
          if (j == 1)
          {
            if (this.this$0.jsPluginEngine.apiAuthoritySilent()) {
              break label261;
            }
            paramJSONObject = this.this$0.jsPluginEngine;
            i = j;
            if (BaseJsPluginEngine.isAuthWhiteAppId(this.this$0.jsPluginEngine.appBrandRuntime.appId)) {
              break label261;
            }
          }
          if (i == 2)
          {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            return;
          }
          this.this$0.jsPluginEngine.reqAuthorize(this.val$event, this.val$jsonParams, this.val$webview, this.val$callbackId);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          QLog.e("[mini] DataJsPlugin", 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
          paramJSONObject.printStackTrace();
          return;
        }
        QLog.e("[mini] DataJsPlugin", 1, "getSetting-getAuthList failed");
        return;
        label261:
        int i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */