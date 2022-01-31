package com.tencent.mobileqq.minigame.jsapi.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class OpenDataPlugin$5
  implements MiniAppCmdInterface
{
  OpenDataPlugin$5(OpenDataPlugin paramOpenDataPlugin, JsRuntime paramJsRuntime, int paramInt, String paramString1, Boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
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
      Object localObject;
      int i;
      for (;;)
      {
        try
        {
          localObject = (CloudStorage.StModifyFriendInteractiveStorageRsp)paramJSONObject.get("response");
          i = paramJSONObject.getInt("retCode");
          localObject = paramJSONObject.getString("errMsg");
          paramJSONObject = new JSONObject();
          if (i != 0) {
            break label408;
          }
          if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
          {
            localObject = this.val$object + this.val$action;
            String str = "已" + this.val$action + "\n马上QQ告诉好友？";
            OpenDataPlugin.access$100(this.this$0, (String)localObject, str, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataPlugin.5.1(this), new OpenDataPlugin.5.2(this), new OpenDataPlugin.5.3(this));
            if ((this.this$0.jsPluginEngine == null) || (!(this.this$0.jsPluginEngine instanceof GameJsPluginEngine)) || (((GameJsPluginEngine)this.this$0.jsPluginEngine).getGameJsRuntime(1) == null)) {
              break;
            }
            localObject = ((GameJsPluginEngine)this.this$0.jsPluginEngine).getGameJsRuntime(1);
            if (localObject == null) {
              break;
            }
            paramJSONObject.put("key", this.val$key);
            ((GameJsRuntime)localObject).evaluateSubcribeJS("onInteractiveStorageModified", paramJSONObject.toString(), -1);
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
        this.this$0.jsPluginEngine.callbackJsEventOK(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
      }
      label408:
      paramJSONObject.put("errMsg", localObject);
      paramJSONObject.put("errCode", i);
      GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE ret != null");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ret != null");
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", paramJSONObject, this.val$callbackId);
      return;
    }
    GameLog.getInstance().e("OpenDataPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$jsRuntime, "modifyFriendInteractiveStorage", null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OpenDataPlugin.5
 * JD-Core Version:    0.7.0.1
 */