package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import org.json.JSONObject;

final class QQFriendJsPlugin$1
  implements AsyncResult
{
  QQFriendJsPlugin$1(String paramString1, String paramString2, ChannelProxy paramChannelProxy, Context paramContext, QQFriendJsPlugin.IAddFriendCallBack paramIAddFriendCallBack) {}
  
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
          if (!this.val$channelProxy.startAddFriendActivity(this.val$context, this.val$appId, this.val$openId))
          {
            MiniToast.makeText(this.val$context, 0, "暂不支持在" + QUAUtil.getApplicationName(this.val$context) + "中添加好友", 1);
            if (this.val$addFriendCallBack != null)
            {
              QMLog.e("QQFriendJsPlugin", "app not implement");
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
            QMLog.d("QQFriendJsPlugin", " doAddFriend() exception e = " + paramJSONObject);
          }
        }
      } while (this.val$addFriendCallBack == null);
      QMLog.e("QQFriendJsPlugin", "getSettingByOpenId failed");
      this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "auth deny");
      return;
    }
    QMLog.e("QQFriendJsPlugin", "getUserSetting failed");
    this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "network err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */