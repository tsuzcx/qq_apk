package com.tencent.qqmini.sdk.auth;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class AuthState$1
  implements AsyncResult
{
  AuthState$1(AuthState paramAuthState, AsyncResult paramAsyncResult) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    AsyncResult localAsyncResult = this.val$asyncResult;
    if (localAsyncResult != null) {
      localAsyncResult.onReceiveResult(paramBoolean, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthState.1
 * JD-Core Version:    0.7.0.1
 */