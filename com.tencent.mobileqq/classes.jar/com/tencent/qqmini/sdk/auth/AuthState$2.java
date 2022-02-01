package com.tencent.qqmini.sdk.auth;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class AuthState$2
  implements AsyncResult
{
  AuthState$2(AuthState paramAuthState) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.e("AuthState", "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthState.2
 * JD-Core Version:    0.7.0.1
 */