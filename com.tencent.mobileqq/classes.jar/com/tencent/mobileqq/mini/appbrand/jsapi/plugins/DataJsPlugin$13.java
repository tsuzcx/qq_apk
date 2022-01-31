package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class DataJsPlugin$13
  implements MiniAppCmdInterface
{
  DataJsPlugin$13(DataJsPlugin paramDataJsPlugin, AuthorizeCenter paramAuthorizeCenter, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      QLog.d("[mini] DataJsPlugin", 1, "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
      Object localObject = paramJSONObject.opt("authList");
      if (!(localObject instanceof byte[])) {
        return;
      }
      paramJSONObject = new INTERFACE.StGetAuthListRsp();
      try
      {
        paramJSONObject.mergeFrom((byte[])localObject);
        localObject = paramJSONObject.auths.get();
        paramJSONObject = paramJSONObject.settings.get();
        this.val$authorizeCenter.updateAuthList((List)localObject, paramJSONObject);
        this.val$authorizeCenter.setAuthorizeSynchronized();
        int i = this.val$authorizeCenter.getAuthFlagFromAuthorize(this.val$finalScopeName);
        if (BaseJsPluginEngine.isAuthWhiteAppId(this.this$0.jsPluginEngine.appBrandRuntime.appId)) {
          i = 2;
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
    }
    QLog.e("[mini] DataJsPlugin", 1, "getSetting-getAuthList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */