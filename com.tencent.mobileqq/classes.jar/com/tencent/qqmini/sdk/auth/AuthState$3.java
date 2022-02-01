package com.tencent.qqmini.sdk.auth;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AuthState$3
  implements AsyncResult
{
  AuthState$3(AuthState paramAuthState) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateUserSetting() onCmdListener isSuccess: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("   ; ret: ");
    localStringBuilder.append(paramJSONObject);
    QMLog.e("AuthState", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthState.3
 * JD-Core Version:    0.7.0.1
 */