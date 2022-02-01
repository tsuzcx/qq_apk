package com.tencent.mobileqq.mini.app;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.CmdCallback.Stub;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class MiniAppClientQIPCModule$7
  extends CmdCallback.Stub
{
  MiniAppClientQIPCModule$7(MiniAppClientQIPCModule paramMiniAppClientQIPCModule, JsRuntime paramJsRuntime, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("shareJson");
    QLog.d("MiniAppClientQIPCModule", 1, "handleDirectShareSucCallback shareJsonString after = " + paramBundle);
    MiniAppClientQIPCModule.access$200(this.this$0, this.val$jsRuntime, this.val$shareEvent, this.val$callbackId, this.val$shareAppid, this.val$shareOpenid, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.app.MiniAppClientQIPCModule.7
 * JD-Core Version:    0.7.0.1
 */