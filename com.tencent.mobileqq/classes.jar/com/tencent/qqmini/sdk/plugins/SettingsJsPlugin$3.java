package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class SettingsJsPlugin$3
  implements ChannelProxy.AuthListResult
{
  SettingsJsPlugin$3(SettingsJsPlugin paramSettingsJsPlugin, AuthState paramAuthState, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authorizeCenter.updateAuthStateList(null, paramList1);
      this.val$authorizeCenter.setSynchronized();
      paramList = new HashMap();
      if (this.val$withSubscriptions)
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          Object localObject = (UserSettingInfo)paramList1.next();
          if (("setting.sysMsgSubscribed".equals(((UserSettingInfo)localObject).settingItem)) || ("setting.onceMsgSubscribed".equals(((UserSettingInfo)localObject).settingItem)))
          {
            localObject = SettingsJsPlugin.access$300(this.this$0, ((UserSettingInfo)localObject).subItems);
            if (localObject != null) {
              paramList.putAll((Map)localObject);
            }
          }
        }
      }
      if ((paramList != null) && (paramList.size() > 0)) {
        this.val$authorizeCenter.updateIsSysSubMsgMaintain(true);
      }
      SettingsJsPlugin.access$400(this.this$0, this.val$authorizeCenter, this.val$req, this.val$withSubscriptions, paramList);
      return;
    }
    QMLog.e("SettingsJsPlugin", "getSetting-getAuthStateList failed");
    SettingsJsPlugin.access$400(this.this$0, this.val$authorizeCenter, this.val$req, this.val$withSubscriptions, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */