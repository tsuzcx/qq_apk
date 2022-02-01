package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class OtherJsPlugin$5
  implements MiniAppCmdInterface
{
  OtherJsPlugin$5(OtherJsPlugin paramOtherJsPlugin, AuthorizeCenter paramAuthorizeCenter, String paramString, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (!paramBoolean) {
      OtherJsPlugin.access$500(this.this$0, this.val$authorizeCenter, this.val$eventName, this.val$webview, this.val$callbackId, this.val$withSubscriptions, null);
    }
    do
    {
      return;
      QLog.d(OtherJsPlugin.access$000(), 1, "getSetting-getAuthList suc, ret:" + paramJSONObject.toString());
      paramJSONObject = paramJSONObject.opt("authList");
    } while (!(paramJSONObject instanceof byte[]));
    Object localObject = new INTERFACE.StGetAuthListRsp();
    label306:
    for (;;)
    {
      try
      {
        ((INTERFACE.StGetAuthListRsp)localObject).mergeFrom((byte[])paramJSONObject);
        localObject = ((INTERFACE.StGetAuthListRsp)localObject).settings.get();
        this.val$authorizeCenter.updateAuthList(null, (List)localObject);
        this.val$authorizeCenter.setAuthorizeSynchronized();
        paramJSONObject = null;
        if (this.val$withSubscriptions)
        {
          localObject = ((List)localObject).iterator();
          paramJSONObject = null;
          if (!((Iterator)localObject).hasNext()) {
            break label306;
          }
          INTERFACE.StUserSettingInfo localStUserSettingInfo = (INTERFACE.StUserSettingInfo)((Iterator)localObject).next();
          if ("setting.sysMsgSubscribed".equals(localStUserSettingInfo.settingItem.get())) {
            paramJSONObject = OtherJsPlugin.access$600(this.this$0, localStUserSettingInfo.subItems.get());
          }
        }
        else
        {
          if ((paramJSONObject != null) && (paramJSONObject.size() > 0)) {
            this.val$authorizeCenter.updateIsSysSubMsgMaintain(true);
          }
          OtherJsPlugin.access$500(this.this$0, this.val$authorizeCenter, this.val$eventName, this.val$webview, this.val$callbackId, this.val$withSubscriptions, paramJSONObject);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramJSONObject)
      {
        QLog.e(OtherJsPlugin.access$000(), 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
        paramJSONObject.printStackTrace();
        OtherJsPlugin.access$500(this.this$0, this.val$authorizeCenter, this.val$eventName, this.val$webview, this.val$callbackId, this.val$withSubscriptions, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */