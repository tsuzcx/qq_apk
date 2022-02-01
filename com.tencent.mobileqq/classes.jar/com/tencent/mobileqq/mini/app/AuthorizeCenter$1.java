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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAuthorize() onCmdListener isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("   ; ret: ");
      localStringBuilder.append(paramJSONObject);
      QLog.e("AuthorizeCenter", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.AuthorizeCenter.1
 * JD-Core Version:    0.7.0.1
 */