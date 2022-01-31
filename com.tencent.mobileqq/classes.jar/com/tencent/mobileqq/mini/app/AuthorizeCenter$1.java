package com.tencent.mobileqq.mini.app;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AuthorizeCenter$1
  implements MiniAppCmdInterface
{
  AuthorizeCenter$1(AuthorizeCenter paramAuthorizeCenter) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AuthorizeCenter", 2, "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.1
 * JD-Core Version:    0.7.0.1
 */