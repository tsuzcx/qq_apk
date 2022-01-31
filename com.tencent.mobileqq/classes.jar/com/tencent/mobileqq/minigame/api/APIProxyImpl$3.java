package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.minigame.manager.GameInfoManager;
import com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.AuthorizeCallback;
import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class APIProxyImpl$3
  implements MiniGameAuthorizeManager.AuthorizeCallback
{
  APIProxyImpl$3(APIProxyImpl paramAPIProxyImpl, boolean paramBoolean, String paramString, APICallback paramAPICallback) {}
  
  public void onAuthorizeFinish(boolean paramBoolean)
  {
    QLog.i("APIProxyImpl", 1, "onAuthorizeFinish " + paramBoolean);
    if (paramBoolean) {
      MiniAppCmdUtil.getInstance().getUserInfo(GameInfoManager.g().getAppId(), this.val$withCredentials, this.val$lang, new APIProxyImpl.3.1(this));
    }
    do
    {
      return;
      QLog.i("APIProxyImpl", 1, "user denied SCOPE_USER_INFO request");
    } while (this.val$apiCallback == null);
    Object localObject = ApiUtil.wrapCallbackFail("getUserInfo", null, "auth deny");
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "")
    {
      this.val$apiCallback.onCallback(false, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */