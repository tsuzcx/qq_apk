package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AuthorizeCenter$2
  implements MiniAppCmdInterface
{
  AuthorizeCenter$2(AuthorizeCenter paramAuthorizeCenter) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AuthorizeCenter", 2, "updateUserSetting() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.2
 * JD-Core Version:    0.7.0.1
 */