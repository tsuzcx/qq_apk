package com.tencent.qqmini.sdk.minigame.plugins;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import android.text.TextUtils;
import bgok;
import bgxo;
import bhaj;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class OpenDataJsPlugin$8
  implements AsyncResult
{
  OpenDataJsPlugin$8(OpenDataJsPlugin paramOpenDataJsPlugin, bgok parambgok, String paramString1, Boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.d("OpenDataJsPlugin", "modifyFriendInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.b();
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
          this.val$req.a();
          if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
          {
            paramJSONObject = this.val$object + this.val$action;
            String str = "已" + this.val$action + "\n马上QQ告诉好友？";
            OpenDataJsPlugin.access$600(this.this$0, paramJSONObject, str, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataJsPlugin.8.1(this), new OpenDataJsPlugin.8.2(this), new OpenDataJsPlugin.8.3(this));
          }
          if (OpenDataJsPlugin.access$700(this.this$0))
          {
            paramJSONObject = (bgxo)this.val$req.a;
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
          bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
          bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error " + paramJSONObject.getMessage());
          this.val$req.b();
          return;
        }
        paramJSONObject = null;
      }
      label341:
      ((JSONObject)localObject).put("errMsg", paramJSONObject);
      ((JSONObject)localObject).put("errCode", i);
      bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE ret != null");
      bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ret != null");
      this.val$req.a((JSONObject)localObject, null);
      return;
    }
    bhaj.a().e("OpenDataJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    bhaj.a("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */