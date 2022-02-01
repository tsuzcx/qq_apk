package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AuthorizeCenter$3
  implements MiniAppCmdInterface
{
  AuthorizeCenter$3(AuthorizeCenter paramAuthorizeCenter, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUserSetting() onCmdListener isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("   ; ret: ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.e("AuthorizeCenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.val$listener;
    if (localObject != null) {
      ((MiniAppCmdInterface)localObject).onCmdListener(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.3
 * JD-Core Version:    0.7.0.1
 */