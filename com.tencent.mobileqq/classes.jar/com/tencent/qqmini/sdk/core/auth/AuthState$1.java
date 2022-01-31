package com.tencent.qqmini.sdk.core.auth;

import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class AuthState$1
  implements AsyncResult
{
  AuthState$1(AuthState paramAuthState) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.e("AuthState", "setAuthorize() onCmdListener isSuccess: " + paramBoolean + "   ; ret: " + paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.AuthState.1
 * JD-Core Version:    0.7.0.1
 */