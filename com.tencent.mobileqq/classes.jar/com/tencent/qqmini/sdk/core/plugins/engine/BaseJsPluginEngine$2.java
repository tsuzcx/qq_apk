package com.tencent.qqmini.sdk.core.plugins.engine;

import bgkd;
import com.tencent.qqmini.sdk.core.auth.AuthFilterList;
import com.tencent.qqmini.sdk.core.auth.AuthState;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;

class BaseJsPluginEngine$2
  implements ChannelProxy.AuthListResult
{
  BaseJsPluginEngine$2(BaseJsPluginEngine paramBaseJsPluginEngine, AuthState paramAuthState, String paramString1, String paramString2, bgkd parambgkd) {}
  
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
        this.val$req.a();
        return;
      }
      BaseJsPluginEngine.access$300(this.this$0, this.val$req, this.val$scope);
      return;
    }
    QMLog.e("JsPluginEngine[AuthGuard]", "getSetting-getAuthStateList failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.engine.BaseJsPluginEngine.2
 * JD-Core Version:    0.7.0.1
 */