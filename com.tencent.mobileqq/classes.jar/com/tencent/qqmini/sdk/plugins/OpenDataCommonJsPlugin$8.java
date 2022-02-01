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
    QMLog.d("OpenDataCommonJsPlugin", "modifyFriendInteractiveStorage receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , ret == null");
      this.val$req.fail("request ret is null.");
      return;
    }
    if (paramBoolean)
    {
      int i;
      String str1;
      try
      {
        i = paramJSONObject.getInt("retCode");
        str1 = paramJSONObject.getString("errMsg");
        paramJSONObject = new JSONObject();
        if (i == 0)
        {
          this.val$req.ok();
          if ((!TextUtils.isEmpty(this.val$title)) && (!this.val$quiet.booleanValue()))
          {
            str1 = this.val$object + this.val$action;
            String str2 = "已" + this.val$action + "\n马上QQ告诉好友？";
            OpenDataCommonJsPlugin.access$1000(this.this$0, str1, str2, "告诉他", Boolean.valueOf(true), "下次吧", new OpenDataCommonJsPlugin.8.1(this), new OpenDataCommonJsPlugin.8.2(this), new OpenDataCommonJsPlugin.8.3(this));
          }
          OpenDataCommonJsPlugin.access$1100(this.this$0, paramJSONObject, this.val$req, this.val$key);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error ", paramJSONObject);
        this.val$req.fail();
        return;
      }
      paramJSONObject.put("errMsg", str1);
      paramJSONObject.put("errCode", i);
      QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE " + paramJSONObject.toString());
      this.val$req.fail(paramJSONObject, "");
      return;
    }
    QMLog.e("OpenDataCommonJsPlugin", "handleNativeRequest API_MODIFY_FRIEND_INTERACTIVE_STORAGE error , isSuc false");
    this.val$req.fail("request failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.OpenDataCommonJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */