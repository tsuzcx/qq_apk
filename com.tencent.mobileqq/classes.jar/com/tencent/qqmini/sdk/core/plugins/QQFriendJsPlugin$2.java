package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.os.Bundle;
import bemw;
import besl;
import bfgt;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import org.json.JSONObject;

final class QQFriendJsPlugin$2
  implements AsyncResult
{
  QQFriendJsPlugin$2(String paramString1, String paramString2, MiniAppProxy paramMiniAppProxy, Context paramContext, QQFriendJsPlugin.IAddFriendCallBack paramIAddFriendCallBack) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      i = paramJSONObject.optInt("authState", -1);
      paramJSONObject = paramJSONObject.optString("settingItem", "");
      if ((i != 1) || (!"setting.addFriend".equals(paramJSONObject))) {}
    }
    while (this.val$addFriendCallBack == null)
    {
      do
      {
        try
        {
          int i;
          paramJSONObject = new Bundle();
          paramJSONObject.putString("openId", this.val$openId);
          paramJSONObject.putString("appId", this.val$appId);
          if (!this.val$miniAppProxy.startAddFriendActivity(this.val$context, this.val$appId, this.val$openId))
          {
            bemw.a(this.val$context, 0, "暂不支持在" + bfgt.a(this.val$context) + "中添加好友", 1);
            if (this.val$addFriendCallBack != null)
            {
              besl.d("QQFriendJsPlugin", "app not implement");
              this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "app not implement");
            }
          }
          if (this.val$addFriendCallBack != null) {
            this.val$addFriendCallBack.onAddFriendCallBack("addFriend", true, null);
          }
          return;
        }
        catch (NumberFormatException paramJSONObject)
        {
          for (;;)
          {
            besl.a("QQFriendJsPlugin", " doAddFriend() exception e = " + paramJSONObject);
          }
        }
      } while (this.val$addFriendCallBack == null);
      besl.d("QQFriendJsPlugin", "getSettingByOpenId failed");
      this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "auth deny");
      return;
    }
    besl.d("QQFriendJsPlugin", "getUserSetting failed");
    this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "network err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */