package com.tencent.qqmini.sdk.plugins.engine;

import com.tencent.qqmini.sdk.auth.AuthFilterList;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;

class BaseJsPluginEngine$6
  implements ChannelProxy.AuthListResult
{
  BaseJsPluginEngine$6(BaseJsPluginEngine paramBaseJsPluginEngine, AuthState paramAuthState, String paramString1, String paramString2, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, List<UserAuthInfo> paramList, List<UserSettingInfo> paramList1)
  {
    if (paramBoolean)
    {
      this.val$authState.updateAuthStateList(paramList, paramList1);
      this.val$authState.setSynchronized();
      paramBoolean = this.val$authState.isPermissionGranted(this.val$scope);
      if (AuthFilterList.isAppInWhiteList(this.val$appId)) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        this.val$req.ok();
        return;
      }
      BaseJsPluginEngine.access$900(this.this$0, this.val$req, this.val$scope);
      return;
    }
    QMLog.e("JsPluginEngine[AuthGuard]", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.6
 * JD-Core Version:    0.7.0.1
 */