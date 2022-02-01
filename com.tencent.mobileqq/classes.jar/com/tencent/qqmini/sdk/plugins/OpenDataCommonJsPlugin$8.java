package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class OpenDataCommonJsPlugin$8
  implements AsyncResult
{
  OpenDataCommonJsPlugin$8(OpenDataCommonJsPlugin paramOpenDataCommonJsPlugin, RequestEvent paramRequestEvent, String paramString1, Boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("modifyFriendInteractiveStorage receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(String.valueOf(paramJSONObject));
    QMLog.d("OpenDataCommonJsPlugin", ((StringBuilder)localObject1).toString());
    if (paramJSONObject == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.fail("request ret is null.");
      return;
    }
    if (paramBoolean) {
      try
      {
        int i = paramJSONObject.getInt("retCode");
        localObject1 = paramJSONObject.getString("errMsg");
        paramJSONObject = new JSONObject();
        if (i == 0)
        {
          this.val$req.ok();
          if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.val$object);
            ((StringBuilder)localObject1).append(this.val$action);
            localObject1 = ((StringBuilder)localObject1).toString();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("已");
            ((StringBuilder)localObject2).append(this.val$action);
            ((StringBuilder)localObject2).append("\n马上QQ告诉好友？");
            localObject2 = ((StringBuilder)localObject2).toString();
            this.this$0.doShowFriendInteractiveDialog((String)localObject1, (String)localObject2, this.val$openid, this.val$nick, this.val$title, this.val$imageUrl, this.val$imageUrlId, this.val$req);
          }
          OpenDataCommonJsPlugin.access$600(this.this$0, paramJSONObject, this.val$req, this.val$key);
          return;
        }
        paramJSONObject.put("errMsg", localObject1);
        paramJSONObject.put("errCode", i);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE ");
        ((StringBuilder)localObject1).append(paramJSONObject.toString());
        QMLog.e("OpenDataCommonJsPlugin", ((StringBuilder)localObject1).toString());
        this.val$req.fail(paramJSONObject, "");
        return;
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
        this.val$req.fail();
        return;
      }
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.fail("request failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */