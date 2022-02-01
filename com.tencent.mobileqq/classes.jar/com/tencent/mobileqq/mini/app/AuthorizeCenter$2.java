package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class AuthorizeCenter$2
  implements MiniAppCmdInterface
{
  AuthorizeCenter$2(AuthorizeCenter paramAuthorizeCenter, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    MiniAppCmdInterface localMiniAppCmdInterface = this.val$listener;
    if (localMiniAppCmdInterface != null) {
      localMiniAppCmdInterface.onCmdListener(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.2
 * JD-Core Version:    0.7.0.1
 */