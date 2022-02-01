package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class SettingsJsPlugin$2
  implements ChannelProxy.AuthListResult
{
  SettingsJsPlugin$2(SettingsJsPlugin paramSettingsJsPlugin, AuthState paramAuthState, boolean paramBoolean, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    Object localObject = null;
    paramList = null;
    if (paramBoolean)
    {
      this.val$authorizeCenter.updateAuthStateList(null, paramList1);
      this.val$authorizeCenter.setSynchronized();
      if (this.val$withSubscriptions)
      {
        paramList1 = paramList1.iterator();
        localObject = paramList;
        if (paramList1.hasNext())
        {
          localObject = (UserSettingInfo)paramList1.next();
          if (!"setting.sysMsgSubscribed".equals(((UserSettingInfo)localObject).settingItem)) {
            break label164;
          }
          paramList = SettingsJsPlugin.access$100(this.this$0, ((UserSettingInfo)localObject).subItems);
        }
      }
    }
    label164:
    for (;;)
    {
      break;
      if ((localObject != null) && (((Map)localObject).size() > 0)) {
        this.val$authorizeCenter.updateIsSysSubMsgMaintain(true);
      }
      SettingsJsPlugin.access$200(this.this$0, this.val$authorizeCenter, this.val$req, this.val$withSubscriptions, (Map)localObject);
      return;
      QMLog.e("SettingsJsPlugin", "getSetting-getAuthStateList failed");
      SettingsJsPlugin.access$200(this.this$0, this.val$authorizeCenter, this.val$req, this.val$withSubscriptions, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.SettingsJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */