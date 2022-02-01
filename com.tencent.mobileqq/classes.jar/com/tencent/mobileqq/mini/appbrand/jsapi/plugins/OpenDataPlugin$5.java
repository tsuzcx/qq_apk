package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

class OpenDataPlugin$5
  implements MiniAppCmdInterface
{
  OpenDataPlugin$5(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt, String paramString1, String paramString2, Boolean paramBoolean, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("OpenDataPlugin", 1, "modifyFriendInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
      return;
    }
    if (paramBoolean)
    {
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          Object localObject = (CloudStorage.StModifyFriendInteractiveStorageRsp)paramJSONObject.get("response");
          int i = paramJSONObject.getInt("retCode");
          localObject = paramJSONObject.getString("errMsg");
          paramJSONObject = paramJSONObject.optString("details", "");
          localJSONObject = new JSONObject();
          localJSONObject.put("errMsg", localObject);
          localJSONObject.put("errCode", i);
          localJSONObject.put("details", paramJSONObject);
          if (i != 0) {
            break label463;
          }
          this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "modifyFriendInteractiveStorage", localJSONObject, this.val$callbackId);
          if (this.this$0.isMiniGameRuntime())
          {
            if (OpenDataPlugin.access$000(this.this$0).get("onInteractiveStorageModified") != null)
            {
              localJSONObject.put("key", this.val$key);
              ((JsRuntime)OpenDataPlugin.access$000(this.this$0).get("onInteractiveStorageModified")).evaluateSubcribeJS("onInteractiveStorageModified", localJSONObject.toString(), -1);
            }
            if ((TextUtils.isEmpty(this.val$title)) || (this.val$quiet.booleanValue())) {
              break;
            }
            paramJSONObject = this.val$object + this.val$action;
            localObject = "已" + this.val$action + "\n马上QQ告诉好友？";
            OpenDataPlugin.access$200(this.this$0, paramJSONObject, (String)localObject, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataPlugin.5.1(this), new OpenDataPlugin.5.2(this), new OpenDataPlugin.5.3(this));
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
          GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
          return;
        }
        if ((this.this$0.jsPluginEngine instanceof JsPluginEngine)) {
          this.this$0.jsPluginEngine.appBrandRuntime.evaluateServiceSubcribeJS("onInteractiveStorageModified", localJSONObject.toString());
        }
      }
      label463:
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE retCode != 0");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error retCode != 0");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", localJSONObject, this.val$callbackId);
      return;
    }
    GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OpenDataPlugin.5
 * JD-Core Version:    0.7.0.1
 */