package com.tencent.mobileqq.mini.servlet;

import android.support.annotation.NonNull;

final class MiniAppSSOCmdHelper$1
  implements MiniAppSSOCmdHelper.MiniAppCmdCallbackInternal<RESPONSE>
{
  MiniAppSSOCmdHelper$1(MiniAppSSOCmdHelper.MiniAppCmdCallback paramMiniAppCmdCallback, Class paramClass) {}
  
  @NonNull
  public Class<? extends RESPONSE> getResponseClass()
  {
    return this.val$responseClass;
  }
  
  public void onReceived(boolean paramBoolean, RESPONSE paramRESPONSE)
  {
    MiniAppSSOCmdHelper.MiniAppCmdCallback localMiniAppCmdCallback = this.val$cmdCallback;
    if (localMiniAppCmdCallback != null) {
      localMiniAppCmdCallback.onReceived(paramBoolean, paramRESPONSE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.1
 * JD-Core Version:    0.7.0.1
 */