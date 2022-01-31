package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.QQFriendsJsPlugin.IAddFriendCallBack;
import com.tencent.mobileqq.triton.sdk.APICallback;
import org.json.JSONObject;

class APIProxyImpl$2
  implements QQFriendsJsPlugin.IAddFriendCallBack
{
  APIProxyImpl$2(APIProxyImpl paramAPIProxyImpl, APICallback paramAPICallback) {}
  
  public void onAddFriendCallBack(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (this.val$apiCallback != null) {
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (paramString1 = ApiUtil.wrapCallbackOk(paramString1, null);; paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, paramString2))
    {
      this.val$apiCallback.onCallback(paramBoolean, paramString1.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */