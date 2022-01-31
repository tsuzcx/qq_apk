package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.triton.sdk.APICallback;
import org.json.JSONObject;

class APIProxyImpl$4
  implements MiniAppCmdInterface
{
  APIProxyImpl$4(APIProxyImpl paramAPIProxyImpl, APICallback paramAPICallback) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = ApiUtil.wrapCallbackOk("getUserInfo", paramJSONObject);
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.toString();
      }
    }
    for (;;)
    {
      if (this.val$apiCallback != null) {
        this.val$apiCallback.onCallback(paramBoolean, paramJSONObject);
      }
      return;
      paramJSONObject = "";
      continue;
      paramJSONObject = ApiUtil.wrapCallbackFail("getUserInfo", paramJSONObject, null);
      if (paramJSONObject != null) {
        paramJSONObject = paramJSONObject.toString();
      } else {
        paramJSONObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */