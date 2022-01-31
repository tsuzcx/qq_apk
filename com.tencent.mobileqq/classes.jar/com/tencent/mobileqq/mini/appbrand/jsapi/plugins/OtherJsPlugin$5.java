package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class OtherJsPlugin$5
  implements MiniAppCmdInterface
{
  OtherJsPlugin$5(OtherJsPlugin paramOtherJsPlugin, AuthorizeCenter paramAuthorizeCenter, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      QLog.d(OtherJsPlugin.access$000(), 1, "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.opt("authList");
      INTERFACE.StGetAuthListRsp localStGetAuthListRsp;
      if ((paramJSONObject instanceof byte[])) {
        localStGetAuthListRsp = new INTERFACE.StGetAuthListRsp();
      }
      try
      {
        localStGetAuthListRsp.mergeFrom((byte[])paramJSONObject);
        paramJSONObject = localStGetAuthListRsp.settings.get();
        this.val$authorizeCenter.updateAuthList(null, paramJSONObject);
        this.val$authorizeCenter.setAuthorizeSynchronized();
        OtherJsPlugin.access$500(this.this$0, this.val$authorizeCenter, this.val$eventName, this.val$webview, this.val$callbackId);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramJSONObject)
      {
        QLog.e(OtherJsPlugin.access$000(), 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
        paramJSONObject.printStackTrace();
        return;
      }
    }
    QLog.e(OtherJsPlugin.access$000(), 1, "getSetting-getAuthList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */