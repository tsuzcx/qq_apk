package com.tencent.qqmini.sdk.core.plugins;

import bgok;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;

class SettingsJsPlugin$2
  implements ChannelProxy.AuthListResult
{
  SettingsJsPlugin$2(SettingsJsPlugin paramSettingsJsPlugin, AuthState paramAuthState, bgok parambgok) {}
  
  public void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authorizeCenter.updateAuthStateList(null, paramList1);
      this.val$authorizeCenter.setSynchronized();
      SettingsJsPlugin.access$100(this.this$0, this.val$authorizeCenter, this.val$req);
      return;
    }
    QMLog.e("SettingsJsPlugin", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */