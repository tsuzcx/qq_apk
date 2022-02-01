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
      int i = paramJSONObject.optInt("authState", -1);
      paramJSONObject = paramJSONObject.optString("settingItem", "");
      if ((i == 1) && ("setting.addFriend".equals(paramJSONObject)))
      {
        try
        {
          paramJSONObject = new Bundle();
          paramJSONObject.putString("openId", this.val$openId);
          paramJSONObject.putString("appId", this.val$appId);
          if (!this.val$channelProxy.startAddFriendActivity(this.val$context, this.val$appId, this.val$openId))
          {
            paramJSONObject = this.val$context;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("暂不支持在");
            localStringBuilder.append(QUAUtil.getApplicationName(this.val$context));
            localStringBuilder.append("中添加好友");
            MiniToast.makeText(paramJSONObject, 0, localStringBuilder.toString(), 1);
            if (this.val$addFriendCallBack != null)
            {
              QMLog.e("QQFriendJsPlugin", "app not implement");
              this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "app not implement");
            }
          }
        }
        catch (NumberFormatException paramJSONObject)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" doAddFriend() exception e = ");
          localStringBuilder.append(paramJSONObject);
          QMLog.d("QQFriendJsPlugin", localStringBuilder.toString());
        }
        paramJSONObject = this.val$addFriendCallBack;
        if (paramJSONObject != null) {
          paramJSONObject.onAddFriendCallBack("addFriend", true, null);
        }
      }
      else if (this.val$addFriendCallBack != null)
      {
        QMLog.e("QQFriendJsPlugin", "getSettingByOpenId failed");
        this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "auth deny");
      }
    }
    else if (this.val$addFriendCallBack != null)
    {
      QMLog.e("QQFriendJsPlugin", "getUserSetting failed");
      this.val$addFriendCallBack.onAddFriendCallBack("addFriend", false, "network err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */