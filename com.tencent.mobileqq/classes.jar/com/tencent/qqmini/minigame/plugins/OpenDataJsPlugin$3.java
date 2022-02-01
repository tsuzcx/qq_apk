package com.tencent.qqmini.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import android.text.TextUtils;
import com.tencent.qqmini.minigame.GameJsService;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class OpenDataJsPlugin$3
  implements AsyncResult
{
  OpenDataJsPlugin$3(OpenDataJsPlugin paramOpenDataJsPlugin, RequestEvent paramRequestEvent, String paramString1, Boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("OpenDataJsPlugin", "modifyFriendInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.fail();
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
          paramJSONObject = paramJSONObject.getString("errMsg");
          localObject = new JSONObject();
          if (i != 0) {
            break label341;
          }
          this.val$req.ok();
          if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
          {
            paramJSONObject = this.val$object + this.val$action;
            String str = "已" + this.val$action + "\n马上QQ告诉好友？";
            OpenDataJsPlugin.access$100(this.this$0, paramJSONObject, str, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataJsPlugin.3.1(this), new OpenDataJsPlugin.3.2(this), new OpenDataJsPlugin.3.3(this));
          }
          if (OpenDataJsPlugin.access$200(this.this$0))
          {
            paramJSONObject = (GameJsService)this.val$req.jsService;
            if ((paramJSONObject == null) || (paramJSONObject.getTargetContextType() != 1)) {
              break;
            }
            ((JSONObject)localObject).put("key", this.val$key);
            paramJSONObject.evaluateSubscribeJS("onInteractiveStorageModified", ((JSONObject)localObject).toString(), -1);
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
          GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
          this.val$req.fail();
          return;
        }
        paramJSONObject = null;
      }
      label341:
      ((JSONObject)localObject).put("errMsg", paramJSONObject);
      ((JSONObject)localObject).put("errCode", i);
      GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE ret != null");
      GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ret != null");
      this.val$req.fail((JSONObject)localObject, null);
      return;
    }
    GameLog.getInstance().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    GameLog.vconsoleLog("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */