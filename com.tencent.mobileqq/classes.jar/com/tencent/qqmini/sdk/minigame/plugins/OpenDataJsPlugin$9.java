package com.tencent.qqmini.sdk.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import android.text.TextUtils;
import bekr;
import betc;
import beuw;
import bexk;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import org.json.JSONObject;

class OpenDataJsPlugin$9
  implements AsyncResult
{
  OpenDataJsPlugin$9(OpenDataJsPlugin paramOpenDataJsPlugin, bekr parambekr, String paramString1, Boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.a("OpenDataJsPlugin", "modifyFriendInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.b();
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = (CloudStorage.StModifyFriendInteractiveStorageRsp)paramJSONObject.get("response");
        i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        localObject = new JSONObject();
        if (i != 0) {
          break label339;
        }
        if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
        {
          paramJSONObject = this.val$object + this.val$action;
          String str = "已" + this.val$action + "\n马上QQ告诉好友？";
          OpenDataJsPlugin.access$100(this.this$0, paramJSONObject, str, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataJsPlugin.9.1(this), new OpenDataJsPlugin.9.2(this), new OpenDataJsPlugin.9.3(this));
          if (!OpenDataJsPlugin.access$200(this.this$0)) {
            break label410;
          }
          paramJSONObject = (beuw)this.val$req.a;
          if ((paramJSONObject == null) || (paramJSONObject.a() != 1)) {
            break;
          }
          ((JSONObject)localObject).put("key", this.val$key);
          paramJSONObject.a("onInteractiveStorageModified", ((JSONObject)localObject).toString(), -1);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
        bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
        this.val$req.b();
        return;
      }
      this.val$req.a();
      continue;
      label339:
      ((JSONObject)localObject).put("errMsg", paramJSONObject);
      ((JSONObject)localObject).put("errCode", i);
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE ret != null");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ret != null");
      this.val$req.a((JSONObject)localObject, null);
      return;
      bexk.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
      bexk.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
      this.val$req.b();
      return;
      label410:
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */